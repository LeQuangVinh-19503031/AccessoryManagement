package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import model.DonHangChiTiet;

public class HoaDonChiTiet_DAO {
	
	public static ArrayList<DonHangChiTiet> getAllFromDB(){
		ArrayList<DonHangChiTiet> list = new ArrayList<DonHangChiTiet>();
		ConnectDB.getConDB();
		Connection con = ConnectDB.getCon();
		
		try {
			String spl = "Select * From ChiTietDonHang";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(spl);
			while(resultSet.next()) {
				list.add(new DonHangChiTiet(
						resultSet.getString(1),
						resultSet.getString(2),
						resultSet.getLong(3),
						resultSet.getInt(4),
						resultSet.getInt(5),
						resultSet.getLong(6)
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@SuppressWarnings("finally")
	public static boolean insert(DonHangChiTiet a) {
		
		ConnectDB.getConDB();
		Connection con = ConnectDB.getCon();
		PreparedStatement prepare = null;
		String sql = "insert into ChiTietDonHang values (?,?,?,?,?,?)";
			try {
				
				prepare = con.prepareStatement(sql);
				prepare.setString(1, a.getMaHoaDon());
				prepare.setString(2, a.getMaLinhKien());
				prepare.setLong(3, a.getGiaBan());
				prepare.setInt(4, a.getSoLuong());
				prepare.setInt(5,  a.getGiamGia());
				prepare.setLong(6, a.getGiaSauKhiGiam());
				prepare.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				return true;
			}
		
	}
	
	public static boolean xoaCTDH(String maHD, String maLK) {
		ConnectDB.getConDB();
		Connection con = ConnectDB.getCon();
		PreparedStatement prepare = null;
		String sql = "DELETE FROM ChiTietDonHang WHERE MaHD=? and MaLK=?";
			try {
				prepare = con.prepareStatement(sql);
				prepare.setString(1, maHD);
				prepare.setString(2, maLK);
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

	public static boolean capNhat(DonHangChiTiet a) {
		ConnectDB.getConDB();
		Connection con = ConnectDB.getCon();
		PreparedStatement prepare = null;
		String sql = "UPDATE ChiTietDonHang "+
		"SET GiaBan = ?, SoLuong = ?, GiamGia = ?, ThanhTien = ? "+
				"WHERE MaHD = ? and MaLK = ? ";
			try {
				
				prepare = con.prepareStatement(sql);
				prepare.setLong(1,  a.getGiaBan());
				prepare.setInt(2, a.getSoLuong());
				prepare.setInt(3, a.getGiamGia());
				prepare.setLong(4, a.getGiaSauKhiGiam());
				prepare.setString(5, a.getMaHoaDon());
				prepare.setString(6, a.getMaLinhKien());
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
