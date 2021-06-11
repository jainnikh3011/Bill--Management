package com.pos.Gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import javax.swing.border.BevelBorder;

import com.pos.daos.*;
import com.pos.pojos.*;


public class CategoryForm extends JPanel implements ActionListener{

	JLabel lblCategoryName, lblCategoryType, statusLabel;
	JTextField txtCategoryName;
	JTextArea ta;
	Categories c;
	CategoriesDao categoryDao;
	int currentRow, totalRow;
	ArrayList<Integer> ids;

	public CategoryForm() {
		setLayout(new BorderLayout());

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(null);
		centerPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

		lblCategoryName = new JLabel("Category Name "); 
		txtCategoryName = new JTextField();
		lblCategoryType = new JLabel("Category details ");  
		ta = new JTextArea(50,70);
		ta.setCaretPosition(ta.getDocument().getLength());
		JScrollPane scrollPane = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		lblCategoryName.setBounds(50, 50, 100, 25);
		txtCategoryName.setBounds(200, 50, 200, 25);
		lblCategoryType.setBounds(50, 100, 100, 25);
		scrollPane.setBounds(200, 100, 200, 100);
		centerPanel.add(lblCategoryName);
		centerPanel.add(txtCategoryName);
		centerPanel.add(lblCategoryType);
		centerPanel.add(scrollPane);
		

		createToolBar();
		statusLabel = new JLabel(" Row 1 of 1");
		statusLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		add(centerPanel, BorderLayout.CENTER);
		add(statusLabel, BorderLayout.SOUTH);

		c = new Categories();
		categoryDao = new CategoriesDao();
		ids = categoryDao.findAllCategoriesByIds();
		if (ids.size() > 0) {
			currentRow = 1;
			totalRow = ids.size();
			c = categoryDao.find(ids.get(currentRow - 1));
		}
		updateCourse();
	}

	public void fetchCourse() {
		c.setCatname(txtCategoryName.getText());
		c.setCatdetails(ta.getText());
	}

	public void updateCourse() {
		txtCategoryName.setText(c.getCatname()); 
		ta.setText(c.getCatdetails());
		statusLabel.setText("Row " + currentRow + " of " + totalRow);
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

	@Override

	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("First")) {
			if (currentRow != 1) {
				currentRow = 1;
				c = categoryDao.find(ids.get(currentRow - 1));
				updateCourse();
			}
		} else if (str.equals("Previous")) {
			if (currentRow != 1) {
				currentRow = currentRow - 1;
				c = categoryDao.find(ids.get(currentRow - 1));
				updateCourse();
			}
		} else if (str.equals("Next")) {
			if (currentRow != totalRow) {
				currentRow = currentRow + 1;
				c = categoryDao.find(ids.get(currentRow - 1));
				updateCourse();
			}
		} else if (str.equals("Last")) {
			if (currentRow != totalRow) {
				currentRow = totalRow;
				c = categoryDao.find(ids.get(currentRow - 1));
				updateCourse();
			}
		} else if (str.equals("Save")) {
			fetchCourse();
			categoryDao.editCategory(c);
			JOptionPane.showMessageDialog(this, "SuccessFully Added","Save",JOptionPane.PLAIN_MESSAGE);
					
		} else if (str.equals("New")) {
			c = new Categories();
			categoryDao.createCategory(c);
			ids = categoryDao.findAllCategoriesByIds();
			currentRow = ids.size();
			totalRow = ids.size();
			c = categoryDao.find(ids.get(currentRow - 1));
			updateCourse();
		} else if (str.equals("Delete")) {
			if (currentRow != 0) {
				int x = JOptionPane.showConfirmDialog(this, "Are you Sure, you want to delete it !", "Delete",
						JOptionPane.YES_NO_OPTION);
				if (x == JOptionPane.YES_OPTION) {
					boolean answer = categoryDao.removeCategory(c.getCatid());
					if (!answer) {
						JOptionPane.showMessageDialog(this, "Unable to Delete Course !", "Delete",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					ids = categoryDao.findAllCategoriesByIds();
					totalRow = ids.size();
					currentRow = currentRow - 1;
					if (currentRow == 0 && totalRow >= 1) {
						currentRow = totalRow;
						c = categoryDao.find(ids.get(currentRow - 1));
						updateCourse();
					} else if (currentRow != 0) {
						c = categoryDao.find(ids.get(currentRow - 1));
						updateCourse();
					} else {
						txtCategoryName.setText("");
						ta.setText("");
					}
				}
			}
		}

}
	public static void main(String argv[]) {
		JFrame f = new JFrame("Category");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new CategoryForm());
		f.setMinimumSize(new Dimension(500, 300));
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
	}
}
