package com.pos.Gui;




import javax.swing.*;
import com.pos.daos.*;
import com.pos.pojos.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class SalesTable extends AbstractTableModel {
	ArrayList<OrderDetails> listOd;
	String[] column = { "Product Id", "Quantity", " Price", "Cgst", "Sgst", "Total" };


	public SalesTable(ArrayList<OrderDetails> od) {
		ProductsDao productDao = new ProductsDao();
		listOd = od;
	}

	public String getColumnName(int col) {
		return column[col];
	}

	public Class getColumnClass(int c) {
		return column[c].getClass();
	}

	@Override
	public int getColumnCount() {
		return column.length;
	}

	@Override
	public int getRowCount() {
		return listOd.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		OrderDetails p = listOd.get(arg0);
		if (arg1 == 0)
			return p.getProdId();
//		else if (arg1 == 1)
//			return p.get();
		else if (arg1 == 1)
			return p.getProdqty();
		else if (arg1 == 2)
			return p.getProdprice();
		else if (arg1 == 3)
			return p.getProdcgst();
		else if (arg1 == 4)
			return p.getProdsgst();
		else if (arg1 == 5)
			return p.getProdprice() * p.getProdqty();

		return null;
	}



	

	

}

