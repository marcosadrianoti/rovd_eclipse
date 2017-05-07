package br.com.ciacpla.rovdigital.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.ciacpla.rovdigital.entity.Aircraft;
import br.com.ciacpla.rovdigital.entity.Maintenance;

public class MaintenanceDAOTest {

	@Test
	@Ignore
	public void salvar() throws ParseException {

		Long codigoAeronave = 1L;
		AircraftDAO aircraftDAO = new AircraftDAO();
		Aircraft aircraft = aircraftDAO.buscar(codigoAeronave);

		Maintenance maintenance = new Maintenance();

		maintenance.setServiceOrder("Teste");
		maintenance.setAircraft(aircraft);
		maintenance.setDateMaintenance(new SimpleDateFormat("dd/MM/yyyy").parse("09/05/2017"));
		maintenance.setPerformedMaintenance("100");
		maintenance.setNextMaintenance("50");
		maintenance.setAvailableTime(new BigDecimal("10"));
		maintenance.setObs("Nenhuma ocorrência na manutenção.");

		MaintenanceDAO maintenanceDAO = new MaintenanceDAO();
		maintenanceDAO.salvar(maintenance);
	}
	
	@Test
	@Ignore
	public void listar() {

		MaintenanceDAO maintenanceDAO = new MaintenanceDAO();
		List<Maintenance> listaDeManutencoes = maintenanceDAO.listar();

		System.out.println("Encontrados: " + listaDeManutencoes.size());

		for (Maintenance maintenance : listaDeManutencoes) {
			System.out.println("OS: " + maintenance.getServiceOrder());
			System.out.println("Aeronave: " + maintenance.getAircraft().getIcaoRegistry());
			System.out.println("Data: " + maintenance.getDateMaintenance());
			System.out.println("Manu executada: " + maintenance.getPerformedMaintenance());
			System.out.println("Próxima Manu: " + maintenance.getNextMaintenance());
			System.out.println("Tempo disponível: " + maintenance.getAvailableTime());
			System.out.println("Obs: " + maintenance.getObs());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		MaintenanceDAO maintenanceDAO = new MaintenanceDAO();
		Maintenance maintenance = maintenanceDAO.buscar(codigo);

		if (maintenance == null) {
			System.out.println("Nenhuma manutenção encontrada.");
		} else {
			System.out.println("OS: " + maintenance.getServiceOrder());
			System.out.println("Aeronave: " + maintenance.getAircraft().getIcaoRegistry());
			System.out.println("Data: " + maintenance.getDateMaintenance());
			System.out.println("Manu executada: " + maintenance.getPerformedMaintenance());
			System.out.println("Próxima Manu: " + maintenance.getNextMaintenance());
			System.out.println("Tempo disponível: " + maintenance.getAvailableTime());
			System.out.println("Obs: " + maintenance.getObs());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 3L;
		MaintenanceDAO maintenanceDAO = new MaintenanceDAO();
		Maintenance maintenance = maintenanceDAO.buscar(codigo);

		if (maintenance == null) {
			System.out.println("Nenhuma manutenção excluida.");
		} else {
			maintenanceDAO.excluir(maintenance);
			System.out.println("Manutenção excluida:");
			System.out.println("OS: " + maintenance.getServiceOrder());
			System.out.println("Aeronave: " + maintenance.getAircraft().getIcaoRegistry());
			System.out.println("Data: " + maintenance.getDateMaintenance());
			System.out.println("Manu executada: " + maintenance.getPerformedMaintenance());
			System.out.println("Próxima Manu: " + maintenance.getNextMaintenance());
			System.out.println("Tempo disponível: " + maintenance.getAvailableTime());
			System.out.println("Obs: " + maintenance.getObs());
		}
	}
	
	@Test
	@Ignore
	public void editar() throws ParseException{
		
		Long codigoAeronave = 2L;
		AircraftDAO aircraftDAO = new AircraftDAO();
		Aircraft aircraft = aircraftDAO.buscar(codigoAeronave);
		
		Long codigo = 1L;
		MaintenanceDAO maintenanceDAO = new MaintenanceDAO();
		Maintenance maintenance = maintenanceDAO.buscar(codigo);
		
		if (maintenance == null) {
			System.out.println("Nenhuma manutenção encontrada.");
		} else {
			System.out.println("Manu editada - Antes:");
			System.out.println("OS: " + maintenance.getServiceOrder());
			System.out.println("Aeronave: " + maintenance.getAircraft().getIcaoRegistry());
			System.out.println("Data: " + maintenance.getDateMaintenance());
			System.out.println("Manu executada: " + maintenance.getPerformedMaintenance());
			System.out.println("Próxima Manu: " + maintenance.getNextMaintenance());
			System.out.println("Tempo disponível: " + maintenance.getAvailableTime());
			System.out.println("Obs: " + maintenance.getObs());
			
			maintenance.setServiceOrder("Teste");
			maintenance.setAircraft(aircraft);
			maintenance.setDateMaintenance(new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2017"));
			maintenance.setPerformedMaintenance("100");
			maintenance.setNextMaintenance("50");
			maintenance.setAvailableTime(new BigDecimal("10"));
			maintenance.setObs("Trocou velas.");
			maintenanceDAO.editar(maintenance);
			
			System.out.println("Manu editada - Depois:");
			System.out.println("OS: " + maintenance.getServiceOrder());
			System.out.println("Aeronave: " + maintenance.getAircraft().getIcaoRegistry());
			System.out.println("Data: " + maintenance.getDateMaintenance());
			System.out.println("Manu executada: " + maintenance.getPerformedMaintenance());
			System.out.println("Próxima Manu: " + maintenance.getNextMaintenance());
			System.out.println("Tempo disponível: " + maintenance.getAvailableTime());
			System.out.println("Obs: " + maintenance.getObs());
		}
	}
}
