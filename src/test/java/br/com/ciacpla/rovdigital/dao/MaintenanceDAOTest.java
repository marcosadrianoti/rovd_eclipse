package br.com.ciacpla.rovdigital.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Ignore;
import org.junit.Test;

import br.com.ciacpla.rovdigital.entity.Aircraft;
import br.com.ciacpla.rovdigital.entity.Maintenance;

public class MaintenanceDAOTest {

	@Test
	@Ignore
	public void salvar() throws ParseException {

		Long codigoAeronave = 2L;
		AircraftDAO aircraftDAO = new AircraftDAO();
		Aircraft aircraft = aircraftDAO.buscar(codigoAeronave);

		Maintenance maintenance = new Maintenance();

		maintenance.setServiceOrder("os01");
		maintenance.setAircraft(aircraft);
		maintenance.setDateMaintenance(new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2017"));
		maintenance.setPerformedMaintenance("50");
		maintenance.setNextMaintenance("100");
		maintenance.setAvailableTime(new BigDecimal("10"));
		maintenance.setObs("Nenhuma ocorrência na manutenção.");

		MaintenanceDAO maintenanceDAO = new MaintenanceDAO();
		maintenanceDAO.salvar(maintenance);
	}
}
