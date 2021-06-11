package com.pos.Gui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.pos.daos.*;
import com.pos.pojos.*;

public class StockOrderReport extends JPanel implements ActionListener {
	JTable table;
	JPanel centerPanel;
	DefaultTableModel dtm;
	JButton b1;

	public StockOrderReport() {
		setLayout(new BorderLayout());
		centerPanel = new JPanel();
		b1=new JButton("GO");
		b1.addActionListener(this);
		centerPanel.add(b1);
		
		dtm = new DefaultTableModel();
		dtm.addColumn("Category ID");
		dtm.addColumn("Product Qih");
	
//		dtm.addColumn("Quantity");
	//	StockModel stock = new StockModel();
		table = new JTable(dtm);
		centerPanel.add(new JScrollPane(table), BorderLayout.CENTER);
		add(centerPanel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ReportsDao rd = new ReportsDao();
		
	ArrayList<Integer> list = rd.getStockOrderReport();
		
			Object obj[] = new Object[list.size()];
			for (int i = 0; i <= list.size()-1; i++)
				{
				obj[i] = list.get(i);
			
			   //dtm.insertRow(1, obj);
			  
				}
			 dtm.addRow(obj);
			
		

	
	}

	public static void main(String[] args) {
		JFrame f = new JFrame("Report");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new StockOrderReport());
		f.setMinimumSize(new Dimension(800, 800));
		f.pack();
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);

	}
}

