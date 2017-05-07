package br.com.ciacpla.rovdigital.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.ciacpla.rovdigital.entity.CategoryAircraft;
import br.com.ciacpla.rovdigital.entity.HoursPack;
import br.com.ciacpla.rovdigital.entity.Pilot;

public class HoursPackDAOTest {
	
	@Test
	@Ignore
	public void salvar() throws ParseException {
		
		Long codigoPiloto = 1L;
		PilotDAO pilotDAO = new PilotDAO();
		Pilot pilot = pilotDAO.buscar(codigoPiloto);
		
		Long codigoCategoria = 1L;
		CategoryAircraftDAO categoryAircraftDAO = new CategoryAircraftDAO();
		CategoryAircraft categoryAircraft = categoryAircraftDAO.buscar(codigoCategoria);
		
		HoursPack hoursPack = new HoursPack();

		hoursPack.setPilot(pilot);;
		hoursPack.setAmountHours(new BigDecimal("8.5"));
		hoursPack.setCategoryAircraft(categoryAircraft);
		hoursPack.setCurrentBalance(new BigDecimal("31.5"));

		HoursPackDAO hoursPackDAO = new HoursPackDAO();
		hoursPackDAO.salvar(hoursPack);
	}
	
	@Test
	@Ignore
	public void listar() {
		
		HoursPackDAO hoursPackDAO = new HoursPackDAO();
		List<HoursPack> listaDePacotes = hoursPackDAO.listar();

		System.out.println("Encontrados: " + listaDePacotes.size());
		
		for(HoursPack hoursPack : listaDePacotes){
		System.out.println("Piloto: " + hoursPack.getPilot().getName());
		System.out.println("Pacote: " + hoursPack.getAmountHours());
		System.out.println("Saldo: " + hoursPack.getCurrentBalance());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 2L;
		HoursPackDAO hoursPackDAO = new HoursPackDAO();
		HoursPack hoursPack = hoursPackDAO.buscar(codigo);

		if (hoursPack == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Piloto: " + hoursPack.getPilot().getName());
			System.out.println("Pacote: " + hoursPack.getAmountHours());
			System.out.println("Saldo: " + hoursPack.getCurrentBalance());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 2L;
		HoursPackDAO hoursPackDAO = new HoursPackDAO();
		HoursPack hoursPack = hoursPackDAO.buscar(codigo);

		if (hoursPack == null) {
			System.out.println("Nenhum piloto excluido.");
		} else {
			hoursPackDAO.excluir(hoursPack);
			System.out.println("Pacote excluido:");
			System.out.println("Piloto: " + hoursPack.getPilot().getName());
			System.out.println("Pacote: " + hoursPack.getAmountHours());
			System.out.println("Saldo: " + hoursPack.getCurrentBalance());
		}
	}
	
	@Test
	@Ignore
	public void editar(){
		
		Long codigoPiloto = 1L;
		PilotDAO pilotDAO = new PilotDAO();
		Pilot pilot = pilotDAO.buscar(codigoPiloto);
		
		Long codigoCategoria = 1L;
		CategoryAircraftDAO categoryAircraftDAO = new CategoryAircraftDAO();
		CategoryAircraft categoryAircraft = categoryAircraftDAO.buscar(codigoCategoria);
		
		Long codigo = 1L;
		HoursPackDAO hoursPackDAO = new HoursPackDAO();
		HoursPack hoursPack = hoursPackDAO.buscar(codigo);
		
		if (hoursPack == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Pacote editado - Antes:");
			System.out.println("Piloto: " + hoursPack.getPilot().getName());
			System.out.println("Categoria: " + hoursPack.getCategoryAircraft().getCategory());
			System.out.println("Pacote: " + hoursPack.getAmountHours());
			System.out.println("Saldo: " + hoursPack.getCurrentBalance());
			
			hoursPack.setPilot(pilot);
			hoursPack.setCategoryAircraft(categoryAircraft);
			hoursPack.setAmountHours(new BigDecimal("20.0"));
			hoursPack.setCurrentBalance(new BigDecimal("45.1"));
			hoursPackDAO.editar(hoursPack);
			
			System.out.println("Pacote editado - Depois:");
			System.out.println("Piloto: " + hoursPack.getPilot().getName());
			System.out.println("Categoria: " + hoursPack.getCategoryAircraft().getCategory());
			System.out.println("Pacote: " + hoursPack.getAmountHours());
			System.out.println("Saldo: " + hoursPack.getCurrentBalance());
		}
	}
}
