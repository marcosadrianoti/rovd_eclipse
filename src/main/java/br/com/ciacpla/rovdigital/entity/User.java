package br.com.ciacpla.rovdigital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class User extends GenericEntity{
	
	@Column(length=50, nullable=false)
	private String userName;
	
	@Column(length=32, nullable=false)
    private String userPassword;
	
	@Column(nullable=false)
    private boolean conected;
	
	@Column(nullable=false)
    private boolean accessReports;
	
	@Column(nullable=false)
    private boolean accessPilots;
	
	@Column(nullable=false)
    private boolean accessAircrafts;
	
	@Column(nullable=false)
    private boolean accessInstructors;
	
	@Column(nullable=false)
    private boolean accessAirports;
	
	@Column(nullable=false)
    private boolean accessFlights;
	
	@Column(nullable=false)
    private boolean accessClasses;
	
	@Column(nullable=false)
    private boolean accessUsers;
	
	@Column(nullable=false)
    private boolean accessMaintenances;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public boolean isConected() {
		return conected;
	}

	public void setConected(boolean conected) {
		this.conected = conected;
	}

	public boolean isAccessReports() {
		return accessReports;
	}

	public void setAccessReports(boolean accessReports) {
		this.accessReports = accessReports;
	}

	public boolean isAccessPilots() {
		return accessPilots;
	}

	public void setAccessPilots(boolean accessPilots) {
		this.accessPilots = accessPilots;
	}

	public boolean isAccessAircrafts() {
		return accessAircrafts;
	}

	public void setAccessAircrafts(boolean accessAircrafts) {
		this.accessAircrafts = accessAircrafts;
	}

	public boolean isAccessInstructors() {
		return accessInstructors;
	}

	public void setAccessInstructors(boolean accessInstructors) {
		this.accessInstructors = accessInstructors;
	}

	public boolean isAccessAirports() {
		return accessAirports;
	}

	public void setAccessAirports(boolean accessAirports) {
		this.accessAirports = accessAirports;
	}

	public boolean isAccessFlights() {
		return accessFlights;
	}

	public void setAccessFlights(boolean accessFlights) {
		this.accessFlights = accessFlights;
	}

	public boolean isAccessClasses() {
		return accessClasses;
	}

	public void setAccessClasses(boolean accessClasses) {
		this.accessClasses = accessClasses;
	}

	public boolean isAccessUsers() {
		return accessUsers;
	}

	public void setAccessUsers(boolean accessUsers) {
		this.accessUsers = accessUsers;
	}

	public boolean isAccessMaintenances() {
		return accessMaintenances;
	}

	public void setAccessMaintenances(boolean accessMaintenances) {
		this.accessMaintenances = accessMaintenances;
	}
	
}
