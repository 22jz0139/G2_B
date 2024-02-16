package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	private static final String CN_STRING = "jdbc:oracle:thin:@//10.40.112.11:1521/dbsys";
    private static final String USER = "jz220139";
    private static final String PASS = "pass39";

    private static DBManager self;


    /**
    *コンストラクタ
    */
    private DBManager(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch (ClassNotFoundException e){
        }
    }
    /**インスタンスを取得するメゾット */
    public static DBManager getInstance(){
        if (self == null) {
            self = new DBManager();
        }
        return self;
    }

    /**
    *コネクションを取得
    */
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CN_STRING,USER,PASS);
    }
}
