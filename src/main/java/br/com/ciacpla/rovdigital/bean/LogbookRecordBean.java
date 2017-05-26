package br.com.ciacpla.rovdigital.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.ciacpla.rovdigital.dao.AirportDAO;
import br.com.ciacpla.rovdigital.dao.LogbookDAO;
import br.com.ciacpla.rovdigital.dao.LogbookRecordDAO;
import br.com.ciacpla.rovdigital.dao.PilotDAO;
import br.com.ciacpla.rovdigital.dao.UserDAO;
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
			String codigoVoo = logbookRecord.getCodigo().toString();

			LogbookRecordDAO logbookRecordDAO = new LogbookRecordDAO();
			logbookRecordDAO.excluir(logbookRecord);

			logbookRecords = logbookRecordDAO.listar();

			Messages.addFlashGlobalInfo("Voo nº " + codigoVoo + " excluido com sucesso");
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

	public void salvar() {

		try {
			LogbookRecordDAO logbookRecordDAO = new LogbookRecordDAO();
			logbookRecordDAO.merge(logbookRecord);
			String codigoVoo = logbookRecord.getCodigo().toString();

			logbookRecord = new LogbookRecord();

			PilotDAO pilotDAO = new PilotDAO();
			pilots = pilotDAO.listar();

			AirportDAO airportDAO = new AirportDAO();
			airports = airportDAO.listar();

			LogbookDAO logbookDAO = new LogbookDAO();
			logbooks = logbookDAO.listar();

			UserDAO userDAO = new UserDAO();
			users = userDAO.listar();

			logbookRecords = logbookRecordDAO.listar();

			Messages.addGlobalInfo("Voo nº " + codigoVoo +" salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			logbookRecord = (LogbookRecord) evento.getComponent().getAttributes().get("vooSelecionado");
			
			PilotDAO pilotDAO = new PilotDAO();
			pilots = pilotDAO.listar();

			AirportDAO airportDAO = new AirportDAO();
			airports = airportDAO.listar();

			LogbookDAO logbookDAO = new LogbookDAO();
			logbooks = logbookDAO.listar();

			UserDAO userDAO = new UserDAO();
			users = userDAO.listar();
			
		} catch (RuntimeException erro) {
			String codigoVoo = logbookRecord.getCodigo().toString();
			Messages.addFlashGlobalError("Erro ao selecionar o Voo nº " + codigoVoo);
			erro.printStackTrace();
		}
	}
}
