package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import model.KhachHang;

public class KhachHang_DAO {
	public static ArrayList<KhachHang> getAllKhachHangFromDB(){
		ArrayList<KhachHang> list = new ArrayList<KhachHang>();
		ConnectDB.getConDB();
		Connection con = ConnectDB.getCon();
		
		try {
			String spl = "Select * From KhachHang";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(spl);
			while(resultSet.next()) {
				list.add(new KhachHang(
						resultSet.getString(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5)
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		ConnectDB conDB = new ConnectDB();
		conDB.connect();
		ArrayList<KhachHang> list = KhachHang_DAO.getAllKhachHangFromDB();
		for (KhachHang loaiLinhKien : list) {
			System.out.println(loaiLinhKien);
		}
		conDB.disconect();
	}
}
