package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Item;

public class itemDAO {
	/**
	    * itemテーブルのデータをすべて取得するメゾット
	    * @return アイテムデータのリスト 
	    */
	    public List<Item> get() {
	        List<Item> list = new ArrayList<>();

	        DBManager manager = DBManager.getInstance();
	        try(Connection cn = manager.getConnection()) {
	            String sql = "SELECT * FROM ITEMS";
	            			 //"SELECT * FROM Items i JOIN Images j ON i.itemID ＝ j.itemID";
	            PreparedStatement stmt = cn.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();

	            //データをリストに格納
	            while(rs.next()) {
	                Item item = rs2model(rs);
	                list.add(item);
	            }
	        } catch(SQLException e) {
	            e.printStackTrace();
	        }

	        return list;    
	    }

	    /**
		 * アイテムテーブルの中から、主キーが id であるレコードを返すメソッド
		 * @param id 主キーの値
		 * @return 発見したビデオデータ。なければnull
		 */
		public Item find(int id) {
			Item item = null;
			DBManager manager = DBManager.getInstance();
			try(Connection cn = manager.getConnection()) {
				// プレースホルダで変数部分を定義
				String sql = "SELECT * FROM items WHERE item_id = ?;";
				PreparedStatement stmt = cn.prepareStatement(sql);
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				
				// データをリストに格納
				if (rs.next()) {
					item = rs2model(rs);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			return  item;
		}
	    /**
		 * ResultSetの行データをモデルの形に変換するメソッド
		 * @param rs 変換前のデータ
		 * @return 変換後のデータ
		 */
		private Item rs2model(ResultSet rs) throws SQLException {
			/* 中略。rsの値を取得し、それぞれの変数に代入 */
	        int item_id = rs.getInt("item_id");
	        String item_name = rs.getString("item_name");
	        String img_url = rs.getString("img_url");
	        int price = rs.getInt("price");
	        int stock = rs.getInt("stock");
	        int category_id = rs.getInt("Category_id");

			return new Item(item_id, item_name, img_url, price, stock,category_id);
		}
		
		/**
		* DBのデータを変更する
		* @return 成功/失敗
		*/
		
		public int update(int stock,int item_id) {
		    int ret = -1;
		    
		    
		    // ②DBのデータを変更
		    DBManager manager = DBManager.getInstance();
		    try(Connection cn = manager.getConnection()) {
		        // プレースホルダで変数部分を定義
		        String sql = "UPDATE ITEMS SET stock = ? WHERE item_id = ?";
		        PreparedStatement stmt = cn.prepareStatement(sql);
		        stmt.setInt(1, stock);
		        stmt.setInt(2, item_id);
		        
		        ret = stmt.executeUpdate();
		        
		    } catch(SQLException e) {
		        e.printStackTrace();
		    }
		    
		    return ret;
		}
}
