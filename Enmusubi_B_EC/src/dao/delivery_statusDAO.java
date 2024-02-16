package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Delivery_status;

public class delivery_statusDAO {
	/**
	    * delivery_statusテーブルのデータをすべて取得するメゾット
	    * @return delivery_statusデータのリスト 
	    */
	    public List<Delivery_status> get() {
	        List<Delivery_status> delivery_status_list = new ArrayList<>();

	        DBManager manager = DBManager.getInstance();
	        try(Connection cn = manager.getConnection()) {
	            String sql = "SELECT * FROM DELIVERY_STATUS";
	            			 //"SELECT * FROM Items i JOIN Images j ON i.itemID ＝ j.itemID";
	            PreparedStatement stmt = cn.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();

	            //データをリストに格納
	            while(rs.next()) {
	            	Delivery_status delivery_status = rs2model(rs);
	            	delivery_status_list.add(delivery_status);
	            }
	        } catch(SQLException e) {
	            e.printStackTrace();
	        }

	        return delivery_status_list;    
	    }

	    /**
		 * アイテムテーブルの中から、主キーが id であるレコードを返すメソッド
		 * @param id 主キーの値
		 * @return 発見したビデオデータ。なければnull
		 */
		public Delivery_status find(int id) {
			Delivery_status delivery_status = null;
			DBManager manager = DBManager.getInstance();
			try(Connection cn = manager.getConnection()) {
				// プレースホルダで変数部分を定義
				String sql = "SELECT * FROM DELIVERY_STATUS WHERE delivery_status_id = ?;";
				PreparedStatement stmt = cn.prepareStatement(sql);
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				
				// データをリストに格納
				if (rs.next()) {
					delivery_status = rs2model(rs);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			return  delivery_status;
		}
	    /**
		 * ResultSetの行データをモデルの形に変換するメソッド
		 * @param rs 変換前のデータ
		 * @return 変換後のデータ
		 */
		private Delivery_status rs2model(ResultSet rs) throws SQLException {
			/* 中略。rsの値を取得し、それぞれの変数に代入 */
	        int status_id = rs.getInt("status_id");
	        String status_name = rs.getString("status_name");

			return new Delivery_status(status_id, status_name);
		}
}