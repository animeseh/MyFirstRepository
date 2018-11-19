package com.onlineshop.daos;
 
import java.util.List;
 

import com.onlineshop.models.Item;
 
public interface ItemDAO {
     
    boolean addItem(Item item);
    boolean updateItem(Item item);
    Item getItemByProductIdAndCustomerId(int productid,String customerId);
    List<Item> getItemsListByCart(int cartId);
    boolean increaseQuantity(int itemId);
    boolean decreaseQuantity(int itemId);
    boolean deleteItem(int itemId);
     
}