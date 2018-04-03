package com.packt.webstore.domain.repository.impl;


import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.exception.ProductNotFoundException;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    private List<Product> listOfProducts = new ArrayList<Product>();

    public InMemoryProductRepository() {
        Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
        iphone.setDescription("Apple iPhone 5s, smartfon z 4-calowym " +
                "wyświetlaczem o rozdzielczości 640x1136 oraz 8-megapikselowym aparatem");
        iphone.setCategory("Smartfon");
        iphone.setManufacturer("Apple");
        iphone.setUnitsInStock(1000);

        Product laptop_dell = new Product("P1235", "Dell Inspiron", new BigDecimal(700));
        laptop_dell.setDescription("Dell Inspiron, 14-calowy laptop (czarny) z procesorem " +
                "Intel Core 3. generacji");
        laptop_dell.setCategory("Laptop");
        laptop_dell.setManufacturer("Dell");
        laptop_dell.setUnitsInStock(1000);

        Product tablet_Nexus = new Product("P1236", "Nexus 7", new BigDecimal(300));
        tablet_Nexus.setDescription("Google Nexus 7 jest najlżejszym 7-calowym " +
                "tabletem z 4-rdzeniowym procesorem Qualcomm Snapdragon™ S4 Pro");
        tablet_Nexus.setCategory("Tablet");
        tablet_Nexus.setManufacturer("Google");
        tablet_Nexus.setUnitsInStock(1000);

        listOfProducts.add(iphone);
        listOfProducts.add(laptop_dell);
        listOfProducts.add(tablet_Nexus);
    }

    public List<Product> getAllProducts() {
        return listOfProducts;
    }

    public Product getProductById(String productId) {
        Product productById = null;
        for (Product product : listOfProducts) {
            if (product != null && product.getProductId() != null && product.getProductId().equals(productId)) {
                productById = product;
                break;
            }
        }
        if (productById == null) {
            throw new ProductNotFoundException(productId);
        }
        return productById;
    }

    public List<Product> getProductByCategory(String category) {
        List<Product> productsByCategory = new ArrayList<Product>();

        for (Product product : listOfProducts) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                productsByCategory.add(product);
            }
        }
        return productsByCategory;
    }

    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        Set<Product> productsByBrand = new HashSet<Product>();
        Set<Product> productsByCategory = new HashSet<Product>();
        Set<String> criterias = filterParams.keySet();
        if (criterias.contains("brand")) {
            for (String brandName : filterParams.get("brand")) {
                for (Product product : listOfProducts) {
                    if (brandName.equalsIgnoreCase(product.getManufacturer())) {
                        productsByBrand.add(product);
                    }
                }
            }
        }
        if (criterias.contains("category")) {
            for (String category : filterParams.get("category")) {
                productsByCategory.addAll(this.getProductByCategory(category));
            }
        }
        productsByCategory.retainAll(productsByBrand);
        return productsByCategory;

    }

    public List<Product> getProductsByManufacturer(String manufacturer) {
        List<Product> productsByManufacturer = new ArrayList<Product>();
        for (Product product : listOfProducts) {
            if (manufacturer.equalsIgnoreCase(product.getManufacturer())) {
                productsByManufacturer.add(product);
            }
        }
        return productsByManufacturer;
    }

    public Set<Product> getProductsByPriceFilter(Map<String, List<String>> filterPrice) {
        Set<Product> productsByPriceFilter = new HashSet<Product>();
        Set<String> criteria = filterPrice.keySet();
        float low = -1, high = -1;
        if (criteria.contains("low")) {
            low = Float.parseFloat(filterPrice.get("low").get(0));
        }
        if (criteria.contains("high")) {
            high = Float.parseFloat(filterPrice.get("high").get(0));
        }
        if (low != -1 && high == -1) {
            for (Product product : listOfProducts) {
                if (product.getUnitPrice().floatValue() > low) {
                    productsByPriceFilter.add(product);
                }
            }
        }
        if (high != -1 && low == -1) {
            for (Product product : listOfProducts) {
                if (product.getUnitPrice().floatValue() < high) {
                    productsByPriceFilter.add(product);
                }
            }
        }
        if (high != -1 && low != -1) {
            for (Product product : listOfProducts) {
                if (product.getUnitPrice().floatValue() < high && product.getUnitPrice().floatValue() > low) {
                    productsByPriceFilter.add(product);
                }
            }
        }
        return productsByPriceFilter;
    }

    public Set<Product> getProductsByAdvancedFilter(String category, Map<String, List<String>> filterPrice,
                                                    String manufacturer) {
        Set<Product> byCat = new HashSet<>(this.getProductByCategory(category));
        Set<Product> byPrice = new HashSet<>(this.getProductsByPriceFilter(filterPrice));
        Set<Product> byManu = new HashSet<>(this.getProductsByManufacturer(manufacturer));
        Set<Product> filtered = new HashSet<>();
        for (Product product : byCat) {
            if (byPrice.contains(product) && byManu.contains(product)) {
                filtered.add(product);
            }
        }
        return filtered;
    }

    public void addProduct(Product product) {
        listOfProducts.add(product);
    }
}
