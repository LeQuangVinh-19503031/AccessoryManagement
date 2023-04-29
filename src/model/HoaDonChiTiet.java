package model;

import java.util.Objects;

public class HoaDonChiTiet {
	private String maHoaDon;
	private String maLinhKien;
	private long giaBan;
	private int soLuong;
	private int giamGia;
	private long giaSauKhiGiam;
	
	public HoaDonChiTiet() {
	}

	public HoaDonChiTiet(String maHoaDon, String maLinhKien, long giaBan, int soLuong, int giamGia,
			long giaSauKhiGiam) {
		this.maHoaDon = maHoaDon;
		this.maLinhKien = maLinhKien;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.giamGia = giamGia;
		this.giaSauKhiGiam = giaSauKhiGiam;
	}

	@Override
	public String toString() {
		return "HoaDonChiTiet [maHoaDon=" + maHoaDon + ", maLinhKien=" + maLinhKien + ", giaBan=" + giaBan
				+ ", soLuong=" + soLuong + ", giamGia=" + giamGia + ", giaSauKhiGiam=" + giaSauKhiGiam + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(giaBan, giaSauKhiGiam, giamGia, maHoaDon, maLinhKien, soLuong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDonChiTiet other = (HoaDonChiTiet) obj;
		return giaBan == other.giaBan && giaSauKhiGiam == other.giaSauKhiGiam && giamGia == other.giamGia
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
		return giaSauKhiGiam;
	}

	public void setGiaSauKhiGiam(long giaSauKhiGiam) {
		this.giaSauKhiGiam = giaSauKhiGiam;
	}
	
	
}
