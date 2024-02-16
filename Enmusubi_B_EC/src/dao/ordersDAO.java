package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Order;


public class ordersDAO {
	/**
	    * orderテーブルのデータをすべて取得するメゾット
	    * @return orderデータのリスト 
	    */
	    public List<Order> get() {
	        List<Order> order_list = new ArrayList<>();

	        DBManager manager = DBManager.getInstance();
	        try(Connection cn = manager.getConnection()) {
	            String sql = "SELECT * FROM ORDERS";
	            			 //"SELECT * FROM Items i JOIN Images j ON i.itemID ＝ j.itemID";
	            PreparedStatement stmt = cn.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();

	            //データをリストに格納
	            while(rs.next()) {
	            	Order order = rs2model(rs);
	            	order_list.add(order);
	            }
	        } catch(SQLException e) {
	            e.printStackTrace();
	        }

	        return order_list;    
	    }

	    /**
		 * アイテムテーブルの中から、主キーが id であるレコードを返すメソッド
		 * @param id 主キーの値
		 * @return 発見したビデオデータ。なければnull
		 */
		public Order find(int id) {
			Order order = null;
			DBManager manager = DBManager.getInstance();
			try(Connection cn = manager.getConnection()) {
				// プレースホルダで変数部分を定義
				String sql = "SELECT * FROM ORDERS WHERE order_id = ?;";
				PreparedStatement stmt = cn.prepareStatement(sql);
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				
				// データをリストに格納
				if (rs.next()) {
					order = rs2model(rs);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			return  order;
		}
	    /**
		 * ResultSetの行データをモデルの形に変換するメソッド
		 * @param rs 変換前のデータ
		 * @return 変換後のデータ
		 */
		private Order rs2model(ResultSet rs) throws SQLException {
			/* 中略。rsの値を取得し、それぞれの変数に代入 */
	        int order_id = rs.getInt("order_id");
	        int customer_id = rs.getInt("customer_id");
	        int item_id = rs.getInt("item_id");
	        String item_name = rs.getString("item_name");
	        int stock = rs.getInt("stock");
	        int delivery_id = rs.getInt("delivery_id");

			return new Order(order_id, customer_id, item_id, item_name, stock,delivery_id);
		}
}