package model;

public abstract class User {
	private String name;
	private int id;
	private String pwd;

	public User(String name, int id, String pwd) {
		this.name = name;
		this.id = id;
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}

	public String toString() {
		return String.format("Name : %s\nId : %d\n,Password : %s", name, id, pwd);
	}
}
