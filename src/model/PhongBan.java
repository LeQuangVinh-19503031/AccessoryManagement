package model;

import java.util.Objects;

public class PhongBan {
	private String maPB;
	private String tenPB;
	public String getMaPB() {
		return maPB;
	}
	public void setMaPB(String maPB) {
		this.maPB = maPB;
	}
	public String getTenPB() {
		return tenPB;
	}
	public void setTenPB(String tenPB) {
		this.tenPB = tenPB;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maPB, tenPB);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongBan other = (PhongBan) obj;
		return Objects.equals(maPB, other.maPB) && Objects.equals(tenPB, other.tenPB);
	}
	public PhongBan(String maPB, String tenPB) {
		this.maPB = maPB;
		this.tenPB = tenPB;
	}
	public PhongBan() {
	}
	@Override
	public String toString() {
		return "PhongBan [maPB=" + maPB + ", tenPB=" + tenPB + "]";
	}
	
	
}
