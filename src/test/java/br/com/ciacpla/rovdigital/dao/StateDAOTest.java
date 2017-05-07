package br.com.ciacpla.rovdigital.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.ciacpla.rovdigital.entity.State;

public class StateDAOTest {
	@Test
	@Ignore
	public void salvar() {
		State estado = new State();
		estado.setName("Distrito Federal");
		estado.setAcronym("DF");

		StateDAO estadoDAO = new StateDAO();
		estadoDAO.salvar(estado);
	}

	@Test
	@Ignore
	public void listar() {
		StateDAO estadoDAO = new StateDAO();
		List<State> resultado = estadoDAO.listar();

		System.out.println("Encontrados: " + resultado.size());
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		
		StateDAO estadoDAO = new StateDAO();
		State estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println(estado.getCodigo() + " - " + estado.getName());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 4L;
		StateDAO estadoDAO = new StateDAO();
		State estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum registro excluido.");
		} else {
			estadoDAO.excluir(estado);
			System.out.println("Registro excluido:");
			System.out.println(estado.getCodigo() + " - " + estado.getName());
		}
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 4L;
		StateDAO estadoDAO = new StateDAO();
		State estado = estadoDAO.buscar(codigo);
		
		if (estado == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Registro editado - antes:");
			System.out.println(estado.getCodigo() + " - " + estado.getName()
			+ " - " + estado.getAcronym());
			
			estado.setAcronym("SP");
			estado.setName("São Paulo");
			estadoDAO.editar(estado);
			
			System.out.println("Registro editado - depois:");
			System.out.println(estado.getCodigo() + " - " + estado.getName()
			+ " - " + estado.getAcronym());
		}
	}
}
