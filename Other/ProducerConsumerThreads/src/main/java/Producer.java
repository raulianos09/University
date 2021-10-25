import java.util.ArrayList;
import java.util.List;


public class Producer implements Runnable {

    private List<Integer> buffer;
    private List<Integer> array1;
    private List<Integer> array2;
    private List<Integer> products;

    public Producer(List<Integer> buffer, List<Integer> array1, List<Integer> array2) {
        this.buffer = buffer;
        this.array1 = array1;
        this.array2 = array2;
        this.products = new ArrayList<>();
    }

    @Override
    public void run() {
        for (int i = 0; i < array1.size(); i++) {
            synchronized (buffer) {
                buffer.add(array1.get(i) * array2.get(i));
                products.add(array1.get(i) * array2.get(i));
            }
        }

        synchronized (buffer) {
            buffer.add(null);
        }
    }
}
