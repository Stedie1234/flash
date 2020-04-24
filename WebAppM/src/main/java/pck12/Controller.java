package pck12;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

import pck12.*;

@ManagedBean
@RequestScoped
public class Controller implements ActionListener {

	private List<Customer> customers;
	private List<Order> orders;
	private CustomerDao cdao;
	private OrderDao odao;

	private Customer c;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Customer getC() {
		return c;
	}

	public void setC(Customer c) {
		this.c = c;
	}

	public Controller() {
		cdao = new CustomerDao();
		customers = cdao.getAllCustomers();
		odao = new OrderDao();
		orders = odao.getAllOrders();
		c = new Customer();
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public void processAction(ActionEvent event) throws AbortProcessingException {
		customers = cdao.getAllCustomers();
		orders = odao.getAllOrders();
		
	}

	public void insert() {

		cdao.insertCustomer(c.getId(), c.getName(), c.getAge());
	}
}
