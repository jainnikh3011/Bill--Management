package com.pos.Gui;



import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import com.pos.pojos.*;

import com.pos.daos.*;

public class ProductForm extends JPanel implements ActionListener {

	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,statusLabel;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf9,tf10;
	Products p;
	ProductsDao pd;
	int currentRow, totalRow;
	ArrayList<Integer> ids;
	JComboBox<String> jc;
	ArrayList<String> category;
	JTable table;
	JScrollPane sp;
	ArrayList<Integer> catID;

	public ProductForm() {
		setLayout(new BorderLayout());
		JPanel centerPanel = new JPanel(); 
		centerPanel.setLayout(null);
		centerPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

		l1 = new JLabel("Product Code");
		tf1 = new JTextField();
		l2 = new JLabel("Product Name ");
		tf2 = new JTextField();
		l3 = new JLabel("Product Price ");
		tf3 = new JTextField();
		l4 = new JLabel("Quantity in Hand"); 
		tf4 = new JTextField();
		l5 = new JLabel("Reorder level");
		tf5 = new JTextField();
		l6 = new JLabel("SGST");
		tf6 = new JTextField(); 
		l7 = new JLabel("CGST");
		tf7 = new JTextField();
		l8 = new JLabel("Category");
		l9= new JLabel("Cat ID");
		tf9 = new JTextField();
		
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
		l6.setBounds(50, 300, 100, 25);
		tf6.setBounds(200, 300, 200, 25);
		l7.setBounds(50, 350, 100, 25);
		tf7.setBounds(200,350, 200, 25);
		l8.setBounds(50,450,100,25);
		l9.setBounds(50,400,100,25);
		tf9.setBounds(200,400,200,25);
		
	
		
		centerPanel.add(l1);
		centerPanel.add(tf1);
		centerPanel.add(l2);
		centerPanel.add(tf2);
		centerPanel.add(l3);
		centerPanel.add(tf3);
		centerPanel.add(l4);
		centerPanel.add(tf4);
		centerPanel.add(l5);
		centerPanel.add(tf5);
		centerPanel.add(l6);
		centerPanel.add(tf6);
		centerPanel.add(l7);
		centerPanel.add(tf7);
		centerPanel.add(l8);
		centerPanel.add(l9);
		centerPanel.add(tf9);// isme table ka natak kya ara 
		
		createToolBar();
		statusLabel = new JLabel(" Row 1 of 1");
		statusLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		add(statusLabel, BorderLayout.SOUTH); 
		
		pd = new ProductsDao();
		CategoriesDao c = new CategoriesDao();
		ids = pd.findAllProductByIds();
		catID=c.findAllCategoriesByIds();
		category = c.findAllCategory();
	
		p = new Products();
		
		if (ids.size() > 0) {
			currentRow = 1;
			totalRow =ids.size();
			p = pd.find(ids.get(currentRow - 1));
		}
		updateCourse();
	
	String s[] = new String[0];
	s = category.toArray(s);
	jc = new JComboBox<String>(s);
	jc.addActionListener(this);
	
	CategoryTable st = new CategoryTable(catID.get(0));
	table = new JTable(st);
	table.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	sp = new JScrollPane(table);
	
	jc.setBounds(200,450,100,25);
	sp.setBounds(50,500,700,150);
	centerPanel.add(jc);
	centerPanel.add(sp);
	add(centerPanel, BorderLayout.CENTER);
	}

	public void fetchCourse() {
		p.setProdcode(tf1.getText());
		p.setProdname(tf2.getText());
		float num = Float.parseFloat(tf3.getText());
		p.setProdprice(num);
		int num1 =Integer.parseInt(tf4.getText());
		p.setProdqih(num1);
		int num2 = Integer.parseInt(tf5.getText());
		p.setProdreorderlevel(num2);
		float num3 = Float.parseFloat(tf6.getText());
		p.setProdsgst(num3);
		float num4 = Float.parseFloat(tf7.getText());
		p.setProdcgst(num4);
		int num5 = Integer.parseInt(tf9.getText());
		p.setCatid(num5);
		
	
	}

	public void updateCourse() {
		tf1.setText(p.getProdcode()); 
		tf2.setText(p.getProdname());
		tf3.setText(p.getProdprice()+"");
		tf4.setText(p.getProdqih()+"");
		tf5.setText(p.getProdreorderlevel()+"");
		tf6.setText(p.getProdsgst()+"");
		tf7.setText(p.getProdcgst()+"");
		tf9.setText(p.getCatid()+"");
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
		int x = jc.getSelectedIndex();
		int id = catID.get(x);
		CategoryTable st = new CategoryTable(id); 
		table.setModel(st);
		
		String str = e.getActionCommand();
		if (str.equals("First")) {
			if (currentRow != 1) {
				currentRow = 1;
				p = pd.find(ids.get(currentRow - 1));
				updateCourse();
			}
		} else if (str.equals("Previous")) {
			if (currentRow != 1) {
				currentRow = currentRow - 1;
				p = pd.find(ids.get(currentRow - 1));
				updateCourse();
			}
		} else if (str.equals("Next")) {
			if (currentRow != totalRow) {
				currentRow = currentRow + 1;
				p = pd.find(ids.get(currentRow - 1));
				updateCourse();
			}
		} else if (str.equals("Last")) {
			if (currentRow != totalRow) {
				currentRow = totalRow;
				p= pd.find(ids.get(currentRow - 1));
				updateCourse();
			}
		} else if (str.equals("Save")) {
			fetchCourse();
			pd.editProduct(p);
			JOptionPane.showMessageDialog(this, "Saved Successfully","Save",JOptionPane.PLAIN_MESSAGE);
					
			
		} else if (str.equals("New")) {
			p = new Products();
			pd.createProduct(p);
			ids = pd.findAllProductByIds();
			currentRow = ids.size();
			totalRow = ids.size();
			p = pd.find(ids.get(currentRow - 1));
			updateCourse();
		} else if (str.equals("Delete")) {
			if (currentRow != 0) {
				int x1 = JOptionPane.showConfirmDialog(this, "Are you Sure, you want to delete it !", "Delete",
						JOptionPane.YES_NO_OPTION);
				if (x1 == JOptionPane.YES_OPTION) {
					boolean answer = pd.removeProduct(p.getProdid());
					if (!answer) {
						JOptionPane.showMessageDialog(this, "Unable to Delete Course !", "Delete",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					ids = pd.findAllProductByIds();
					totalRow = ids.size();
					currentRow = currentRow - 1;
					if (currentRow == 0 && totalRow >= 1) {
						currentRow = totalRow;
						p = pd.find(ids.get(currentRow - 1));
						updateCourse();
					} else if (currentRow != 0) {
						p = pd.find(ids.get(currentRow - 1));
						updateCourse();
					} else {
						tf1.setText("");
						tf2.setText("");
						tf3.setText("");
						tf4.setText("");
						tf5.setText("");
						tf6.setText("");
						tf7.setText("");
						tf9.setText("");
					}
				}
			}
		}
	}

	public static void main(String argv[]) {
		JFrame f = new JFrame("Product Form");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new ProductForm());
		f.setMinimumSize(new Dimension(800, 800));
		f.setLocationRelativeTo(null);
		//f.setResizable(false);
		f.setVisible(true);
	}
}

