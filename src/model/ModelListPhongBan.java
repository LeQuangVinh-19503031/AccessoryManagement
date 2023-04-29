package model;

import java.util.ArrayList;

public class ModelListPhongBan {
	
	private ArrayList<PhongBan> list;
	
	public ModelListPhongBan() {
		this.list = new ArrayList<PhongBan>();
		// TODO Auto-generated constructor stub
	}

	public ModelListPhongBan(ArrayList<PhongBan> list) {
		this.list = list;
	}

	public ArrayList<PhongBan> getList() {
		return list;
	}

	public void setList(ArrayList<PhongBan> list) {
		this.list = list;
	}
	
	public boolean addHD(PhongBan a) {
		if(this.list.contains(a))
			return false;
		this.list.add(a);
		return true;
	}
	
	public boolean update(PhongBan a) {
		PhongBan temp = null;
		for (PhongBan hoaDon : list) {
			if(a.getMaPB().equalsIgnoreCase(hoaDon.getMaPB())){
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
		for (PhongBan hoaDon : list) {
			if(!hoaDon.getMaPB().equalsIgnoreCase(ma)) {
				n += 1;
			}else
				break;
		}
		if(n<this.list.size())
			return n;
		return -1;
	}
}
