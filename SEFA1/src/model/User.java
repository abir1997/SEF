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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		return true;
	}
	
	
}
