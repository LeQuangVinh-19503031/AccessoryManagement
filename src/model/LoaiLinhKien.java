package model;

import java.util.Objects;

public class LoaiLinhKien {
	private String ma;
	private String ten;
	
	public LoaiLinhKien() {
	}

	public LoaiLinhKien(String ma, String ten) {
		this.ma = ma;
		this.ten = ten;
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

	@Override
	public int hashCode() {
		return Objects.hash(ma, ten);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiLinhKien other = (LoaiLinhKien) obj;
		return Objects.equals(ma, other.ma) && Objects.equals(ten, other.ten);
	}

	@Override
	public String toString() {
		return "LoaiLinhKien [ma=" + ma + ", ten=" + ten + "]";
	}

	
	
}
