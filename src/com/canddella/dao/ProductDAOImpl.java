package com.canddella.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.canddella.entity.Product;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public Product getProduct(String productCode) {
		Product product=null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		try
		{
			
		
		Connection connection=DatabaseConnection.getConnection();
		PreparedStatement statement=connection.prepareStatement("select * from product where productcode=?");
		statement.setString(1, productCode);
		ResultSet resultSet=statement.executeQuery();
		while(resultSet.next())
		{
			LocalDate activationDate=LocalDate.parse(resultSet.getString(5), formatter);
			LocalDate expiryDate=LocalDate.parse(resultSet.getString(6), formatter);
			
			product=new Product(resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),activationDate,expiryDate);
			
		}
		connection.close();
		
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return product;
	}

	@Override
	public void deleteProduct(String productCode) {
		try
		{
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement("delete from product where productcode=?");
			statement.setString(1, productCode);
			statement.executeUpdate();
			System.out.println("Deleted");
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public List<Product> listAllProducts() {
		ArrayList <Product> productList = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate activationDate=null;
		LocalDate expiryDate=null;
		try
		{
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from product");
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next())
			{
				activationDate=LocalDate.parse(resultSet.getString(5), formatter);
				expiryDate=LocalDate.parse(resultSet.getString(6), formatter);
				
				Product product=new Product(resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),activationDate,expiryDate);
				productList.add(product);
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return productList;
	}

	@Override
	public void saveProduct(Product product) {
		try
		{
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into product(productcode,productname,productdescription,activationdate,expirydate) values(?,?,?,?,?)");
			statement.setString(1, product.getProductCode());
			statement.setString(2,product.getProductName());
			statement.setString(3,product.getProductDescription());
			Date activationDate= Date.valueOf(product.getActivationDate());
			Date expiryDate= Date.valueOf(product.getExpiryDate());
			
			statement.setDate(4,activationDate);
			statement.setDate(5, expiryDate);
			int count=0;
			count=statement.executeUpdate();
			if(count>0)
			{
				System.out.println("Updated Successfully");
			}
			connection.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
