package model;

import java.util.Objects;

public class LoaiLinhKien {
	private String maLLK;
	private String tenLLK;
	
	public LoaiLinhKien() {
	}

	public LoaiLinhKien(String ma, String ten) {
		this.maLLK = ma;
		this.tenLLK = ten;
	}

	public String getMa() {
		return maLLK;
	}

	public void setMa(String ma) {
		this.maLLK = ma;
	}

	public String getTen() {
		return tenLLK;
	}

	public void setTen(String ten) {
		this.tenLLK = ten;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maLLK, tenLLK);
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
		return Objects.equals(maLLK, other.maLLK) && Objects.equals(tenLLK, other.tenLLK);
	}

	@Override
	public String toString() {
		return "LoaiLinhKien [ma=" + maLLK + ", ten=" + tenLLK + "]";
	}

	
	
}
