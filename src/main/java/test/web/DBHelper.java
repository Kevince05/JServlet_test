package test.web;

import java.sql.*;
import java.util.ArrayList;

public class DBHelper {

	private String username;
	private String password;
	private String DBurl;
	private Connection conn;

	public DBHelper(String usr, String pwd, String url) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.username = usr;
			this.password = pwd;
			this.DBurl = url;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void connect() throws SQLException {
		conn = DriverManager.getConnection(DBurl, username, password);
	}

	public void disconnect() throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}

	public Boolean register(String username, String password) throws SQLException {
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO users (username, password) VALUES ('" + username + "', '" + password + "')";
		stmt.executeUpdate(sql);
		return true;

	}
	
	public Boolean login(String username, String password) throws SQLException {
		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			return true;
		}
		return false;
	}
	
	public ArrayList<Users> getAllUsers() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT id,username FROM users";
        ResultSet rs = stmt.executeQuery(sql);
		ArrayList<Users> ret = new ArrayList<Users>();
        do{
            ret.add(new Users(rs.getInt("id"), rs.getString("username")));
        } while (rs.next());
        return ret;
    }
}
