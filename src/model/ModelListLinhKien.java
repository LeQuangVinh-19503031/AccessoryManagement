package model;

import java.util.ArrayList;

public class ModelListLinhKien {
	
	private ArrayList<LinhKien> list;
	
	public ModelListLinhKien() {
		this.list = new ArrayList<LinhKien>();
		// TODO Auto-generated constructor stub
	}

	public ModelListLinhKien(ArrayList<LinhKien> list) {
		this.list = list;
	}

	public ArrayList<LinhKien> getList() {
		return list;
	}

	public void setList(ArrayList<LinhKien> list) {
		this.list = list;
	}
	
	public boolean addHD(LinhKien a) {
		if(this.list.contains(a))
			return false;
		this.list.add(a);
		return true;
	}
	
	public boolean update(LinhKien a) {
		LinhKien temp = null;
		for (LinhKien hoaDon : list) {
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
		for (LinhKien hoaDon : list) {
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
