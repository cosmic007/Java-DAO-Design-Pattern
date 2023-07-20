package com.canddella.service;

import java.util.List;

import com.canddella.dao.ProductDAOImpl;
import com.canddella.entity.Product;

public class ProductServiceImpl implements ProductService {
	ProductDAOImpl productDAOImpl = new ProductDAOImpl();

	@Override
	public Product getProduct(String productCode) {
		
		
		
		return productDAOImpl.getProduct(productCode);
	}

	@Override
	public void deleteProduct(String productCode) {
		productDAOImpl.deleteProduct(productCode);
		
	}

	@Override
	public List<Product> listAllProducts() {
		
		return productDAOImpl.listAllProducts();
	}

	@Override
	public void saveProduct(Product product) {
		productDAOImpl.saveProduct(product);
		
	}

}
