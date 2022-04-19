package org.pluralsight.streamlambdas.ExampleStream;

import org.pluralsight.streamlambdas.ExampleData;
import org.pluralsight.streamlambdas.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Example06 {
    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        try (FileWriter writer = new FileWriter("products.txt")) {
            products.forEach(product -> {
                try {
                    writer.write(product.toString() + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException | RuntimeException e){
            System.err.println("An exception occurred:" + e.getMessage());
        }
    }
}
