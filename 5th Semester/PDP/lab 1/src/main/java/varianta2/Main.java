package varianta2;


import varianta2.Model.Inventory;
import varianta2.Model.Shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        Inventory inventory = new Inventory();

        int NUMBER_OF_CUSTOMERS = 1000;
        int NUMBER_OF_THREADS = 20;
        Shop shop = new Shop(inventory);
        for(int i = 0; i<NUMBER_OF_CUSTOMERS / NUMBER_OF_THREADS ; i++)
        {
            System.out.println("\n#####START######-- "+ (i + 1) +" --######START#####");
            List<Thread> threads = new ArrayList<>();
            for(int j = 0; j< NUMBER_OF_THREADS; j++)
            {
                Thread t = new Thread(shop);
                threads.add(t);
                t.start();
                System.out.println("Execution on thread " + t.getId() + " started");
            }
            shop.checker();
            for(int j = 0; j< NUMBER_OF_THREADS; j++)
            {
                try {
                    threads.get(j).join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("#####FINISH#####-- "+ (i + 1) +" --#####FINISH#####");
        }
    }
}
