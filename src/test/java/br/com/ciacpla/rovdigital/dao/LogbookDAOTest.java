package br.com.ciacpla.rovdigital.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.ciacpla.rovdigital.entity.Aircraft;
import br.com.ciacpla.rovdigital.entity.Logbook;

public class LogbookDAOTest {

	@Test
	@Ignore
	public void salvar() throws ParseException {

		Long codigoAeronave = 1L;
		AircraftDAO aircraftDAO = new AircraftDAO();
		Aircraft aircraft = aircraftDAO.buscar(codigoAeronave);

		Logbook logbook = new Logbook();

		logbook.setNumberLogbook("teste");
		logbook.setAircraft(aircraft);
		logbook.setStartTotalTime(new BigDecimal("5888.9"));
		logbook.setStartDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2019"));
		logbook.setFinalTotalTime(new BigDecimal("9888.9"));
		logbook.setFinalDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2021"));

		LogbookDAO logbookDAO = new LogbookDAO();
		logbookDAO.salvar(logbook);
	}
	
	@Test
	@Ignore
	public void listar() {

		LogbookDAO logbookDAO = new LogbookDAO();
		List<Logbook> listaDeLogs = logbookDAO.listar();

		System.out.println("Encontrados: " + listaDeLogs.size());

		for (Logbook logbook : listaDeLogs) {
			System.out.println("Número do logbook: " + logbook.getNumberLogbook());
			System.out.println("Aeronave: " + logbook.getAircraft().getIcaoRegistry());
			System.out.println("Tempo inicial: " + logbook.getStartTotalTime());
			System.out.println("Data inicial: " + logbook.getStartDate());
			System.out.println("Tempo final: " + logbook.getFinalTotalTime());
			System.out.println("Data final: " + logbook.getFinalDate());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 2L;
		LogbookDAO logbookDAO = new LogbookDAO();
		Logbook logbook = logbookDAO.buscar(codigo);

		if (logbook == null) {
			System.out.println("Nenhum log encontrado.");
		} else {
			System.out.println("Número do logbook: " + logbook.getNumberLogbook());
			System.out.println("Aeronave: " + logbook.getAircraft().getIcaoRegistry());
			System.out.println("Tempo inicial: " + logbook.getStartTotalTime());
			System.out.println("Data inicial: " + logbook.getStartDate());
			System.out.println("Tempo final: " + logbook.getFinalTotalTime());
			System.out.println("Data final: " + logbook.getFinalDate());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 3L;
		LogbookDAO logbookDAO = new LogbookDAO();
		Logbook logbook = logbookDAO.buscar(codigo);

		if (logbook == null) {
			System.out.println("Nenhuma log excluido.");
		} else {
			logbookDAO.excluir(logbook);
			System.out.println("Log excluido:");
			System.out.println("Número do logbook: " + logbook.getNumberLogbook());
			System.out.println("Aeronave: " + logbook.getAircraft().getIcaoRegistry());
			System.out.println("Tempo inicial: " + logbook.getStartTotalTime());
			System.out.println("Data inicial: " + logbook.getStartDate());
			System.out.println("Tempo final: " + logbook.getFinalTotalTime());
			System.out.println("Data final: " + logbook.getFinalDate());
		}
	}
	
	@Test
	@Ignore
	public void editar() throws ParseException{
		
		Long codigoAeronave = 2L;
		AircraftDAO aircraftDAO = new AircraftDAO();
		Aircraft aircraft = aircraftDAO.buscar(codigoAeronave);
		
		Long codigo = 2L;
		LogbookDAO logbookDAO = new LogbookDAO();
		Logbook logbook = logbookDAO.buscar(codigo);
		
		if (logbook == null) {
			System.out.println("Nenhum logbook encontrado.");
		} else {
			System.out.println("Logbook editado - Antes:");
			System.out.println("Número do logbook: " + logbook.getNumberLogbook());
			System.out.println("Aeronave: " + logbook.getAircraft().getIcaoRegistry());
			System.out.println("Tempo inicial: " + logbook.getStartTotalTime());
			System.out.println("Data inicial: " + logbook.getStartDate());
			System.out.println("Tempo final: " + logbook.getFinalTotalTime());
			System.out.println("Data final: " + logbook.getFinalDate());
			
			logbook.setNumberLogbook("teste");
			logbook.setAircraft(aircraft);
			logbook.setStartTotalTime(new BigDecimal("5888.9"));
			logbook.setStartDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2019"));
			logbook.setFinalTotalTime(new BigDecimal("9888.9"));
			logbook.setFinalDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2021"));
			logbookDAO.editar(logbook);
			
			System.out.println("Logbook editado - Depois:");
			System.out.println("Número do logbook: " + logbook.getNumberLogbook());
			System.out.println("Aeronave: " + logbook.getAircraft().getIcaoRegistry());
			System.out.println("Tempo inicial: " + logbook.getStartTotalTime());
			System.out.println("Data inicial: " + logbook.getStartDate());
			System.out.println("Tempo final: " + logbook.getFinalTotalTime());
			System.out.println("Data final: " + logbook.getFinalDate());
		}
	}
}
