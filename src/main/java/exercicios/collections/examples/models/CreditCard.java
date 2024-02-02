package exercicios.collections.examples.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CreditCard {
    private double limit;
    private double balance;
    private final List<Product> products;

    public CreditCard(double limit) {
        this.limit = limit;
        this.balance = limit;
        this.products = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public boolean purchase(Product product){
        if(this.balance >= product.getPrice() ){
            this.balance -= product.getPrice();
            products.add(product);
            return true;
        }

        return false;
    }
}
