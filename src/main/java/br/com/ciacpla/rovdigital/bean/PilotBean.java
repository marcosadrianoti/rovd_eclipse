package br.com.ciacpla.rovdigital.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.ciacpla.rovdigital.dao.PilotDAO;
import br.com.ciacpla.rovdigital.entity.Pilot;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PilotBean implements Serializable {

	// MODELOS
	private Pilot pilot;
	private List<Pilot> pilots;

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public List<Pilot> getPilots() {
		return pilots;
	}

	public void setPilots(List<Pilot> pilots) {
		this.pilots = pilots;
	}

	// CONTROLES
	public void excluir(ActionEvent evento) {
		try {
			pilot = (Pilot) evento.getComponent().getAttributes().get("pilotSelecionado");
			String pilotName = pilot.getName();

			PilotDAO pilotDAO = new PilotDAO();
			pilotDAO.excluir(pilot);

			pilots = pilotDAO.listar();

			Messages.addFlashGlobalInfo("Piloto " + pilotName + " excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar excluir o Piloto");
			erro.printStackTrace();
		}
	}

	@PostConstruct // Executa este controle logo que o managebean for criado.
	public void listar() {
		try {
			PilotDAO pilotDAO = new PilotDAO();
			pilots = pilotDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar listar");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			pilot = new Pilot();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao gerar um novo Piloto");
			erro.printStackTrace();
		}
	}

	public void salvar() {

		try {
			PilotDAO pilotDAO = new PilotDAO();
			pilotDAO.merge(pilot);
			String pilotName = pilot.getName();

			pilot = new Pilot();
			pilots = pilotDAO.listar();

			Messages.addGlobalInfo("Piloto " + pilotName +" salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			pilot= (Pilot) evento.getComponent().getAttributes().get("pilotSelecionado");
			
		} catch (RuntimeException erro) {
			String pilotName = pilot.getName();
			Messages.addFlashGlobalError("Erro ao selecionar o Piloto " + pilotName);
			erro.printStackTrace();
		}
	}
}
