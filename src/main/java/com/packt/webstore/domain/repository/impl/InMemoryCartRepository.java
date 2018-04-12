package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Cart;
import com.packt.webstore.domain.CartItem;
import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.CartRepository;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;
import com.packt.webstore.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class InMemoryCartRepository implements CartRepository {
    private Map<String, Cart> listOfCarts;


    public InMemoryCartRepository() {
        listOfCarts = new HashMap<String, Cart>();
//        Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
//        iphone.setDescription("Apple iPhone 5s, smartfon z 4-calowym " +
//                "wyświetlaczem o rozdzielczości 640x1136 oraz 8-megapikselowym aparatem");
//        iphone.setCategory("Smartfon");
//        iphone.setManufacturer("Apple");
//        iphone.setUnitsInStock(1000);
//        iphone.setCondition("NEW");
//        iphone.setDiscontinued(false);
//
//        CartItem cartItem = new CartItem(iphone);
//        Cart cartt = new Cart("1234");
//        cartt.addCartItem(cartItem);
//        listOfCarts.put("1234",cartt);


    }

    public Cart create(Cart cart) {
        if (listOfCarts.keySet().contains(cart.getCartId())) {
            throw new IllegalArgumentException(String.format("Nie można utworzyć" +
                    " koszyka. Koszyk o wskazanym id (%) już istnieje.", cart.getCartId()));
        }
        listOfCarts.put(cart.getCartId(), cart);
        return cart;
    }

    public Cart read(String cartId) {
        return listOfCarts.get(cartId);
    }

    public void update(String cartId, Cart cart) {
        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException(String.format("Nie można zaktualizować koszyka." +
                    " Koszyk o wskazanym id (%) nie istnieje", cartId));
        }
        listOfCarts.put(cartId, cart);
    }

    public void delete(String cartId) {
        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException(String.format("Nie można usunąć koszyka. " +
                    "Koszyk o wskazanym id (%) nie istnieje", cartId));
        }
        listOfCarts.remove(cartId);
    }
}
