package br.com.ciacpla.rovdigital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

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
    private boolean accessLessons;
	
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
	
	@Transient //Indica ao hibernate que não é uma coluna na tabela
	public String isConectedFormated() {
		return formatar(conected);
	}

	public void setConected(boolean conected) {
		this.conected = conected;
	}

	public boolean isAccessReports() {
		return accessReports;
	}
	
	@Transient //Indica ao hibernate que não é uma coluna na tabela
	public String isAccessReportsFormated() {
		return formatar(accessReports);
	}

	public void setAccessReports(boolean accessReports) {
		this.accessReports = accessReports;
	}

	public boolean isAccessPilots() {
		return accessPilots;
	}

	@Transient //Indica ao hibernate que não é uma coluna na tabela
	public String isAccessPilotsFormated() {
		return formatar(accessPilots);
	}

	public void setAccessPilots(boolean accessPilots) {
		this.accessPilots = accessPilots;
	}

	public boolean isAccessAircrafts() {
		return accessAircrafts;
	}

	@Transient //Indica ao hibernate que não é uma coluna na tabela
	public String isAccessAircraftsFormated() {
		return formatar(accessAircrafts);
	}

	public void setAccessAircrafts(boolean accessAircrafts) {
		this.accessAircrafts = accessAircrafts;
	}

	public boolean isAccessInstructors() {
		return accessInstructors;
	}

	@Transient //Indica ao hibernate que não é uma coluna na tabela
	public String isAccessInstructorsFormated() {
		return formatar(accessInstructors);
	}

	public void setAccessInstructors(boolean accessInstructors) {
		this.accessInstructors = accessInstructors;
	}

	public boolean isAccessAirports() {
		return accessAirports;
	}

	@Transient //Indica ao hibernate que não é uma coluna na tabela
	public String isAccessAirportsFormated() {
		return formatar(accessAirports);
	}

	public void setAccessAirports(boolean accessAirports) {
		this.accessAirports = accessAirports;
	}

	public boolean isAccessFlights() {
		return accessFlights;
	}

	@Transient //Indica ao hibernate que não é uma coluna na tabela
	public String isAccessFlightsFormated() {
		return formatar(accessFlights);
	}

	public void setAccessFlights(boolean accessFlights) {
		this.accessFlights = accessFlights;
	}

	public boolean isAccessLessons() {
		return accessLessons;
	}

	@Transient //Indica ao hibernate que não é uma coluna na tabela
	public String isAccessLessonsFormated() {
		return formatar(accessLessons);
	}

	public void setAccessLessons(boolean accessLessons) {
		this.accessLessons = accessLessons;
	}

	public boolean isAccessUsers() {
		return accessUsers;
	}

	@Transient //Indica ao hibernate que não é uma coluna na tabela
	public String isAccessUsersFormated() {
		return formatar(accessUsers);
	}

	public void setAccessUsers(boolean accessUsers) {
		this.accessUsers = accessUsers;
	}

	public boolean isAccessMaintenances() {
		return accessMaintenances;
	}

	@Transient //Indica ao hibernate que não é uma coluna na tabela
	public String isAccessMaintenancesFormated() {
		return formatar(accessMaintenances);
	}

	public void setAccessMaintenances(boolean accessMaintenances) {
		this.accessMaintenances = accessMaintenances;
	}
	
	@Transient
	public String formatar(Boolean campo) {
		String Formated = "Não";
		if(campo == true){
			Formated = "Sim";
		}
		return Formated;
	}
}
