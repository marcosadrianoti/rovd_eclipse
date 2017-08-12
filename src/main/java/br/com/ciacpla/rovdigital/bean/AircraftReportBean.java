package br.com.ciacpla.rovdigital.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.ciacpla.rovdigital.dao.AircraftDAO;
import br.com.ciacpla.rovdigital.entity.Aircraft;
import br.com.ciacpla.rovdigital.util.Relatorio;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class AircraftReportBean implements Serializable {

	// MODELOS
	
	private Aircraft aircraft;
	private List<Aircraft> aircrafts;
	private Date dataInicial;
	private Date dataFinal;

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

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	// CONTROLES

	public void gerarRelatorio() {

		Date dataInicio = getDataInicial();
		Date dataFinal = getDataFinal();

		String aviao;
		if (aircraft == null) {
			aviao = "%%";
		} else {
			aviao = aircraft.getIcaoRegistry();
		}

		Map<String, Object> parametros = new HashMap<>();
		parametros.put("DATA_INICIAL", dataInicio);
		parametros.put("DATA_FINAL", dataFinal);
		parametros.put("AIRCRAFT", aviao);
		parametros.put("LOGOPLA", this.getClass().getResourceAsStream("/img/logopla.gif"));

		Relatorio relatorio = new Relatorio();
		relatorio.getRelatorio("/reports/aircrafts.jasper", parametros);

	}

	@PostConstruct // Executa este controle logo que o managebean for criado.
	public void novoRelatorio() {
		this.setAircraft(null);
		this.setDataInicial(null);
		this.setDataFinal(null);
		try {
			AircraftDAO aircraftDAO = new AircraftDAO();
			aircrafts = aircraftDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar listar");
			erro.printStackTrace();
		}
	}

}
