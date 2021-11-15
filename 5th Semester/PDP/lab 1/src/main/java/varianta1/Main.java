package varianta1;

import varianta1.Model.Inventory;
import varianta1.Model.Shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String args[]) {
        Inventory inventory = new Inventory();
        System.out.println("Press 1 for loading products from file or 2 for generating new products");
        Scanner sc = new Scanner(System.in);
        String option = sc.next();
        while (true) {
            if (option.trim().equals("1")) {
                try {
                    inventory.loadInventory();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            } else if (option.trim().equals("2")) {
                try {
                    inventory.generateAndLoad();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            } else {
                System.out.println("Try again!");
            }
        }

        int NUMBER_OF_CUSTOMERS = 1000;
        int NUMBER_OF_THREADS = 20;
        ReentrantLock lock = new ReentrantLock();
        ReentrantReadWriteLock checkerLock = new ReentrantReadWriteLock();
        Shop shop = new Shop(inventory,lock,checkerLock);
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
            for(int j = 0; j< NUMBER_OF_THREADS; j++)
            {
                try {
                    threads.get(j).join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            shop.checker();
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("#####FINISH#####-- "+ (i + 1) +" --#####FINISH#####");
        }
    }
}
