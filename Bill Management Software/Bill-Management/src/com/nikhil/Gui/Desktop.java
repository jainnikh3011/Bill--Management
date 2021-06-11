package com.pos.Gui;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;


@SuppressWarnings("serial")
public class Desktop extends JFrame implements ActionListener {

	JDesktopPane desktopPane;
	JLabel statusLabel;
	UIManager.LookAndFeelInfo laf[];
	JMenuBar menuBar;
	JToolBar jToolBar;

	public Desktop() {
		setLayout(new BorderLayout());
		desktopPane = new JDesktopPane() {
			ImageIcon icon; // pehle chala ke dekhe bina icons se 
			Image image;
			{
				icon = new ImageIcon(getClass().getResource("/image/Online2.jpg"));
				image = icon.getImage();
			}

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};

		laf = UIManager.getInstalledLookAndFeels();
		statusLabel = new JLabel("...");
		desktopPane.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		statusLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		statusLabel.setFont(new Font("Time New Roman", Font.BOLD, 16));

		createToolBar();
		createMenuBar();

		getContentPane().add(desktopPane, BorderLayout.CENTER);
		getContentPane().add(statusLabel, BorderLayout.SOUTH);

		setTitle("Point of sale");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/icons/p21.png"));
		setIconImage(icon1.getImage());
		setVisible(true);
	}

	public void createToolBar() {
		jToolBar = new JToolBar();
		JButton btn1 = new JButton(new ImageIcon(getClass().getResource("/icon/category.png")));
		btn1.setActionCommand("category");
		btn1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn1.setToolTipText("Category");
		btn1.addActionListener(this);
		jToolBar.add(btn1);

		JButton btn2 = new JButton(new ImageIcon(getClass().getResource("/icon/product.png")));
		btn2.setActionCommand("product");
		btn2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn2.setToolTipText("Product");
		btn2.addActionListener(this);
		jToolBar.add(btn2);

		JButton btn3 = new JButton(new ImageIcon(getClass().getResource("/icon/customer.png")));
		btn3.setActionCommand("customer");
		btn3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn3.setToolTipText("Customer"); 
		btn3.addActionListener(this);
		jToolBar.add(btn3);

		jToolBar.addSeparator();

		JButton btn5 = new JButton(new ImageIcon(getClass().getResource("/icon/sale.png")));
		btn5.setActionCommand("sales");
		btn5.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn5.setToolTipText("Sales");
		btn5.addActionListener(this);
		jToolBar.add(btn5);

		jToolBar.addSeparator();

		JButton btn6 = new JButton(new ImageIcon(getClass().getResource("/icon/categorywise.png")));
		btn6.setActionCommand("categorywisesale");
		btn6.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn6.setToolTipText("CategoryWise Sale");
		btn6.addActionListener(this);
		jToolBar.add(btn6);

		JButton btn7 = new JButton(new ImageIcon(getClass().getResource("/icon/stockO.png")));
		btn7.setActionCommand("stockoder");
		btn7.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn7.setToolTipText("Stock Oder Report");
		btn7.addActionListener(this);
		jToolBar.add(btn7);

		JButton btn8 = new JButton(new ImageIcon(getClass().getResource("/icon/amount.png")));
		btn8.setActionCommand("amountrecive");
		btn8.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn8.setToolTipText("Amount recivable report");
		btn8.addActionListener(this);
		jToolBar.add(btn8);

		JButton btn9 = new JButton(new ImageIcon(getClass().getResource("/icon/stockAnalysis.png")));
		btn9.setActionCommand("stockanalysis");
		btn9.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn9.setToolTipText("Stock Analysis");
		btn9.addActionListener(this);
		jToolBar.add(btn9);

		JButton btn10 = new JButton(new ImageIcon(getClass().getResource("/icon/gst.png")));
		btn10.setActionCommand("Gstreport");
		btn10.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn10.setToolTipText("GST Report");
		btn10.addActionListener(this);
		jToolBar.add(btn10);

		jToolBar.addSeparator();

		JButton btn13 = new JButton(new ImageIcon(getClass().getResource("/icons/p13.png")));
		btn13.setActionCommand("Metal");
		btn13.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn13.setToolTipText("Metal Look And Feel");
		btn13.addActionListener(this);
		jToolBar.add(btn13);

		JButton btn14 = new JButton(new ImageIcon(getClass().getResource("/icons/p14.png")));
		btn14.setActionCommand("Motif");
		btn14.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn14.setToolTipText("Motif Look And Feel");
		btn14.addActionListener(this);
		jToolBar.add(btn14);

		JButton btn15 = new JButton(new ImageIcon(getClass().getResource("/icons/p15.png")));
		btn15.setActionCommand("Nimbus");
		btn15.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn15.setToolTipText("Nimbus Look And Feel");
		btn15.addActionListener(this);
		jToolBar.add(btn15);

		JButton btn16 = new JButton(new ImageIcon(getClass().getResource("/icons/p16.png")));
		btn16.setActionCommand("Windows");
		btn16.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn16.setToolTipText("Windows Look And Feel");
		btn16.addActionListener(this);
		jToolBar.add(btn16);

		JButton btn17 = new JButton(new ImageIcon(getClass().getResource("/icons/p17.png")));
		btn17.setActionCommand("WindowsClassic");
		btn17.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn17.setToolTipText("Windows Classic Look And Feel");
		btn17.addActionListener(this);
		jToolBar.add(btn17);

		jToolBar.addSeparator();

		JButton btn11 = new JButton(new ImageIcon(getClass().getResource("/icon/about.png")));
		btn11.setActionCommand("about");
		btn11.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn11.setToolTipText("About us");
		btn11.addActionListener(this);
		jToolBar.add(btn11);

		JButton btn12 = new JButton(new ImageIcon(getClass().getResource("/icon/read.png")));
		btn12.setActionCommand("Readme");
		btn12.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn12.setToolTipText("Read Me");
		btn12.addActionListener(this);
		jToolBar.add(btn12);
		add(jToolBar, BorderLayout.NORTH);
	}

	@SuppressWarnings("deprecation")
	public void createMenuBar() {
		menuBar = new JMenuBar();
		menuBar.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		JMenu jMenu1 = new JMenu("Database");
		jMenu1.setMnemonic('D');

		JMenu jMenu2 = new JMenu("Transaction");
		jMenu2.setMnemonic('T');

		JMenu jMenu3 = new JMenu("Reports");
		jMenu3.setMnemonic('R');

		JMenu jMenu4 = new JMenu("Look And Feel");
		jMenu4.setMnemonic('L');

		JMenuItem menuItem1 = new JMenuItem("Category", new ImageIcon(getClass().getResource("/icon/category.png")));
		menuItem1.setActionCommand("category");
		menuItem1.setMnemonic('C');
		menuItem1.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.Event.CTRL_MASK));
		menuItem1.addActionListener(this);
		jMenu1.add(menuItem1);

		JMenuItem menuItem2 = new JMenuItem("Product", new ImageIcon(getClass().getResource("/icon/product.png")));
		menuItem2.setActionCommand("product");
		menuItem2.setMnemonic('P');
		menuItem2.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.Event.CTRL_MASK));
		menuItem2.addActionListener(this);
		jMenu1.add(menuItem2);

		JMenuItem menuItem3 = new JMenuItem("Customer", new ImageIcon(getClass().getResource("/icon/customer.png")));
		menuItem3.setActionCommand("customer");
		menuItem3.setMnemonic('U');
		menuItem3.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.Event.CTRL_MASK));
		menuItem3.addActionListener(this); 
		jMenu1.add(menuItem3);

	    JMenuItem menuItem4 = new JMenuItem("Sales", new ImageIcon(getClass().getResource("/icon/sale.png")));
		menuItem4.setActionCommand("sales");
		menuItem4.setMnemonic('S');
		menuItem4.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.Event.CTRL_MASK));
		menuItem4.addActionListener(this);
		jMenu2.add(menuItem4);

		JMenuItem menuItem5 = new JMenuItem("Categorywise Sales",
				new ImageIcon(getClass().getResource("/icon/categorywise.png")));
		menuItem5.setActionCommand("Categorywisesales");
		menuItem5.setMnemonic('I');
		menuItem5.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.Event.CTRL_MASK));
		menuItem5.addActionListener(this);
		jMenu3.add(menuItem5);

		JMenuItem menuItem6 = new JMenuItem("Stock Order Report",
				new ImageIcon(getClass().getResource("/icon/stockO.png")));
		menuItem6.setActionCommand("Stockorderreport");
		menuItem6.setMnemonic('O');
		menuItem6.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.Event.CTRL_MASK));
		menuItem6.addActionListener(this);
		jMenu3.add(menuItem6);

		JMenuItem menuItem7 = new JMenuItem("Amount Receivable Report",
				new ImageIcon(getClass().getResource("/icon/amount.png")));
		menuItem7.setActionCommand("Amt");
		menuItem7.setMnemonic('M');
		menuItem7.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_7, java.awt.Event.CTRL_MASK));
		menuItem7.addActionListener(this);
		jMenu3.add(menuItem7);

		JMenuItem menuItem8 = new JMenuItem("Stock Analysis Reports",
				new ImageIcon(getClass().getResource("/icon/stockAnalysis.png")));
		menuItem8.setActionCommand("Stock");
		menuItem8.setMnemonic('R');
		menuItem8.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_8, java.awt.Event.CTRL_MASK));
		menuItem8.addActionListener(this);
		jMenu3.add(menuItem8);

		JMenuItem menuItem9 = new JMenuItem("GST Report", new ImageIcon(getClass().getResource("/icon/gst.png")));
		menuItem9.setActionCommand("gst");
		menuItem9.setMnemonic('G');
		menuItem9.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_9, java.awt.Event.CTRL_MASK));
		menuItem9.addActionListener(this);
		jMenu3.add(menuItem9);

		jMenu1.addSeparator();

		JMenuItem menuItem13 = new JMenuItem("Exit");
		menuItem13.setActionCommand("Exit");
		menuItem13.setMnemonic('x');
		menuItem13.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.Event.CTRL_MASK));
		menuItem13.addActionListener(this);
		jMenu1.add(menuItem13);

		JCheckBoxMenuItem menuItem14 = new JCheckBoxMenuItem("Metal");
		menuItem14.setSelected(true);
		menuItem14.setActionCommand("Metal");
		menuItem14.setMnemonic('e');
		menuItem14.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.Event.CTRL_MASK));
		menuItem14.addActionListener(this);
		jMenu4.add(menuItem14);

		JCheckBoxMenuItem menuItem15 = new JCheckBoxMenuItem("Motif");
		menuItem15.setActionCommand("Motif");
		menuItem15.setMnemonic('f');
		menuItem15.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.Event.CTRL_MASK));
		menuItem15.addActionListener(this);
		jMenu4.add(menuItem15);

		JCheckBoxMenuItem menuItem16 = new JCheckBoxMenuItem("Nimbus");
		menuItem16.setActionCommand("Nimbus");
		menuItem16.setMnemonic('N');
		menuItem16.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.Event.CTRL_MASK));
		menuItem16.addActionListener(this);
		jMenu4.add(menuItem16);

		JCheckBoxMenuItem menuItem17 = new JCheckBoxMenuItem("Windows");
		menuItem17.setActionCommand("Windows");
		menuItem17.setMnemonic('W');
		menuItem17.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.Event.CTRL_MASK));
		menuItem17.addActionListener(this);
		jMenu4.add(menuItem17);

		JCheckBoxMenuItem menuItem18 = new JCheckBoxMenuItem("Windows Classic");
		menuItem18.setActionCommand("WindowsClassic");
		menuItem18.setMnemonic('C');
		menuItem18.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.Event.CTRL_MASK));
		menuItem18.addActionListener(this);
		jMenu4.add(menuItem18);

		ButtonGroup bg = new ButtonGroup();
		bg.add(menuItem14);
		bg.add(menuItem15);
		bg.add(menuItem16);
		bg.add(menuItem17);
		bg.add(menuItem18);

		JMenu jMenu5 = new JMenu("Help");
		jMenu5.setMnemonic('H');

		JMenuItem menuItem10 = new JMenuItem("About", new ImageIcon(getClass().getResource("/icon/about.png")));
		menuItem10.setMnemonic('A');
		menuItem10.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_8, java.awt.Event.CTRL_MASK));
		jMenu5.add(menuItem10);

		JMenuItem menuItem11 = new JMenuItem("Read me", new ImageIcon(getClass().getResource("/icon/read.png")));
		menuItem11.setActionCommand("Read");
		menuItem11.setMnemonic('R');
		menuItem11.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_8, java.awt.Event.CTRL_MASK));
		menuItem8.addActionListener(this);
		jMenu5.add(menuItem11);

		menuBar.add(jMenu1);
		menuBar.add(jMenu2);
		menuBar.add(jMenu3);
		menuBar.add(jMenu4);

		setJMenuBar(menuBar);

	}

	public void actionPerformed(ActionEvent ae) {
		String str = ae.getActionCommand();
		int i = -1;
		if (str.equals("Metal")) {
			i = 0;
		} else if (str.equals("Nimbus")) {
			i = 1;
		} else if (str.equals("Motif")) {
			i = 2;
		} else if (str.equals("Windows")) {
			i = 3;
		} else if (str.equals("WindowsClassic")) {
			i = 4;
		}

		if (i > -1) {
			try {
				UIManager.setLookAndFeel(laf[i].getClassName());
				SwingUtilities.updateComponentTreeUI(this);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Unable to Apply Look And Feel");
			}
			return;
		}

		JInternalFrame internalFrame = new JInternalFrame("Title", true, true, true, true);
		if (str.equals("category")) {
			internalFrame.setTitle("Categories & details");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/icon/category.png")));
			internalFrame.setContentPane(new CategoryForm());
			internalFrame.setBounds(10, 10, 400, 300);
			internalFrame.setVisible(true);
		} else if (str.equals("product")) {
			internalFrame.setTitle("Product");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/icon/product.png")));
			internalFrame.setContentPane(new ProductForm());
			internalFrame.setBounds(10, 10, 700, 900);
			internalFrame.setVisible(true);
		} else if (str.equals("customer")) {
			internalFrame.setTitle("Customer");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/icon/customer.png")));
			internalFrame.setContentPane(new CustomerForm());
			internalFrame.setBounds(10, 10, 400, 400);
			internalFrame.setVisible(true);
		} else if (str.equals("sales")) {
			internalFrame.setTitle("Sales");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/icon/customer.png")));
			internalFrame.setContentPane((new Sales()));
			internalFrame.setBounds(10, 10, 700, 700);
			internalFrame.setVisible(true);
		}
		desktopPane.add(internalFrame, 1);
	}

	public static void main(String args[]) {
		new Desktop();
	}
}
