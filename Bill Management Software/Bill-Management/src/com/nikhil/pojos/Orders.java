package com.pos.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Orders implements Serializable {
	protected int orderid;
	protected int custid;
	protected Date  orderdatetime;
	protected float orderamount ;
	protected float ordersgst;
	protected float ordercgst;
	public Orders() {
		super();
	}
	public Orders(int orderid) {
		super();
		this.orderid = orderid;
	}
	public Orders(int custid,float orderamount, float ordersgst, float ordercgst) {
		super();
		
		this.custid = custid;
		
		this.orderamount = orderamount;
		this.ordersgst = ordersgst;
		this.ordercgst = ordercgst;
	}
	
	public Orders(Date orderdatetime, float orderamount, float ordersgst, float ordercgst) {
		super();
		this.orderdatetime = orderdatetime;
		this.orderamount = orderamount;
		this.ordersgst = ordersgst;
		this.ordercgst = ordercgst;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public Date getOrderdatetime() {
		return orderdatetime;
	}
	public void setOrderdatetime(Date orderdatetime) {
		this.orderdatetime = orderdatetime;
	}
	public float getOrderamount() {
		return orderamount;
	}
	public void setOrderamount(float orderamount) {
		this.orderamount = orderamount;
	}
	public float getOrdersgst() {
		return ordersgst;
	}
	public void setOrdersgst(float ordersgst) {
		this.ordersgst = ordersgst;
	}
	public float getOrdercgst() {
		return ordercgst;
	}
	public void setOrdercgst(float ordercgst) {
		this.ordercgst = ordercgst;
	}
	@Override
	public int hashCode() {
		return Objects.hash(orderid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Orders))
			return false;
		Orders other = (Orders) obj;
		return orderid == other.orderid;
	}
	@Override
	public String toString() {
		return "Orders [orderid=" + orderid + ", custid=" + custid + ", orderdatetime=" + orderdatetime
				+ ", orderamount=" + orderamount + ", ordersgst=" + ordersgst + ", ordercgst=" + ordercgst + "]";
	}
	
	

}
