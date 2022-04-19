package org.pluralsight.streamlambdas.FunctionInterfaces;

import org.pluralsight.streamlambdas.Category;
import org.pluralsight.streamlambdas.ExampleData;
import org.pluralsight.streamlambdas.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class FuncExample04 {
    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        Optional<Product> opt = products.stream()
                .filter(product -> product.getCategory() == Category.OFFICE)
                .findAny();

        opt.ifPresent(System.out::println);

        boolean foundOfficeProduct = products.stream()
                .anyMatch(product -> product.getCategory() == Category.OFFICE);

        System.out.println("Does the list contain at least one office product ? " + foundOfficeProduct);

        BigDecimal priceLimit = new BigDecimal("10.00");
        boolean allProductsAreCheap = products.stream()
                .allMatch(product -> product.getPrice().compareTo(priceLimit) < 0);
        System.out.println("Are all products cheap ?" + allProductsAreCheap);

        boolean allProductsAreExpensive = products.stream()
                .noneMatch(product -> product.getPrice().compareTo(priceLimit) < 0);
        System.out.println("Are all products expensive ?" + allProductsAreExpensive);
    }
}
