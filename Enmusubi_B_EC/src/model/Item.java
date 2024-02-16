package model;

public class Item {
	private int item_id,price,stock,category_id;
	private String item_name,img_url;
	
	public Item(int item_id, String item_name, String img_url, int price, int stock, int category_id) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.img_url = img_url;
		this.price = price;
		this.stock = stock;
		this.setCategory_id(category_id);
	}

	public String getItem_name() {return item_name;}
	public void setItem_name(String item_name) {this.item_name = item_name;}
	
	public int getCategory_id() {return category_id;}
	public void setCategory_id(int category_id) {this.category_id = category_id;}
	
	public int getItem_id() {return item_id;}
	public void setItem_id(int item_id) {this.item_id = item_id;}
	
	public int getPrice() {return price;}
	public void setPrice(int price) {this.price = price;}
	
	public int getStock() {return stock;}
	public void setStock(int stock) {this.stock = stock;}
	
	public String getImg_url() {return img_url;}
	public void setImg_ur(String img_url) {this.img_url = img_url;}
}