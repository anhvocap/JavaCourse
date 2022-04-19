package org.pluralsight.streamlambdas.FunctionInterfaces;

import org.pluralsight.streamlambdas.Category;
import org.pluralsight.streamlambdas.ExampleData;
import org.pluralsight.streamlambdas.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuncExample02 {
    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        Map<Category, List<Product>> productsByCategory = new HashMap<>();

        for(Product product:products) {
            productsByCategory.computeIfAbsent(product.getCategory(), c -> new ArrayList<>()).add(product);
        }

        productsByCategory.forEach((category, ps) -> {
            System.out.println("Category:" + category);
            ps.forEach(product -> {
                System.out.println("- " + product.getName());
            });
        });
    }
}
