package pck12;

import java.sql.SQLException;
import java.util.List;

public interface ODao {
	List<Order> getAllOrders();

	Order getOrder(int id);

	void updateOrder(int id, int cid,String name);
	
	void updateOrder(int id, int cid);
	
	void updateOrder(int id,String name);
	
	void deleteOrder(int id);
	
	void insertOrder(int id, int cid,String name);

}
