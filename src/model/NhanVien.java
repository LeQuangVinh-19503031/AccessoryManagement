package model;

import java.sql.Date;
import java.util.Objects;

public class NhanVien {
	private String ma;
	private String ten;
	private String maPB;
	private String maQL;
	private Date ngayVaoLam;
	private Date ngaySinh;
	private String gioiTinh;
	private String diaChi;
	private String dienThoai;
	private String email;
	private String cccd;
	private String user;
	private String pass;

	public NhanVien() {
	}

	public NhanVien(String ma, String ten, String maPB, String maQL, Date ngayVaoLam, Date ngaySinh, String gioiTinh,
			String diaChi, String dienThoai, String email, String cccd, String user, String pass) {
		this.ma = ma;
		this.ten = ten;
		this.maPB = maPB;
		this.maQL = maQL;
		this.ngayVaoLam = ngayVaoLam;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
		this.cccd = cccd;
		this.user = user;
		this.pass = pass;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cccd, diaChi, dienThoai, email, gioiTinh, ma, maPB, maQL, ngaySinh, ngayVaoLam, pass, ten,
				user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(cccd, other.cccd) && Objects.equals(diaChi, other.diaChi)
				&& Objects.equals(dienThoai, other.dienThoai) && Objects.equals(email, other.email)
				&& Objects.equals(gioiTinh, other.gioiTinh) && Objects.equals(ma, other.ma)
				&& Objects.equals(maPB, other.maPB) && Objects.equals(maQL, other.maQL)
				&& Objects.equals(ngaySinh, other.ngaySinh) && Objects.equals(ngayVaoLam, other.ngayVaoLam)
				&& Objects.equals(pass, other.pass) && Objects.equals(ten, other.ten)
				&& Objects.equals(user, other.user);
	}

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

	public String getMaPB() {
		return maPB;
	}

	public void setMaPB(String maPB) {
		this.maPB = maPB;
	}

	public String getMaQL() {
		return maQL;
	}

	public void setMaQL(String maQL) {
		this.maQL = maQL;
	}

	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}

	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCccd() {
		return cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
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

	@Override
	public String toString() {
		return "NhanVien [ma=" + ma + ", ten=" + ten + ", maPB=" + maPB + ", maQL=" + maQL + ", ngayVaoLam="
				+ ngayVaoLam + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi
				+ ", dienThoai=" + dienThoai + ", email=" + email + ", cccd=" + cccd + ", user=" + user + ", pass="
				+ pass + "]";
	}

	

	
}
