package model;

import java.util.Objects;

public class NhaCungCap {
	private String ma;
	private String ten;
	private String diaChi;
	private String sdt;
	private String email;
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		return Objects.hash(diaChi, email, ma, sdt, ten);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhaCungCap other = (NhaCungCap) obj;
		return Objects.equals(diaChi, other.diaChi) && Objects.equals(email, other.email)
				&& Objects.equals(ma, other.ma) && Objects.equals(sdt, other.sdt) && Objects.equals(ten, other.ten);
	}
	@Override
	public String toString() {
		return "NhaCungCap [ma=" + ma + ", ten=" + ten + ", diaChi=" + diaChi + ", sdt=" + sdt + ", email=" + email
				+ "]";
	}
	public NhaCungCap(String ma, String ten, String diaChi, String sdt, String email) {
		this.ma = ma;
		this.ten = ten;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.email = email;
	}
	public NhaCungCap() {
	}

	
	
}
