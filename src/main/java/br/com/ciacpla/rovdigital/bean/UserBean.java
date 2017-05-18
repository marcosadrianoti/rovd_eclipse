package br.com.ciacpla.rovdigital.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.ciacpla.rovdigital.dao.UserDAO;
import br.com.ciacpla.rovdigital.entity.User;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UserBean implements Serializable {

	// MODELOS
	private User user;
	private List<User> users;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	// CONTROLES
	public void excluir(ActionEvent evento) {
		try {
			user = (User) evento.getComponent().getAttributes().get("userSelecionado");
			String userName = user.getUserName();

			UserDAO userDAO = new UserDAO();
			userDAO.excluir(user);

			users = userDAO.listar();

			Messages.addFlashGlobalInfo("Usuário " + userName + " excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar excluir o Usuário");
			erro.printStackTrace();
		}
	}

	@PostConstruct // Executa este controle logo que o managebean for criado.
	public void listar() {
		try {
			UserDAO userDAO = new UserDAO();
			users = userDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar listar");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			user = new User();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao gerar um novo Usuário");
			erro.printStackTrace();
		}
	}

	public void salvar() {

		try {
			UserDAO userDAO = new UserDAO();
			userDAO.merge(user);
			String userName = user.getUserName();

			user = new User();
			users = userDAO.listar();

			Messages.addGlobalInfo("Usuário " + userName +" salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			user = (User) evento.getComponent().getAttributes().get("userSelecionado");
			
		} catch (RuntimeException erro) {
			String userName = user.getUserName();
			Messages.addFlashGlobalError("Erro ao selecionar o Usuário " + userName);
			erro.printStackTrace();
		}
	}
}
