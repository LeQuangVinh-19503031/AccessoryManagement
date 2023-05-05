package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import model.DonHang;
import model.NhaCungCap;

public class NhaCungCap_DAO {
	public static ArrayList<NhaCungCap> getAllFromDB(){
		ArrayList<NhaCungCap> list = new ArrayList<NhaCungCap>();
		ConnectDB.getConDB();
		Connection con = ConnectDB.getCon();
		
		try {
			String sql = "Select * From NhaCungCap";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				list.add(new NhaCungCap(
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

	@SuppressWarnings("finally")
	public static boolean insertNCC(NhaCungCap a) {
//		insert into DonDatHang values ('DH01', 'KH01', 'NV02', getDate(), '05-17-2023', 'IUH')
		ConnectDB.getConDB();
		Connection con = ConnectDB.getCon();
		PreparedStatement prepare = null;
		String sql = "insert into NhaCungCap values (?,?,?,?,?)";
			try {
				
				prepare = con.prepareStatement(sql);
				prepare.setString(1, a.getMa());
				prepare.setString(2, a.getTen());
				prepare.setString(3, a.getDiaChi());
				prepare.setString(4, a.getSdt());
				prepare.setString(5, a.getEmail());
				
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

	public static boolean update(NhaCungCap a) {
		ConnectDB.getConDB();
		Connection con = ConnectDB.getCon();
		PreparedStatement prepare = null;
		String sql = "UPDATE NhaCungCap "+
		"SET TenNCC = ?, DiaChi = ?, Phone = ?, Email= ? "+
				"WHERE MaNCC = ?";
			try {
				
				prepare = con.prepareStatement(sql);
				prepare.setString(1, a.getTen());
				prepare.setString(2, a.getDiaChi());
				prepare.setString(3, a.getSdt());
				prepare.setString(4,  a.getEmail());
				prepare.setString(5, a.getMa());
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
	
	public static boolean xoa(NhaCungCap a) {
		ConnectDB.getConDB();
		Connection con = ConnectDB.getCon();
		PreparedStatement prepare = null;
		String sql = "DELETE FROM NhaCungCap WHERE MaNCC=?";
			try {
				prepare = con.prepareStatement(sql);
				prepare.setString(1, a.getMa());
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
	
	public static void main(String[] args) {
		ConnectDB c = new ConnectDB();
		c.connect();
		xoa(new NhaCungCap("", "", "", "", ""));
		c.disconect();
	}
}
