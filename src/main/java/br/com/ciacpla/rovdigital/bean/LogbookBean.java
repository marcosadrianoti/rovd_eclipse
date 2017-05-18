package br.com.ciacpla.rovdigital.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.ciacpla.rovdigital.dao.AircraftDAO;
import br.com.ciacpla.rovdigital.dao.LogbookDAO;
import br.com.ciacpla.rovdigital.entity.Aircraft;
import br.com.ciacpla.rovdigital.entity.Logbook;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class LogbookBean implements Serializable {

	// MODELOS
	private Logbook logbook;
	private List<Logbook> logbooks;
	private List<Aircraft> aircrafts;

	public Logbook getLogbook() {
		return logbook;
	}

	public void setLogbook(Logbook logbook) {
		this.logbook = logbook;
	}

	public List<Logbook> getLogbooks() {
		return logbooks;
	}

	public void setLogbooks(List<Logbook> logbooks) {
		this.logbooks = logbooks;
	}

	public List<Aircraft> getAircrafts() {
		return aircrafts;
	}

	public void setAircrafts(List<Aircraft> aircrafts) {
		this.aircrafts = aircrafts;
	}

	// CONTROLES
	public void excluir(ActionEvent evento) {
		try {
			logbook = (Logbook) evento.getComponent().getAttributes().get("logbookSelecionado");
			String numberLogbook = logbook.getNumberLogbook();

			LogbookDAO logbookDAO = new LogbookDAO();
			logbookDAO.excluir(logbook);

			logbooks = logbookDAO.listar();

			Messages.addFlashGlobalInfo("Diário " + numberLogbook + " excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar excluir o Diário");
			erro.printStackTrace();
		}
	}

	@PostConstruct // Executa este controle logo que o managebean for criado.
	public void listar() {
		try {
			LogbookDAO logbookDAO = new LogbookDAO();
			logbooks = logbookDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar listar");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			logbook = new Logbook();
			AircraftDAO aircraftDAO = new AircraftDAO();
			aircrafts = aircraftDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao gerar um novo Diário");
			erro.printStackTrace();
		}
	}

	public void salvar() {

		try {
			LogbookDAO logbookDAO = new LogbookDAO();
			logbookDAO.merge(logbook);
			String numberLogbook = logbook.getNumberLogbook();

			logbook = new Logbook();

			AircraftDAO aircraftDAO = new AircraftDAO();
			aircrafts = aircraftDAO.listar();

			logbooks = logbookDAO.listar();

			Messages.addGlobalInfo("Diário " + numberLogbook +" salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			logbook = (Logbook) evento.getComponent().getAttributes().get("logbookSelecionado");
			
			AircraftDAO aircraftDAO = new AircraftDAO();
			aircrafts = aircraftDAO.listar();
		} catch (RuntimeException erro) {
			String numberLogbook = logbook.getNumberLogbook();
			Messages.addFlashGlobalError("Erro ao selecionar o Diário " + numberLogbook);
			erro.printStackTrace();
		}
	}
}
