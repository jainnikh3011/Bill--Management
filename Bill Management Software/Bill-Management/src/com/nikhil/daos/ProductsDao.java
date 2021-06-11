package com.pos.daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.pos.pojos.*;
import com.pos.utilities.*;

public class ProductsDao {
	
public boolean createProduct(Products product) {
			Connection conn = MyDatabaseConnection.getConnection();
			try {
				String sql = "insert into products(cat_id, " + " prod_code, "+" prod_name, "+" prod_price, "+" prod_qih, "+" prod_reorder_level, "+" prod_sgst, "+" prod_cgst) values(?,?,?,?,?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1,product.getCatid());
				ps.setString(2,product.getProdcode());
				ps.setString(3,product.getProdname());
				ps.setFloat(4,product.getProdprice());
				ps.setInt(5,product.getProdqih());
				ps.setInt(6,product.getProdreorderlevel());
				ps.setFloat(7,product.getProdsgst());
				ps.setFloat(8,product.getProdcgst());
				ps.executeUpdate();
			}
				 catch (SQLException sq) {
						System.out.println("Unable to create a new row." + sq);
				return false;
				
			}
			return true;
		}
		public ArrayList<String>findAllProduct() {
			Connection conn= MyDatabaseConnection.getConnection();
			ArrayList<String> a = new ArrayList<String>();
			try {
				String sql="Select prod_name from products";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs= ps.executeQuery();
				while (rs.next()) {
					Products d =new Products();
					d.setProdname(rs.getString("prod_name"));
					
					
					a.add(d.getProdname());
					
				}
			}
				 catch (SQLException sq) {
						System.out.println("Unable to find  a new row." + sq);
				
			}
			return a;
			}
		
		public boolean editProduct(Products product) {
			Connection conn = MyDatabaseConnection.getConnection();
			try {
				String sql = "update products set cat_id=?,prod_code=?,  prod_name=?, prod_price=?,prod_qih=?,prod_reorder_level=?,prod_sgst=?, prod_cgst=? where prod_id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1,product.getCatid());
				ps.setString(2,product.getProdcode());
				ps.setString(3,product.getProdname());
				ps.setFloat(4,product.getProdprice());
				ps.setInt(5,product.getProdqih());
				ps.setInt(6,product.getProdreorderlevel());
				ps.setFloat(7,product.getProdsgst());
				ps.setFloat(8,product.getProdcgst());
				ps.setInt(9, product.getProdid());
				ps.executeUpdate();
			}
				 catch (SQLException sq) {
						System.out.println("Unable to update products" + sq);
				return false;
				
			}
			return true;
		}
		
		public boolean removeProduct(int prodId) {
			Connection conn = MyDatabaseConnection.getConnection();
			try {
				String sql = "delete from products where prod_id = ? ";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1,prodId);
				ps.executeUpdate();
			}
			 catch (SQLException sq) {
					System.out.println("Unable to delete Products." + sq);
			return false;
			
		}
		return true;
		
		
		}
		
		public Products find(int prodId) {
			Connection conn = MyDatabaseConnection.getConnection();
			Products d=new Products();
			try {
				String sql = "Select * from products where prod_id= ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1,prodId);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
				d.setProdid(prodId);
				d.setCatid(rs.getInt("cat_id")); 
				d.setProdcode(rs.getString("prod_code"));
				d.setProdname(rs.getString("prod_name"));
				d.setProdprice(rs.getFloat("prod_price"));
				d.setProdqih(rs.getInt("prod_qih"));
				d.setProdreorderlevel(rs.getInt("prod_reorder_level"));
				d.setProdsgst(rs.getFloat("prod_sgst"));
				d.setProdcgst(rs.getFloat("prod_cgst"));
			}
			}
			 catch (SQLException sq) {
					System.out.println("Unable to find  a new row." + sq);
			
		}
		return d ;
		}

		public ArrayList<Products>findAllProducts() {
			Connection conn= MyDatabaseConnection.getConnection();
			ArrayList<Products> a = new ArrayList<Products>();
			try {
				String sql="Select * from products";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs= ps.executeQuery();
				while (rs.next()) {
					Products d =new Products();
					d.setProdid(rs.getInt("prod_id"));
					d.setCatid(rs.getInt("cat_id")); 
					d.setProdcode(rs.getString("prod_code"));
					d.setProdname(rs.getString("prod_name"));
					d.setProdprice(rs.getFloat("prod_price"));
					d.setProdqih(rs.getInt("prod_qih"));
					d.setProdreorderlevel(rs.getInt("prod_reorder_level"));
					d.setProdsgst(rs.getFloat("prod_sgst"));
					d.setProdcgst(rs.getFloat("prod_cgst"));
					
					a.add(d);
					
				}
			}
				 catch (SQLException sq) {
						System.out.println("Unable to find  a new row." + sq);
				
			}
			return a;
			}
		
		public ArrayList<Integer>findAllProductByIds() {
			Connection conn= MyDatabaseConnection.getConnection();
			ArrayList<Integer> a = new ArrayList<Integer>();
			try {
				String sql="Select prod_id from products";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs= ps.executeQuery();
				while (rs.next()) {
					Products d =new Products();
					d.setProdid(rs.getInt("prod_id"));
					
					
					a.add(d.getProdid());
					
				}
			}
				 catch (SQLException sq) {
						System.out.println("Unable to find  a products" + sq);
				
			}
			return a;
			}
		
		public ArrayList<Products> searchProducts(String name) {
			Connection conn = MyDatabaseConnection.getConnection();
			ArrayList<Products> a = new ArrayList<Products>();
			try {
				String sql= "Select * from products where prod_name = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1,name);
				ResultSet rs = ps.executeQuery();
			while(rs.next()) {
					Products d =new Products();
					d.setProdid(rs.getInt("prod_id"));
					d.setCatid(rs.getInt("cat_id")); 
					d.setProdcode(rs.getString("prod_code"));
					d.setProdname(rs.getString("prod_name"));
					d.setProdprice(rs.getFloat("prod_price"));
					d.setProdqih(rs.getInt("prod_qih"));
					d.setProdreorderlevel(rs.getInt("prod_reorder_level"));
					d.setProdsgst(rs.getFloat("prod_sgst"));
					d.setProdcgst(rs.getFloat("prod_cgst"));
					
					a.add(d);
					
					
				}
			
			}
				catch (SQLException sq) {
					System.out.println("Unable to find a products" + sq);
			
		}
		return a;
		}

		public ArrayList<Products> findAllByCategory(int catid) {
			Connection conn= MyDatabaseConnection.getConnection();
			ArrayList<Products> a = new ArrayList<Products>();
			try {
				String sql="Select * from products where cat_id=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1,catid);
				ResultSet rs= ps.executeQuery();
				while (rs.next()) {
					Products d =new Products();
					d.setCatid(catid);
					d.setProdid(rs.getInt("prod_id"));
					d.setProdcode(rs.getString("prod_code"));
					d.setProdname(rs.getString("prod_name"));
					d.setProdprice(rs.getFloat("prod_price"));
					d.setProdqih(rs.getInt("prod_qih"));
					d.setProdreorderlevel(rs.getInt("prod_reorder_level"));
					d.setProdsgst(rs.getFloat("prod_sgst"));
					d.setProdcgst(rs.getFloat("prod_cgst"));
					//d.setCatname(rs.getString("cat_name"));
					
					a.add(d);
					
				}
			}
				 catch (SQLException sq) {
						System.out.println("Unable to find  Category" + sq);
				
			}
			return a;
			}
		

		public static void main (String args[]) {
//		Products c = new Products(2,"abc","apple",50f,2,3,8.4f,7.8f);
		ProductsDao dp = new ProductsDao();
//		dp.createProduct(c); 
			
		Products p = new Products();
//		CategoriesDao dp = new CategoriesDao();
//		dp.editCategory(d);
		System.out.println(dp.findAllProduct());
		
//		CategoriesDao dp = new CategoriesDao();
//		dp.removeCategory(1);
			
//		CategoriesDao cp = new CategoriesDao();
//		System.out.println(cp.find(2));
		
//		CategoriesDao dp = new CategoriesDao();
		//System.out.println(dp.findAllByCategory(1));
			

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



