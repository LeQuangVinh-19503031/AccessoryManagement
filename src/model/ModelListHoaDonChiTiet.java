package model;

import java.util.ArrayList;

public class ModelListHoaDonChiTiet {
	
	private ArrayList<HoaDonChiTiet> list;
	
	public ModelListHoaDonChiTiet() {
		this.list = new ArrayList<HoaDonChiTiet>();
		// TODO Auto-generated constructor stub
	}

	public ModelListHoaDonChiTiet(ArrayList<HoaDonChiTiet> list) {
		this.list = list;
	}

	public ArrayList<HoaDonChiTiet> getList() {
		return list;
	}

	public void setList(ArrayList<HoaDonChiTiet> list) {
		this.list = list;
	}
	
	public boolean addHD(HoaDonChiTiet a) {
		if(this.list.contains(a))
			return false;
		this.list.add(a);
		return true;
	}
	
	public boolean update(HoaDonChiTiet a) {
		HoaDonChiTiet temp = null;
		for (HoaDonChiTiet hoaDon : list) {
			if(a.getMaHoaDon().equalsIgnoreCase(hoaDon.getMaHoaDon())){
				temp = hoaDon;
			}
		}
		if(temp == null)
			return false;
		this.list.remove(temp);
		this.list.add(a);
		return true;
	}
	
	public int search(String ma) {
		int n = 0;
		for (HoaDonChiTiet hoaDon : list) {
			if(!hoaDon.getMaHoaDon().equalsIgnoreCase(ma)) {
				n += 1;
			}else
				break;
		}
		if(n<this.list.size())
			return n;
		return -1;
	}
}
