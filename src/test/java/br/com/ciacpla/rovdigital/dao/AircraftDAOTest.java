package br.com.ciacpla.rovdigital.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.ciacpla.rovdigital.entity.Aircraft;
import br.com.ciacpla.rovdigital.entity.CategoryAircraft;

public class AircraftDAOTest {
	
	@Test
	@Ignore
	public void salvar() throws ParseException {

		Long codigoCategoria = 1L;
		CategoryAircraftDAO categoryAircraftDAO = new CategoryAircraftDAO();
		CategoryAircraft categoryAircraft = categoryAircraftDAO.buscar(codigoCategoria);

		Aircraft aircraft= new Aircraft();

		aircraft.setIcaoRegistry("teste");
		aircraft.setManufacturer("PIPER");
		aircraft.setAircraftCode("PA34");
		aircraft.setCategory(categoryAircraft);
		aircraft.setSerialNumber("543.123");
		aircraft.setYearManufacture(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1983"));
		aircraft.setIamDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2019"));
		aircraft.setTsnAirframe(new BigDecimal("33.3"));
		aircraft.setTsnPowerPlant(new BigDecimal("22.3"));
		aircraft.setTsnPropeller(new BigDecimal("456.3"));

		AircraftDAO aircraftDAO = new AircraftDAO();
		aircraftDAO.salvar(aircraft);
	}
	
	@Test
	@Ignore
	public void listar() {

		AircraftDAO aircraftDAO = new AircraftDAO();
		List<Aircraft> listaDeAeronaves = aircraftDAO.listar();

		System.out.println("Encontrados: " + listaDeAeronaves.size());

		for (Aircraft aircraft : listaDeAeronaves) {
			System.out.println("Marca: " + aircraft.getIcaoRegistry());
			System.out.println("Fabricante: " + aircraft.getManufacturer());
			System.out.println("Categoria: " + aircraft.getCategory().getCategory()); 
			System.out.println("Serial: " + aircraft.getSerialNumber());
			System.out.println("Ano de fabricação: " + aircraft.getYearManufacture());
			System.out.println("IAM: " + aircraft.getIamDate());
			System.out.println("TSN celula: " + aircraft.getTsnAirframe());
			System.out.println("TSN motor: " + aircraft.getTsnPowerPlant());
			System.out.println("TSN hélice: " + aircraft.getTsnPropeller());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		AircraftDAO aircraftDAO = new AircraftDAO();
		Aircraft aircraft = aircraftDAO.buscar(codigo);

		if (aircraft == null) {
			System.out.println("Nenhuma aeronave encontrada.");
		} else {
			System.out.println("Marca: " + aircraft.getIcaoRegistry());
			System.out.println("Fabricante: " + aircraft.getManufacturer());
			System.out.println("Categoria: " + aircraft.getCategory().getCategory()); 
			System.out.println("Serial: " + aircraft.getSerialNumber());
			System.out.println("Ano de fabricação: " + aircraft.getYearManufacture());
			System.out.println("IAM: " + aircraft.getIamDate());
			System.out.println("TSN celula: " + aircraft.getTsnAirframe());
			System.out.println("TSN motor: " + aircraft.getTsnPowerPlant());
			System.out.println("TSN hélice: " + aircraft.getTsnPropeller());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 3L;
		AircraftDAO aircraftDAO = new AircraftDAO();
		Aircraft aircraft = aircraftDAO.buscar(codigo);

		if (aircraft == null) {
			System.out.println("Nenhuma aeronave excluida.");
		} else {
			aircraftDAO.excluir(aircraft);
			System.out.println("Marca: " + aircraft.getIcaoRegistry());
			System.out.println("Fabricante: " + aircraft.getManufacturer());
			System.out.println("Categoria: " + aircraft.getCategory().getCategory()); 
			System.out.println("Serial: " + aircraft.getSerialNumber());
			System.out.println("Ano de fabricação: " + aircraft.getYearManufacture());
			System.out.println("IAM: " + aircraft.getIamDate());
			System.out.println("TSN celula: " + aircraft.getTsnAirframe());
			System.out.println("TSN motor: " + aircraft.getTsnPowerPlant());
			System.out.println("TSN hélice: " + aircraft.getTsnPropeller());
		}
	}
	
	@Test
	@Ignore
	public void editar() throws ParseException{
		
		Long codigoCategoria = 1L;
		CategoryAircraftDAO categoryAircraftDAO = new CategoryAircraftDAO();
		CategoryAircraft categoryAircraft = categoryAircraftDAO.buscar(codigoCategoria);
		
		Long codigo = 1L;
		AircraftDAO aircraftDAO = new AircraftDAO();
		Aircraft aircraft = aircraftDAO.buscar(codigo);
		
		if (aircraft == null) {
			System.out.println("Nenhuma aeronave encontrada.");
		} else {
			System.out.println("Aeronave editada - Antes:");
			System.out.println("Marca: " + aircraft.getIcaoRegistry());
			System.out.println("Fabricante: " + aircraft.getManufacturer());
			System.out.println("Categoria: " + aircraft.getCategory().getCategory()); 
			System.out.println("Serial: " + aircraft.getSerialNumber());
			System.out.println("Ano de fabricação: " + aircraft.getYearManufacture());
			System.out.println("IAM: " + aircraft.getIamDate());
			System.out.println("TSN celula: " + aircraft.getTsnAirframe());
			System.out.println("TSN motor: " + aircraft.getTsnPowerPlant());
			System.out.println("TSN hélice: " + aircraft.getTsnPropeller());
			
			aircraft.setCategory(categoryAircraft);
			
			aircraftDAO.editar(aircraft);
			
			System.out.println("Aeronave editada - Depois:");
			System.out.println("Marca: " + aircraft.getIcaoRegistry());
			System.out.println("Fabricante: " + aircraft.getManufacturer());
			System.out.println("Categoria: " + aircraft.getCategory().getCategory()); 
			System.out.println("Serial: " + aircraft.getSerialNumber());
			System.out.println("Ano de fabricação: " + aircraft.getYearManufacture());
			System.out.println("IAM: " + aircraft.getIamDate());
			System.out.println("TSN celula: " + aircraft.getTsnAirframe());
			System.out.println("TSN motor: " + aircraft.getTsnPowerPlant());
			System.out.println("TSN hélice: " + aircraft.getTsnPropeller());
		}
	}
}
