package org.pluralsight.streamlambdas.ExampleStream;

import org.pluralsight.streamlambdas.Category;
import org.pluralsight.streamlambdas.ExampleData;
import org.pluralsight.streamlambdas.Product;

import java.math.BigDecimal;
import java.util.List;

public class Example07 {

    interface ProductFactory {
        Product create(Category category, String name, BigDecimal price);
    }

    static boolean isExpensive(Product product) {
        return product.getPrice().compareTo(new BigDecimal("3.00")) >= 0;
    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        products.removeIf(Example07::isExpensive);

        products.forEach(System.out::println);

        products.stream().map(Product::getName).forEach(System.out::println);

        ProductFactory factory = Product::new;

        Product blueberries = factory.create(Category.FOOD, "Blueberries", new BigDecimal("6.95"));
        System.out.println(blueberries);
    }
}