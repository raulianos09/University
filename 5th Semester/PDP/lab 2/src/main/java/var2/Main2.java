package var2;

import var1.Utility;

import java.util.List;


public class Main2 {
    public static void main(String args[]) {
        List<Integer> array1 = Utility.generateRandomList(100);
        List<Integer> array2 = Utility.generateRandomList(100);
        System.out.println("First array is: ");
        System.out.println(array1);
        System.out.println("Second array is: ");
        System.out.println(array2);

        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer, array1, array2);
        Consumer consumer = new Consumer(buffer, array1.size());

        Thread pThread = new Thread(producer);
        Thread cThread = new Thread(consumer);

        pThread.start();
        cThread.start();

        try {
            pThread.join();
            cThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The dot product computed by producer-consumer threads is: " + consumer.getSum());
        long sum = 0;
        for(int i = 0 ; i< array1.size() ; i++)
        {
            sum += array1.get(i) * array2.get(i);
        }
        System.out.println("The dot product computed sequentially is: " + sum);

    }
}
