package com.pos.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import com.pos.utilities.*;

public class Customers implements Serializable {
	protected int custid;
	protected String custname;
	protected String custmobile;
	protected String custadd;
	protected String city;
	protected Date regdate;
	public Customers() {
		custname = new String();
		custadd = new String();
		city = new String();
	}
	public Customers(int custid) {
		super();
		this.custid = custid;
	}
	
	public Customers(String custname, String custmobile, String custadd, String city) {
		super();
		this.custname = custname;
		this.custmobile = custmobile;
		this.custadd = custadd;
		this.city = city;
	}
	public Customers(String custname, String custmobile, String custadd, String city, Date regdate) {
		super();
		this.custname = custname;
		this.custmobile = custmobile;
		this.custadd = custadd;
		this.city = city;
		this.regdate = regdate;
	}
	public Customers(int custid, String custname, String custmobile, String custadd, String city, Date regdate) {
		super();
		this.custid = custid;
		this.custname = custname;
		this.custmobile = custmobile;
		this.custadd = custadd;
		this.city = city;
		this.regdate = regdate;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCustmobile() {
		return custmobile;
	}
	public void setCustmobile(String custmobile) {
		this.custmobile = custmobile;
	}
	public String getCustadd() {
		return custadd;
	}
	public void setCustadd(String custadd) {
		this.custadd = custadd;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		
		
		this.regdate = regdate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(city);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Customers))
			return false;
		Customers other = (Customers) obj;
		return Objects.equals(city, other.city);
	}
	@Override
	public String toString() {
		return "Customers [custid=" + custid + ", custname=" + custname + ", custmobile=" + custmobile + ", custadd="
				+ custadd + ", city=" + city + ", regdate=" + regdate + "]";
	}
	

	
	
	

}
