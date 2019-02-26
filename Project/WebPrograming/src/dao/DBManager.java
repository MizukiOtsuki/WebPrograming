package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBManager {

	private static String URL = "jdbc:mysql://localhost/";
	private static String DBName = "usermanagement?useUnicode=true&characterEncoding=utf8";
	private static String USER = "root";
	private static String PASS = "password";




public static Connection getConnection() {
    Connection con = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(URL+DBName,USER,PASS);
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    return con;
}

}