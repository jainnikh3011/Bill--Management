package com.pos.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.pos.pojos.*;
import com.pos.utilities.*;


public class CategoriesDao {
	
	public boolean createCategory(Categories cat) {
		Connection conn = MyDatabaseConnection.getConnection();
		try {
			String sql = "insert into categories(cat_name, " + "cat_details) values(?,?)";//
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,cat.getCatname());
			ps.setString(2,cat.getCatdetails());
			ps.executeUpdate();
		}
			 catch (SQLException sq) {
					System.out.println("Unable to create a Category" + sq);
			return false;
			
		}
		return true;
	}
	
	public boolean editCategory(Categories cat) {
		Connection conn = MyDatabaseConnection.getConnection();
		try {
			String sql = "update categories set cat_name = ?,cat_details = ? where cat_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,cat.getCatname());
			ps.setString(2,cat.getCatdetails());
			ps.setInt(3,cat.getCatid());
			ps.executeUpdate();
		}
			 catch (SQLException sq) {
					System.out.println("Unable to update a new row." + sq);
			return false;
			
		}
		return true;
	}
	
	public boolean removeCategory(int catId) {
		Connection conn = MyDatabaseConnection.getConnection();
		try {
			String sql = "delete from categories where cat_id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,catId);
			ps.executeUpdate();
		}
		 catch (SQLException sq) {
				System.out.println("Unable to delete a new row." + sq);
		return false;
		
	}
	return true;
	
	
	}
	public ArrayList<String>findAllCategory() {
		Connection conn= MyDatabaseConnection.getConnection();
		ArrayList<String> a = new ArrayList<String>();
		try {
			String sql="Select cat_name from categories";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while (rs.next()) {
				Categories d =new Categories();
				d.setCatname(rs.getString("cat_name"));
				
				
				a.add(d.getCatname());
				
			}
		}
			 catch (SQLException sq) {
					System.out.println("Unable to find  a Category" + sq);
			
		}
		return a;
		}
	
	public Categories find(int catId) {
		Connection conn = MyDatabaseConnection.getConnection();
		Categories d=new Categories();
		try {
			String sql = "Select * from categories where cat_id= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,catId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
			d.setCatid(catId);
			d.setCatdetails(rs.getString("cat_details")); 
			d.setCatname(rs.getString("cat_name"));
		}
		}
		 catch (SQLException sq) {
				System.out.println("Unable to find Category." + sq);
		
	}
	return d ;
	}

	public ArrayList<Categories>findAllCategories() {
		Connection conn= MyDatabaseConnection.getConnection();
		ArrayList<Categories> a = new ArrayList<Categories>();
		try {
			String sql="Select * from categories";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while (rs.next()) {
				Categories d =new Categories();
				d.setCatid(rs.getInt("cat_id"));
				d.setCatdetails(rs.getString("cat_details"));
				d.setCatname(rs.getString("cat_name"));
				
				a.add(d);
				
			}
		}
			 catch (SQLException sq) {
					System.out.println("Unable to find Category" + sq);
			
		}
		return a;
		}
	
	public ArrayList<Integer>findAllCategoriesByIds() {
		Connection conn= MyDatabaseConnection.getConnection();
		ArrayList<Integer> a = new ArrayList<Integer>();
		try {
			String sql="Select cat_id from categories";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while (rs.next()) {
				Categories d =new Categories();
				d.setCatid(rs.getInt("cat_id"));
				
				
				a.add(d.getCatid());
				
			}
		}
			 catch (SQLException sq) {
					System.out.println("Unable to find  Category." + sq);
			
		}
		return a;
		}
	
	public ArrayList<Categories> searchCategories(String name) {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<Categories> a = new ArrayList<Categories>();
		try {
			String sql= "Select * from categories where cat_name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,name);
			ResultSet rs = ps.executeQuery();
		while(rs.next()) {
				Categories d =new Categories();
				d.setCatid(rs.getInt("cat_id"));
				d.setCatdetails(rs.getString("cat_details"));
				d.setCatname(rs.getString("cat_name"));
				
				a.add(d);
				
				
			}
		
		}
			catch (SQLException sq) {
				System.out.println("no such Category" + sq);
		
	}
	return a;
	}
	public ArrayList<Categories> findAllCategories(int catid) {
		Connection conn = MyDatabaseConnection.getConnection();
		ArrayList<Categories> a = new ArrayList<Categories>();
		try {
			String sql= "Select * from categories where cat_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,catid);
			ResultSet rs = ps.executeQuery();
		while(rs.next()) {
				Categories d =new Categories();
				d.setCatid(rs.getInt("cat_id"));
				d.setCatdetails(rs.getString("cat_details"));
				d.setCatname(rs.getString("cat_name"));
				
				a.add(d);
				
				
			}
		
		}
			catch (SQLException sq) {
				System.out.println("Unable to find Category" + sq);
		
	}
	return a;
		
		
	}
	

	public static void main (String args[]) {
//	Categories c = new Categories("clothing","For Attract");
//	CategoriesDao dp = new CategoriesDao();
//	dp.createCategory(c); 
		
//	Categories d = new Categories(1,"Marketing","For web designing ");
//	CategoriesDao dp = new CategoriesDao();
//	dp.editCategory(d);
	
//	CategoriesDao dp = new CategoriesDao();
//	dp.removeCategory(1);
		
	CategoriesDao cp = new CategoriesDao();
	System.out.println(cp.find(2));
	
//	CategoriesDao dp = new CategoriesDao();
//	System.out.println(dp.findAllCategories());
		

//		CategoriesDao dp = new CategoriesDao();
//		System.out.println(dp.findAllCategoriesByIds());
		
//		CategoriesDao dp = new CategoriesDao();
//		ArrayList<Categories> al = dp.searchCategories("clothing");
//		
//		for (Categories c : al) {
//			System.out.println(c);
		
//}
}

	
}
