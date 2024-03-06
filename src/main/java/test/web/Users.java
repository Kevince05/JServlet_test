package test.web;

public class Users {
	private int id;
	private String username;
	
	public Users(int id, String username) {
		this.id = id;
		this.username = username;
	}
	
	public int getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
}
