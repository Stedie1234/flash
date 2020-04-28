package pck12;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements ODao {

	DBManager db;

	public OrderDao() {
		try {
			db = new DBManager();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Order> getAllOrders()   {
		ArrayList<Order> al = new ArrayList<Order>();
		
		ResultSet rs;
		try {
			rs = db.executeQuery("select * from orders");
			while(rs.next()) {
				al.add(new Order(rs.getInt(1),rs.getInt(2),rs.getString(3)));
			}
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return al;
	}

	@Override
	public Order getOrder(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrder(int id, int cid, String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateOrder(int id, int cid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateOrder(int id, String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOrder(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertOrder(int id, int cid, String name) {
		// TODO Auto-generated method stub

	}

}
