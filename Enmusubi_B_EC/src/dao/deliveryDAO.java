package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Delivery;

public class deliveryDAO {
	/**
	    * orderテーブルのデータをすべて取得するメゾット
	    * @return orderデータのリスト 
	    */
	    public List<Delivery> get() {
	        List<Delivery> delivery_list = new ArrayList<>();

	        DBManager manager = DBManager.getInstance();
	        try(Connection cn = manager.getConnection()) {
	            String sql = "SELECT * FROM DELIVERY";
	            			 //"SELECT * FROM Items i JOIN Images j ON i.itemID ＝ j.itemID";
	            PreparedStatement stmt = cn.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();

	            //データをリストに格納
	            while(rs.next()) {
	            	Delivery order = rs2model(rs);
	            	delivery_list.add(order);
	            }
	        } catch(SQLException e) {
	            e.printStackTrace();
	        }

	        return delivery_list;    
	    }

	    /**
		 * アイテムテーブルの中から、主キーが id であるレコードを返すメソッド
		 * @param id 主キーの値
		 * @return 発見したビデオデータ。なければnull
		 */
		public Delivery find(int id) {
			Delivery delivery = null;
			DBManager manager = DBManager.getInstance();
			try(Connection cn = manager.getConnection()) {
				// プレースホルダで変数部分を定義
				String sql = "SELECT * FROM DELIVERY WHERE delivery_id = ?;";
				PreparedStatement stmt = cn.prepareStatement(sql);
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				
				// データをリストに格納
				if (rs.next()) {
					delivery = rs2model(rs);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			return  delivery;
		}
	    /**
		 * ResultSetの行データをモデルの形に変換するメソッド
		 * @param rs 変換前のデータ
		 * @return 変換後のデータ
		 */
		private Delivery rs2model(ResultSet rs) throws SQLException {
			/* 中略。rsの値を取得し、それぞれの変数に代入 */
	        int delivery_id = rs.getInt("delivery_id");
	        int status_id = rs.getInt("status_id");
	        int order_id = rs.getInt("order_id");
	       
			return new Delivery(delivery_id, status_id, order_id);
		}
		
		/**
		* DBのデータを変更する
		* @return 成功/失敗
		*/
		
		public int update(int status_id,int delivery_id) {
		    int ret = -1;
		    
		    
		    // ②DBのデータを変更
		    DBManager manager = DBManager.getInstance();
		    try(Connection cn = manager.getConnection()) {
		        // プレースホルダで変数部分を定義
		        String sql = "UPDATE DELIVERY SET status_id = ? WHERE delivery_id = ?";
		        PreparedStatement stmt = cn.prepareStatement(sql);
		        stmt.setInt(1, status_id);
		        stmt.setInt(2, delivery_id);
		        
		        ret = stmt.executeUpdate();
		        
		    } catch(SQLException e) {
		        e.printStackTrace();
		    }
		    
		    return ret;
		}
}