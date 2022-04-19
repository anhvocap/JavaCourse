package org.pluralsight.streamlambdas.AdvanceStream;

import org.pluralsight.streamlambdas.ExampleData;
import org.pluralsight.streamlambdas.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class Example02 {
    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        Optional<BigDecimal> opt = products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal::add);

        opt.ifPresentOrElse(
                total -> System.out.printf("The total value of all products is: $ %.2f%n", total),
                () -> System.out.printf("There are no products"));

        BigDecimal total = products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.printf("The total value of all products is: $ %.2f%n", total);

        BigDecimal total2 = products.stream()
                .reduce(BigDecimal.ZERO, (result, product) -> result.add(product.getPrice()), BigDecimal::add);
        System.out.printf("The total value of all products is: $ %.2f%n", total2);
    }
}
