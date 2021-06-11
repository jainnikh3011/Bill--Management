package com.pos.daos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import com.pos.pojos.Categories;
import com.pos.pojos.Products;
import com.pos.utilities.MyDatabaseConnection;

public class ReportsDao {

	public ArrayList<ArrayList<String>> getCategoryWiseSales(int catId, String fromDate, String toDate) {
		ArrayList<ArrayList<String>> alist = new ArrayList<ArrayList<String>>();
		CategoriesDao catDao = new CategoriesDao();
		ArrayList<Categories> catList = null;
		if (catId == 0) {
			catList = catDao.findAllCategories();
		} else {
			Categories cat = catDao.find(catId);
			catList = new ArrayList<Categories>();
			catList.add(cat);
		}
		for (Categories c : catList) {
			ArrayList<String> alString = new ArrayList<String>();
			alString.add(c.getCatname());
			Connection con = MyDatabaseConnection.getConnection();
			String sql = "SELECT sum(o.prod_price * o.prod_qty) from order_details o, products p, categories c, orders od"
					+ " where c.cat_id = ? and p.cat_id = c.cat_id and o.order_id = od.order_id and od.order_datetime >= ? and od.order_datetime <= ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, c.getCatid());
				ps.setString(2, fromDate);
				ps.setString(3, toDate);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					float amount = rs.getFloat(1);
					alString.add("" + amount);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			alist.add(alString);
		}
		// System.out.print(alist);
		return alist;
	}

	public ArrayList<Integer> getStockOrderReport() {
	
			Connection conn = MyDatabaseConnection.getConnection();
			ArrayList<Integer> listproducts = new ArrayList<Integer>();	
			try {
				String sql = "Select cat_id, prod_qih from products where prod_qih < prod_reorder_level";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					//Products pro = new Products();
					//pro.setCatid(rs.getString("cat_name"));
					//pro.setProdname(rs.getString("prod_name"));
					//pro.setProdqih(rs.getInt("prod_qih"));
					
					listproducts.add(rs.getInt("cat_id"));
					listproducts.add(rs.getInt("prod_qih"));
				}
			} catch (SQLException sq) {
				System.out.println("Unable to fetch rows.");
			}
			return listproducts;
		}


	public static void main(String[] args) {
		ReportsDao reportsDao = new ReportsDao();
		/*
		 * ArrayList<ArrayList<String>> alist = reportsDao.getCategoryWiseSales(0,
		 * "2019-1-1", "2020-12-1"); for (ArrayList al : alist) {
		 * System.out.println(al); }
		 */
		//ArrayList<Products> list = reportsDao.getStockOrderReport();
		//for (Products al : list) {
			System.out.println(reportsDao.getStockOrderReport());
		//}
	}
}

