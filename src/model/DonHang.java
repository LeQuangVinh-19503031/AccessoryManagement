package model;

import java.util.Date;
import java.util.Objects;

public class DonHang {
	private String maHD;
	private String maKH;
	private String maNV;
	private Date ngayLapHD;
	private Date ngayGiao;
	private String diaChiGiaoHang;
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public Date getNgayLapHD() {
		return ngayLapHD;
	}
	public void setNgayLapHD(Date ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}
	public Date getNgayGiao() {
		return ngayGiao;
	}
	public void setNgayGiao(Date ngayGiao) {
		this.ngayGiao = ngayGiao;
	}
	public String getDiaChiGiaoHang() {
		return diaChiGiaoHang;
	}
	public void setDiaChiGiaoHang(String diaChiGiaoHang) {
		this.diaChiGiaoHang = diaChiGiaoHang;
	}
	@Override
	public int hashCode() {
		return Objects.hash(diaChiGiaoHang, maHD, maKH, maNV, ngayGiao, ngayLapHD);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonHang other = (DonHang) obj;
		return Objects.equals(diaChiGiaoHang, other.diaChiGiaoHang) && Objects.equals(maHD, other.maHD)
				&& Objects.equals(maKH, other.maKH) && Objects.equals(maNV, other.maNV)
				&& Objects.equals(ngayGiao, other.ngayGiao) && Objects.equals(ngayLapHD, other.ngayLapHD);
	}
	public DonHang(String maHD, String maKH, String maNV, Date date, Date date2, String diaChiGiaoHang) {
		this.maHD = maHD;
		this.maKH = maKH;
		this.maNV = maNV;
		this.ngayLapHD = (Date) date;
		this.ngayGiao = (Date) date2;
		this.diaChiGiaoHang = diaChiGiaoHang;
	}
	public DonHang() {
	}
	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", maKH=" + maKH + ", maNV=" + maNV + ", ngayLapHD=" + ngayLapHD + ", ngayGiao="
				+ ngayGiao + ", diaChiGiaoHang=" + diaChiGiaoHang + "]";
	}
	
	
	public DonHang returnHD() {
		return new DonHang("DH01", "KH01", "NV01", new Date("04/21/2023"), new Date("04/24/2023"), "DiaChi");
	}
	
	
}
