package br.com.ciacpla.rovdigital.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.ciacpla.rovdigital.dao.StateDAO;
import br.com.ciacpla.rovdigital.entity.State;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class StateBean implements Serializable {
//	MODELOS
	private State state;
	private List<State> states;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

//	CONTROLES
	public void excluir(ActionEvent evento) {
		try {
			state = (State) evento.getComponent().getAttributes().get("estadoSelecionado");

			StateDAO stateDao = new StateDAO();
			stateDao.excluir(state);
			states = stateDao.listar();

			Messages.addFlashGlobalInfo("Estado excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar excluir o estado");
			erro.printStackTrace();
		}
	}

	@PostConstruct // Executa este controle logo que o managebean for criado.
	public void listar() {
		try {
			StateDAO stateDao = new StateDAO();
			states = stateDao.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar");
			erro.printStackTrace();
		}
	}

	public void novo() {
		state = new State();
	}

	public void salvar() {

		try {
			StateDAO stateDao = new StateDAO();
			stateDao.merge(state);
			novo();
			states = stateDao.listar();
			Messages.addGlobalInfo("Estado salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		state = (State) evento.getComponent().getAttributes().get("estadoSelecionado");
	}
}
