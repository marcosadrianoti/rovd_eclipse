package br.com.ciacpla.rovdigital.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.ciacpla.rovdigital.dao.PilotDAO;
import br.com.ciacpla.rovdigital.dao.RodRecordDAO;
import br.com.ciacpla.rovdigital.entity.Pilot;
import br.com.ciacpla.rovdigital.entity.RodRecord;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class RodRecordBean implements Serializable {

	// MODELOS
	private RodRecord rodRecord;
	private List<RodRecord> rodRecords;
	private List<Pilot> pilots;

	public RodRecord getRodRecord() {
		return rodRecord;
	}

	public void setRodRecord(RodRecord rodRecord) {
		this.rodRecord = rodRecord;
	}

	public List<RodRecord> getRodRecords() {
		return rodRecords;
	}

	public void setRodRecords(List<RodRecord> rodRecords) {
		this.rodRecords = rodRecords;
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
			rodRecord = (RodRecord) evento.getComponent().getAttributes().get("rodRecordSelecionado");
			String codigoRodRecord = rodRecord.getCodigo().toString();

			RodRecordDAO rodRecordDAO = new RodRecordDAO();
			rodRecordDAO.excluir(rodRecord);

			rodRecords = rodRecordDAO.listar();

			Messages.addFlashGlobalInfo("O registro nº " + codigoRodRecord + " foi excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar excluir o registro");
			erro.printStackTrace();
		}
	}

	@PostConstruct // Executa este controle logo que o managebean for criado.
	public void listar() {
		try {
			RodRecordDAO rodRecordDAO = new RodRecordDAO();
			rodRecords = rodRecordDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar listar");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			rodRecord = new RodRecord();
			PilotDAO pilotDAO = new PilotDAO();
			pilots = pilotDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao gerar um novo Registro");
			erro.printStackTrace();
		}
	}

	public void salvar() {

		try {
			RodRecordDAO rodRecordDAO = new RodRecordDAO();
			rodRecordDAO.merge(rodRecord);
			String codigoRodRecord = rodRecord.getCodigo().toString();

			rodRecord = new RodRecord();

			PilotDAO pilotDAO = new PilotDAO();
			pilots = pilotDAO.listar();

			rodRecords = rodRecordDAO.listar();

			Messages.addGlobalInfo("Registro nº " + codigoRodRecord +" salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			rodRecord = (RodRecord) evento.getComponent().getAttributes().get("rodRecordSelecionado");
			
			PilotDAO pilotDAO = new PilotDAO();
			pilots = pilotDAO.listar();
		} catch (RuntimeException erro) {
			String codigoRodRecord = rodRecord.getCodigo().toString();
			Messages.addFlashGlobalError("Erro ao selecionar o Registro nº " + codigoRodRecord);
			erro.printStackTrace();
		}
	}
}
