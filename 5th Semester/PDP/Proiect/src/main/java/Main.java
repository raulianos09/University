import Graph.*;
import mpi.MPI;
import org.jfree.chart.plot.ThermometerPlot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {

        String APPROACH = "MPI";

        if (APPROACH.equals("MPI")) {

            MPI.Init(args);

            int rank = MPI.COMM_WORLD.Rank();
            int numberOfProcesses = MPI.COMM_WORLD.Size();

            GraphMPI g = new GraphMPI(10);
            g.addEdge(0, 2);
            g.addEdge(0, 3);
            g.addEdge(0, 5);
            g.addEdge(1, 3);
            g.addEdge(1, 4);
            g.addEdge(1, 6);
            g.addEdge(2, 4);
            g.addEdge(2, 7);
            g.addEdge(3, 8);
            g.addEdge(4, 9);
            g.addEdge(5, 6);
            g.addEdge(5, 9);
            g.addEdge(6, 7);
            g.addEdge(7, 8);
            g.addEdge(8, 9);

            if (rank == 0) {
                master(g, numberOfProcesses);
            } else {
                worker(rank, numberOfProcesses);
            }



            MPI.Finalize();

        } else {
            Graph g = new Graph(10);
            g.addEdge(0, 2);
            g.addEdge(0, 3);
            g.addEdge(0, 5);
            g.addEdge(1, 3);
            g.addEdge(1, 4);
            g.addEdge(1, 6);
            g.addEdge(2, 4);
            g.addEdge(2, 7);
            g.addEdge(3, 8);
            g.addEdge(4, 9);
            g.addEdge(5, 6);
            g.addEdge(5, 9);
            g.addEdge(6, 7);
            g.addEdge(7, 8);
            g.addEdge(8, 9);
            g.colorGraph();
            g.show();
        }
    }

    private static void worker(int rank, int numberOfProcesses) {
        int numberOfNodes = 0;
        int[] nr_nodes = new int[1];
        int[] received_data = new int[3];

        MPI.COMM_WORLD.Recv(nr_nodes, 0, 1, MPI.INT, 0, rank);
        numberOfNodes = nr_nodes[0];

        int[] colors = new int[numberOfNodes];
        int[] weights = new int[numberOfNodes];
        int[][] matrix = new int[numberOfNodes][numberOfNodes];

        for (int i = 0; i < numberOfNodes; i++) {
            MPI.COMM_WORLD.Recv(matrix[i], 0, numberOfNodes, MPI.INT, 0, rank);
        }
        MPI.COMM_WORLD.Recv(received_data, 0, 3, MPI.INT, 0, rank);

        MPI.COMM_WORLD.Recv(colors, 0, numberOfNodes, MPI.INT, 0, rank);
        MPI.COMM_WORLD.Recv(weights, 0, numberOfNodes, MPI.INT, 0, rank);

        //System.out.println("from node: " + received_data[0] + " rank-" + rank);
        //System.out.println("to node: " + received_data[1] + " rank-" + rank);
        //System.out.println("max color: " + received_data[2] + " rank-" + rank);

        int current_node;
        int iteration = 0;
        while (iteration < numberOfNodes) {
            boolean all_colored = true;
            for (current_node = received_data[0]; current_node <= received_data[1]; current_node++) {
                if (colors[current_node] == -1) {
                    all_colored = false;
                    int node_weight = weights[current_node];
                    boolean is_local_maxima = true;
                    //check if current node has maximum local weight
                    for (int neighbours = 0; neighbours < numberOfNodes; neighbours++) {
                        if (neighbours != current_node) {
                            if (matrix[current_node][neighbours] == 1 && colors[neighbours] == -1 && weights[neighbours] > weights[current_node]) {
                                is_local_maxima = false;
                                break;
                            }
                        }
                    }
                    //System.out.println("node " + current_node + " local maxima = " + is_local_maxima);
                    if (is_local_maxima) {
                        for (int assigned_color = 0; assigned_color < received_data[2]; assigned_color++) {
                            boolean is_available = true;
                            //check if color is available (not taken by any neighbour)
                            for (int neighbours = 0; neighbours < numberOfNodes; neighbours++) {
                                if (matrix[current_node][neighbours] == 1 && colors[neighbours] != -1 && assigned_color == colors[neighbours]) {
                                    is_available = false;
                                    break;
                                }
                            }
                            if (is_available) {
                                colors[current_node] = assigned_color;
                                //System.out.println("node " + current_node + " colored " + assigned_color + " by process " + rank);
                                break;
                            }
                        }
                    }
                }
            }
            //updating colors list
            int process;
            for (process = 1; process < numberOfProcesses; process++) {
                if (process != rank)
                    MPI.COMM_WORLD.Issend(colors, 0, numberOfNodes, MPI.INT, process, process);
            }

            for (process = 1; process < numberOfProcesses; process++) {
                int[] local_colors = new int[numberOfNodes];
                if (process != rank) {
                    MPI.COMM_WORLD.Recv(local_colors, 0, numberOfNodes, MPI.INT, process, rank);
                    int node = 0;
                    for (node = 0; node < numberOfNodes; node++) {
                        if (colors[node] == -1 && local_colors[node] != -1 && local_colors[node] < received_data[2] && local_colors[node] >= 0)
                            colors[node] = local_colors[node];
                    }
                }
            }

            iteration++;
        }
        MPI.COMM_WORLD.Issend(colors, 0, numberOfNodes, MPI.INT, 0, rank);
    }

    private static void master(GraphMPI g, int numberOfProcesses) {
        //initializations
        int[][] matrix = g.toMatrix();
        int[] weights = g.getWeights();
        int[][] send_data = new int[numberOfProcesses + 1][3];
        int max_color = g.getMaxColor();
        int[] colors = g.getColors();
        int[] nr_nodes = new int[1];
        nr_nodes[0] = g.getNumberOfVertices();

        int nodes_per_process = g.getNumberOfVertices() / (numberOfProcesses - 1);
        int nodes_for_last_process = g.getNumberOfVertices() - nodes_per_process * (numberOfProcesses - 2);
        int from_node = 0, to_node;

        for (int i = 1; i < numberOfProcesses - 1; i++) {
            //send number of vertices to all child processes
            MPI.COMM_WORLD.Issend(nr_nodes, 0, 1, MPI.INT, i, i);
            //send neighbours of node k to all child processes
            for (int k = 0; k < g.getNumberOfVertices(); k++) {
                MPI.COMM_WORLD.Issend(matrix[k], 0, nr_nodes[0], MPI.INT, i, i);
            }
            //send all data needed to child processes
            to_node = from_node + nodes_per_process - 1;
            send_data[i][0] = from_node;
            send_data[i][1] = to_node;
            send_data[i][2] = max_color;
            MPI.COMM_WORLD.Issend(send_data[i], 0, 3, MPI.INT, i, i);
            MPI.COMM_WORLD.Issend(colors, 0, nr_nodes[0], MPI.INT, i, i);
            MPI.COMM_WORLD.Issend(weights, 0, nr_nodes[0], MPI.INT, i, i);
            from_node = to_node + 1;
        }
        //special case for last child process
        int i = numberOfProcesses - 1;
        MPI.COMM_WORLD.Issend(nr_nodes, 0, 1, MPI.INT, i, i);
        //send neighbours of node k to all child processes
        for (int k = 0; k < g.getNumberOfVertices(); k++) {
            MPI.COMM_WORLD.Issend(matrix[k], 0, nr_nodes[0], MPI.INT, i, i);
        }
        //send all data needed to child processes
        to_node = from_node + nodes_for_last_process - 1;
        send_data[i][0] = from_node;
        send_data[i][1] = to_node;
        send_data[i][2] = max_color;
        MPI.COMM_WORLD.Issend(send_data[i], 0, 3, MPI.INT, i, i);
        MPI.COMM_WORLD.Issend(colors, 0, nr_nodes[0], MPI.INT, i, i);
        MPI.COMM_WORLD.Issend(weights, 0, nr_nodes[0], MPI.INT, i, i);

        for (i = 1; i < numberOfProcesses; i++) {
            MPI.COMM_WORLD.Recv(colors, 0, nr_nodes[0], MPI.INT, i, i);
        }
        for (i = 0; i < g.getNumberOfVertices(); i++) {//System.out.println(colors[i]);
            g.setColor(i, colors[i]);
        }
        int[] colors2 = g.getColors();
        for (i = 0; i < g.getNumberOfVertices(); i++) {
            System.out.println(colors2[i]);
        }
        g.show();
    }

    private static List<Integer> createListFromString(String stringElements) {
        List<String> listOfStringElems = Arrays.asList(stringElements.split(","));
        List<Integer> actualList = new ArrayList<>();
        for (String elem : listOfStringElems) {
            actualList.add(Integer.parseInt(elem.trim()));
        }
        return actualList;
    }
}
