package model;

import java.util.Objects;

public class KhachHang {
	private String maKH;
	private String tenKH;
	private String diaChiKH;
	private String sdtKH;
	private String email;

	public String getMa() {
		return maKH;
	}
	public void setMa(String ma) {
		this.maKH = ma;
	}
	public String getTen() {
		return tenKH;
	}
	public void setTen(String ten) {
		this.tenKH = ten;
	}
	public String getDiaChi() {
		return diaChiKH;
	}
	public void setDiaChi(String diaChi) {
		this.diaChiKH = diaChi;
	}
	public String getSdt() {
		return sdtKH;
	}
	public void setSdt(String sdt) {
		this.sdtKH = sdt;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(diaChiKH, email, maKH, sdtKH, tenKH);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(diaChiKH, other.diaChiKH) && Objects.equals(email, other.email)
				&& Objects.equals(maKH, other.maKH) && Objects.equals(sdtKH, other.sdtKH) && Objects.equals(tenKH, other.tenKH);
	}
	
	@Override
	public String toString() {
		return "KhachHang [ma=" + maKH + ", ten=" + tenKH + ", diaChi=" + diaChiKH + ", sdt=" + sdtKH + ", email=" + email
				+ "]";
	}

	public KhachHang(String ma, String ten, String diaChi, String sdt, String email) {
		this.maKH = ma;
		this.tenKH = ten;
		this.diaChiKH = diaChi;
		this.sdtKH = sdt;
		this.email = email;
	}
	public KhachHang() {

	}
	
	
}
