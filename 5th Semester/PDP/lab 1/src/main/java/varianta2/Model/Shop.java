package varianta2.Model;


import org.apache.commons.lang3.tuple.MutablePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Shop implements Runnable {
    private Inventory inventory;
    private double totalSales = 0;
    private List<Bill> bills;

    public Shop(Inventory inventory) {
        this.inventory = inventory;
        this.bills = new ArrayList<>();
    }

    @Override
    public void run() {
        Random r = new Random();

        int productsPerBill = r.nextInt(200);
        Bill bill = new Bill();
        for (int i = 0; i < productsPerBill; i++) {
            MutablePair<MutablePair<Product, Integer>, ReentrantLock> item = this.inventory.selectRandomProduct();
            int quantity = 1 + r.nextInt(20);
            item.getValue().lock();
            try {
                sellProduct(bill, item, quantity);
            } catch (IllegalArgumentException e) {
                //System.out.println(e.getMessage());
            }
            item.getValue().unlock();
        }
        this.bills.add(bill);
        System.out.println("Execution on thread " + Thread.currentThread().getId() + " finished");
    }

    private void sellProduct(Bill bill, MutablePair<MutablePair<Product, Integer>, ReentrantLock> item, int quantity) {
        if (item.getKey().getValue() >= quantity) {
            item.getKey().setValue(item.getKey().getValue() - quantity);
            bill.addProductToBill(item.getKey().getKey(), quantity);
            totalSales += (item.getKey().getKey().getPrice() * quantity);
        } else
            throw new IllegalArgumentException("Not enough products of this type!");
    }

    public void checker() {
        this.inventory.lockEverything();
        double actualSales = 0;
        for (int i = 0 ; i<bills.size(); i++) {
            actualSales += bills.get(i).getBillTotal();
        }
        System.out.println(totalSales + " " + actualSales );
        if (totalSales == actualSales) {
            System.out.println("CHECK GOOD");
        } else {
            System.out.println("CHECK BAD");
        }
        this.inventory.unlockEverything();
    }
}
