package varianta1.Model;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.*;
import java.util.*;

public class Inventory {
    private HashMap<Product, Integer> productList;

    public Inventory() {
        this.productList = new HashMap<>();
    }

    public Product selectRandomProduct(){
        List<Product> products = this.productList.keySet().stream().toList();
        Random r = new Random();
        return products.get(r.nextInt(products.size()));
    }

    public int getQtyOfProduct(Product p){
        return this.productList.get(p);
    }

    public void setQtyOfProduct(Product p, int newQty)
    {
        this.productList.put(p,newQty);
    }

    public void generateAndLoad() throws IOException {
        int numberOfProducts = 10000;
        int maxQuantity = 1000;
        for (int i = 0; i < numberOfProducts; i++) {
            String generatedName = RandomStringUtils.randomAlphabetic(10);
            Random r = new Random();
            double generatedPrice = r.nextDouble(20);
            int generatedQuantity = r.nextInt(maxQuantity);
            Product p = new Product(generatedName, generatedPrice);
            if (productList.containsKey(p)) {
                productList.put(p, productList.get(p) + generatedQuantity);
            } else {
                productList.put(p, generatedQuantity);
            }
        }
        saveInventory();
    }

    private void saveInventory() throws IOException {
        FileWriter writer = new FileWriter("inventory.txt");

        Set<Product> products = productList.keySet();
        for (Product pr : products) {
            writer.write(pr.getName() + " " + pr.getPrice() + " " + productList.get(pr) + "\n");
        }
        writer.close();
    }

    public void loadInventory() throws IOException {
        File inventoryFile = new File("inventory.txt");
        BufferedReader reader = new BufferedReader(new FileReader(inventoryFile));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] args = line.split(" ");
            Product p = new Product(args[0], Double.parseDouble(args[1]));
            if (productList.containsKey(p)) {
                productList.put(p, productList.get(p) + Integer.parseInt(args[2]));
            } else {
                productList.put(p, Integer.parseInt(args[2]));
            }
        }
    }

}
