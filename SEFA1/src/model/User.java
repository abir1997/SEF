package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class User implements Serializable{
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
		return String.format("Name : %s, Id : %d, Password : %s, type:%s", name, id, pwd, this.getClass());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
}
