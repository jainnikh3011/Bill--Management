package com.pos.Gui;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.pos.daos.*;
import com.pos.pojos.*;


public class CategoryTable extends AbstractTableModel {
	

		ArrayList<Products>list; 
		String columns[] = { "ProdId", "CatId", "Product code","Product Name","Product PRice","Quantity","Product reorder level","Sgst","Cgst"};

		public CategoryTable(int catid) {
			ProductsDao sDao = new ProductsDao();
			list = sDao.findAllByCategory(catid);
			
		}
			public String getColumnName(int col) {
				return columns[col];
			}

			public Class getColumnClass(int c) {
		        return columns[c].getClass();
		    }
		         
			@Override
			public int getColumnCount() {
				return columns.length;
			}

			@Override
			public int getRowCount() {
				return list.size();
			}

			@Override
			public Object getValueAt(int arg0, int arg1) {
				Products s = list.get(arg0);
				if (arg1 == 0)
					return s.getProdid();
				else if (arg1 == 1)
					return s.getCatid();
				else if (arg1 == 2)
					return s.getProdcode();
				else if (arg1 == 3)
					return s.getProdname();
				else if (arg1 == 4)
					return s.getProdprice();
				else if (arg1 == 5)
					return s.getProdqih();
				else if (arg1 == 6)
					return s.getProdreorderlevel();
				else if (arg1 == 7)
					return s.getProdsgst();
				else if (arg1 == 8)
					return s.getProdcgst();
				return null;
			}

		}
