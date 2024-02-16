package model;

public class Delivery_status {
	private int status_id;
	String status_name;
	
	public Delivery_status(int status_id, String status_name) {
		super();
		this.status_id = status_id;
		this.status_name = status_name;
	}

	public int getStatus_id() {
		return status_id;
	}

	public int status_id() {return status_id;}
	public void setStatus_id(int status_id) {this.status_id = status_id;}
	
	public String status_name() {return status_name;}
	public void setStatus_name(String status_name) {this.status_name = status_name;}
	
}