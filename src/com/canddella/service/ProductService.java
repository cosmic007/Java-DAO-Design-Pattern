package com.canddella.service;

import java.util.List;

import com.canddella.entity.Product;

public interface ProductService {
	
	public Product getProduct(String productCode);
	public void deleteProduct(String productCode);
	public List<Product> listAllProducts();
	
	public void saveProduct(Product product);

}
