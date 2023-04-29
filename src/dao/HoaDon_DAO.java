package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import connectDB.ConnectDB;
import model.HoaDon;
import model.NhaCungCap;

public class HoaDon_DAO {
	
	static DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
	
	public static ArrayList<HoaDon> getAllHoaDonFromDB(){
		ArrayList<HoaDon> list = new ArrayList<HoaDon>();
		ConnectDB.getConDB();
		Connection con = ConnectDB.getCon();
		
		try {
			String sql = "Select * FROM DonDatHang";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				list.add(new HoaDon(
						resultSet.getString(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getDate(4),
						resultSet.getDate(5),
						resultSet.getString(6)
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@SuppressWarnings("finally")
	public static boolean insertDB(HoaDon a) {
//		insert into DonDatHang values ('DH01', 'KH01', 'NV02', getDate(), '05-17-2023', 'IUH')
		ConnectDB.getConDB();
		Connection con = ConnectDB.getCon();
		PreparedStatement prepare = null;
		String sql = "insert into DonDatHang values (?,?,?,?,?,?)";
			try {
				Date date1 = new Date(a.getNgayLapHD().getYear(), a.getNgayLapHD().getMonth(), a.getNgayLapHD().getDate());
				Date date2 = new Date(a.getNgayGiao().getYear(), a.getNgayGiao().getMonth(), a.getNgayGiao().getDate());
				prepare = con.prepareStatement(sql);
				prepare.setString(1, a.getMaHD());
				prepare.setString(2, a.getMaKH());
				prepare.setString(3, a.getMaNV());
				prepare.setDate(4, date1);
				prepare.setDate(5,  date2);
				prepare.setString(6, a.getDiaChiGiaoHang());
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
	
	public static boolean updateDB(HoaDon a){
	
		ConnectDB.getConDB();
		Connection con = ConnectDB.getCon();
		PreparedStatement prepare = null;
		String sql = "UPDATE DonDatHang "+
		"SET MaKH = ?, MaNV = ?, NgayDatHang = ?, NgayGiaoHang = ?, NoiGiaoNhanHang = ? "+
				"WHERE MaHD = ?";
			try {
				Date date1 = new Date(a.getNgayLapHD().getYear(), a.getNgayLapHD().getMonth(), a.getNgayLapHD().getDate());
				Date date2 = new Date(a.getNgayGiao().getYear(), a.getNgayGiao().getMonth(), a.getNgayGiao().getDate());
				prepare = con.prepareStatement(sql);
				prepare.setString(1, a.getMaKH());
				prepare.setString(2, a.getMaNV());
				prepare.setDate(3, date1);
				prepare.setDate(4,  date2);
				prepare.setString(5, a.getDiaChiGiaoHang());
				prepare.setString(6, a.getMaHD());
				prepare.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
					System.out.println("Update thanh cong");
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return false;
	}
	

	public static boolean xoa(HoaDon a) {
		ConnectDB.getConDB();
		Connection con = ConnectDB.getCon();
		PreparedStatement prepare = null;
		String sql = "DELETE FROM DonDatHang WHERE MaHD=?";
			try {
				prepare = con.prepareStatement(sql);
				prepare.setString(1, a.getMaHD());
				prepare.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
					System.out.println("xoa thanh cong");
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return false;
	}

}
