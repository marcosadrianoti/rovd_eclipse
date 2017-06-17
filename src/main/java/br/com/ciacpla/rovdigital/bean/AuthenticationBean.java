package br.com.ciacpla.rovdigital.bean;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.ciacpla.rovdigital.dao.UserDAO;
import br.com.ciacpla.rovdigital.entity.User;

@ManagedBean
@SessionScoped
public class AuthenticationBean{

	// MODELO
	private User usuario;
	private User usuarioLogado; // Pode ser ultilizado globalmente pelo controle
								// de acesso.

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public User getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(User usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	@PostConstruct
	public void iniciar() {
		usuario = new User();
	}

	// CONTROLE
	public void autenticar() {
		try {

			UserDAO userDAO = new UserDAO();

			usuarioLogado = userDAO.autenticar(usuario.getUserName(), usuario.getUserPassword());
			if (usuarioLogado == null) {
				Messages.addFlashGlobalWarn("NOME e/ou SENHA incorretos");
				return;
			}
			Faces.redirect("./pages/Main.xhtml");
		} catch (IOException e) {
			Messages.addGlobalError(e.getMessage());
			e.printStackTrace();
		}
	}

	public boolean temPermissao(String elementoMenu) {

		switch (elementoMenu) {
		case "Operações":
			return usuarioLogado.isAccessOperations();
		case "Voos":
			return usuarioLogado.isAccessFlights();
		case "Aulas":
			return usuarioLogado.isAccessLessons();
		case "Manutenções":
			return usuarioLogado.isAccessMaintenances();
		case "Cadastramentos":
			return usuarioLogado.isAccessRegistrations();
		case "Pilotos":
			return usuarioLogado.isAccessPilots();
		case "Aeronaves":
			return usuarioLogado.isAccessAircrafts();
		case "Diários":
			return usuarioLogado.isAccessLogbooks();
		case "Aeroportos":
			return usuarioLogado.isAccessAirports();
		case "Finanças":
			return usuarioLogado.isAccessFinances();
		case "Pacote de horas":
			return usuarioLogado.isAccessHoursPacks();
		case "Relatórios":
			return usuarioLogado.isAccessReports();
		case "Por Aluno":
			return usuarioLogado.isAccessReportStudent();
		case "Por Instrutor":
			return usuarioLogado.isAccessReportInstructor();
		case "Por Avião":
			return usuarioLogado.isAccessReportAircraft();
		case "Configurações":
			return usuarioLogado.isAccessConfigurations();
		case "Usuários":
			return usuarioLogado.isAccessUsers();
		default:
			return true;
		}
	}

	public void deslogar(){
		HttpSession autentica = Faces.getSession();
		  autentica.invalidate();
		  Faces.navigate("/pages/Login.xhtml");
	}
}
