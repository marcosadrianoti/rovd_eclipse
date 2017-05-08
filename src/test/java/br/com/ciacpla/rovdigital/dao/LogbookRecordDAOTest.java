package br.com.ciacpla.rovdigital.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.ciacpla.rovdigital.entity.Airport;
import br.com.ciacpla.rovdigital.entity.Logbook;
import br.com.ciacpla.rovdigital.entity.LogbookRecord;
import br.com.ciacpla.rovdigital.entity.Pilot;
import br.com.ciacpla.rovdigital.entity.RodRecord;
import br.com.ciacpla.rovdigital.entity.User;

public class LogbookRecordDAOTest {
	@Test
	@Ignore
	public void salvar() throws ParseException {

		Long codigoLogbook = 2L;
		LogbookDAO logbookDAO = new LogbookDAO();
		Logbook logbook = logbookDAO.buscar(codigoLogbook);
		
		Long codigoRodRecord = 2L;
		RodRecordDAO rodRecordDAO = new RodRecordDAO();
		RodRecord rodRecord = rodRecordDAO.buscar(codigoRodRecord);
		
		Long codigoAeroportoFrom = 2L;
		AirportDAO airportFromDAO = new AirportDAO();
		Airport airportFrom = airportFromDAO.buscar(codigoAeroportoFrom);

		Long codigoAeroportoTo = 2L;
		AirportDAO airportToDAO = new AirportDAO();
		Airport airportTo = airportToDAO.buscar(codigoAeroportoTo);
		
		Long codigoPiloto1 = 2L;
		PilotDAO pilotDAO1 = new PilotDAO();
		Pilot pilot1 = pilotDAO1.buscar(codigoPiloto1);

		Long codigoPiloto2 = 1L;
		PilotDAO pilotDAO2 = new PilotDAO();
		Pilot pilot2 = pilotDAO2.buscar(codigoPiloto2);

		Long codigoUser = 2L;
		UserDAO userDAO = new UserDAO();
		User user = userDAO.buscar(codigoUser);
		
		LogbookRecord logbookRecord = new LogbookRecord();

		logbookRecord.setRodRecord(rodRecord);
		logbookRecord.setLogbook(logbook);
		logbookRecord.setPageLogbook("32");
		logbookRecord.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2019"));
		logbookRecord.setFrom(airportFrom);
		logbookRecord.setTo(airportTo);
		logbookRecord.setStartTime(new SimpleDateFormat("HH:mm:ss").parse("11:15:00"));
		logbookRecord.setFinalTime(new SimpleDateFormat("HH:mm:ss").parse("12:10:00"));
		logbookRecord.setTotalTime(new BigDecimal("0.9"));
		logbookRecord.setTotalTac(new BigDecimal("0.9"));
		logbookRecord.setDayTime(new BigDecimal("1.0"));
		logbookRecord.setNigthTime(new BigDecimal("1.0"));
		logbookRecord.setVfrTime(new BigDecimal("1.0"));
		logbookRecord.setIfrrTime(new BigDecimal("1.0"));
		logbookRecord.setIfrcTime(new BigDecimal("1.0"));
		logbookRecord.setLandings(4);
		logbookRecord.setNat("TN");
		logbookRecord.setPilot1(pilot1);
		logbookRecord.setPilot2(pilot2);
		logbookRecord.setSolo(true);
		logbookRecord.setObs("pouso duro");
		logbookRecord.setUserCrossChecked(user);
		
		LogbookRecordDAO logbookRecordDAO = new LogbookRecordDAO();
		logbookRecordDAO.salvar(logbookRecord);;
	}
	
	@Test
	@Ignore
	public void listar() {

		LogbookRecordDAO logbookRecordDAO = new LogbookRecordDAO();
		List<LogbookRecord> listaDeLogs = logbookRecordDAO.listar();

		System.out.println("Encontrados: " + listaDeLogs.size());

		for (LogbookRecord logbookRecord : listaDeLogs) {
			System.out.println("Código do Rod: " + logbookRecord.getRodRecord().getCodigo());
			System.out.println("Número do Diário: " + logbookRecord.getLogbook().getNumberLogbook());
			System.out.println("Página do Diário: " + logbookRecord.getPageLogbook());
			System.out.println("Data: " + logbookRecord.getDate());
			System.out.println("From: " + logbookRecord.getFrom().getIcaoCode());
			System.out.println("To: " + logbookRecord.getTo().getIcaoCode());
			System.out.println("Time inicial: " + logbookRecord.getStartTime());
			System.out.println("Time final: " + logbookRecord.getFinalTime());
			System.out.println("Time total: " + logbookRecord.getTotalTime());
			System.out.println("Tac total: " + logbookRecord.getTotalTac());
			System.out.println("Diurno: " + logbookRecord.getDayTime());
			System.out.println("Noturno: " + logbookRecord.getNigthTime());
			System.out.println("VFR: " + logbookRecord.getVfrTime());
			System.out.println("IFR-R: " + logbookRecord.getIfrrTime());
			System.out.println("IFR-C: " + logbookRecord.getIfrcTime());
			System.out.println("Pousos: " + logbookRecord.getLandings());
			System.out.println("Nat: " + logbookRecord.getNat());
			System.out.println("Piloto 1: " + logbookRecord.getPilot1().getName());
			System.out.println("Piloto 2: " + logbookRecord.getPilot2().getName());
			System.out.println("Voo solo: " + logbookRecord.isSolo());
			System.out.println("Obs: " + logbookRecord.getObs());
			System.out.println("Checado por: " + logbookRecord.getUserCrossChecked().getUserName());
			
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigoDiario = 3L;
		LogbookRecordDAO logbookRecordDAO = new LogbookRecordDAO();
		LogbookRecord logbookRecord = logbookRecordDAO.buscar(codigoDiario);

		if (logbookRecord == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Código do Rod: " + logbookRecord.getRodRecord().getCodigo());
			System.out.println("Número do Diário: " + logbookRecord.getLogbook().getNumberLogbook());
			System.out.println("Página do Diário: " + logbookRecord.getPageLogbook());
			System.out.println("Data: " + logbookRecord.getDate());
			System.out.println("From: " + logbookRecord.getFrom().getIcaoCode());
			System.out.println("To: " + logbookRecord.getTo().getIcaoCode());
			System.out.println("Time inicial: " + logbookRecord.getStartTime());
			System.out.println("Time final: " + logbookRecord.getFinalTime());
			System.out.println("Time total: " + logbookRecord.getTotalTime());
			System.out.println("Tac total: " + logbookRecord.getTotalTac());
			System.out.println("Diurno: " + logbookRecord.getDayTime());
			System.out.println("Noturno: " + logbookRecord.getNigthTime());
			System.out.println("VFR: " + logbookRecord.getVfrTime());
			System.out.println("IFR-R: " + logbookRecord.getIfrrTime());
			System.out.println("IFR-C: " + logbookRecord.getIfrcTime());
			System.out.println("Pousos: " + logbookRecord.getLandings());
			System.out.println("Nat: " + logbookRecord.getNat());
			System.out.println("Piloto 1: " + logbookRecord.getPilot1().getName());
			System.out.println("Piloto 2: " + logbookRecord.getPilot2().getName());
			System.out.println("Voo solo: " + logbookRecord.isSolo());
			System.out.println("Obs: " + logbookRecord.getObs());
			System.out.println("Checado por: " + logbookRecord.getUserCrossChecked().getUserName());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigoDiario = 2L;
		LogbookRecordDAO logbookRecordDAO = new LogbookRecordDAO();
		LogbookRecord logbookRecord = logbookRecordDAO.buscar(codigoDiario);

		if (logbookRecord == null) {
			System.out.println("Nenhum registro excluido.");
		} else {
			logbookRecordDAO.excluir(logbookRecord);
			System.out.println("Registro excluido:");
			System.out.println("Código do Rod: " + logbookRecord.getRodRecord().getCodigo());
			System.out.println("Número do Diário: " + logbookRecord.getLogbook().getNumberLogbook());
			System.out.println("Página do Diário: " + logbookRecord.getPageLogbook());
			System.out.println("Data: " + logbookRecord.getDate());
			System.out.println("From: " + logbookRecord.getFrom().getIcaoCode());
			System.out.println("To: " + logbookRecord.getTo().getIcaoCode());
			System.out.println("Time inicial: " + logbookRecord.getStartTime());
			System.out.println("Time final: " + logbookRecord.getFinalTime());
			System.out.println("Time total: " + logbookRecord.getTotalTime());
			System.out.println("Tac total: " + logbookRecord.getTotalTac());
			System.out.println("Diurno: " + logbookRecord.getDayTime());
			System.out.println("Noturno: " + logbookRecord.getNigthTime());
			System.out.println("VFR: " + logbookRecord.getVfrTime());
			System.out.println("IFR-R: " + logbookRecord.getIfrrTime());
			System.out.println("IFR-C: " + logbookRecord.getIfrcTime());
			System.out.println("Pousos: " + logbookRecord.getLandings());
			System.out.println("Nat: " + logbookRecord.getNat());
			System.out.println("Piloto 1: " + logbookRecord.getPilot1().getName());
			System.out.println("Piloto 2: " + logbookRecord.getPilot2().getName());
			System.out.println("Voo solo: " + logbookRecord.isSolo());
			System.out.println("Obs: " + logbookRecord.getObs());
			System.out.println("Checado por: " + logbookRecord.getUserCrossChecked().getUserName());
		}
	}
	
	@Test
	@Ignore
	public void editar() throws ParseException{
		
		Long codigoLogbook = 2L;
		LogbookDAO logbookDAO = new LogbookDAO();
		Logbook logbook = logbookDAO.buscar(codigoLogbook);
		
		Long codigoRodRecord = 2L;
		RodRecordDAO rodRecordDAO = new RodRecordDAO();
		RodRecord rodRecord = rodRecordDAO.buscar(codigoRodRecord);
		
		Long codigoAeroportoFrom = 2L;
		AirportDAO airportFromDAO = new AirportDAO();
		Airport airportFrom = airportFromDAO.buscar(codigoAeroportoFrom);

		Long codigoAeroportoTo = 2L;
		AirportDAO airportToDAO = new AirportDAO();
		Airport airportTo = airportToDAO.buscar(codigoAeroportoTo);
		
		Long codigoPiloto1 = 2L;
		PilotDAO pilotDAO1 = new PilotDAO();
		Pilot pilot1 = pilotDAO1.buscar(codigoPiloto1);

		Long codigoPiloto2 = 1L;
		PilotDAO pilotDAO2 = new PilotDAO();
		Pilot pilot2 = pilotDAO2.buscar(codigoPiloto2);

		Long codigoUser = 2L;
		UserDAO userDAO = new UserDAO();
		User user = userDAO.buscar(codigoUser);
		
		Long codigoDiario = 3L;
		LogbookRecordDAO logbookRecordDAO = new LogbookRecordDAO();
		LogbookRecord logbookRecord = logbookRecordDAO.buscar(codigoDiario);
		
		if (logbookRecord == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Diário editado - Antes:");
			System.out.println("Código do Rod: " + logbookRecord.getRodRecord().getCodigo());
			System.out.println("Número do Diário: " + logbookRecord.getLogbook().getNumberLogbook());
			System.out.println("Página do Diário: " + logbookRecord.getPageLogbook());
			System.out.println("Data: " + logbookRecord.getDate());
			System.out.println("From: " + logbookRecord.getFrom().getIcaoCode());
			System.out.println("To: " + logbookRecord.getTo().getIcaoCode());
			System.out.println("Time inicial: " + logbookRecord.getStartTime());
			System.out.println("Time final: " + logbookRecord.getFinalTime());
			System.out.println("Time total: " + logbookRecord.getTotalTime());
			System.out.println("Tac total: " + logbookRecord.getTotalTac());
			System.out.println("Diurno: " + logbookRecord.getDayTime());
			System.out.println("Noturno: " + logbookRecord.getNigthTime());
			System.out.println("VFR: " + logbookRecord.getVfrTime());
			System.out.println("IFR-R: " + logbookRecord.getIfrrTime());
			System.out.println("IFR-C: " + logbookRecord.getIfrcTime());
			System.out.println("Pousos: " + logbookRecord.getLandings());
			System.out.println("Nat: " + logbookRecord.getNat());
			System.out.println("Piloto 1: " + logbookRecord.getPilot1().getName());
			System.out.println("Piloto 2: " + logbookRecord.getPilot2().getName());
			System.out.println("Voo solo: " + logbookRecord.isSolo());
			System.out.println("Obs: " + logbookRecord.getObs());
			System.out.println("Checado por: " + logbookRecord.getUserCrossChecked().getUserName());
			
			logbookRecord.setRodRecord(rodRecord);
			logbookRecord.setLogbook(logbook);
			logbookRecord.setPageLogbook("32");
			logbookRecord.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2019"));
			logbookRecord.setFrom(airportFrom);
			logbookRecord.setTo(airportTo);
			logbookRecord.setStartTime(new SimpleDateFormat("HH:mm:ss").parse("11:15:00"));
			logbookRecord.setFinalTime(new SimpleDateFormat("HH:mm:ss").parse("12:10:00"));
			logbookRecord.setTotalTime(new BigDecimal("0.9"));
			logbookRecord.setTotalTac(new BigDecimal("0.9"));
			logbookRecord.setDayTime(new BigDecimal("1.0"));
			logbookRecord.setNigthTime(new BigDecimal("1.0"));
			logbookRecord.setVfrTime(new BigDecimal("1.0"));
			logbookRecord.setIfrrTime(new BigDecimal("1.0"));
			logbookRecord.setIfrcTime(new BigDecimal("1.0"));
			logbookRecord.setLandings(4);
			logbookRecord.setNat("TN");
			logbookRecord.setPilot1(pilot1);
			logbookRecord.setPilot2(pilot2);
			logbookRecord.setSolo(true);
			logbookRecord.setObs("pouso duro");
			logbookRecord.setUserCrossChecked(user);
			logbookRecordDAO.editar(logbookRecord);
			
			System.out.println("Diário editado - Depois:");
			System.out.println("Código do Rod: " + logbookRecord.getRodRecord().getCodigo());
			System.out.println("Número do Diário: " + logbookRecord.getLogbook().getNumberLogbook());
			System.out.println("Página do Diário: " + logbookRecord.getPageLogbook());
			System.out.println("Data: " + logbookRecord.getDate());
			System.out.println("From: " + logbookRecord.getFrom().getIcaoCode());
			System.out.println("To: " + logbookRecord.getTo().getIcaoCode());
			System.out.println("Time inicial: " + logbookRecord.getStartTime());
			System.out.println("Time final: " + logbookRecord.getFinalTime());
			System.out.println("Time total: " + logbookRecord.getTotalTime());
			System.out.println("Tac total: " + logbookRecord.getTotalTac());
			System.out.println("Diurno: " + logbookRecord.getDayTime());
			System.out.println("Noturno: " + logbookRecord.getNigthTime());
			System.out.println("VFR: " + logbookRecord.getVfrTime());
			System.out.println("IFR-R: " + logbookRecord.getIfrrTime());
			System.out.println("IFR-C: " + logbookRecord.getIfrcTime());
			System.out.println("Pousos: " + logbookRecord.getLandings());
			System.out.println("Nat: " + logbookRecord.getNat());
			System.out.println("Piloto 1: " + logbookRecord.getPilot1().getName());
			System.out.println("Piloto 2: " + logbookRecord.getPilot2().getName());
			System.out.println("Voo solo: " + logbookRecord.isSolo());
			System.out.println("Obs: " + logbookRecord.getObs());
			System.out.println("Checado por: " + logbookRecord.getUserCrossChecked().getUserName());
		}
	}
}
