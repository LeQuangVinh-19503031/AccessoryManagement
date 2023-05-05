package model;

import java.util.Objects;

public class DonHangChiTiet {
	private String maHoaDon;
	private String maLinhKien;
	private long giaBan;
	private int soLuong;
	private int giamGia;
	private long thanhTien;
	
	public DonHangChiTiet() {
	}

	public DonHangChiTiet(String maHoaDon, String maLinhKien, long giaBan, int soLuong, int giamGia,
			long giaSauKhiGiam) {
		this.maHoaDon = maHoaDon;
		this.maLinhKien = maLinhKien;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.giamGia = giamGia;
		this.thanhTien = giaSauKhiGiam;
	}

	@Override
	public String toString() {
		return "HoaDonChiTiet [maHoaDon=" + maHoaDon + ", maLinhKien=" + maLinhKien + ", giaBan=" + giaBan
				+ ", soLuong=" + soLuong + ", giamGia=" + giamGia + ", giaSauKhiGiam=" + thanhTien + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(giaBan, thanhTien, giamGia, maHoaDon, maLinhKien, soLuong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonHangChiTiet other = (DonHangChiTiet) obj;
		return giaBan == other.giaBan && thanhTien == other.thanhTien && giamGia == other.giamGia
				&& Objects.equals(maHoaDon, other.maHoaDon) && Objects.equals(maLinhKien, other.maLinhKien)
				&& soLuong == other.soLuong;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getMaLinhKien() {
		return maLinhKien;
	}

	public void setMaLinhKien(String maLinhKien) {
		this.maLinhKien = maLinhKien;
	}

	public long getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(long giaBan) {
		this.giaBan = giaBan;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(int giamGia) {
		this.giamGia = giamGia;
	}

	public long getGiaSauKhiGiam() {
		return thanhTien;
	}

	public void setGiaSauKhiGiam(long giaSauKhiGiam) {
		this.thanhTien = giaSauKhiGiam;
	}
	
	
}
