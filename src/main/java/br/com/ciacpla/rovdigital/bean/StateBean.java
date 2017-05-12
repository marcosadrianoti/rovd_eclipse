package br.com.ciacpla.rovdigital.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.ciacpla.rovdigital.dao.StateDAO;
import br.com.ciacpla.rovdigital.entity.State;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class StateBean implements Serializable {
	private State state;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void novo() {
		state = new State();
	}

	public void salvar() {

		try {
			StateDAO stateDao = new StateDAO();
			stateDao.salvar(state);
			novo();
			Messages.addGlobalInfo("Estado salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar");
			erro.printStackTrace();
		}
	}
}
