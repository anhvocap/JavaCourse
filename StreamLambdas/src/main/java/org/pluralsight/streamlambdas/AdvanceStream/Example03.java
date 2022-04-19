package org.pluralsight.streamlambdas.AdvanceStream;

import org.pluralsight.streamlambdas.ExampleData;
import org.pluralsight.streamlambdas.Product;

import java.util.ArrayList;
import java.util.List;

public class Example03 {
    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        List<String> productName1 = products.stream().reduce(
                new ArrayList<>(),
                (list, product) -> {
                    ArrayList<String> newList = new ArrayList<>(list);
                    newList.add(product.getName());
                    return newList;
                },
                (list1, list2) -> {
                    ArrayList<String> newList = new ArrayList<>(list1);
                    newList.addAll(list2);
                    return newList;
                }
        );
        productName1.forEach(product -> System.out.println(product));

        List<String> productName2 = products.stream().collect(
                ArrayList::new,
                (list, product) -> list.add(product.getName()),
                ArrayList::addAll
        );
        System.out.println("---");
        productName2.forEach(product -> System.out.println(product));

    }
}
