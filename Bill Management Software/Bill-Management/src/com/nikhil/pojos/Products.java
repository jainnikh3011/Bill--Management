package com.pos.pojos;

import java.io.Serializable;
import java.util.Objects;

public class Products implements Serializable {

 protected int prodid;
 protected int catid;
 protected String prodcode;
 protected String prodname;
 protected float  prodprice;
 protected int prodqih;
 protected int prodreorderlevel;
 protected float prodsgst;
 protected float prodcgst;


 public Products(int prodid) {
	super();
	this.prodid = prodid;
}

 public Products() {
	prodname = new String();
	
}



public Products(int catid, String prodname, int prodqih) {
	super();
	this.catid = catid;
	this.prodname = prodname;
	this.prodqih = prodqih;
}

public Products(int prodid, int catid, String prodcode, String prodname, float prodprice, int prodqih,
		int prodreorderlevel, float prodsgst, float prodcgst) {
	super();
	this.prodid = prodid;
	this.catid = catid;
	this.prodcode = prodcode;
	this.prodname = prodname;
	this.prodprice = prodprice;
	this.prodqih = prodqih;
	this.prodreorderlevel = prodreorderlevel;
	this.prodsgst = prodsgst;
	this.prodcgst = prodcgst;
}

public Products(int catid, String prodcode, String prodname, float prodprice, int prodqih, int prodreorderlevel,
		float prodsgst, float prodcgst) {
	super();
	this.catid = catid;
	this.prodcode = prodcode;
	this.prodname = prodname;
	this.prodprice = prodprice;
	this.prodqih = prodqih;
	this.prodreorderlevel = prodreorderlevel;
	this.prodsgst = prodsgst;
	this.prodcgst = prodcgst;
}

public int getProdid() {
	return prodid;
}

public void setProdid(int prodid) {
	this.prodid = prodid;
}

public int getCatid() {
	return catid;
}

public void setCatid(int catid) {
	this.catid = catid;
}

public String getProdcode() {
	return prodcode;
}

public void setProdcode(String prodcode) {
	this.prodcode = prodcode;
}

public String getProdname() {
	return prodname;
}

public void setProdname(String prodname) {
	this.prodname = prodname;
}

public float getProdprice() {
	return prodprice;
}

public void setProdprice(float prodprice) {
	this.prodprice = prodprice;
}

public int getProdqih() {
	return prodqih;
}

public void setProdqih(int prodqih) {
	this.prodqih = prodqih;
}

public int getProdreorderlevel() {
	return prodreorderlevel;
}

public void setProdreorderlevel(int prodreorderlevel) {
	this.prodreorderlevel = prodreorderlevel;
}

public float getProdsgst() {
	return prodsgst;
}

public void setProdsgst(float prodsgst) {
	this.prodsgst = prodsgst;
}

public float getProdcgst() {
	return prodcgst;
}

public void setProdcgst(float prodcgst) {
	this.prodcgst = prodcgst;
}

@Override
public int hashCode() {
	return Objects.hash(prodid);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!(obj instanceof Products))
		return false;
	Products other = (Products) obj;
	return prodid == other.prodid;
}

@Override
public String toString() {
	return "Products [prodid=" + prodid + ", catid=" + catid + ", prodcode=" + prodcode + ", prodname=" + prodname
			+ ", prodprice=" + prodprice + ", prodqih=" + prodqih + ", prodreorderlevel=" + prodreorderlevel
			+ ", prodsgst=" + prodsgst + ", prodcgst=" + prodcgst + "]";
}
 
 
 
 
 
}
