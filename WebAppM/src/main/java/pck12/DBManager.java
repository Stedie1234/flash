package pck12;

import java.util.Random;
import java.sql.*;

public class DBManager {

	private static Connection con;

	public DBManager() throws SQLException, ClassNotFoundException {
		getConnection();
	}

	public Connection getConnection() throws SQLException, ClassNotFoundException {

		if (con != null && con.isClosed() == false) {
			return con;
		} else {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl", "SYSTEM", "7554Stefan7554");
		}

		return con;

	}

	public ResultSet executeQuery(String query) throws SQLException {
		Statement st = con.createStatement();
		
		return st.executeQuery(query);

	}

	public int executeUpdate(String query) throws SQLException {
		return con.createStatement().executeUpdate(query);
	}

	public void closeConnection() {
		try {
			if (con.isClosed()) {

			} else {
				con.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
