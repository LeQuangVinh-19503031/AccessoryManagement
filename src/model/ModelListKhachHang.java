package model;

import java.util.ArrayList;

public class ModelListKhachHang {
	
	private ArrayList<KhachHang> list;
	
	public ModelListKhachHang() {
		this.list = new ArrayList<KhachHang>();
		// TODO Auto-generated constructor stub
	}

	public ModelListKhachHang(ArrayList<KhachHang> list) {
		this.list = list;
	}

	public ArrayList<KhachHang> getList() {
		return list;
	}

	public void setList(ArrayList<KhachHang> list) {
		this.list = list;
	}
	
	public boolean addHD(KhachHang a) {
		if(this.list.contains(a))
			return false;
		this.list.add(a);
		return true;
	}
	
	public boolean update(KhachHang a) {
		KhachHang temp = null;
		for (KhachHang hoaDon : list) {
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
		for (KhachHang hoaDon : list) {
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
