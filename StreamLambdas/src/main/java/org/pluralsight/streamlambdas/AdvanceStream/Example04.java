package org.pluralsight.streamlambdas.AdvanceStream;

import org.pluralsight.streamlambdas.Category;
import org.pluralsight.streamlambdas.ExampleData;
import org.pluralsight.streamlambdas.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

public class Example04 {
    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        Map<Category, BigDecimal> totalPerCategory = products.stream()
                .collect(Collectors.toMap(
                        Product::getCategory,
                        Product::getPrice,
                        BigDecimal::add
                ));

        System.out.println(totalPerCategory);
    }
}
