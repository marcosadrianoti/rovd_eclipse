package br.com.ciacpla.rovdigital.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.ciacpla.rovdigital.dao.AircraftDAO;
import br.com.ciacpla.rovdigital.dao.AirportDAO;
import br.com.ciacpla.rovdigital.dao.LogbookDAO;
import br.com.ciacpla.rovdigital.dao.LogbookRecordDAO;
import br.com.ciacpla.rovdigital.dao.PilotDAO;
import br.com.ciacpla.rovdigital.dao.UserDAO;
import br.com.ciacpla.rovdigital.entity.Aircraft;
import br.com.ciacpla.rovdigital.entity.Airport;
import br.com.ciacpla.rovdigital.entity.Logbook;
import br.com.ciacpla.rovdigital.entity.LogbookRecord;
import br.com.ciacpla.rovdigital.entity.Pilot;
import br.com.ciacpla.rovdigital.entity.User;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class LogbookRecordBean implements Serializable {

	// MODELOS
	private LogbookRecord logbookRecord;
	private List<LogbookRecord> logbookRecords;

	private List<Aircraft> aircrafts;
	private List<Pilot> pilots;
	private List<Airport> airports;
	private List<Logbook> logbooks;
	private List<User> users;

	public LogbookRecord getLogbookRecord() {
		return logbookRecord;
	}

	public void setLogbookRecord(LogbookRecord logbookRecord) {
		this.logbookRecord = logbookRecord;
	}

	public List<LogbookRecord> getLogbookRecords() {
		return logbookRecords;
	}

	public void setLogbookRecords(List<LogbookRecord> logbookRecords) {
		this.logbookRecords = logbookRecords;
	}

	public List<Aircraft> getAircrafts() {
		return aircrafts;
	}

	public void setAircrafts(List<Aircraft> aircrafts) {
		this.aircrafts = aircrafts;
	}

	public List<Pilot> getPilots() {
		return pilots;
	}

	public void setPilots(List<Pilot> pilots) {
		this.pilots = pilots;
	}

	public List<Airport> getAirports() {
		return airports;
	}

	public void setAirports(List<Airport> airports) {
		this.airports = airports;
	}

	public List<Logbook> getLogbooks() {
		return logbooks;
	}

	public void setLogbooks(List<Logbook> logbooks) {
		this.logbooks = logbooks;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	// CONTROLES
	public void excluir(ActionEvent evento) {
		try {
			logbookRecord = (LogbookRecord) evento.getComponent().getAttributes().get("vooSelecionado");
			String marcaAircraft = logbookRecord.getAircraft().getIcaoRegistry();

			LogbookRecordDAO logbookRecordDAO = new LogbookRecordDAO();
			logbookRecordDAO.excluir(logbookRecord);

			logbookRecords = logbookRecordDAO.listar();

			Messages.addFlashGlobalInfo("Voo da aeronave " + marcaAircraft + " excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar excluir o Voo");
			erro.printStackTrace();
		}
	}

	@PostConstruct // Executa este controle logo que o managebean for criado.
	public void listar() {
		try {
			LogbookRecordDAO logbookRecordDAO = new LogbookRecordDAO();
			logbookRecords = logbookRecordDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar listar");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			logbookRecord = new LogbookRecord();

			AircraftDAO aircraftDAO = new AircraftDAO();
			aircrafts = aircraftDAO.listar();

			PilotDAO pilotDAO = new PilotDAO();
			pilots = pilotDAO.listar();

			AirportDAO airportDAO = new AirportDAO();
			airports = airportDAO.listar();

			LogbookDAO logbookDAO = new LogbookDAO();
			logbooks = logbookDAO.listar();

			UserDAO userDAO = new UserDAO();
			users = userDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao gerar um novo Voo");
			erro.printStackTrace();
		}
	}

	public void salvar() throws ParseException {

		try {
			LogbookRecordDAO logbookRecordDAO = new LogbookRecordDAO();
			logbookRecordDAO.merge(logbookRecord);
			String marcaAircraft = logbookRecord.getAircraft().getIcaoRegistry();

			logbookRecord = new LogbookRecord();

			AircraftDAO aircraftDAO = new AircraftDAO();
			aircrafts = aircraftDAO.listar();

			PilotDAO pilotDAO = new PilotDAO();
			pilots = pilotDAO.listar();

			AirportDAO airportDAO = new AirportDAO();
			airports = airportDAO.listar();

			LogbookDAO logbookDAO = new LogbookDAO();
			logbooks = logbookDAO.listar();

			UserDAO userDAO = new UserDAO();
			users = userDAO.listar();

			logbookRecords = logbookRecordDAO.listar();

			Messages.addGlobalInfo("Voo da aeronave " + marcaAircraft + " salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			logbookRecord = (LogbookRecord) evento.getComponent().getAttributes().get("vooSelecionado");

			AircraftDAO aircraftDAO = new AircraftDAO();
			aircrafts = aircraftDAO.listar();

			PilotDAO pilotDAO = new PilotDAO();
			pilots = pilotDAO.listar();

			AirportDAO airportDAO = new AirportDAO();
			airports = airportDAO.listar();

			LogbookDAO logbookDAO = new LogbookDAO();
			logbooks = logbookDAO.listar();

			UserDAO userDAO = new UserDAO();
			users = userDAO.listar();

		} catch (RuntimeException erro) {
			String marcaAircraft = logbookRecord.getAircraft().getIcaoRegistry();
			Messages.addFlashGlobalError("Erro ao selecionar o Voo da aeronave " + marcaAircraft);
			erro.printStackTrace();
		}
	}

	public void tempoRelogioTotal() {

		double partida = logbookRecord.getStartTime().getTime();
		double corte = logbookRecord.getFinalTime().getTime();
		double tempoTotalHoras = (((corte - partida) / 1000) / 60) / 60;
		BigDecimal tempoTotalHorasFormatado = BigDecimal.valueOf(tempoTotalHoras).setScale(1, RoundingMode.HALF_UP);

		logbookRecord.setTotalTime(tempoTotalHorasFormatado);
		logbookRecord.setDayTime(tempoTotalHorasFormatado);
	}

}
