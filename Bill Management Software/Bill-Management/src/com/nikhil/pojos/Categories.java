package com.pos.pojos;

import java.io.Serializable;
import java.util.Objects;

public class Categories implements Serializable {
	 protected int catid;
	 protected String catname;
	 protected String catdetails;
	 
	 
	 
	public Categories() {
			catname = new String();
			catdetails = new String();
		}
	
	public Categories(String catname, String catdetails) {
		super();
		this.catname = catname;
		this.catdetails = catdetails;
	}

	public Categories(int catid, String catname, String catdetails) {
		super();
		this.catid = catid;
		this.catname = catname;
		this.catdetails = catdetails;
	}
	public Categories(int catid) {
		super();
		this.catid = catid;
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	public String getCatdetails() {
		return catdetails;
	}
	public void setCatdetails(String catdetails) {
		this.catdetails = catdetails;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(catid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Categories))
			return false;
		Categories other = (Categories) obj;
		return catid == other.catid;
	}
	@Override
	public String toString() {
		return "Categories [catid=" + catid + ", catname=" + catname + ", catdetails=" + catdetails + "]";
	}
	

}
