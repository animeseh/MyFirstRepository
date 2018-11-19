package com.onlineshop.daos;

import com.onlineshop.models.Cart;

public interface CartDao {
	boolean addCart(Cart cart);
    Cart getCartByCustomer(String customerId);
    boolean deleteCart(int cartId);
}
