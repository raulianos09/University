package varianta1.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Shop implements Runnable {
    private Inventory inventory;
    double totalSales;
    private List<Bill> bills;
    private ReentrantLock lock;
    private ReentrantReadWriteLock checkerLock;

    public Shop(Inventory inventory, ReentrantLock lock, ReentrantReadWriteLock checkerLock) {
        this.inventory = inventory;
        this.totalSales = 0;
        this.bills = new ArrayList<>();
        this.lock = lock;
        this.checkerLock = checkerLock;
    }

    @Override
    public void run() {
        Random r = new Random();

        int productsPerBill = r.nextInt(200);
        Bill bill = new Bill();
        for (int i = 0; i < productsPerBill; i++) {
            try {
                Product productToBuy = this.inventory.selectRandomProduct();
                int quantity = 1 + r.nextInt(20);
                lock.lock();
                sellProduct(bill, productToBuy, quantity);
            } catch (IllegalArgumentException e) {
                //System.out.println(e.getMessage());
            } finally {
               lock.unlock();
            }
        }
        this.bills.add(bill);
        System.out.println("Execution on thread " + Thread.currentThread().getId() + " finished");

    }

    private void sellProduct(Bill bill, Product productToBuy, int quantity) {
        if (this.inventory.getQtyOfProduct(productToBuy) >= quantity) {
            this.inventory.setQtyOfProduct(productToBuy, this.inventory.getQtyOfProduct(productToBuy) - quantity);
            bill.addProductToBill(productToBuy, quantity);
            totalSales += (productToBuy.getPrice() * quantity);
        } else
            throw new IllegalArgumentException("Not enough products of this type!");
    }


    public void checker() {
        double actualSales = 0;
        for (Bill b : bills) {
            actualSales += b.getBillTotal();
        }
        if ((int) totalSales == (int) actualSales) {
            System.out.println("Check result: Consistent");
        } else {
            System.out.println("Check result: Inconsistent");
        }
        System.out.println("Total sales: " + (int) totalSales);
        System.out.println("Actual sales: " + (int) actualSales);
    }
}
