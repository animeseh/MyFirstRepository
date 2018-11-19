package com.onlineshop.daos;



import java.util.List;

import com.onlineshop.models.Category;

public interface CategoryDao {
	public boolean addCategory(Category categoryObj);
	public boolean deleteCategory(Category categoryObj);
	public boolean updateCategory(Category Category );
	public Category getCategoryById(int categoryId);
	public List<Category> getAllCategories();
	}


