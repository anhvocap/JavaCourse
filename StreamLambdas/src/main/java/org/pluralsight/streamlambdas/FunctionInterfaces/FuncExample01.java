package org.pluralsight.streamlambdas.FunctionInterfaces;

import org.pluralsight.streamlambdas.ExampleData;
import org.pluralsight.streamlambdas.Product;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class FuncExample01 {
    static Optional<Product> findProduct(List<Product> products, Predicate<Product> predicate) {
        for(Product product:products) {
            if(predicate.test(product)) return Optional.of(product);
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        String name = "Spaghetti";
        findProduct(products, product -> product.getName().equals(name))
                .map(Product::getPrice)
                .ifPresentOrElse(
                        price -> System.out.printf("The price of %s is %.2f", name, price),
                        () -> System.out.printf("%s is not available %n", name)
                );
    }
}