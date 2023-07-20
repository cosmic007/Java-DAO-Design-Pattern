package com.canddella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.canddella.entity.Product;
import com.canddella.service.ProductServiceImpl;

public class Utility {

	public static void main(String[] args) {
		ProductServiceImpl productServiceImpl = new ProductServiceImpl();
		Scanner scanner = new Scanner(System.in);
		ArrayList<Product> productList;
		boolean next = false;
		do {
			System.out.println("1.View Product 2.Delete Product 3.View All Products 4.Save Product");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:

				System.out.println("Enter product Code:");
				scanner.nextLine();
				String productCode = scanner.nextLine();
				Product product = productServiceImpl.getProduct(productCode);
				if (product != null) {
					System.out.println(product.getProductCode() + " - " + product.getProductName() + " - "
							+ product.getProductDescription() + " - " + product.getActivationDate() + " - "
							+ product.getExpiryDate());
				} else {
					System.out.println("No Product Found");
				}
				break;
			case 2:
				System.out.println("Enter product Code:");
				scanner.nextLine();
				String productCodeForDelete = scanner.nextLine();
				productServiceImpl.deleteProduct(productCodeForDelete);
				break; 
				
			case 3:
				productList=(ArrayList<Product>) productServiceImpl.listAllProducts();
				for(Product prod:productList)
				{
					System.out.println(prod.getProductCode() + " - " + prod.getProductName() + " - "
							+ prod.getProductDescription() + " - " + prod.getActivationDate() + " - "
							+ prod.getExpiryDate());
					
					
				}
				break;
				
			case 4:
				
				DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd");
				System.out.println("Enter product code:");
				scanner.nextLine();
				String nProductCode=scanner.nextLine();
				System.out.println("Enter procuct name:");
				String nProductName=scanner.nextLine();
				System.out.println("Enter product description:");
				String nProductDescription = scanner.nextLine();
				System.out.println("Enter activation date:");
				String nActivationDate=scanner.nextLine();
				System.out.println("Enter expiry date");
				String nExpiryDate=scanner.nextLine();
				LocalDate activationDate = LocalDate.parse(nActivationDate,format);
				LocalDate expiryDate = LocalDate.parse(nExpiryDate,format);
				
				productServiceImpl.saveProduct(new Product(nProductCode,nProductName,nProductDescription,activationDate,expiryDate));
				break;
	
			default:
				System.out.println("Enter valid choice");
				break;

			}
			System.out.println("\nDo you want to continue? 1.Yes 2.No");
			int ans=scanner.nextInt();
			if(ans==1)
			{
				next=true;
			}
			else if(ans==2)
			{
				next=false;
				System.out.println("Thank you");
				break;
			}

		} while (next);

	}

}
