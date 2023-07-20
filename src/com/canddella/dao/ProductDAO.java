package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Product;

public interface ProductDAO {
	
	public Product getProduct(String productCode);
	
	public void deleteProduct(String productCode);
	
	public List<Product> listAllProducts();
	
	public void saveProduct(Product product);
}
