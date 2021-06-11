package com.pos.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.pos.pojos.Products;
import com.pos.utilities.MyDatabaseConnection;
import com.pos.pojos.*;
import com.pos.utilities.*;

public class OrdersDao {
	
	public boolean createOrder(Orders order,ArrayList<OrderDetails>orderdetails) {
		Connection conn = MyDatabaseConnection.getConnection();
		float totalSgst = 0;
		float totalCgst = 0;
		float totalAmount = 0;
		for(OrderDetails od : orderdetails) {
			totalSgst += od.getProdsgst()*od.getProdqty();
			totalCgst += od.getProdcgst()*od.getProdqty();
			totalAmount += od.getProdprice()*od.getProdqty();
			
		}
		try {
			
			String sql = "insert into orders(cust_id, "+" order_datetime, "+" order_amount, "+" order_sgst, "+ " order_cgst) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,order.getCustid());
			java.sql.Date dt = new java.sql.Date(new java.util.Date().getTime());
			ps.setDate(2,dt);
			ps.setFloat(3,order.getOrderamount());
			ps.setFloat(4,order.getOrdersgst());
			ps.setFloat(5,order.getOrdercgst());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			int id = 0;
			if(rs.next()) {
				id = rs.getInt(1);
			}
			
			
			
	
	
		for(OrderDetails od : orderdetails) {
			sql = "insert into order_details(order_id,"+" prod_id,"+" prod_qty,"+" prod_price,"+" prod_sgst,"+" prod_cgst) values(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.setInt(2,od.getProdId());
			ps.setInt(3,od.getProdqty());
			ps.setFloat(4, od.getProdprice());
			ps.setFloat(5,od.getProdsgst());
			ps.setFloat(6, od.getProdcgst());
			ps.executeUpdate();
			
			
			
		}
		}
			 catch (SQLException sq) {
					System.out.println("Unable to create order." + sq);
			return false;
			
		}
		return true;
	}
	
	public Date fetchOrderDate(int custid){
		Orders o = new Orders();
		
		Connection conn = MyDatabaseConnection.getConnection();
		try {
		String Sql = "Select order_datetime from orders where cust_id=?";
		PreparedStatement ps1 = conn.prepareStatement(Sql);
		ps1.setInt(1,custid);
		ResultSet rs = ps1.executeQuery();//no
		if(rs.next()) {
			java.sql.Date dt = rs.getDate("order_datetime");
			o.setOrderdatetime(new java.util.Date(dt.getTime()));
			
			
		}
		}
		 catch (SQLException sq) {
				System.out.println("Unable to fetch Date" + sq);
		
	}
		return o.getOrderdatetime();
		
		
	}
	public static void main(String args[]) {
		OrdersDao od = new OrdersDao();
		Orders o = new Orders(2,1000,65f,76f);
		ProductsDao pdao = new ProductsDao();
		Products p = pdao.find(1);
		ArrayList <OrderDetails> ar = new ArrayList<OrderDetails>();
		OrderDetails d = new OrderDetails();
		d.setProdId(p.getProdid());
		d.setProdqty(1);
		d.setProdprice(p.getProdprice());
		d.setProdsgst(p.getProdsgst());
		d.setProdcgst(p.getProdcgst());
		ar.add(d);
		
		System.out.println(od.createOrder(o, ar));
		System.out.print(od.fetchOrderDate(1));
		
		
	}
	

}
