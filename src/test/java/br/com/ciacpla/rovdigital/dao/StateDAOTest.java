package br.com.ciacpla.rovdigital.dao;

import org.junit.Test;

import br.com.ciacpla.rovdigital.entity.State;

public class StateDAOTest {
	@Test
	public void salvar() {
		State estado = new State();
		estado.setName("Distrito Federal");
		estado.setAcronym("DF");
		
		StateDAO estadoDAO = new StateDAO();
		estadoDAO.salvar(estado);
	}
}
