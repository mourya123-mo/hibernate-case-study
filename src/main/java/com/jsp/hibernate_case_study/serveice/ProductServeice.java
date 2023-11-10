package com.jsp.hibernate_case_study.serveice;

import java.util.Scanner;

import com.jsp.hibernate_case_study.dao.ProductDao;
import com.jsp.hibernate_case_study.entity.Product;

public class ProductServeice 
{
	Scanner s=new Scanner(System.in);
	Product product=new Product();

	ProductDao productdao=new ProductDao();
	public void addproduct() {
	
	System.out.println("enter product id");
	int id=s.nextInt();
	System.out.println("enter product name");
	String name=s.next();
	System.out.println("enter product price");
	double price=s.nextDouble();
	System.out.println("enter product quantity");
	int quantity=s.nextInt();
	
	product.setProductId(id);
	product.setProductName(name);
	product.setProductPrice(price);
	product.setProductQuantity(quantity);
	
	String mesg=productdao.addproduct(product);
	System.out.println(mesg);
}
	public void getProductById()
	{
		System.out.println("enter product id");
		int id=s.nextInt();
	
		Product byId = productdao.getProductById(id);
		System.out.println(byId);
	
	}
}
