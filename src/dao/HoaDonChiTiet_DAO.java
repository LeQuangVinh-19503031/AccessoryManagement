package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import model.HoaDonChiTiet;

public class HoaDonChiTiet_DAO {
	public static ArrayList<HoaDonChiTiet> getAllFromDB(){
		ArrayList<HoaDonChiTiet> list = new ArrayList<HoaDonChiTiet>();
		ConnectDB.getConDB();
		Connection con = ConnectDB.getCon();
		
		try {
			String spl = "Select * From HoaDonChiTiet";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(spl);
			while(resultSet.next()) {
				list.add(new HoaDonChiTiet(
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
