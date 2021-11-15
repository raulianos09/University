package var2;

import java.util.List;


public class Producer implements Runnable {

    private Buffer buffer;
    private List<Integer> array1;
    private List<Integer> array2;

    public Producer(Buffer buffer, List<Integer> array1, List<Integer> array2) {
        this.buffer = buffer;
        this.array1 = array1;
        this.array2 = array2;
    }

    @Override
    public void run() {
        for (int i = 0; i < array1.size(); i++) {
            try {
                buffer.put(array1.get(i) * array2.get(i));
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
