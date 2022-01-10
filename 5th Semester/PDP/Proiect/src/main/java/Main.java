import Graph.*;
import mpi.MPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
                worker(rank);
            }

            //g.show();

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

    private static void worker(int rank) {
        Object[] matrix = new Object[1];
        int[] begin = new int[1];
        int[] end = new int[1];
        int[] numberOfVertices = new int[1];

        MPI.COMM_WORLD.Recv(matrix, 0, 1, MPI.OBJECT, 0, 0);

        String stringMatrix = (String) matrix[0];
        List<Integer> linearizedMatrix = createListFromString(stringMatrix.substring(1, stringMatrix.length() - 1));
        List<List<Integer>> actualMatrix = new ArrayList<>();

        MPI.COMM_WORLD.Recv(numberOfVertices, 0, 1, MPI.INT, 0, 0);
        for (int i = 0; i < numberOfVertices[0]; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < numberOfVertices[0]; j++) {
                row.add(linearizedMatrix.get(i * numberOfVertices[0] + j));
            }
            actualMatrix.add(row);
        }



        MPI.COMM_WORLD.Recv(begin, 0, 1, MPI.INT, 0, 0);
        MPI.COMM_WORLD.Recv(end, 0, 1, MPI.INT, 0, 0);


    }

    private static void master(GraphMPI g, int numberOfProcesses) {
        int start = 0, finish = 0;
        int len = g.getNumberOfVertices() / (numberOfProcesses - 1);

        MPI.COMM_WORLD.Bcast(g,0,1,MPI.OBJECT,0);

        for (int i = 1; i < numberOfProcesses; i++) {
            start = finish;
            finish += len;

            if (i == numberOfProcesses - 1) {
                finish = g.getNumberOfVertices();
            }


            MPI.COMM_WORLD.Send(new Object[]{g.toMatrix().toString()}, 0, 1, MPI.OBJECT, i, 0);
            MPI.COMM_WORLD.Send(new int[]{g.getNumberOfVertices()}, 0, 1, MPI.INT, i, 0);


            MPI.COMM_WORLD.Send(new int[]{start}, 0, 1, MPI.INT, i, 0);
            MPI.COMM_WORLD.Send(new int[]{finish}, 0, 1, MPI.INT, i, 0);
        }
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
