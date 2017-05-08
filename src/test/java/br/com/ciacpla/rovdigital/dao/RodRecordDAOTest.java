package br.com.ciacpla.rovdigital.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.ciacpla.rovdigital.entity.Pilot;
import br.com.ciacpla.rovdigital.entity.RodRecord;
import br.com.ciacpla.rovdigital.entity.User;

public class RodRecordDAOTest {
	@Test
	@Ignore
	public void salvar() throws ParseException {

		Long codigoPiloto1 = 2L;
		PilotDAO pilotDAO1 = new PilotDAO();
		Pilot pilot1 = pilotDAO1.buscar(codigoPiloto1);

		Long codigoPiloto2 = 1L;
		PilotDAO pilotDAO2 = new PilotDAO();
		Pilot pilot2 = pilotDAO2.buscar(codigoPiloto2);

		Long codigoUser = 2L;
		UserDAO userDAO = new UserDAO();
		User user = userDAO.buscar(codigoUser);
		
		RodRecord rodRecord = new RodRecord();

		rodRecord.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2019"));
		rodRecord.setStartTime(new SimpleDateFormat("HH:mm:ss").parse("11:15:00"));
		rodRecord.setFinalTime(new SimpleDateFormat("HH:mm:ss").parse("12:10:00"));
		rodRecord.setTotalTime(new BigDecimal("0.9"));
		rodRecord.setStartTac(new BigDecimal("123.9"));
		rodRecord.setFinalTac(new BigDecimal("124.9"));
		rodRecord.setTotalTac(new BigDecimal("0.9"));
		rodRecord.setLandings(4);
		rodRecord.setMission("pso1");
		rodRecord.setPilot1(pilot1);
		rodRecord.setPilot2(pilot2);
		rodRecord.setObs("pouso duro");
		rodRecord.setUserCrossChecked(user);

		RodRecordDAO rodRecordDAO = new RodRecordDAO();
		rodRecordDAO.salvar(rodRecord);
	}
	
	@Test
	@Ignore
	public void listar() {

		RodRecordDAO rodRecordDAO = new RodRecordDAO();
		List<RodRecord> listaDeRods = rodRecordDAO.listar();

		System.out.println("Encontrados: " + listaDeRods.size());

		for (RodRecord rodRecord : listaDeRods) {
			System.out.println("Data: " + rodRecord.getDate());
			System.out.println("Time inicial: " + rodRecord.getStartTime());
			System.out.println("Time final: " + rodRecord.getFinalTime());
			System.out.println("Time total: " + rodRecord.getTotalTime());
			System.out.println("Tac inicial: " + rodRecord.getStartTac());
			System.out.println("Tac final: " + rodRecord.getFinalTac());
			System.out.println("Tac total: " + rodRecord.getTotalTac());
			System.out.println("Pousos: " + rodRecord.getLandings());
			System.out.println("Missão: " + rodRecord.getMission());
			System.out.println("Piloto 1: " + rodRecord.getPilot1().getName());
			System.out.println("Piloto 2: " + rodRecord.getPilot2().getName());
			System.out.println("Obs: " + rodRecord.getObs());
			System.out.println("Checado por: " + rodRecord.getUserCrossChecked().getUserName());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 3L;
		RodRecordDAO rodRecordDAO = new RodRecordDAO();
		RodRecord rodRecord = rodRecordDAO.buscar(codigo);

		if (rodRecord == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Data: " + rodRecord.getDate());
			System.out.println("Time inicial: " + rodRecord.getStartTime());
			System.out.println("Time final: " + rodRecord.getFinalTime());
			System.out.println("Time total: " + rodRecord.getTotalTime());
			System.out.println("Tac inicial: " + rodRecord.getStartTac());
			System.out.println("Tac final: " + rodRecord.getFinalTac());
			System.out.println("Tac total: " + rodRecord.getTotalTac());
			System.out.println("Pousos: " + rodRecord.getLandings());
			System.out.println("Missão: " + rodRecord.getMission());
			System.out.println("Piloto 1: " + rodRecord.getPilot1().getName());
			System.out.println("Piloto 2: " + rodRecord.getPilot2().getName());
			System.out.println("Obs: " + rodRecord.getObs());
			System.out.println("Checado por: " + rodRecord.getUserCrossChecked().getUserName());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 2L;
		RodRecordDAO rodRecordDAO = new RodRecordDAO();
		RodRecord rodRecord = rodRecordDAO.buscar(codigo);

		if (rodRecord == null) {
			System.out.println("Nenhum registro excluido.");
		} else {
			rodRecordDAO.excluir(rodRecord);
			System.out.println("Registro excluido:");
			System.out.println("Data: " + rodRecord.getDate());
			System.out.println("Time inicial: " + rodRecord.getStartTime());
			System.out.println("Time final: " + rodRecord.getFinalTime());
			System.out.println("Time total: " + rodRecord.getTotalTime());
			System.out.println("Tac inicial: " + rodRecord.getStartTac());
			System.out.println("Tac final: " + rodRecord.getFinalTac());
			System.out.println("Tac total: " + rodRecord.getTotalTac());
			System.out.println("Pousos: " + rodRecord.getLandings());
			System.out.println("Missão: " + rodRecord.getMission());
			System.out.println("Piloto 1: " + rodRecord.getPilot1().getName());
			System.out.println("Piloto 2: " + rodRecord.getPilot2().getName());
			System.out.println("Obs: " + rodRecord.getObs());
			System.out.println("Checado por: " + rodRecord.getUserCrossChecked().getUserName());
		}
	}
	
	@Test
	@Ignore
	public void editar() throws ParseException{
		
		Long codigoPiloto1 = 1L;
		PilotDAO pilotDAO1 = new PilotDAO();
		Pilot pilot1 = pilotDAO1.buscar(codigoPiloto1);

		Long codigoPiloto2 = 2L;
		PilotDAO pilotDAO2 = new PilotDAO();
		Pilot pilot2 = pilotDAO2.buscar(codigoPiloto2);

		Long codigoUser = 1L;
		UserDAO userDAO = new UserDAO();
		User user = userDAO.buscar(codigoUser);
		
		Long codigo = 3L;
		RodRecordDAO rodRecordDAO = new RodRecordDAO();
		RodRecord rodRecord = rodRecordDAO.buscar(codigo);
		
		if (rodRecord == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Rod editado - Antes:");
			System.out.println("Data: " + rodRecord.getDate());
			System.out.println("Time inicial: " + rodRecord.getStartTime());
			System.out.println("Time final: " + rodRecord.getFinalTime());
			System.out.println("Time total: " + rodRecord.getTotalTime());
			System.out.println("Tac inicial: " + rodRecord.getStartTac());
			System.out.println("Tac final: " + rodRecord.getFinalTac());
			System.out.println("Tac total: " + rodRecord.getTotalTac());
			System.out.println("Pousos: " + rodRecord.getLandings());
			System.out.println("Missão: " + rodRecord.getMission());
			System.out.println("Piloto 1: " + rodRecord.getPilot1().getName());
			System.out.println("Piloto 2: " + rodRecord.getPilot2().getName());
			System.out.println("Obs: " + rodRecord.getObs());
			System.out.println("Checado por: " + rodRecord.getUserCrossChecked().getUserName());
			
			rodRecord.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2018"));
			rodRecord.setStartTime(new SimpleDateFormat("HH:mm:ss").parse("14:15:00"));
			rodRecord.setFinalTime(new SimpleDateFormat("HH:mm:ss").parse("16:10:00"));
			rodRecord.setTotalTime(new BigDecimal("2.9"));
			rodRecord.setStartTac(new BigDecimal("1232.9"));
			rodRecord.setFinalTac(new BigDecimal("1244.9"));
			rodRecord.setTotalTac(new BigDecimal("2.9"));
			rodRecord.setLandings(3);
			rodRecord.setMission("ps02");
			rodRecord.setPilot1(pilot1);
			rodRecord.setPilot2(pilot2);
			rodRecord.setObs("Abasteceu fora.");
			rodRecord.setUserCrossChecked(user);
			rodRecordDAO.editar(rodRecord);
			
			System.out.println("Rod editado - Depois:");
			System.out.println("Data: " + rodRecord.getDate());
			System.out.println("Time inicial: " + rodRecord.getStartTime());
			System.out.println("Time final: " + rodRecord.getFinalTime());
			System.out.println("Time total: " + rodRecord.getTotalTime());
			System.out.println("Tac inicial: " + rodRecord.getStartTac());
			System.out.println("Tac final: " + rodRecord.getFinalTac());
			System.out.println("Tac total: " + rodRecord.getTotalTac());
			System.out.println("Pousos: " + rodRecord.getLandings());
			System.out.println("Missão: " + rodRecord.getMission());
			System.out.println("Piloto 1: " + rodRecord.getPilot1().getName());
			System.out.println("Piloto 2: " + rodRecord.getPilot2().getName());
			System.out.println("Obs: " + rodRecord.getObs());
			System.out.println("Checado por: " + rodRecord.getUserCrossChecked().getUserName());
		}
	}
}
