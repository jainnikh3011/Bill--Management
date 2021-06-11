package com.pos.Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import com.pos.daos.CategoriesDao;
import com.pos.daos.CustomersDao;
import com.pos.daos.OrdersDao;
import com.pos.daos.ProductsDao;
import com.pos.pojos.Customers;
import com.pos.pojos.OrderDetails;
import com.pos.pojos.Orders;
import com.pos.pojos.Products;
import com.pos.utilities.DateUtils;


public class Sale  extends JPanel implements ActionListener{
	JLabel mobile,lblName,lblmobile,lblAddress, lblCity,lblRegdate,lblOrderDnT ,lblCategory, lblProduct, lblQuantity;
	JTextField tfMobile,txtName, txtMobile, txtAddress, txtCity,tfRegdate,tfOrderDnT,tfProduct, tfQuantity;
	JButton btn1, btn2, generateBill, clearBtn;
	JComboBox<String> comboProduct;
	Customers customer;
	CustomersDao cd;
	ProductsDao productDao;
	Products p;
	ArrayList<String> category, product;
	ArrayList<Integer> ids, id;  
	DefaultComboBoxModel<String> productModel;
	JTable table;
	JLabel cgst, sgst, total, grandTotal;
	float cgstF, sgstF, totalF, grandTotalF;
	ArrayList<OrderDetails> orderDetails;
	
	
	
	
	public Sale() {
		setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel();
		northPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		mobile = new JLabel("Customer Mobile");
		mobile.setFont(new Font("Verdana", Font.PLAIN, 18));
		tfMobile = new JTextField(20);
		northPanel.add(mobile);
		northPanel.add(tfMobile);
		btn1 = new JButton("GO");
		btn1.setActionCommand("Go");
		btn1.addActionListener(this);
		northPanel.add(btn1);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(null);
		centerPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	
		lblName = new JLabel("Customer Name");
		txtName = new JTextField();
		centerPanel.add(lblName);
		centerPanel.add(txtName);
		lblmobile = new JLabel("Customer Mobile");
		txtMobile = new JTextField();
		centerPanel.add(lblmobile);
		centerPanel.add(txtMobile);
		lblAddress = new JLabel("Customer Add");
		txtAddress = new JTextField();
		centerPanel.add(lblAddress);
		centerPanel.add(txtAddress);
		lblCity = new JLabel("City");
		txtCity = new JTextField();
		centerPanel.add(lblCity);
		centerPanel.add(txtCity);
		lblRegdate = new JLabel("Registration Date");
		tfRegdate = new JTextField();
		centerPanel.add(lblRegdate);
		centerPanel.add(tfRegdate);
		lblOrderDnT = new JLabel("Order Time ");
		tfOrderDnT = new JTextField();
		centerPanel.add(lblOrderDnT);
		centerPanel.add(tfOrderDnT);
		
		

		
		
		
		lblProduct = new JLabel("Products");
		centerPanel.add(lblProduct);
		
		productDao = new ProductsDao();
		product = productDao.findAllProduct();
		id = productDao.findAllProductByIds();
		String str[] = new String[0];
		str = product.toArray(str);
		productModel = new DefaultComboBoxModel<String>(str);
		comboProduct = new JComboBox<String>(productModel);
		comboProduct.addActionListener(this);
		centerPanel.add(comboProduct);

		lblQuantity = new JLabel("Quantity");
		centerPanel.add(lblQuantity);
		tfQuantity = new JTextField();
		centerPanel.add(tfQuantity);
		
		btn2 = new JButton("Display");
		btn2.setActionCommand("Display");
		btn2.addActionListener(this);
		centerPanel.add(btn2);
		
	
		
		 
		
		lblName.setBounds(30, 30, 130, 25);
		lblName.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtName.setBounds(200, 30, 200, 25);
		lblmobile.setBounds(30, 70, 130, 25);
		lblmobile.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtMobile.setBounds(200, 70, 200, 25);
		lblAddress.setBounds(30, 110, 130, 25);
		lblAddress.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtAddress.setBounds(200, 110, 200, 25);
		lblCity.setBounds(30, 150, 130, 25);
		lblCity.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtCity.setBounds(200, 150, 200, 25);
		lblRegdate.setBounds(30, 190, 130, 25);
		lblRegdate.setFont(new Font("Verdana", Font.PLAIN, 14));
		tfRegdate.setBounds(200,190,200,25);
		lblOrderDnT.setBounds(30, 230, 130, 25);
		lblOrderDnT.setFont(new Font("Verdana", Font.PLAIN, 14));
		tfOrderDnT.setBounds(200,230,200,25);
		lblProduct.setBounds(30,270,130,25);
		lblProduct.setFont(new Font("Verdana", Font.PLAIN, 14));
		comboProduct.setBounds(120,270, 100, 25);
		lblQuantity.setBounds(250,270,200,25);
		lblQuantity.setFont(new Font("Verdana", Font.PLAIN, 14));
		tfQuantity.setBounds(330, 270, 50, 25);
		btn2.setBounds(500,270,100,25);
		
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		
		
		SalesTable st = new SalesTable(new ArrayList<OrderDetails>());
		table = new JTable(st);
		table.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane js = new JScrollPane(table);
		centerPanel.add(js, BorderLayout.CENTER);
		js.setBounds(30, 320, 620, 100);
		
		
		
		cgst = new JLabel("Cgst");
		cgst.setBounds(300, 500, 200, 30);
		sgst = new JLabel(" Sgst ");
		sgst.setBounds(300, 520, 200, 30);
		total = new JLabel(" Total ");
		total.setBounds(300, 540, 200, 30);
		grandTotal = new JLabel(" Grand Total: ");
		grandTotal.setBounds(300, 560, 200, 30);
		centerPanel.add(cgst);
		centerPanel.add(sgst);
		centerPanel.add(total);
		centerPanel.add(grandTotal);
		
		generateBill = new JButton("Generate Bill");
		generateBill.setActionCommand("generate");
		generateBill.addActionListener(this);
		generateBill.setBounds(350, 450, 150, 30);
		centerPanel.add(generateBill);
		
		
		
		
		



		


		
		

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String str = e.getActionCommand();
		Customers customer = new Customers();
		CustomersDao custDao = new CustomersDao();
		String mobile = tfMobile.getText();
		customer = custDao.findMobile(mobile);
		OrdersDao od = new OrdersDao();
		

		if (str.equals("Go")) {
			
			customer = custDao.findMobile(mobile);
			if (customer.getCustname().trim().length() > 0) {
				txtName.setText(customer.getCustname());
				txtAddress.setText(customer.getCustadd());
				txtMobile.setText(customer.getCustmobile());
				txtCity.setText(customer.getCity());
				
				
				
				try { 
					java.util.Date dt = customer.getRegdate();
					SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy"); 
					String dateString = formatter.format(dt.getTime());
					
					tfRegdate.setText(dateString);
					 dt = od.fetchOrderDate(customer.getCustid());
					formatter = new SimpleDateFormat("dd.MM.yyyy  hh:mm aaa");
					dateString = formatter.format(dt.getTime());
					tfOrderDnT.setText(dateString);
					
					
					
				} catch (IllegalArgumentException ea) {
					tfRegdate.setForeground(Color.red);
					tfRegdate.setText("Error: " + ea.getMessage());
				}
				
				
				
			} else
				JOptionPane.showMessageDialog(this, "No Mobile");
			
		}
 
		else if (str.equals("Display")) {
			
			orderDetails = new ArrayList<OrderDetails>();
			int productIndex = productModel.getIndexOf(productModel.getSelectedItem());
			int productId = id.get(productIndex);
			Products product = productDao.find(productId);
			int qty = Integer.parseInt(tfQuantity.getText());
			if(qty==product.getProdqih()) {
			
			OrderDetails od1 = new OrderDetails(product.getProdid(), product.getProdqih(),
					product.getProdprice(), product.getProdcgst(), product.getProdsgst());
			totalF = qty * product.getProdprice();
			sgstF = (qty * product.getProdsgst());
			cgstF = (qty * product.getProdcgst());
			grandTotalF = totalF + sgstF + cgstF;
			sgst.setText("SGST : " + sgstF);
			cgst.setText("CGST : " + cgstF);
			total.setText("Total : " + totalF);
			grandTotal.setText("Grand Total : " + grandTotalF);

			orderDetails.add(od1);
			SalesTable st = new SalesTable(orderDetails);
			table.setModel(st);
	
			}
			else{
				JOptionPane.showMessageDialog(this, "No such Quantity");
				
			}
			
			
		}
		else if (str.equals("generate")) {
//			customer = new Customers();
//			OrdersDao od1 = new OrdersDao();
			
			
			orderDetails = new ArrayList<OrderDetails>();
			int productIndex = productModel.getIndexOf(productModel.getSelectedItem());
			int productId = id.get(productIndex);
			Products product = productDao.find(productId);
			int qty = Integer.parseInt(tfQuantity.getText());
			Orders order = new Orders();
			order.setCustid(customer.getCustid());
			order.setOrderamount(product.getProdqih()* product.getProdprice());
			order.setOrdersgst(product.getProdqih()* product.getProdsgst());
			order.setOrdercgst(product.getProdqih()* product.getProdcgst());
			
			
			OrderDetails od2 = new OrderDetails(product.getProdid(), product.getProdqih(),
					product.getProdprice(), product.getProdcgst(), product.getProdsgst());
			totalF = qty * product.getProdprice();
			sgstF = (qty * product.getProdsgst());
			cgstF = (qty * product.getProdcgst());
			grandTotalF = totalF + sgstF + cgstF;
			sgst.setText("SGST : " + sgstF);
			cgst.setText("CGST : " + cgstF);
			total.setText("Total : " + totalF);
			grandTotal.setText("Grand Total : " + grandTotalF);

			orderDetails.add(od2);
			
			if(od.createOrder(order, orderDetails)) {
				JOptionPane.showMessageDialog(this, "Order Generated Successfully, Please collect Rs. " + grandTotalF  +" /-");
			}
			else
				JOptionPane.showMessageDialog(this, "Order Generation Failure !!!");
	}
		}

		

	public static void main(String[] args) {
		JFrame f = new JFrame("Transaction");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new Sale());
		f.setMinimumSize(new Dimension(700, 800));
		f.pack();
		f.setLocationRelativeTo(null);
		//f.setResizable(false);
		f.setVisible(true);
	}
}