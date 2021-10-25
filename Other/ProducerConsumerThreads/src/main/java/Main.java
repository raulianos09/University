import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String args[]) {
        List<Integer> array1 = Utility.generateRandomList(100);
        List<Integer> array2 = Utility.generateRandomList(100);
        System.out.println("First array is: ");
        System.out.println(array1);
        System.out.println("Second array is: ");
        System.out.println(array2);

        List<Integer> buffer = new ArrayList<>();
        Producer producer = new Producer(buffer, array1, array2);
        Consumer consumer = new Consumer(buffer);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
