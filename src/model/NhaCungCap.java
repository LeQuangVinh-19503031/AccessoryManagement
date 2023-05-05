package model;

import java.util.Objects;

public class NhaCungCap {
	private String maNCC;
	private String tenNCC;
	private String diaChi;
	private String sdt;
	private String email;
	public String getMa() {
		return maNCC;
	}
	public void setMa(String ma) {
		this.maNCC = ma;
	}
	public String getTen() {
		return tenNCC;
	}
	public void setTen(String ten) {
		this.tenNCC = ten;
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
		return Objects.hash(diaChi, email, maNCC, sdt, tenNCC);
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
				&& Objects.equals(maNCC, other.maNCC) && Objects.equals(sdt, other.sdt) && Objects.equals(tenNCC, other.tenNCC);
	}
	@Override
	public String toString() {
		return "NhaCungCap [ma=" + maNCC + ", ten=" + tenNCC + ", diaChi=" + diaChi + ", sdt=" + sdt + ", email=" + email
				+ "]";
	}
	public NhaCungCap(String ma, String ten, String diaChi, String sdt, String email) {
		this.maNCC = ma;
		this.tenNCC = ten;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.email = email;
	}
	public NhaCungCap() {
	}

	
	
}
