package model;

import java.util.Objects;

public class LinhKien {
	private String ma;
	private String ten;
	private String maLoaiLinhKien;
	private String maNCC;
	private String donViTinh;
	private long giaNhap;
	private long giaBan;
	private int soLuongTon;
	private String anhPath;
	private String moTa;
	@Override
	public String toString() {
		return "LinhKien [ma=" + ma + ", ten=" + ten + ", maLoaiLinhKien=" + maLoaiLinhKien + ", maNCC=" + maNCC
				+ ", donViTinh=" + donViTinh + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", soLuongTon="
				+ soLuongTon + ", anhPath=" + anhPath + ", moTa=" + moTa + "]";
	}
	public LinhKien() {
	}
	public LinhKien(String ma, String ten, String maLoaiLinhKien, String maNCC, String donViTinh, long giaNhap,
			long giaBan, int soLuongTon, String anhPath, String moTa) {
		this.ma = ma;
		this.ten = ten;
		this.maLoaiLinhKien = maLoaiLinhKien;
		this.maNCC = maNCC;
		this.donViTinh = donViTinh;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.soLuongTon = soLuongTon;
		this.anhPath = anhPath;
		this.moTa = moTa;
	}
	@Override
	public int hashCode() {
		return Objects.hash(anhPath, donViTinh, giaBan, giaNhap, ma, maLoaiLinhKien, maNCC, moTa, soLuongTon, ten);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LinhKien other = (LinhKien) obj;
		return Objects.equals(anhPath, other.anhPath) && Objects.equals(donViTinh, other.donViTinh)
				&& giaBan == other.giaBan && giaNhap == other.giaNhap && Objects.equals(ma, other.ma)
				&& Objects.equals(maLoaiLinhKien, other.maLoaiLinhKien) && Objects.equals(maNCC, other.maNCC)
				&& Objects.equals(moTa, other.moTa) && soLuongTon == other.soLuongTon && Objects.equals(ten, other.ten);
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
	public String getMaLoaiLinhKien() {
		return maLoaiLinhKien;
	}
	public void setMaLoaiLinhKien(String maLoaiLinhKien) {
		this.maLoaiLinhKien = maLoaiLinhKien;
	}
	public String getMaNCC() {
		return maNCC;
	}
	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public long getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(long giaNhap) {
		this.giaNhap = giaNhap;
	}
	public long getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(long giaBan) {
		this.giaBan = giaBan;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}
	public String getAnhPath() {
		return anhPath;
	}
	public void setAnhPath(String anhPath) {
		this.anhPath = anhPath;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	

	
	
	
}
