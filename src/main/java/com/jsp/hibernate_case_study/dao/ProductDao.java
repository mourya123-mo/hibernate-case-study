package com.jsp.hibernate_case_study.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate_case_study.entity.Cart;
import com.jsp.hibernate_case_study.entity.Product;

public class ProductDao {
	
	Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class).addAnnotatedClass(Cart.class);
	SessionFactory sf = cfg.buildSessionFactory();
	
	public String addproduct(Product p) {
	
	Session session = sf.openSession();
	Transaction trans = session.beginTransaction();
	
	session.save(p);
	trans.commit();
	session.close();
	return "product added sucessfully";
	}

	public Product getProductById(int id) {
	
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		Product product=session.get(Product.class, id);
		trans.commit();
		session.close();
		return product;
	}

	public void getAllProducts() {
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<Product> query=session.createQuery("from Product");
		List<Product> plist=query.getResultList();
		for(Product i:plist)
		{
			System.out.println(i.getProductId() +" " + i.getProductName()+" "+i.getProductPrice()+" "+i.getProductQuantity());
		}
		trans.commit();
		session.close();

	}

//	public void updateProduct() {
//		SessionFactory sf = cfg.buildSessionFactory();
//		Session session = sf.openSession();
//		Transaction trans = session.beginTransaction();
//		System.out.println("enter product quantity to be updated");
//		@SuppressWarnings("unused")
//		int  productQuantity=s.nextInt();
//		@SuppressWarnings("unchecked")
//		Query<Product> query=session.createQuery("update Product set  productQuantity= productQuantity  where productId=1");
//		int nora = query.executeUpdate();
//		System.out.println(nora);
//		
//		trans.commit();
//		session.close();
//
//	}

//	@SuppressWarnings("unused")
//	public void deleteProduct() {
//	SessionFactory sf = cfg.buildSessionFactory();
//	Session session = sf.openSession();
//	Transaction trans = session.beginTransaction();
//	System.out.println("enter product id to be deleted");
//	int productId=s.nextInt();
//	@SuppressWarnings("unchecked")
//	Query<Product> query= session.createQuery("delete from Product where productId=productId");
//	int nora = query.executeUpdate();
//	System.out.println(nora);
//	
//	trans.commit();
//	session.close();
//
//	}
}
