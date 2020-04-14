package pck;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

@ManagedBean
@RequestScoped
public class BenutzerBean implements ActionListener,ValueChangeListener{

	private String username="";
	private String password="";

	
	@ManagedProperty(value="#{dBManager}")
	private DBManager db;
	
	
	public DBManager getDb() {
		return db;
	}

	public void setDb(DBManager db) {
		this.db = db;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void processAction(ActionEvent event) throws AbortProcessingException {
		System.out.println("User Submit "+db.getCount());
		db.incrementCount();
		
	}

	public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
		System.out.println("Value User Submit "+db.getCount1());
		db.incrementCount1();
		
	}

	
	
	
}
