package com.packt.webstore.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class CartTest {
    private Cart cart;

    @Before
    public void setup() {
        cart = new Cart();
    }

    @Test
    public void cart_grand_price_should_be_equal_to_cartItem_total_price() {
        CartItem cartItem = new CartItem();
        Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
        cartItem.setProduct(iphone);
        cart.addCartItem(cartItem);

        BigDecimal grandPrice = cart.getGrandTotal();

        Assert.assertEquals(cartItem.getTotalPrice(), grandPrice);
    }
}
