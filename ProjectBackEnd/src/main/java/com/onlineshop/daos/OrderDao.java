package com.onlineshop.daos;
 
import com.onlineshop.models.Order;
 
 
public interface OrderDao {
     
    public int makeOrder(Order order);
}