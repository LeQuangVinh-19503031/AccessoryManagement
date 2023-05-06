package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import model.LinhKien;
import model.NhaCungCap;

public class LinhKien_DAO {
	public static ArrayList<LinhKien> getAllHoaDonFromDB(){
		ArrayList<LinhKien> list = new ArrayList<LinhKien>();
		ConnectDB.getConDB();
		Connection con = ConnectDB.getCon();
		
		try {
			String spl = "Select * From LinhKien";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(spl);
			while(resultSet.next()) {
				list.add(new LinhKien(
						resultSet.getString(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getLong(6),
						resultSet.getLong(7),
						resultSet.getInt(8),
						resultSet.getString(9)
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
	}
	
	//MaLK,TenLK,MaLLK,MaNCC,DonViTinh,GiaNhap,GiaBan,SLTon,MoTa
		public static boolean update(LinhKien a) {
			ConnectDB.getConDB();
			Connection con = ConnectDB.getCon();
			PreparedStatement prepare = null;
			String sql = "UPDATE LinhKien "+
			"SET TenLK = ?, MaLLK = ?, MaNCC = ?, DonViTinh= ?, GiaNhap= ?, GiaBan= ?, SLTon= ?, MoTa= ? "+
					"WHERE MaLK = ?";
				try {
					
					prepare = con.prepareStatement(sql);
					prepare.setString(1, a.getTen());
					prepare.setString(2, a.getMaLLK());
					prepare.setString(3, a.getMaNCC());
					prepare.setString(4,  a.getDonViTinh());
					prepare.setDouble(5,  a.getGiaNhap());
					prepare.setDouble(6,  a.getGiaBan());
					prepare.setInt(7,  a.getSoLuongTon());
					prepare.setString(8,  a.getMoTa());
					prepare.setString(9, a.getMa());
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
		
		//MaLK,TenLK,MaLLK,MaNCC,DonViTinh,GiaNhap,GiaBan,SLTon,MoTa
		@SuppressWarnings("finally")
		public static boolean insertLK(LinhKien a) {
			ConnectDB.getConDB();
			Connection con = ConnectDB.getCon();
			PreparedStatement prepare = null;
			String sql = "insert into LinhKien values (?,?,?,?,?,?,?,?,?)";
				try {
					
					prepare = con.prepareStatement(sql);
					prepare.setString(1, a.getMa());
					prepare.setString(2, a.getTen());
					prepare.setString(3, a.getMaLLK());
					prepare.setString(4, a.getMaNCC());
					prepare.setString(5, a.getDonViTinh());
					prepare.setLong(6, a.getGiaNhap());
					prepare.setLong(7, a.getGiaBan());
					prepare.setInt(8, a.getSoLuongTon());
					prepare.setString(9, a.getMoTa());
					
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

}
