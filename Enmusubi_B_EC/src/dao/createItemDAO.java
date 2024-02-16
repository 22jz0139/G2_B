package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Item;

public class createItemDAO {
	
	/**
	    * itemテーブルのデータをすべて取得するメゾット
	    * @return アイテムデータのリスト 
	    */
	    public List<Item> get() {
	        List<Item> list = new ArrayList<>();

	        DBManager manager = DBManager.getInstance();
	        try(Connection cn = manager.getConnection()) {
	            String sql = "SELECT * FROM ITEMS";
	            
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
	* DBのデータを追加する
	* @return 成功/失敗
	*/
	
	public int insert(String img_url,int item_id,String item_name,int price, int stock,int category_id) {
	    int ret = -1;
	    
	    
	    // ②DBのデータの追加
	    DBManager manager = DBManager.getInstance();
	    try(Connection cn = manager.getConnection()) {
	        // プレースホルダで変数部分を定義
	        String sql = "INSERT INTO ITEMS (img_url,item_id,item_name,price,stock,category_id) VALUES (?,?,?,?,?,?)";
	        PreparedStatement stmt = cn.prepareStatement(sql);
	        stmt.setString(1, img_url);
	        stmt.setInt(2, item_id);
	        stmt.setString(3, item_name);
	        stmt.setInt(4, price);
	        stmt.setInt(5, stock);
	        stmt.setInt(6, category_id);
	        
	        System.out.println(img_url);
	        System.out.println(item_id);
	        System.out.println(item_name);
	        System.out.println(price);
	        System.out.println(stock);
	        System.out.println(category_id);
	        ret = stmt.executeUpdate();
	        
	    } catch(SQLException e) {
	        e.printStackTrace();
	    }
	    System.out.println(item_name);
	    return ret;
	}
}