package model;

import java.util.ArrayList;

public class ModelListHoaDon {
	
	private ArrayList<HoaDon> list;
	
	public ModelListHoaDon() {
		this.list = new ArrayList<HoaDon>();
		// TODO Auto-generated constructor stub
	}

	public ModelListHoaDon(ArrayList<HoaDon> list) {
		this.list = list;
	}

	public ArrayList<HoaDon> getList() {
		return list;
	}

	public void setList(ArrayList<HoaDon> list) {
		this.list = list;
	}
	
	public boolean addHD(HoaDon a) {
		if(this.list.contains(a))
			return false;
		this.list.add(a);
		return true;
	}
	
	public boolean update(HoaDon a) {
		HoaDon temp = null;
		for (HoaDon hoaDon : list) {
			if(a.getMaHD().equalsIgnoreCase(hoaDon.getMaHD())){
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
		for (HoaDon hoaDon : list) {
			if(!hoaDon.getMaHD().equalsIgnoreCase(ma)) {
				n += 1;
			}else
				break;
		}
		if(n<this.list.size())
			return n;
		return -1;
	}
}
