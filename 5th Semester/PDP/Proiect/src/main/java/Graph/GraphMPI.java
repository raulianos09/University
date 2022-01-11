package Graph;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class GraphMPI {

    private int numberOfEdges;
    private int numberOfVertices;

    private Set<Integer> colors;
    private Map<GNode, Set<GNode>> graph;

    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public Set<Integer> getIndependentSet() {
        return independentSet.stream().map(n -> n.getNodeID()).collect(Collectors.toSet());
    }

    private final Set<GNode> independentSet;
    private ExecutorService executorService;

    public GraphMPI(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        this.numberOfEdges = numberOfEdges;

        graph = new HashMap<>();

        for (int i = 0; i < numberOfVertices; i++) {
            GNode n = new GNode(i);
            n.setColor(-1);
            Random r = new Random();
            n.setWeight(r.nextInt(0, 100));
            graph.put(n, new HashSet<>());
        }

        independentSet = new HashSet<>(graph.keySet());
        executorService = Executors.newFixedThreadPool(8);
    }

    public Set<GNode> getNeighbours(GNode node) {
        return this.graph.get(node);
    }

    public void setColor(int node, int color) {
        for(GNode n : graph.keySet()) {
            if(n.getNodeID() == node)
                n.setColor(color);
        }
    }

    public int[] getWeights() {
        int[] weights = new int[numberOfVertices];
        for (GNode node : graph.keySet())
            weights[node.getNodeID()] = node.getWeight();
        return weights;
    }

    public int[] getColors() {
        int[] colors = new int[numberOfVertices];
        for(GNode node : graph.keySet())
            colors[node.getNodeID()] = node.getColor();
        return colors;
    }

    public void setColors(int[] colors) {
        for(GNode node : graph.keySet())
            node.setColor(colors[node.getNodeID()]);
    }

    public int getMaxColor() {
        int max = 0;
        for (GNode node : graph.keySet())
            if (graph.get(node).size() > max)
                max = graph.get(node).size();
        return max + 1;
    }

    public int[][] toMatrix() {
        int[][] matrix = new int[numberOfVertices][numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++)
            for (int j = 0; j < numberOfVertices; j++)
                matrix[i][j] = 0;

        for (GNode node : graph.keySet())
            for (GNode neighbour : graph.get(node)) {
                matrix[node.getNodeID()][neighbour.getNodeID()] = 1;
            }
        return matrix;
    }

    public void addEdge(int node1, int node2) {
        GNode n1 = this.graph.keySet().stream().filter(gNode -> gNode.getNodeID() == node1).collect(Collectors.toList()).get(0);
        GNode n2 = this.graph.keySet().stream().filter(gNode -> gNode.getNodeID() == node2).collect(Collectors.toList()).get(0);
        this.graph.get(n1).add(n2);
        this.graph.get(n2).add(n1);
    }


    public void show() {
        List<String> colors = Arrays.asList("#FFFF00", "#1CE6FF", "#FF34FF", "#FF4A46", "#008941", "#006FA6", "#A30059",
                "#FFDBE5", "#7A4900", "#0000A6", "#63FFAC", "#B79762", "#004D43", "#8FB0FF", "#997D87",
                "#5A0007", "#809693", "#FEFFE6", "#1B4400", "#4FC601", "#3B5DFF", "#4A3B53", "#FF2F80",
                "#61615A", "#BA0900", "#6B7900", "#00C2A0", "#FFAA92", "#FF90C9", "#B903AA", "#D16100",
                "#DDEFFF", "#000035", "#7B4F4B", "#A1C299", "#300018", "#0AA6D8", "#013349", "#00846F",
                "#372101", "#FFB500", "#C2FFED", "#A079BF", "#CC0744", "#C0B9B2", "#C2FF99", "#001E09",
                "#00489C", "#6F0062", "#0CBD66", "#EEC3FF", "#456D75", "#B77B68", "#7A87A1", "#788D66",
                "#885578", "#FAD09F", "#FF8A9A", "#D157A0", "#BEC459", "#456648", "#0086ED", "#886F4C",
                "#34362D", "#B4A8BD", "#00A6AA", "#452C2C", "#636375", "#A3C8C9", "#FF913F", "#938A81",
                "#575329", "#00FECF", "#B05B6F", "#8CD0FF", "#3B9700", "#04F757", "#C8A1A1", "#1E6E00",
                "#7900D7", "#A77500", "#6367A9", "#A05837", "#6B002C", "#772600", "#D790FF", "#9B9700",
                "#549E79", "#FFF69F", "#201625", "#72418F", "#BC23FF", "#99ADC0", "#3A2465", "#922329",
                "#5B4534", "#FDE8DC", "#404E55", "#0089A3", "#CB7E98", "#A4E804", "#324E72", "#6A3A4C");
        Collections.shuffle(colors);
        System.setProperty("org.graphstream.ui", "swing");
        org.graphstream.graph.Graph graph = new SingleGraph("visual_graph");
        graph.setAttribute("ui.stylesheet", "node {size: 30px;}");
        graph.setAttribute("ui.antialias");
        for (GNode node : this.graph.keySet()) {
            if(node.getColor() != -1) {
                Node n = graph.addNode(Integer.toString(node.getNodeID()));
                n.setAttribute("ui.style", "fill-color:" + colors.get(node.getColor() % colors.size()) + "; text-size: 20px;");
                n.setAttribute("ui.size", "3gu");
                n.setAttribute("ui.label", Integer.toString(node.getNodeID()));
                n.setAttribute("ui.class", "big");
            }
        }
        for (GNode node : this.graph.keySet()) {
            for (GNode node2 : this.graph.get(node)) {
                if (node2.getNodeID() < node.getNodeID())
                    continue;
                Edge e = graph.addEdge(Integer.toString(node.getNodeID()) + Integer.toString(node2.getNodeID()), Integer.toString(node.getNodeID()), Integer.toString(node2.getNodeID()));
                e.setAttribute("ui.style", "size: 3px;");
            }
        }
        graph.display();
    }
}
