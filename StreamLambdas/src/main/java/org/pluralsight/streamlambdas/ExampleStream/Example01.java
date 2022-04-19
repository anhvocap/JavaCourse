package org.pluralsight.streamlambdas.ExampleStream;

import org.pluralsight.streamlambdas.ExampleData;
import org.pluralsight.streamlambdas.Product;

import java.util.List;
import java.util.Comparator;

public class Example01 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

//        products.sort(new Comparator<Product>() {
//            @Override
//            public int compare(Product o1, Product o2) {
//                return o1.getPrice().compareTo(o2.getPrice());
//            }
//        });

        products.sort((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()));

        for(Product product:products) {
            System.out.println(product);
        }


    }
}
