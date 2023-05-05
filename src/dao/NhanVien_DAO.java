package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
						resultSet.getInt(8),
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
		
		for (TaiKhoan taiKhoan : list) {
			System.out.println(taiKhoan);
		}
		
		return list;
	}
	
	
	
	public static void main(String[] args) {
		ConnectDB connectDB = new ConnectDB();
		connectDB.connect();
		getAllAccountPass();
		connectDB.disconect();
	}


	public static boolean insertNV(NhanVien a) {
		ConnectDB.getConDB();
		Connection con = ConnectDB.getCon();
		PreparedStatement prepare = null;
		String sql = "insert into NhanVien values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				Date dateSinh = new Date(a.getNgaySinh().getYear(), a.getNgaySinh().getMonth(), a.getNgaySinh().getDate());
				Date dateLam = new Date(a.getNgayVaoLam().getYear(), a.getNgayVaoLam().getMonth(), a.getNgayVaoLam().getDate());
				
				prepare = con.prepareStatement(sql);

				prepare.setString(1, a.getMa());
				prepare.setString(2, a.getTen());
				prepare.setString(3, a.getMaPB());
				prepare.setString(4, a.getMaQL());
				prepare.setDate(5, dateLam);
				prepare.setDate(6, dateSinh);
				prepare.setString(7, a.getGioiTinh());
				prepare.setInt(8, a.getLuongCB());
				prepare.setString(9, a.getDienThoai());
				prepare.setString(10, a.getEmail());
				prepare.setString(11, a.getCccd());
				prepare.setString(12, a.getUser());
				prepare.setString(13, a.getPass());
				
				prepare.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return false;
	}
	
	public static ArrayList<String> getAllMaNVFromDB(){
		ArrayList<String> list = new ArrayList<String>();
		ConnectDB.getConDB();
		Connection con = ConnectDB.getCon();
		
		try {
			String sql = "select MaNV from NhanVien";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				list.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}


	public static boolean updateNV(NhanVien a) {
		
		ConnectDB.getConDB();
		Connection con = ConnectDB.getCon();
		PreparedStatement prepare = null;
		String sql = "UPDATE NhanVien "+
		"SET TenNV = ?, MaPB = ?, MaQuanLy = ?, NgayVaoLam = ?, NgaySinh = ?, GioiTinh = ?, LuongCB = ?, Phone = ?, Email = ?, chungMinhThu = ?, TaiKhoan = ?, MatKhau = ? "+
				"WHERE MaNV = ?";
		try {
			Date dateSinh = new Date(a.getNgaySinh().getYear(), a.getNgaySinh().getMonth(), a.getNgaySinh().getDate());
			Date dateLam = new Date(a.getNgayVaoLam().getYear(), a.getNgayVaoLam().getMonth(), a.getNgayVaoLam().getDate());
			
			prepare = con.prepareStatement(sql);

			prepare.setString(1, a.getTen());
			prepare.setString(2, a.getMaPB());
			prepare.setString(3, a.getMaQL());
			prepare.setDate(4, dateLam);
			prepare.setDate(5, dateSinh);
			prepare.setString(6, a.getGioiTinh());
			prepare.setInt(7, a.getLuongCB());
			prepare.setString(8, a.getDienThoai());
			prepare.setString(9, a.getEmail());
			prepare.setString(10, a.getCccd());
			prepare.setString(11, a.getUser());
			prepare.setString(12, a.getPass());
			prepare.setString(13, a.getMa());
			
			prepare.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			return false;
	}
	

}
