package br.com.ciacpla.rovdigital.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.ciacpla.rovdigital.dao.AirportDAO;
import br.com.ciacpla.rovdigital.dao.StateDAO;
import br.com.ciacpla.rovdigital.entity.Airport;
import br.com.ciacpla.rovdigital.entity.State;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class AirportBean implements Serializable {

	// MODELOS
	private Airport airport;
	private List<Airport> airports;
	private List<State> states;

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	public List<Airport> getAirports() {
		return airports;
	}

	public void setAirports(List<Airport> airports) {
		this.airports = airports;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	// CONTROLES
	public void excluir(ActionEvent evento) {
		try {
			airport = (Airport) evento.getComponent().getAttributes().get("aeroportoSelecionado");

			AirportDAO airportDAO = new AirportDAO();
			airportDAO.excluir(airport);

			airports = airportDAO.listar();

			Messages.addFlashGlobalInfo("Aeroporto excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o aeroporto");
			erro.printStackTrace();
		}
	}

	@PostConstruct // Executa este controle logo que o managebean for criado.
	public void listar() {
		try {
			AirportDAO airportDAO = new AirportDAO();
			airports = airportDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			airport = new Airport();
			StateDAO stateDAO = new StateDAO();
			states = stateDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar um novo Aeroporto");
			erro.printStackTrace();
		}

	}

	public void salvar() {

		try {
			AirportDAO airportDAO = new AirportDAO();
			airportDAO.merge(airport);

			airport = new Airport();

			StateDAO stateDAO = new StateDAO();
			states = stateDAO.listar();

			airports = airportDAO.listar();

			Messages.addGlobalInfo("Estado salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			airport = (Airport) evento.getComponent().getAttributes().get("aeroportoSelecionado");
			StateDAO stateDAO = new StateDAO();
			states = stateDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao selecionar o Aeroporto");
			erro.printStackTrace();
		}
	}
}
