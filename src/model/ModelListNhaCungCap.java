package model;

import java.util.ArrayList;

public class ModelListNhaCungCap {
	
	private ArrayList<NhaCungCap> list;
	
	public ModelListNhaCungCap() {
		this.list = new ArrayList<NhaCungCap>();
		// TODO Auto-generated constructor stub
	}

	public ModelListNhaCungCap(ArrayList<NhaCungCap> list) {
		this.list = list;
	}

	public ArrayList<NhaCungCap> getList() {
		return list;
	}

	public void setList(ArrayList<NhaCungCap> list) {
		this.list = list;
	}
	
	public boolean addHD(NhaCungCap a) {
		if(this.list.contains(a))
			return false;
		this.list.add(a);
		return true;
	}
	
	public boolean update(NhaCungCap a) {
		NhaCungCap temp = null;
		for (NhaCungCap hoaDon : list) {
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
		for (NhaCungCap hoaDon : list) {
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
