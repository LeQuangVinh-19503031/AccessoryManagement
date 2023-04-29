package model;

import java.util.ArrayList;

public class ModelListNhanVien {
	
	private ArrayList<NhanVien> list;
	
	public ModelListNhanVien() {
		this.list = new ArrayList<NhanVien>();
		// TODO Auto-generated constructor stub
	}

	public ModelListNhanVien(ArrayList<NhanVien> list) {
		this.list = list;
	}

	public ArrayList<NhanVien> getList() {
		return list;
	}

	public void setList(ArrayList<NhanVien> list) {
		this.list = list;
	}
	
	public boolean addHD(NhanVien a) {
		if(this.list.contains(a))
			return false;
		this.list.add(a);
		return true;
	}
	
	public boolean update(NhanVien a) {
		NhanVien temp = null;
		for (NhanVien hoaDon : list) {
			if(a.getMa().equalsIgnoreCase(hoaDon.getMa())){
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
		for (NhanVien hoaDon : list) {
			if(!hoaDon.getMa().equalsIgnoreCase(ma)) {
				n += 1;
			}else
				break;
		}
		if(n<this.list.size())
			return n;
		return -1;
	}
}
