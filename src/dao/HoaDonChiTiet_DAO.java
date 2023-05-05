package dao;

import java.sql.Connection;
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
}
