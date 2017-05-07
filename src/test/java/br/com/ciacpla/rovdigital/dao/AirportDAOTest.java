package br.com.ciacpla.rovdigital.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.ciacpla.rovdigital.entity.Airport;
import br.com.ciacpla.rovdigital.entity.State;

public class AirportDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Long codigoEstado = 1L;
		// Com chave estrangeira, tem que sempre procurar primeiro
		// o objeto pai correspondente.
		StateDAO stateDAO = new StateDAO();
		State estado = stateDAO.buscar(codigoEstado);

		// Agora cuida do objeto filho.
		Airport aeroporto = new Airport();
		aeroporto.setIcaoCode("SWNS");
		aeroporto.setCity("Anápolis");
		aeroporto.setState(estado);// Foi passado o objeto todo.

		// Finalmente salva o novo aeroporto(objeto).
		AirportDAO airportDAO = new AirportDAO();
		airportDAO.salvar(aeroporto);
	}

	@Test
	@Ignore
	public void listar() {
		AirportDAO airportDAO = new AirportDAO();
		List<Airport> listaDeAeroportos = airportDAO.listar();

		for (Airport airport : listaDeAeroportos) {
			System.out.println(
					airport.getIcaoCode() + " - " + airport.getCity() + " - " + airport.getState().getAcronym());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 2L;

		AirportDAO airportDAO = new AirportDAO();
		Airport airport = new AirportDAO().buscar(codigo);

		System.out.println(airport.getIcaoCode() + " - " + airport.getCity() + " - " + airport.getState().getAcronym());
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;

		AirportDAO airportDAO = new AirportDAO();
		Airport airport = new AirportDAO().buscar(codigo);
		
		airportDAO.excluir(airport);
		
		System.out.println("Aeroporto removido:");
		System.out.println(airport.getIcaoCode() + " - " + airport.getCity() + " - " + airport.getState().getAcronym());
	}
	
	@Test
	public void editar(){
		Long codigoAeroporto = 4L;
		Long codigoEstado = 3L;

//		StateDAO stateDAO = new StateDAO();
		State estado = new StateDAO().buscar(codigoEstado);
		
		System.out.println("Estado encontrado:");
		System.out.println(estado.getAcronym());
		
		
		AirportDAO airportDAO = new AirportDAO();
		Airport airport = new AirportDAO().buscar(codigoAeroporto);
		
		System.out.println("Aeroporto a ser editado:");
		System.out.println(airport.getIcaoCode() + " - " + airport.getCity() + " - " + airport.getState().getAcronym());
		
		airport.setCity("Botelho");
		airport.setState(estado);
		airportDAO.editar(airport);
		
		System.out.println("Aeroporto editado:");
		System.out.println(airport.getIcaoCode() + " - " + airport.getCity() + " - " + airport.getState().getAcronym());
	}
}
