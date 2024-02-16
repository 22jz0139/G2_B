package model;

public class Delivery {
	private int delivery_id, status_id,order_id;
	
	public Delivery(int delivery_id,int status_id,int order_id) {
		super();
		this.delivery_id = delivery_id;
		this.status_id = status_id;
		this.order_id = order_id;
	}

	public int getDelivery_id() {return delivery_id;}
	public void setDelivery_id(int delivery_id) {this.delivery_id = delivery_id;}

	public int getStatus_id() {return status_id;}
	public void setStatus_id(int status_id) {this.status_id = status_id;}
	
	public int getOrder_id() {return order_id;}
	public void setOrder_id(int order_id) {this.order_id = order_id;}
}