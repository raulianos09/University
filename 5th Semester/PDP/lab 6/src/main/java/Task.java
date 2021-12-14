import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class Task implements Runnable {
    private Graph graph;
    private int startingNode;
    private Lock lock;
    private List<Integer> result;

    public Task(Graph graph, int startingNode, Lock lock, List<Integer> result) {
        this.graph = graph;
        this.startingNode = startingNode;
        this.lock = lock;
        this.result = result;
    }

    @Override
    public void run() {
        List<Integer> path = new ArrayList<>();
        visit(startingNode, path);
    }

    private void visit(int node,List<Integer> path) {
        path.add(node);
        if (path.size() == graph.size()) {
            if (graph.neighboursOf(node).contains(this.startingNode)) {
                this.lock.lock();
                this.result.clear();
                this.result.addAll(path);
                this.lock.unlock();
            }
            return;
        }
        for (int neighbour : graph.neighboursOf(node)) {
            if(!path.contains(neighbour))
                 visit(neighbour,new ArrayList<>(path));
        }
    }
}
