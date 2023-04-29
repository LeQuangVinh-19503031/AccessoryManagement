package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	public static Connection con = null;
	public static ConnectDB conDB = new ConnectDB();

	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		ConnectDB.con = con;
	}

	public static ConnectDB getConDB() {
		return conDB;
	}

	public static void setConDB(ConnectDB conDB) {
		ConnectDB.conDB = conDB;
	}

	public void connect() {
		try {
			String url = "jdbc:sqlserver://localhost:1433;database=QLLK";
			String user = "sa";
			String pass = "123";
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null)
				System.out.println("Dang nhap thanh cong");
		}
	}
	
	public void disconect() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ConnectDB connectDB = new ConnectDB();
		connectDB.connect();
		connectDB.disconect();
	}
}
