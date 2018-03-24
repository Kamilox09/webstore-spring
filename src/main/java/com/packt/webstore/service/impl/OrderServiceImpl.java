package com.packt.webstore.service.impl;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.OrderService;
import com.packt.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    public void processOrder(String productId, int count) {
        Product productById = productService.getProductById(productId);
        if (productById.getUnitsInStock() < count) {
            throw new IllegalArgumentException("Zbyt mało towaru. Obecna liczba sztuk w magazynie: "
                    + productById.getUnitsInStock());
        }
        productById.setUnitsInStock(productById.getUnitsInStock() - count);
    }
}
