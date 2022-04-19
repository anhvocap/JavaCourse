package org.pluralsight.streamlambdas.ExampleStream;

import org.pluralsight.streamlambdas.ExampleData;
import org.pluralsight.streamlambdas.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Example04 {
    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        BigDecimal priceLimit = new BigDecimal("5.00");

        List<Product> cheapProducts = new ArrayList<>();
        products.parallelStream().forEach(product -> {
            if(product.getPrice().compareTo(priceLimit) < 0) {
                cheapProducts.add(product);
            }
        });

        cheapProducts.forEach(product -> {
            System.out.println(product);
        });

        //System.out.println("There are " + cheapProducts.size() + " cheap products");
    }
}
