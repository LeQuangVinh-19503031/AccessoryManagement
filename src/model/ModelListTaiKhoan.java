package model;

import java.util.ArrayList;

public class ModelListTaiKhoan {
	
	private ArrayList<TaiKhoan> list;
	
	public ModelListTaiKhoan() {
		this.list = new ArrayList<TaiKhoan>();
		// TODO Auto-generated constructor stub
	}

	public ModelListTaiKhoan(ArrayList<TaiKhoan> list) {
		this.list = list;
	}

	public ArrayList<TaiKhoan> getList() {
		return list;
	}

	public void setList(ArrayList<TaiKhoan> list) {
		this.list = list;
	}
	
	public boolean addHD(TaiKhoan a) {
		if(this.list.contains(a))
			return false;
		this.list.add(a);
		return true;
	}
	
	public boolean update(TaiKhoan a) {
		TaiKhoan temp = null;
		for (TaiKhoan hoaDon : list) {
			if(a.getUser().equalsIgnoreCase(hoaDon.getUser())){
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
		for (TaiKhoan hoaDon : list) {
			if(!hoaDon.getUser().equalsIgnoreCase(ma)) {
				n += 1;
			}else
				break;
		}
		if(n<this.list.size())
			return n;
		return -1;
	}
}
