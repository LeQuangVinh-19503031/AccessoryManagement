package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import model.NhanVien;
import model.TaiKhoan;

public class NhanVien_DAO {
	public static ArrayList<NhanVien> getAllFromDB(){
		ArrayList<NhanVien> list = new ArrayList<NhanVien>();
		ConnectDB.getConDB();
		Connection con = ConnectDB.getCon();
		
		try {
			String sql = "Select * from NhanVien";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				list.add(new NhanVien(
						resultSet.getString(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getDate(5), 
						resultSet.getDate(6),
						resultSet.getString(7),
						resultSet.getString(8),
						resultSet.getString(9),
						resultSet.getString(10),
						resultSet.getString(11),
						resultSet.getString(12),
						resultSet.getString(13)
						));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public static ArrayList<TaiKhoan> getAllAccountPass(){
		ArrayList<TaiKhoan> list = new ArrayList<TaiKhoan>();
		ConnectDB.getConDB();
		Connection con = ConnectDB.getCon();
		
		try {
			String sql = "Select taiKhoan, matKhau, MaNV from NhanVien";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				list.add(new TaiKhoan(
						resultSet.getString(1),
						resultSet.getString(2)
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public static void main(String[] args) {
		ConnectDB connectDB = new ConnectDB();
		connectDB.connect();
		ArrayList<NhanVien> list =  NhanVien_DAO.getAllFromDB();
		for (NhanVien nhanVien : list) {
			System.out.println(nhanVien);
		}
		connectDB.disconect();
	}
	
}
