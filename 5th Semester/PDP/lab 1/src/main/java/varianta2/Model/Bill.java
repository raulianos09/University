package varianta2.Model;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    List<ImmutablePair<Product, Integer>> bill;
    double billTotal;

    public Bill() {
        this.bill = new ArrayList<>();
        this.billTotal = 0;
    }

    public void addProductToBill(Product p, Integer quantity)
    {
        this.bill.add(new ImmutablePair<>(p, quantity));
        this.billTotal += (p.getPrice() * quantity);
    }

    public Double getBillTotal(){
        return this.billTotal;
    }
}
