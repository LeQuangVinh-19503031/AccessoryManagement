package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import model.LinhKien;

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
	
}
