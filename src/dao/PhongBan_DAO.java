package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import model.PhongBan;

public class PhongBan_DAO {
	public static ArrayList<PhongBan> getAllFromDB(){
		ArrayList<PhongBan> list = new ArrayList<PhongBan>();
		ConnectDB.getConDB();
		Connection con = ConnectDB.getCon();
		
		try {
			String sql = "select * from PhongBan";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				list.add(new PhongBan(
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
		ArrayList<PhongBan> list = PhongBan_DAO.getAllFromDB();
		for (PhongBan phongBan : list) {
			System.out.println(phongBan);
		}
		conDB.disconect();
	}
}
