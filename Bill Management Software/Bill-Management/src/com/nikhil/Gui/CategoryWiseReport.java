package com.pos.Gui;


import com.pos.daos.*;
import com.pos.pojos.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

@SuppressWarnings("serial")
public class CategoryWiseReport extends JPanel implements ActionListener {

	JPanel centerPanel, northPanel;
	JLabel lblCategory, lblDateFrom, lblDateTo, lblTotal;
	JTextField txtDateFrom, txtDateTo;
	JButton btn1;
	JTable table;
	DefaultComboBoxModel<String> categoryModel;
	JComboBox<String> bcategoryName;
	ArrayList<Integer> catIds;
	ArrayList<String> category;
	DefaultTableModel dtm;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CategoryWiseReport() {
		setLayout(new BorderLayout());
		northPanel = new JPanel();
		northPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		add(northPanel, BorderLayout.NORTH);

		lblCategory = new JLabel("Category");
		northPanel.add(lblCategory);

		CategoriesDao catDao = new CategoriesDao();
		catIds = catDao.findAllCategoriesByIds();
		category = catDao.findAllCategory();
		catIds.add(0, 0);
		category.add(0, "All Categories");
		String s[] = new String[0];
		s = category.toArray(s);
		categoryModel = new DefaultComboBoxModel<String>(s);
		bcategoryName = new JComboBox<String>(categoryModel);
		bcategoryName.setActionCommand("b1");
		northPanel.add(bcategoryName);

		lblDateFrom = new JLabel("From Date");
		txtDateFrom = new JTextField(10);
		try {
			MaskFormatter format = new MaskFormatter("****-**-**");
			format.setPlaceholderCharacter('_');
			txtDateFrom = new JFormattedTextField(format);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		northPanel.add(lblDateFrom);
		northPanel.add(txtDateFrom);

		lblDateTo = new JLabel("To Date");
		txtDateTo = new JTextField(10);
		try {
			MaskFormatter format = new MaskFormatter("****-**-**");
			format.setPlaceholderCharacter('_');
			txtDateTo = new JFormattedTextField(format);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		northPanel.add(lblDateTo);
		northPanel.add(txtDateTo);

		btn1 = new JButton("GO");
		btn1.setActionCommand("go");
		btn1.addActionListener(this);
		northPanel.add(btn1);

		centerPanel = new JPanel();
		dtm = new DefaultTableModel();
		dtm.addColumn("Category Name");
		dtm.addColumn("Sales");
		// Object[] row = {"Red","Green"};
//		dtm.addRow(row);
//		dtm.addRow(row);
//		dtm.addRow(row);
//		dtm.addRow(row);
//		dtm.addRow(row);
//		dtm.addRow(row);
//		dtm.addRow(row);
//		dtm.addRow(row);

		table = new JTable(dtm);
		centerPanel.add(new JScrollPane(table));
		add(centerPanel, BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<ArrayList<String>> alist;
		int x = bcategoryName.getSelectedIndex();
		int id = catIds.get(x);
		System.out.println(id + " " + txtDateFrom.getText() + " " + txtDateTo.getText());
		alist = new ReportsDao().getCategoryWiseSales(id, txtDateFrom.getText(), txtDateTo.getText());
//		if (dtm.getRowCount() > 0) {
//			for (int i = dtm.getColumnCount() - 1; i >= 0; i--)
//				dtm.removeRow(i);
//		}
		dtm.setRowCount(0);
		for (ArrayList<String> alString : alist) {
			Object obj[] = new Object[alString.size()];
			for (int i = 0; i < alString.size(); i++)
				obj[i] = alString.get(i);
			dtm.addRow(obj);
		}

	}

	public static void main(String[] args) {
		JFrame f = new JFrame("Report");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new CategoryWiseReport());
		f.setMinimumSize(new Dimension(800, 800));
		f.pack();
		f.setLocationRelativeTo(null);
//		f.setResizable(false);
		f.setVisible(true);

	}
}

