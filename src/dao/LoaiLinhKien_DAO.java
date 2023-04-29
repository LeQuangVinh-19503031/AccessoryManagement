package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import model.LoaiLinhKien;

public class LoaiLinhKien_DAO {


	public static ArrayList<LoaiLinhKien> getAllLoaiLinhKienFromDB(){
		ArrayList<LoaiLinhKien> list = new ArrayList<LoaiLinhKien>();
		ConnectDB.getConDB();
		Connection con = ConnectDB.getCon();
		
		try {
			String spl = "Select * From LoaiLinhKien";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(spl);
			while(resultSet.next()) {
				list.add(new LoaiLinhKien(
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
		ConnectDB conDB = new ConnectDB();
		conDB.connect();
		for (LoaiLinhKien l : LoaiLinhKien_DAO.getAllLoaiLinhKienFromDB()) {
			System.out.println(l);
		}
		conDB.disconect();
	}
}
