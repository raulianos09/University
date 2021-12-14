import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.readHamiltonian();
       //g.readNonHamiltonian();

        int NUMBER_OF_THREADS = 5;
        ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        Lock lock = new ReentrantLock();
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < g.size(); i++)
        {
            service.submit(new Task(g,i,lock,result));
        }
        service.shutdown();
        while (!service.isTerminated())
        {

        }
        if(result.size() > 0)
            System.out.println("Hamiltonian cycle found: " +result);
        else
            System.out.println("No hamiltionian cycle found!");
    }
}
