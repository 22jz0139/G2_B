package model;

public class Order {
	private int order_id,customer_id,item_id,stock,delivery_id;
	private String item_name;
	
	public Order(int order_id, int customer_id, int item_id, String item_name,int stock, int delivery_id) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.item_id = item_id;
		this.setItem_name(item_name);
		this.stock = stock;
		this.delivery_id = delivery_id;
	}

	
	public int getOrder_id() {return order_id;}
	public void setOrder_id(int order_id) {this.order_id = order_id;}
	
	public int getCustomer_id() {return customer_id;}
	public void setCustomer_id(int customer_id) {this.customer_id = customer_id;}
	
	public int getItem_id() {return item_id;}
	public void setItem_id(int item_id) {this.item_id = item_id;}
	
	public String getItem_name() {return item_name;}
	public void setItem_name(String item_name) {this.item_name = item_name;}
	
	public int getStock() {return stock;}
	public void setStock(int stock) {this.stock = stock;}
	
	public int getDelivery_id() {return delivery_id;}
	public void setDelivery_id(int delivery_id) {this.delivery_id = delivery_id;}
	
}