package br.com.ciacpla.rovdigital.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.ciacpla.rovdigital.entity.User;

public class UserDAOTest {

	@Test
	@Ignore
	public void salvar() {

		User user = new User();

		user.setUserName("usuario33");
		user.setUserPassword("6788");
		user.setConected(true);
		user.setAccessReports(true);
		user.setAccessPilots(false);
		user.setAccessAircrafts(true);
		user.setAccessInstructors(true);
		user.setAccessAirports(false);
		user.setAccessFlights(true);
		user.setAccessLessons(true);
		user.setAccessUsers(true);
		user.setAccessMaintenances(true);

		UserDAO userDAO = new UserDAO();
		userDAO.salvar(user);
	}
	
	@Test
	@Ignore
	public void listar() {

		UserDAO userDAO = new UserDAO();
		List<User> listaDeUsuarios = userDAO.listar();

		System.out.println("Encontrados: " + listaDeUsuarios.size());

		for (User user : listaDeUsuarios) {
			System.out.println("Nome: " + user.getUserName());
			System.out.println("Senha: " + user.getUserPassword());
			System.out.println("Conectado: " + user.isConected());
			System.out.println("Relatórios: " + user.isAccessReports());
			System.out.println("Pilotos: " + user.isAccessPilots());
			System.out.println("Aeronaves: " + user.isAccessAircrafts());
			System.out.println("Instrutores: " + user.isAccessInstructors());
			System.out.println("Aeroportos: " + user.isAccessAirports());
			System.out.println("Voos: " + user.isAccessFlights());
			System.out.println("Aulas: " + user.isAccessLessons());
			System.out.println("Usuários: " + user.isAccessUsers());
			System.out.println("Manutenção: " + user.isAccessMaintenances());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		
		Long codigo = 2L;
		UserDAO userDAO = new UserDAO();
		User user = userDAO.buscar(codigo);

		if (user == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Nome: " + user.getUserName());
			System.out.println("Senha: " + user.getUserPassword());
			System.out.println("Conectado: " + user.isConected());
			System.out.println("Relatórios: " + user.isAccessReports());
			System.out.println("Pilotos: " + user.isAccessPilots());
			System.out.println("Aeronaves: " + user.isAccessAircrafts());
			System.out.println("Instrutores: " + user.isAccessInstructors());
			System.out.println("Aeroportos: " + user.isAccessAirports());
			System.out.println("Voos: " + user.isAccessFlights());
			System.out.println("Aulas: " + user.isAccessLessons());
			System.out.println("Usuários: " + user.isAccessUsers());
			System.out.println("Manutenção: " + user.isAccessMaintenances());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 3L;
		UserDAO userDAO = new UserDAO();
		User user = userDAO.buscar(codigo);

		if (user == null) {
			System.out.println("Nenhum usuário excluido.");
		} else {
			userDAO.excluir(user);
			System.out.println("Usuário excluido:");
			System.out.println("Nome: " + user.getUserName());
			System.out.println("Senha: " + user.getUserPassword());
			System.out.println("Conectado: " + user.isConected());
			System.out.println("Relatórios: " + user.isAccessReports());
			System.out.println("Pilotos: " + user.isAccessPilots());
			System.out.println("Aeronaves: " + user.isAccessAircrafts());
			System.out.println("Instrutores: " + user.isAccessInstructors());
			System.out.println("Aeroportos: " + user.isAccessAirports());
			System.out.println("Voos: " + user.isAccessFlights());
			System.out.println("Aulas: " + user.isAccessLessons());
			System.out.println("Usuários: " + user.isAccessUsers());
			System.out.println("Manutenção: " + user.isAccessMaintenances());
		}
	}
	
	@Test
	@Ignore
	public void editar(){
		
		Long codigo = 1L;
		UserDAO userDAO = new UserDAO();
		User user = userDAO.buscar(codigo);
		
		if (user == null) {
			System.out.println("Nenhum usuário encontrado.");
		} else {
			System.out.println("Usuário editado - Antes:");
			System.out.println("Nome: " + user.getUserName());
			System.out.println("Senha: " + user.getUserPassword());
			System.out.println("Conectado: " + user.isConected());
			System.out.println("Relatórios: " + user.isAccessReports());
			System.out.println("Pilotos: " + user.isAccessPilots());
			System.out.println("Aeronaves: " + user.isAccessAircrafts());
			System.out.println("Instrutores: " + user.isAccessInstructors());
			System.out.println("Aeroportos: " + user.isAccessAirports());
			System.out.println("Voos: " + user.isAccessFlights());
			System.out.println("Aulas: " + user.isAccessLessons());
			System.out.println("Usuários: " + user.isAccessUsers());
			System.out.println("Manutenção: " + user.isAccessMaintenances());
			System.out.println();
			
			user.setUserName("Arthur");
			user.setUserPassword("5544");
			user.setConected(false);
			user.setAccessReports(true);
			user.setAccessPilots(false);
			user.setAccessAircrafts(true);
			user.setAccessInstructors(false);
			user.setAccessAirports(false);
			user.setAccessFlights(true);
			user.setAccessLessons(true);
			user.setAccessUsers(true);
			user.setAccessMaintenances(true);
			userDAO.editar(user);
			
			System.out.println("Usuário editado - Depois:");
			System.out.println("Nome: " + user.getUserName());
			System.out.println("Senha: " + user.getUserPassword());
			System.out.println("Conectado: " + user.isConected());
			System.out.println("Relatórios: " + user.isAccessReports());
			System.out.println("Pilotos: " + user.isAccessPilots());
			System.out.println("Aeronaves: " + user.isAccessAircrafts());
			System.out.println("Instrutores: " + user.isAccessInstructors());
			System.out.println("Aeroportos: " + user.isAccessAirports());
			System.out.println("Voos: " + user.isAccessFlights());
			System.out.println("Aulas: " + user.isAccessLessons());
			System.out.println("Usuários: " + user.isAccessUsers());
			System.out.println("Manutenção: " + user.isAccessMaintenances());
		}
	}
}
