package org.example;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class ProductTest extends TestCase {
    public void testProductListJson() {
        List<Product> list = new ArrayList<>();
        Product p = new Product("12as","orange", 2.1);
        list.add(p);
        list.add(new Product("12at","apple", 1.5));

    }



}