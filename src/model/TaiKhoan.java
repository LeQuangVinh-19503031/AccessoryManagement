package model;

import java.util.Objects;

public class TaiKhoan {
	private String user;
	private String pass;

	public TaiKhoan() {
	}

	public TaiKhoan(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "TaiKhoan [user=" + user + ", pass=" + pass + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(pass, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(pass, other.pass) && Objects.equals(user, other.user);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
