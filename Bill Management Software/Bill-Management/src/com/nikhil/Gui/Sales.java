package com.pos.Gui;


import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import com.pos.daos.*;
import com.pos.pojos.*;
import com.pos.utilities.*;


public class Sales extends JPanel implements ActionListener {

	JLabel lblMobile, Mobile, lblName, lblAddress, lblCity, lblCategory, lblProduct, lblQuantity, combProduct;
	JTextField txtName, txtAddress, txtCity, txtMobile, tfMobile, tfProduct, tfQuantity;
	JButton btn1, btn2, generateBill, clearBtn;
	JTable table1;
	JPanel centerPanel, northPanel;
	Customers customer;
	CustomersDao custDao;
	ArrayList<String> category, product;
	Products pd, product1;
	JComboBox<String> bcategoryName, bproductName;
	ProductsDao productDao;
	ArrayList<Integer> ids, id; //ids=category id=product
	DefaultComboBoxModel<String> categoryModel, productModel;
	ArrayList<OrderDetails> orderDetails;
	JLabel cgst, sgst, total, grandTotal;
	float cgstF, sgstF, totalF, grandTotalF;

	public Sales() {
		orderDetails = new ArrayList<OrderDetails>();
		setLayout(new BorderLayout());
		northPanel = new JPanel();
		northPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		add(northPanel, BorderLayout.NORTH);

		centerPanel = new JPanel();
		centerPanel.setLayout(null);
		centerPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		add(centerPanel, BorderLayout.CENTER);

		lblMobile = new JLabel("Customer Mobile");
		lblMobile.setFont(new Font("Verdana", Font.PLAIN, 18));
		tfMobile = new JTextField(20);
		northPanel.add(lblMobile);
		northPanel.add(tfMobile);

		btn1 = new JButton("GO");
		btn1.setActionCommand("go");
		btn1.addActionListener(this);
		northPanel.add(btn1);

		lblName = new JLabel("Customer Name");
		txtName = new JTextField();
		centerPanel.add(lblName);
		centerPanel.add(txtName);

		Mobile = new JLabel("Customer Mobile");
		txtMobile = new JTextField();
		centerPanel.add(Mobile);
		centerPanel.add(txtMobile);

		lblAddress = new JLabel("Customer Address");
		txtAddress = new JTextField();
		centerPanel.add(lblAddress);
		centerPanel.add(txtAddress);

		lblCity = new JLabel("City");
		txtCity = new JTextField();
		centerPanel.add(lblCity);
		centerPanel.add(txtCity);
		lblCategory = new JLabel("Categories");
		centerPanel.add(lblCategory);

		CategoriesDao catDao = new CategoriesDao();
		ids = catDao.findAllCategoriesByIds();
		category = catDao.findAllCategory();

		String s[] = new String[0];
		s = category.toArray(s);
		categoryModel = new DefaultComboBoxModel<String>(s);
		bcategoryName = new JComboBox<String>(categoryModel);
		bcategoryName.addActionListener(this);
		centerPanel.add(bcategoryName);
		bcategoryName.setBounds(150, 200, 110, 25);
		bcategoryName.addActionListener(this);
		bcategoryName.setActionCommand("b1");

		combProduct = new JLabel("Product");
		combProduct.setBounds(270, 200, 110, 25);
		combProduct.setFont(new Font("Verdana", Font.PLAIN, 14));
		centerPanel.add(combProduct);

		productDao = new ProductsDao();
		product = productDao.findAllProduct();
		id = productDao.findAllProductByIds();

		String str[] = new String[0];
		str = product.toArray(str);
		productModel = new DefaultComboBoxModel<String>(str);
		bproductName = new JComboBox<String>(productModel);
		bproductName.addActionListener(this);
		centerPanel.add(bproductName);
		bproductName.setBounds(340, 200, 100, 25);

		btn2 = new JButton("Go");
		btn2.setActionCommand("Display");
		btn2.addActionListener(this);
		centerPanel.add(btn2);
		btn2.setBounds(600, 200, 50, 25);

		lblName.setBounds(30, 30, 130, 25);
		lblName.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtName.setBounds(200, 30, 200, 25);
		btn1.setBounds(300, 70, 50, 25);
		Mobile.setBounds(30, 70, 130, 25);
		Mobile.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtMobile.setBounds(200, 70, 200, 25);
		lblAddress.setBounds(30, 110, 130, 25);
		lblAddress.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtAddress.setBounds(200, 110, 200, 25);
		lblCity.setBounds(30, 150, 100, 25);
		lblCity.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtCity.setBounds(200, 150, 200, 25);
		lblCategory.setBounds(50, 200, 80, 25);
		lblCategory.setFont(new Font("Verdana", Font.PLAIN, 14));

		lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblQuantity.setBounds(450, 200, 100, 25);
		centerPanel.add(lblQuantity);

		tfQuantity = new JTextField();
		tfQuantity.setBounds(520, 200, 50, 25);
		centerPanel.add(tfQuantity);

		generateBill = new JButton("Genrate Bill");
		generateBill.setActionCommand("genrate");
		generateBill.addActionListener(this);
		generateBill.setBounds(450, 380, 150, 30);
		generateBill.setBackground(Color.RED);
		generateBill.setEnabled(false);
		centerPanel.add(generateBill);
		
		
		clearBtn = new JButton("Clear");
		clearBtn.setActionCommand("clear");
		clearBtn.addActionListener(this);
		clearBtn.setBounds(300, 590, 100, 25);
		centerPanel.add(clearBtn);
		

		SalesTable st = new SalesTable(orderDetails);
		table1 = new JTable(st);
		table1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane js = new JScrollPane(table1);
		centerPanel.add(js, BorderLayout.CENTER);
		js.setBounds(30, 250, 620, 100);

		cgst = new JLabel("Cgst");
		cgst.setBounds(300, 430, 100, 25);
		sgst = new JLabel(" Sgst ");
		sgst.setBounds(300, 460, 100, 25);
		total = new JLabel(" Total ");
		total.setBounds(300, 490, 100, 25);
		grandTotal = new JLabel(" Grand Total: ");
		grandTotal.setBounds(300, 520, 100, 25);
		centerPanel.add(cgst);
		centerPanel.add(sgst);
		centerPanel.add(total);
		centerPanel.add(grandTotal);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		Customers customer = new Customers();
		CustomersDao custDao = new CustomersDao();
		String mobile = tfMobile.getText();
		customer = custDao.findMobile(mobile);

		if (str.equals("go")) {
			System.out.println(str);
			customer = custDao.findMobile(mobile);
			if (customer.getCustname().trim().length() > 0) {
				txtName.setText(customer.getCustname());
				txtAddress.setText(customer.getCustadd());
				txtMobile.setText(customer.getCustmobile());
				txtCity.setText(customer.getCity());
			} else
				JOptionPane.showMessageDialog(this, "No Mobile");
		}
 
		else if (str.equals("Display")) {
	//		product1 = new Product();
			int productIndex = productModel.getIndexOf(productModel.getSelectedItem());
			int productId = id.get(productIndex);
			int qty = Integer.parseInt(tfQuantity.getText());
			Products product = productDao.find(productId);
			OrderDetails od = new OrderDetails(product.getProdid(), product.getProdqih(),
					product.getProdprice(), product.getProdcgst(), product.getProdsgst());
			totalF = qty * product.getProdprice();
			sgstF = (qty * product.getProdsgst());
			cgstF = (qty * product.getProdcgst());
			grandTotalF = totalF + sgstF + cgstF;
			sgst.setText("SGST : " + sgstF);
			cgst.setText("CGST : " + cgstF);
			total.setText("Total : " + totalF);
			grandTotal.setText("Grand Total : " + grandTotalF);
			orderDetails.add(od);
			SalesTable st = new SalesTable(orderDetails);
			table1.setModel(st);
			ArrayList<Products> product1 = productDao.findAllProducts();
			int quantityLeft = product.getProdqih() - qty ;
		//	Product pd  = new Product( productId , ((Product) product1).getCategoryId(), product1.getProductCode(),product.getProductName(), product.getProductPrice(),
			//		quantityLeft, product.getProductReoderLevel(), product.getProductCgst(),product.getProductSgst()) ;
			productDao.editProduct(product);
			
			generateBill.setEnabled(true);
		}

//		else if (str.equals("b1")) {
//			int x = bcategoryName.getSelectedIndex();
//			int id1 = ids.get(x);
//			product = productDao.findByCategoryIdString(id1);
//			id = productDao.findByCategoryIdInt(id1);
//			productModel.removeAllElements(); 
//			productModel.addAll(product);
//			if (productModel.getSize() > 0)
//				productModel.setSelectedItem(productModel.getElementAt(0));
//		}
		else if (str.equals("genrate")) {
				OrdersDao od = new OrdersDao();
				java.util.Date dt = DateUtils.convertDate("23-10-2015");
				Orders order = new Orders(dt,500,45f,46f);
				order.setCustid(customer.getCustid());
				if(od.createOrder(order, orderDetails)) {
					JOptionPane.showMessageDialog(this, "Order Generated Successfully, Please collect Rs. " + grandTotalF  +" /-");
				}
				else
					JOptionPane.showMessageDialog(this, "Order Generation Failure !!!");
		}
		else if(str.equals("clear")) {
			tfMobile.setText("");
			txtName.setText("");
			txtAddress.setText("");
			txtMobile.setText("");
			txtCity.setText("");
			bcategoryName.setSelectedIndex(0);
			
			
			
		}

	}
	

	public static void main(String[] args) {
		JFrame f = new JFrame("Transaction");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new Sales());
		f.setMinimumSize(new Dimension(700, 700));
		f.pack();
		f.setLocationRelativeTo(null);
		//f.setResizable(false);
		f.setVisible(true);
	}

}

