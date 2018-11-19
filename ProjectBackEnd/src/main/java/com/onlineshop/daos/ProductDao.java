package com.onlineshop.daos;

import java.util.List;

import com.onlineshop.models.Product;

public interface ProductDao {
	public boolean addProduct(Product productObj);
	public boolean deleteProduct(Product ProductObj);
	public boolean updateProduct(Product product );
	public Product getProductById(int ProductId);
	public List<Product> getAllProducts();
	public List<Product>getAllProductsByCategory(int categoryId);
}
