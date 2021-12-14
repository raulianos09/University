import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    private int numberOfNodes;
    private Map<Integer , List<Integer>> edges;

    Graph()
    {   this.numberOfNodes = 0;
        this.edges = new HashMap<Integer, List<Integer>>();
    }


    private void read(String filePath)
    {
        File file = new File(filePath);
        Scanner myReader = null;
        try {
            myReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.numberOfNodes = Integer.parseInt(myReader.nextLine().strip());
        for(int i = 0; i<this.numberOfNodes ; i++)
        {
            this.edges.put(i, Arrays.stream(myReader.nextLine().strip().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        }
        myReader.close();
    }

    public int size()
    {
        return this.numberOfNodes;
    }

    public List<Integer> neighboursOf(int node)
    {
        return this.edges.get(node);
    }

    public void readHamiltonian()
    {
        read("src/main/java/Graphs/hamiltonianGraph.txt");
    }

    public void readNonHamiltonian()
    {
        read("src/main/java/Graphs/nonHamiltonianGraph.txt");
    }
}
