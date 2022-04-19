package org.pluralsight.streamlambdas.AdvanceStream;

import org.pluralsight.streamlambdas.Category;
import org.pluralsight.streamlambdas.ExampleData;
import org.pluralsight.streamlambdas.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example05 {
    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        Map<Category, List<Product>> productByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        productByCategory.forEach((category, productList) -> {
            System.out.println("===" + category + "===");
            productList.forEach(product -> System.out.println(product));
        });

        Map<Category, List<String>> productNameByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.mapping(Product::getName, Collectors.toList())));

        productNameByCategory.forEach(((category, strings) -> {
            System.out.println("---" + category + "---");
            strings.forEach(s -> System.out.println(s));
        }));

        Map<Category, BigDecimal> totalPerCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.mapping(Product::getPrice, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
                ));

        totalPerCategory.forEach(((category, decimal) -> {
            System.out.println("---" + category + ":" + decimal);
        }));

    }
}
