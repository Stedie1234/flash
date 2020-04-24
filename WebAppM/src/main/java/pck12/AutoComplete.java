package pck12;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import org.primefaces.event.SlideEndEvent;

@ManagedBean

@SessionScoped

public class AutoComplete {

	private String message;
	private boolean agree;
	private boolean checkbox;

	// selectoneButton
	private String platform;
	// selectOneRadio
	private String console;
	// selectOneMenu
	private String somenu;
	// selectOneMenu with gourp
	private String car;
	private List<SelectItem> cars;
	// selectOneListbox
	private String carlistbox;
	// selected cars
	private String[] selectedCars;
	// tristatecheckbox
	private String value;
	// inputNumber
	private Double valueInputNumber;
	// inputMask
	private String date;
	// toggleswitch
	private boolean tswitch;
	// chips
	private List<String> gunlist;
	// DatePicker
	private Date ldate;
	// spinner
	private double spinner;
	// slider
	private double slider;
	// input switch
	private boolean inputs;
	// password
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isInputs() {
		return inputs;
	}

	public void setInputs(boolean inputs) {
		this.inputs = inputs;
	}

	public void onSlideEnd(SlideEndEvent event) {
		FacesMessage message = new FacesMessage("Slide Ended" + "Value: " + event.getValue());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public double getSlider() {
		return slider;
	}

	public void setSlider(double slider) {
		this.slider = slider;
	}

	public double getSpinner() {
		return spinner;
	}

	public void setSpinner(double spinner) {
		this.spinner = spinner;
	}

	public Date getLdate() {

		return ldate;

	}

	public void setLdate(Date ldate) {
		this.ldate = ldate;
		System.out.println(ldate);
	}

	public List<String> getGunlist() {
		return gunlist;
	}

	public void setGunlist(List<String> gunlist) {
		this.gunlist = gunlist;
	}

	public boolean isTswitch() {
		return tswitch;
	}

	public void setTswitch(boolean tswitch) {
		this.tswitch = tswitch;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getValueInputNumber() {
		return valueInputNumber;
	}

	public void setValueInputNumber(Double valueInputNumber) {
		this.valueInputNumber = valueInputNumber;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String[] getSelectedCars() {
		return selectedCars;
	}

	public void setSelectedCars(String[] selectedCars) {
		this.selectedCars = selectedCars;
	}

	public String getCarlistbox() {
		return carlistbox;
	}

	public void setCarlistbox(String carlistbox) {
		this.carlistbox = carlistbox;
	}

	@PostConstruct
	public void init() {
		SelectItemGroup g1 = new SelectItemGroup("German Cars");
		g1.setSelectItems(new SelectItem[] { new SelectItem("BMW", "BMW"), new SelectItem("Mercedes", "Mercedes"),
				new SelectItem("Volkswagen", "Volkswagen") });

		SelectItemGroup g2 = new SelectItemGroup("American Cars");
		g2.setSelectItems(new SelectItem[] { new SelectItem("Chrysler", "Chrysler"), new SelectItem("GM", "GM"),
				new SelectItem("Ford", "Ford") });

		cars = new ArrayList<SelectItem>();
		cars.add(g1);
		cars.add(g2);

	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public List<SelectItem> getCars() {
		return cars;
	}

	public void setCars(List<SelectItem> cars) {
		this.cars = cars;
	}

	public String getSomenu() {
		return somenu;
	}

	public void setSomenu(String somenu) {
		this.somenu = somenu;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public boolean isCheckbox() {
		return checkbox;
	}

	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}

	public boolean isAgree() {
		return agree;
	}

	public void setAgree(boolean agree) {
		this.agree = agree;
	}

	public List<String> complete(String query) {

		List<String> queries = new ArrayList<String>();

		for (int i = 0; i < 15; i++) {

			queries.add(query + i);

		}

		return queries;

	}

	public String getMessage() {

		return message;

	}

	public void setMessage(String message) {

		this.message = message;

	}

	public void onfocus() {
		System.out.println("focus");
	}

}
