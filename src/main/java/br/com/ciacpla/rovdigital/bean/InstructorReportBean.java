package br.com.ciacpla.rovdigital.bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.swing.ImageIcon;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.ciacpla.rovdigital.dao.PilotDAO;
import br.com.ciacpla.rovdigital.entity.Pilot;
import br.com.ciacpla.rovdigital.util.Relatorio;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class InstructorReportBean implements Serializable {

	// MODELOS
	
//	private HttpServletResponse response;
//	private FacesContext context;
//	private ByteArrayOutputStream baos;
//	private InputStream stream;
	
	
	private Pilot pilot;
	private List<Pilot> pilots;
	private Date dataInicial;
	private Date dataFinal;

//	public InstructorReportBean(){
//		this.context = FacesContext.getCurrentInstance();
//		this.response = (HttpServletResponse) context.getExternalContext().getResponse();
//	}
	
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
		
			//String caminho = Faces.getRealPath("\\reports\\instructors.jasper");
//			stream = getClass().getResourceAsStream("/reports/instructors.jasper");
//			baos = new ByteArrayOutputStream();
//		try {
			
//			JasperReport report = (JasperReport) JRLoader.loadObject(stream);
			
			Date dataInicio = getDataInicial();
			Date dataFinal = getDataFinal();

			String invaName;
			if (pilot == null) {
				invaName = "%%";
			} else {
				invaName = pilot.getName();
			}

			Map<String, Object> parametros = new HashMap<>();
			parametros.put("DATA_INICIAL", dataInicio);
			parametros.put("DATA_FINAL", dataFinal);
			parametros.put("INSTRUCTOR", invaName);
			
//			String caminhoImg = Faces.getRealPath("\\src\\main\\java\\reports\\logopla.png");
			InputStream caminhoImg = getClass().getResourceAsStream("/src/main/java/reports/logopla.png");
			parametros.put("LOGOPLA", caminhoImg);

			Relatorio relatorio = new Relatorio();
			relatorio.getRelatorio(parametros);
			
			
			
//			Connection conexao = HibernateUtil.getConexao();

			//JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
//			JasperPrint relatorio = JasperFillManager.fillReport(report, parametros, conexao);
//			
//			JasperExportManager.exportReportToPdfStream(relatorio, baos);
			
//			response.reset();
//			response.setContentType("application/pdf");
//			response.setContentLength(baos.size());
//			response.setHeader("Content-disposition", "inline; filename=relatorio.pdf");
//			response.getOutputStream().write(baos.toByteArray());
//			response.getOutputStream().flush();
//			response.getOutputStream().close();
//			
//			context.responseComplete();
//			
			
			
			
			//JasperViewer.viewReport(relatorio, false);
			
			//JasperPrintManager.printReport(relatorio, true);

//		} catch (JRException erro) {
//			Messages.addGlobalError("Ocorreu um erro ao tentar gerar o Relatório");
//			erro.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} 
	}

	@PostConstruct // Executa este controle logo que o managebean for criado.
	public void novoRelatorio() {
		this.setPilot(null);
		this.setDataInicial(null);
		this.setDataFinal(null);
		try {
			PilotDAO pilotDAO = new PilotDAO();
			pilots = pilotDAO.listarPilotoPeloTipo("invaFliesAtSchool");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar listar");
			erro.printStackTrace();
		}
	}

}
