package pck12;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements Dao {

	private DBManager db;

	public CustomerDao() {
		try {
			db = new DBManager();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Customer> getAllCustomers() {
		ArrayList<Customer> al = new ArrayList<Customer>();
		try {
			db.getConnection();
			ResultSet rs = db.executeQuery("select * from customers");
			while (rs.next()) {
				al.add(new Customer(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
			rs.close();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return al;
	}

	@Override
	public Customer getCustomer(int id) {
		Customer c = new Customer();
		try {
			ResultSet rs = db.executeQuery("select * from customers where customerid=" + id);
			while (rs.next()) {
				c = new Customer(rs.getInt(1), rs.getString(2), rs.getInt(3));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}

	@Override
	public void updateStudent(int id, String nname, int nage) {
		try {
			PreparedStatement ps = db.getConnection()
					.prepareStatement("update customers set name=?,age=? where customerid=?");
			ps.setInt(3, id);
			ps.setString(1, nname);
			ps.setInt(2, nage);
			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateStudent(int id, String nname) {
		try {
			PreparedStatement ps = db.getConnection()
					.prepareStatement("update customers set name=? where customerid=?");
			ps.setInt(2, id);
			ps.setString(1, nname);

			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateStudent(int id, int nage) {
		try {
			PreparedStatement ps = db.getConnection().prepareStatement("update customers set age=? where customerid=?");
			ps.setInt(2, id);

			ps.setInt(1, nage);
			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delteCustomer(int id) {
		try {

			db.getConnection().createStatement().executeUpdate("delete from customers where customerid=" + id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Close() {
		db.closeConnection();
	}

	@Override
	public void insertCustomer(int id, String nname, int nage) {
		try {
			PreparedStatement ps = db.getConnection().prepareStatement("insert into customers values(?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, nname);
			ps.setInt(3, nage);
			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
