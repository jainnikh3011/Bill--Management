package com.pos.pojos;

import java.util.Objects;

public class OrderDetails {
	protected int orderDetailId;
	protected int orderId;
	protected int prodId;
	protected int prodqty;
	protected float prodprice;
	protected float prodsgst;
	protected float prodcgst;
	
	
	public OrderDetails() {
		super();
	}
	public OrderDetails(int prodId, int prodqty, float prodprice, float prodsgst, float prodcgst) {
		super();
		this.prodId = prodId;
		this.prodqty = prodqty;
		this.prodprice = prodprice;
		this.prodsgst = prodsgst;
		this.prodcgst = prodcgst;
	}
	public OrderDetails(int orderId, int prodId, int prodqty,float prodprice, float prodsgst, float prodcgst) {
		super();
		this.orderId = orderId;
		this.prodId = prodId;
		this.prodqty = prodqty;
		this.prodprice = prodprice;
		this.prodsgst = prodsgst;
		this.prodcgst = prodcgst;
	}
	public OrderDetails(int orderDetailId, int orderId, int prodId, int prodqty, float prodprice, float prodsgst,
			float prodcgst) {
		super();
		this.orderDetailId = orderDetailId;
		this.orderId = orderId;
		this.prodId = prodId;
		this.prodqty = prodqty;
		this.prodprice = prodprice;
		this.prodsgst = prodsgst;
		this.prodcgst = prodcgst;
	}
	public int getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public int getProdqty() {
		return prodqty;
	}
	public void setProdqty(int prodqty) {
		this.prodqty = prodqty;
	}
	public float getProdprice() {
		return prodprice;
	}
	public void setProdprice(float prodprice) {
		this.prodprice = prodprice;
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
		return Objects.hash(orderDetailId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof OrderDetails))
			return false;
		OrderDetails other = (OrderDetails) obj;
		return orderDetailId == other.orderDetailId;
	}
	@Override
	public String toString() {
		return "OrderDetails [orderDetailId=" + orderDetailId + ", orderId=" + orderId + ", prodId=" + prodId
				+ ", prodqty=" + prodqty + ", prodprice=" + prodprice + ", prodsgst=" + prodsgst + ", prodcgst="
				+ prodcgst + "]";
	}
	
	
	
	
	

}
