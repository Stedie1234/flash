package pck12;

import java.util.List;

public interface Dao {
	public List<Customer> getAllCustomers();

	public Customer getCustomer(int id);

	public void updateStudent(int id, String nname, int nage);

	public void updateStudent(int id, String nname);

	public void updateStudent(int id, int nage);

	public void delteCustomer(int id);

	public void insertCustomer(int id, String nname, int nage);

}
