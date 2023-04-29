package model;

import java.util.ArrayList;

public class ModelListLoaiLinhKien {
	
	private ArrayList<LoaiLinhKien> list;
	
	public ModelListLoaiLinhKien() {
		this.list = new ArrayList<LoaiLinhKien>();
		// TODO Auto-generated constructor stub
	}

	public ModelListLoaiLinhKien(ArrayList<LoaiLinhKien> list) {
		this.list = list;
	}

	public ArrayList<LoaiLinhKien> getList() {
		return list;
	}

	public void setList(ArrayList<LoaiLinhKien> list) {
		this.list = list;
	}
	
	public boolean addHD(LoaiLinhKien a) {
		if(this.list.contains(a))
			return false;
		this.list.add(a);
		return true;
	}
	
	public boolean update(LoaiLinhKien a) {
		LoaiLinhKien temp = null;
		for (LoaiLinhKien hoaDon : list) {
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
		for (LoaiLinhKien hoaDon : list) {
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
