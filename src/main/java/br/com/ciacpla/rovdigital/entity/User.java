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
	
	@Transient
	private String userPasswordUnencrypted;
	
	@Column(nullable=false)
    private boolean conected;
	
	@Column(nullable=false)
	private boolean accessOperations;

	@Column(nullable=false)
	private boolean accessFlights;

	@Column(nullable=false)
	private boolean accessLessons;
	
	@Column(nullable=false)
	private boolean accessMaintenances;
	
	@Column(nullable=false)
	private boolean accessRegistrations;
	
	@Column(nullable=false)
	private boolean accessPilots;
	
	@Column(nullable=false)
	private boolean accessAircrafts;
	
	@Column(nullable=false)
	private boolean accessLogbooks;
	
	@Column(nullable=false)
	private boolean accessAirports;
	
	@Column(nullable=false)
	private boolean accessFinances;
	
	@Column(nullable=false)
	private boolean accessHoursPacks;
	
	@Column(nullable=false)
	private boolean accessReports;
	
	@Column(nullable=false)
	private boolean accessReportStudent;

	@Column(nullable=false)
	private boolean accessReportInstructor;

	@Column(nullable=false)
	private boolean accessReportAircraft;
	
	@Column(nullable=false)
	private boolean accessConfigurations;
	
	@Column(nullable=false)
	private boolean accessUsers;
	
	//NOME DO USUÁRIO
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	//SENHA DO USUÁRIO
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String getUserPasswordUnencrypted() {
		return userPasswordUnencrypted;
	}
	
	public void setUserPasswordUnencrypted(String userPasswordUnencrypted) {
		this.userPasswordUnencrypted = userPasswordUnencrypted;
	}
	
	//USUÁRIO ESTÁ CONECTADO
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
	
//MENU OPERAÇÕES
	public boolean isAccessOperations() {
		return accessOperations;
	}
	
	@Transient //Indica ao hibernate que não é uma coluna na tabela
	public String isAccessOperationsFormated() {
		return formatar(accessOperations);
	}
	
	public void setAccessOperations(boolean accessOperations) {
		this.accessOperations = accessOperations;
	}
	
	//ITEM VOOS
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
	
	//ITEM AULAS
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
	
	//ITEM MANUTENÇÕES
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
	
//MENU CADASTRAMENTOS
	public boolean isAccessRegistrations() {
		return accessRegistrations;
	}

	@Transient //Indica ao hibernate que não é uma coluna na tabela
	public String isAccessRegistrationsFormated() {
		return formatar(accessRegistrations);
	}
	
	public void setAccessRegistrations(boolean accessRegistrations) {
		this.accessRegistrations = accessRegistrations;
	}
	
	//ITEM PILOTOS
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
	
	//ITEM AERONAVES
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
	
	//ITEM DIÁRIOS
	public boolean isAccessLogbooks() {
		return accessLogbooks;
	}
	
	@Transient //Indica ao hibernate que não é uma coluna na tabela
	public String isAccessLogbooksFormated() {
		return formatar(accessLogbooks);
	}
	
	public void setAccessLogbooks(boolean accessLogbooks) {
		this.accessLogbooks = accessLogbooks;
	}
	
	//ITEM AEROPORTOS
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
	
//MENU FINANÇAS
	public boolean isAccessFinances() {
		return accessFinances;
	}
	
	@Transient //Indica ao hibernate que não é uma coluna na tabela
	public String isAccessFinancesFormated() {
		return formatar(accessFinances);
	}
	
	public void setAccessFinances(boolean accessFinances) {
		this.accessFinances = accessFinances;
	}
	
	//ITEM PACOTE DE HORAS
	public boolean isAccessHoursPacks() {
		return accessHoursPacks;
	}

	@Transient //Indica ao hibernate que não é uma coluna na tabela
	public String isAccessHoursPacksFormated() {
		return formatar(accessHoursPacks);
	}
	
	public void setAccessHoursPacks(boolean accessHoursPacks) {
		this.accessHoursPacks = accessHoursPacks;
	}
	
//MENU RELATÓRIOS
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
	
	//ITEM POR ALUNO
	public boolean isAccessReportStudent() {
		return accessReportStudent;
	}

	@Transient //Indica ao hibernate que não é uma coluna na tabela
	public String isAccessReportStudentFormated() {
		return formatar(accessReportStudent);
	}
	
	public void setAccessReportStudent(boolean accessReportStudent) {
		this.accessReportStudent = accessReportStudent;
	}
	
	//ITEM POR INSTRUTOR
	public boolean isAccessReportInstructor() {
		return accessReportInstructor;
	}

	@Transient //Indica ao hibernate que não é uma coluna na tabela
	public String isAccessReportInstructorFormated() {
		return formatar(accessReportInstructor);
	}
	
	public void setAccessReportInstructor(boolean accessReportStructor) {
		this.accessReportInstructor = accessReportStructor;
	}
	
	//ITEM POR AERONAVE
	public boolean isAccessReportAircraft() {
		return accessReportAircraft;
	}

	@Transient //Indica ao hibernate que não é uma coluna na tabela
	public String isAccessReportAircraftFormated() {
		return formatar(accessReportAircraft);
	}
	
	public void setAccessReportAircraft(boolean accessReportAircraft) {
		this.accessReportAircraft = accessReportAircraft;
	}
	
//MENU CONFIGURAÇÕES
	public boolean isAccessConfigurations() {
		return accessConfigurations;
	}

	@Transient //Indica ao hibernate que não é uma coluna na tabela
	public String isAccessConfigurationsFormated() {
		return formatar(accessConfigurations);
	}
	
	public void setAccessConfigurations(boolean accessConfigurations) {
		this.accessConfigurations = accessConfigurations;
	}
	
	//ITEM USUÁRIOS
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
	
	//Metodo para trocar TRUE por SIM e FALSE por NÃO
	@Transient
	public String formatar(Boolean campo) {
		String Formated = "Não";
		if(campo == true){
			Formated = "Sim";
		}
		return Formated;
	}
}
