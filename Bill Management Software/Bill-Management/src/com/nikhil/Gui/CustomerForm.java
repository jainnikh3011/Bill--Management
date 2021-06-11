package com.pos.Gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import com.pos.pojos.*;
import com.pos.utilities.DateUtils;
import com.pos.daos.*;

public class CustomerForm extends JPanel implements ActionListener {

	JLabel l1,l2,l3,l4,l5,statusLabel;
	JTextField tf1,tf2,tf3,tf4,tf5;
	Customers cus;
	CustomersDao cd;
	int currentRow, totalRow;
	ArrayList<Integer> ids;
	


	public CustomerForm() {
		setLayout(new BorderLayout());
		
		
		JPanel centerPanel = new JPanel(); 
		centerPanel.setLayout(null);
		centerPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

		l1 = new JLabel("Customer Name");
		tf1 = new JTextField();
		l2 = new JLabel("Customers Mobile");
		tf2 = new JTextField();
		l3 = new JLabel("Customer Add");
		tf3 = new JTextField();
		l4 = new JLabel("City"); 
		tf4 = new JTextField();
		l5 = new JLabel("Registration Date");
		tf5 = new JTextField();
		
		l1.setBounds(50, 50, 100, 25);
		tf1.setBounds(200, 50, 200, 25);
		l2.setBounds(50, 100, 100, 25);
		tf2.setBounds(200, 100, 200, 25);
		l3.setBounds(50, 150, 100, 25);
		tf3.setBounds(200, 150, 200, 25);
		l4.setBounds(50, 200, 100, 25);
		tf4.setBounds(200, 200, 200, 25);
		l5.setBounds(50, 250, 100, 25);
		tf5.setBounds(200, 250, 200, 25);
		
		centerPanel.add(l1);
		centerPanel.add(tf1);
		centerPanel.add(l2);
		centerPanel.add(tf2);
		centerPanel.add(l3);
		centerPanel.add(tf3);
		centerPanel.add(l4);
		centerPanel.add(tf4);
		centerPanel.add(l5);
		centerPanel.add(tf5);// thkh rehne de  
		
		createToolBar();
		statusLabel = new JLabel(" Row 1 of 1");
		statusLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		add(centerPanel, BorderLayout.CENTER);
		add(statusLabel, BorderLayout.SOUTH); 
		
		
		cus = new Customers();
		cd = new CustomersDao();
		ids = cd.findAllCustomerByIds();
		if (ids.size() > 0) {
			currentRow = 1;
			totalRow = ids.size();
			cus = cd.find(ids.get(currentRow - 1));
		}
		updateCourse();

	
	}

	public void fetchCourse() {
		cus.setCustname(tf1.getText());
		
		cus.setCustmobile(tf2.getText());
		cus.setCustadd(tf3.getText());
		cus.setCity(tf4.getText());
		try {
		java.util.Date dt = DateUtils.convertDate(tf5.getText());
		cus.setRegdate(dt);
		}
		catch (IllegalArgumentException e) {
			tf5.setForeground(Color.red);
			tf5.setText("Error: " + e.getMessage());
		}
		
	}

	public void updateCourse() {
		tf1.setText(cus.getCustname()); 
		tf2.setText(cus.getCustmobile());
		tf3.setText(cus.getCustadd()+"");
		tf4.setText(cus.getCity()+"");
		try { 
		java.util.Date date = cus.getRegdate();  
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd"); 
		String strDate = dateFormat.format(date); 
		tf5.setText(strDate);
		statusLabel.setText("Row " + currentRow + " of " + totalRow);
		}
		catch (IllegalArgumentException e) {
			tf5.setForeground(Color.red);
			tf5.setText("Error: " + e.getMessage());
		}
		
	}

	public void createToolBar() {
		JToolBar jToolBar = new JToolBar();
		JButton btn1 = new JButton(new ImageIcon(getClass().getResource("/icons/First.png")));
		btn1.setActionCommand("First");
		btn1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn1.setToolTipText("First Row");
		btn1.addActionListener(this);
		jToolBar.add(btn1);

		JButton btn2 = new JButton(new ImageIcon(getClass().getResource("/icons/Back.png")));
		btn2.setActionCommand("Previous");
		btn2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn2.setToolTipText("Previous Row");
		btn2.addActionListener(this);
		jToolBar.add(btn2);

		JButton btn3 = new JButton(new ImageIcon(getClass().getResource("/icons/Forward.png")));
		btn3.setActionCommand("Next");
		btn3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn3.setToolTipText("Next Row");
		btn3.addActionListener(this);
		jToolBar.add(btn3);

		JButton btn4 = new JButton(new ImageIcon(getClass().getResource("/icons/Last.png")));
		btn4.setActionCommand("Last");
		btn4.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn4.setToolTipText("Last Row");
		btn4.addActionListener(this);
		jToolBar.add(btn4);

		jToolBar.addSeparator();

		JButton btn5 = new JButton(new ImageIcon(getClass().getResource("/icons/update.png")));
		btn5.setActionCommand("Save");
		btn5.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn5.setToolTipText("Save Row");
		btn5.addActionListener(this);
		jToolBar.add(btn5);

		JButton btn6 = new JButton(new ImageIcon(getClass().getResource("/icons/delete.png")));
		btn6.setActionCommand("Delete");
		btn6.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn6.setToolTipText("Delete Row");
		btn6.addActionListener(this);
		jToolBar.add(btn6);

		JButton btn7 = new JButton(new ImageIcon(getClass().getResource("/icons/add.png")));
		btn7.setActionCommand("New");
		btn7.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn7.setToolTipText("New Row");
		btn7.addActionListener(this);
		jToolBar.add(btn7);

		add(jToolBar, BorderLayout.NORTH);
	}

	

	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("First")) {
			if (currentRow != 1) {
				currentRow = 1;
				cus = cd.find(ids.get(currentRow - 1));
				updateCourse();
			}
		} else if (str.equals("Previous")) {
			if (currentRow != 1) {
				currentRow = currentRow - 1;
				cus = cd.find(ids.get(currentRow - 1));
				updateCourse();
			}
		} else if (str.equals("Next")) {
			if (currentRow != totalRow) {
				currentRow = currentRow + 1;
				cus = cd.find(ids.get(currentRow - 1));
				updateCourse();
			}
		} else if (str.equals("Last")) {
			if (currentRow != totalRow) {
				currentRow = totalRow;
				cus = cd.find(ids.get(currentRow - 1));
				updateCourse();
			}
		} else if (str.equals("Save")) {
			fetchCourse();
			cd.editCustomer(cus);
			JOptionPane.showMessageDialog(this, "SuccessFully Added","Save",JOptionPane.PLAIN_MESSAGE);
					
		}
		
	else if (str.equals("New")) {
			cus = new Customers();
			cd.createCustomer(cus);
			ids = cd.findAllCustomerByIds();
			currentRow = ids.size();
			totalRow = ids.size();
			cus = cd.find(ids.get(currentRow - 1));
			updateCourse();
		
		} else if (str.equals("Delete")) {
			if (currentRow != 0) {
				int x1 = JOptionPane.showConfirmDialog(this, "Are you Sure, you want to delete it !", "Delete",
						JOptionPane.YES_NO_OPTION);
				if (x1 == JOptionPane.YES_OPTION) {
					boolean answer = cd.removeCustomer(cus.getCustid());
					if (!answer) {
						JOptionPane.showMessageDialog(this, "Unable to Delete Course !", "Delete",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					ids = cd.findAllCustomerByIds();
					totalRow = ids.size();
					currentRow = currentRow - 1;
					if (currentRow == 0 && totalRow >= 1) {
						currentRow = totalRow;
						cus = cd.find(ids.get(currentRow - 1));
						updateCourse();
					} else if (currentRow != 0) {
						cus = cd.find(ids.get(currentRow - 1));
						updateCourse();
					} else {
						tf1.setText("");
						tf2.setText("");
						tf3.setText("");
						tf4.setText("");
						tf5.setText("");
		
					}
				}
			}
		}
	}

	public static void main(String argv[]) {
		JFrame f = new JFrame("Customer Registration Form");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new CustomerForm());
		f.setMinimumSize(new Dimension(800, 800));
		f.setLocationRelativeTo(null);
		//f.setResizable(false);
		f.setVisible(true);
	}
}

