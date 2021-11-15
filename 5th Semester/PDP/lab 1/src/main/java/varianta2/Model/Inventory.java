package varianta2.Model;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.tuple.MutablePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Inventory {
    List<MutablePair<MutablePair<Product,Integer>, ReentrantLock>> inventory;

    public Inventory() {
        this.inventory = new ArrayList<>();
        generateInventory();
    }

    private void generateInventory(){
        int numberOfProducts = 10000;
        int maxQuantity = 1000;
        for (int i = 0; i < numberOfProducts; i++) {
            String generatedName = RandomStringUtils.randomAlphabetic(10);
            Random r = new Random();
            double generatedPrice = r.nextDouble(20);
            int generatedQuantity = r.nextInt(maxQuantity);
            Product p = new Product(generatedName,generatedPrice);
            inventory.add(new MutablePair<>(new MutablePair<>(p,generatedQuantity), new ReentrantLock()));
        }
    }

    public MutablePair<MutablePair<Product, Integer>, ReentrantLock> selectRandomProduct() {
        Random r = new Random();
        return this.inventory.get(r.nextInt(this.inventory.size()));
    }

    public void lockEverything(){
        for (MutablePair<MutablePair<Product, Integer>, ReentrantLock>  item:inventory) {
            item.getValue().lock();
        }
    }

    public void unlockEverything(){
        for (MutablePair<MutablePair<Product, Integer>, ReentrantLock>  item:inventory) {
            item.getValue().unlock();
        }
    }
}
