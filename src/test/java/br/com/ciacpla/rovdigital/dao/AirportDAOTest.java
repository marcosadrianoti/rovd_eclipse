package br.com.ciacpla.rovdigital.dao;

import org.junit.Test;

import br.com.ciacpla.rovdigital.entity.Airport;
import br.com.ciacpla.rovdigital.entity.State;

public class AirportDAOTest {
	
	@Test
	public void salvar(){
//		Com chave estrangeira, tem que sempre procurar primeiro 
//		o objeto pai correspondente.
		StateDAO stateDAO = new StateDAO();
		State estado = stateDAO.buscar(1L);
		
//		Agora cuida do objeto filho.
		Airport aeroporto = new Airport();
		aeroporto.setIcaoCode("SWNS");
		aeroporto.setCity("Anápolis");
		aeroporto.setState(estado);//Foi passado o objeto todo.
		
//		Finalmente salva o novo aeroporto(objeto).
		AirportDAO airportDAO = new AirportDAO();
		airportDAO.salvar(aeroporto);
	}
}
