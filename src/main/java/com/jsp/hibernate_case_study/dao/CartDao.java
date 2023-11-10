package com.jsp.hibernate_case_study.dao;

import java.util.Scanner;

import org.hibernate.cfg.Configuration;

import com.jsp.hibernate_case_study.entity.Cart;

public class CartDao {
	Scanner s=new Scanner(System.in);
	Configuration cfg=new Configuration().configure().addAnnotatedClass(Cart.class);
	public void createCart()
	{
		Cart cart=new Cart();
//		cart.getProducts().add();
	}
	
	public void addProductTocart()
	{
		
	}
	public void deleteFromcart()
	{
		
	}
}
