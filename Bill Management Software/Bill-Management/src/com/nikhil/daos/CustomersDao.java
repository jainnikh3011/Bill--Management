package com.pos.daos;


import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.pos.pojos.*;
import com.pos.utilities.*;


public class CustomersDao {

		public boolean createCustomer(Customers cust) {
			Connection conn = MyDatabaseConnection.getConnection();
			try {
				String sql = "insert into customers(cust_name, " + "cust_mobiles, "+" cust_address,"+"city,"+" reg_date) values(?,?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1,cust.getCustname());
				ps.setString(2,cust.getCustmobile());
				ps.setString(3,cust.getCustadd());
				ps.setString(4,cust.getCity());
				java.util.Date dt = DateUtils.convertDate("01-01-2000");
				java.sql.Date dt1 = new java.sql.Date(dt.getTime());
				ps.setDate(5,dt1);
				ps.executeUpdate();
			}
				 catch (SQLException sq) {
						System.out.println("Unable to create a Customoer." + sq);
				return false;
				
			}
			return true;
		}
		
		public boolean editCustomer(Customers cust) {
			Connection conn = MyDatabaseConnection.getConnection();
			try {
				String sql = "update customers set cust_name=?,cust_mobiles=?,cust_address=?,city=?,reg_date=? where cust_id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1,cust.getCustname());
				ps.setString(2,cust.getCustmobile());
				ps.setString(3,cust.getCustadd());
				ps.setString(4,cust.getCity());
				java.sql.Date dt = new java.sql.Date(cust.getRegdate().getTime());
				ps.setDate(5,dt);
				ps.setInt(6,cust.getCustid());
				ps.executeUpdate();
			}
				 catch (SQLException sq) {
						System.out.println("Unable to update Category" + sq);
				return false;
				
			}
			return true;
		}
		
		public boolean removeCustomer(int custId) {
			Connection conn = MyDatabaseConnection.getConnection();
			try {
				String sql = "delete from customers where cust_id = ? ";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1,custId);
				ps.executeUpdate();
			}
			 catch (SQLException sq) {
					System.out.println("Unable to delete a row." + sq);
			return false;
			
		}
		return true;
		
		
		}
		public Customers findMobile(String customerMobile) {
			Connection conn = MyDatabaseConnection.getConnection();
			Customers cust = new Customers();

			try {

				String sql = "select * from customers where cust_mobiles = ? ";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, customerMobile);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					cust.setCustid(rs.getInt("cust_id"));
					cust.setCustname(rs.getString("cust_name"));
					cust.setCustmobile(rs.getString("cust_mobiles"));
					cust.setCustadd(rs.getString("cust_address"));
					cust.setCity(rs.getString("city"));
					
					java.sql.Date dt = rs.getDate("reg_date");
					
					cust.setRegdate(new java.util.Date(dt.getTime()));

				}
			} catch (SQLException sq) {
				System.out.println("Unable to fetch rows." + sq);
			}
			return cust;
		}
		
		public Customers find(int custId) {
			Connection conn = MyDatabaseConnection.getConnection();
			Customers d=new Customers();
			try {
				String sql = "Select * from customers where cust_id= ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1,custId);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
				d.setCustid(custId);
				d.setCustname(rs.getString("cust_name")); 
				d.setCustmobile(rs.getString("cust_mobiles"));
				d.setCustadd(rs.getString("cust_address"));
				d.setCity(rs.getString("city"));
				java.sql.Date dt = rs.getDate("reg_date");
				
				d.setRegdate(new java.util.Date(dt.getTime())); 
			}
			}
			 catch (SQLException sq) {
					System.out.println("Unable to find  a row." + sq);
			
		}
		return d ;
		}

		public ArrayList<Customers>findAllCustomers() {
			Connection conn= MyDatabaseConnection.getConnection();
			ArrayList<Customers> a = new ArrayList<Customers>();
			try {
				String sql="Select * from customers";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs= ps.executeQuery();
				while (rs.next()) {
					Customers d =new Customers();
					d.setCustid(rs.getInt("custId"));
					d.setCustname(rs.getString("cust_name")); 
					d.setCustmobile(rs.getString("cust_mobiles"));
					d.setCustadd(rs.getString("cust_address"));
					d.setCity(rs.getString("city"));
					java.sql.Date dt = rs.getDate("reg_date");
					d.setRegdate(new java.util.Date(dt.getTime()));
					
					a.add(d);
					
				}
			}
				 catch (SQLException sq) {
						System.out.println("Unable to find  customer" + sq);
				
			}
			return a;
			}
		
		public ArrayList<Integer>findAllCustomerByIds() {
			Connection conn= MyDatabaseConnection.getConnection();
			ArrayList<Integer> a = new ArrayList<Integer>();
			try {
				String sql="Select * from customers";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs= ps.executeQuery();
				while (rs.next()) {
					int x = 0;
					x=(rs.getInt("cust_id"));
					a.add(x);
					
				}
			}
				 catch (SQLException sq) {
						System.out.println("Unable to find Customer  ." + sq);
				
			}
			return a;
			}
		
		public ArrayList<Customers> searchCustomers(String name) {
			Connection conn = MyDatabaseConnection.getConnection();
			ArrayList<Customers> a = new ArrayList<Customers>();
			try {
				String sql= "Select * from customers where cust_name = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1,name);
				ResultSet rs = ps.executeQuery();
			while(rs.next()) {
					Customers d =new Customers();
					d.setCustid(rs.getInt("custId"));
					d.setCustname(rs.getString("cust_name")); 
					d.setCustmobile(rs.getString("cust_mobiles"));
					d.setCustadd(rs.getString("cust_address"));
					d.setCity(rs.getString("city"));
					
					a.add(d);
					
					
				}
			
			}
				catch (SQLException sq) {
					System.out.println("no  such customer." + sq);
			
		}
		return a;
		}
		

		public static void main (String args[]) {
			
//	
//		Customers c = new Customers("Aman","7456734567","abc","bhopal");
//		CustomersDao dp = new CustomersDao();
//		dp.createCustomer(c); 
			
//		Customers d = new Customers(1,"Mohit",8989898989d,"bada bazar","sagar",dt);
//		CustomersDao dp = new CustomersDao();
//		dp.editCustomer(d);
//		
//		CustomersDao dp1 = new CustomersDao();
//			System.out.println(dp1.findMobile("9993659069"));
//			
//		CustomersDao cp = new CustomersDao();
//		System.out.println(cp.find(2));
		
//		CategoriesDao dp = new CategoriesDao();
//		System.out.println(dp.findAllCategories());
			

//			CategoriesDao dp = new CategoriesDao();
//			System.out.println(dp.findAllCategoriesByIds());
			
//			CategoriesDao dp = new CategoriesDao();
//			ArrayList<Categories> al = dp.searchCategories("clothing");
//			
//			for (Categories c : al) {
//				System.out.println(c);
			
	//}
	}
	}



