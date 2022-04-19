package org.pluralsight.streamlambdas.ExampleStream;

import java.math.BigDecimal;
import java.util.List;

import org.pluralsight.streamlambdas.ExampleData;
import org.pluralsight.streamlambdas.Product;

import java.util.List;
import java.util.Comparator;

public class Example02 {

    interface ProductFilter {
        boolean accept(Product product);
    }

    static void printProduct(List<Product> products, ProductFilter filter) {
        for(Product product:products) {
            System.out.println("---");
            if(filter.accept(product)) {
                System.out.println(product);
            }
        }
    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        BigDecimal priceLimit = new BigDecimal("6.00");
        //priceLimit = new BigDecimal("6.00");

        ProductFilter filter = product -> product.getPrice().compareTo(priceLimit) < 0;

        printProduct(products, filter);
    }
}
