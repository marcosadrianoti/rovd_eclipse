package br.com.ciacpla.rovdigital.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.ciacpla.rovdigital.dao.PilotDAO;
import br.com.ciacpla.rovdigital.entity.Pilot;
import br.com.ciacpla.rovdigital.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class StudentReportBean implements Serializable {

	// MODELOS
	private Pilot pilot;
	private List<Pilot> pilots;
	private Date dataInicial;
	private Date dataFinal;

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
		try {

			String caminho = Faces.getRealPath("\\reports\\students.jasper");

			Date dataInicio = getDataInicial();
			Date dataFinal = getDataFinal();

			String studentName;
			if (pilot == null) {
				studentName = "%%";
			} else {
				studentName = pilot.getName();
			}

			Map<String, Object> parametros = new HashMap<>();
			parametros.put("DATA_INICIAL", dataInicio);
			parametros.put("DATA_FINAL", dataFinal);
			parametros.put("STUDENT", studentName);

			Connection conexao = HibernateUtil.getConexao();

			JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
			
			JasperPrintManager.printReport(relatorio, true);

		} catch (JRException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar o Relatório");
			erro.printStackTrace();
		}
	}

	@PostConstruct // Executa este controle logo que o managebean for criado.
	public void novoRelatorio() {
		this.setPilot(null);
		this.setDataInicial(null);
		this.setDataFinal(null);
		try {
			PilotDAO pilotDAO = new PilotDAO();
			pilots = pilotDAO.listarPilotoPeloTipo("student");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar listar");
			erro.printStackTrace();
		}
	}

}
