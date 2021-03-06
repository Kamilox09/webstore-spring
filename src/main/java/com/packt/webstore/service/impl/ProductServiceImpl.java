package com.packt.webstore.service.impl;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product getProductById(String productId) {
        return productRepository.getProductById(productId);
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.getProductByCategory(category);
    }


    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        return productRepository.getProductsByFilter(filterParams);
    }

    public List<Product> getProductsByManufacturer(String manufacturer) {
        return productRepository.getProductsByManufacturer(manufacturer);
    }

    public Set<Product> getProductsByPriceFilter(Map<String, List<String>> filterPrice) {
        return productRepository.getProductsByPriceFilter(filterPrice);
    }

    public Set<Product> getProductsByAdvancedFilter(String category, Map<String, List<String>> filterPrice,
                                                    String manufacturer) {
        return productRepository.getProductsByAdvancedFilter(category, filterPrice, manufacturer);
    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

}
