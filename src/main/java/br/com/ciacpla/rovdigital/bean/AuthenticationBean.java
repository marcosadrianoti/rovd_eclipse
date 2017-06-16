package br.com.ciacpla.rovdigital.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.ciacpla.rovdigital.dao.UserDAO;
import br.com.ciacpla.rovdigital.entity.User;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class AuthenticationBean implements Serializable {

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
			Faces.redirect("./pages/Flights.xhtml");
		} catch (IOException e) {
			Messages.addGlobalError(e.getMessage());
			e.printStackTrace();
		}
	}
}
