package br.com.ciacpla.rovdigital.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.ciacpla.rovdigital.dao.AircraftDAO;
import br.com.ciacpla.rovdigital.dao.CategoryAircraftDAO;
import br.com.ciacpla.rovdigital.entity.Aircraft;
import br.com.ciacpla.rovdigital.entity.CategoryAircraft;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class AircraftBean implements Serializable {

	// MODELOS
	private Aircraft aircraft;
	private List<Aircraft> aircrafts;
	private List<CategoryAircraft> categoryAircrafts;

	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public List<Aircraft> getAircrafts() {
		return aircrafts;
	}

	public void setAircrafts(List<Aircraft> aircrafts) {
		this.aircrafts = aircrafts;
	}

	public List<CategoryAircraft> getCategoryAircrafts() {
		return categoryAircrafts;
	}

	public void setCategoryAircrafts(List<CategoryAircraft> categoryAircrafts) {
		this.categoryAircrafts = categoryAircrafts;
	}

	// CONTROLES
	public void excluir(ActionEvent evento) {
		try {
			aircraft = (Aircraft) evento.getComponent().getAttributes().get("aeronaveSelecionada");
			String aircraftRegistry = aircraft.getIcaoRegistry();

			AircraftDAO aircraftDAO = new AircraftDAO();
			aircraftDAO.excluir(aircraft);

			aircrafts = aircraftDAO.listar();

			Messages.addFlashGlobalInfo("Aeronave " + aircraftRegistry + " excluida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar excluir a aeronave");
			erro.printStackTrace();
		}
	}

	@PostConstruct // Executa este controle logo que o managebean for criado.
	public void listar() {
		try {
			AircraftDAO aircraftDAO = new AircraftDAO();
			aircrafts = aircraftDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar listar");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			aircraft= new Aircraft();
			CategoryAircraftDAO categoryAircraftDAO = new CategoryAircraftDAO();
			categoryAircrafts = categoryAircraftDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao gerar uma nova Aeronave");
			erro.printStackTrace();
		}

	}

	public void salvar() {

		try {
			AircraftDAO aircraftDAO = new AircraftDAO();
			aircraftDAO.merge(aircraft);
			String aircraftRegistry = aircraft.getIcaoRegistry();

			aircraft = new Aircraft();

			CategoryAircraftDAO categoryAircraftDAO = new CategoryAircraftDAO();
			categoryAircrafts = categoryAircraftDAO.listar();

			aircrafts = aircraftDAO.listar();

			Messages.addGlobalInfo("Aeronave " + aircraftRegistry +" salva com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			aircraft = (Aircraft) evento.getComponent().getAttributes().get("aeronaveSelecionada");
			
			CategoryAircraftDAO categoryAircraftDAO = new CategoryAircraftDAO();
			categoryAircrafts = categoryAircraftDAO.listar();
		} catch (RuntimeException erro) {
			String aircraftRegistry = aircraft.getIcaoRegistry();
			Messages.addFlashGlobalError("Erro ao selecionar a Aeronave " + aircraftRegistry);
			erro.printStackTrace();
		}
	}
}
