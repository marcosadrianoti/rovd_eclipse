package br.com.ciacpla.rovdigital.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.ciacpla.rovdigital.entity.Pilot;

public class PilotDAOTest {

	@Test
	@Ignore
	public void salvar() throws ParseException {

		Pilot piloto = new Pilot();

		piloto.setName("Piloto teste2");
		piloto.setCanac("987654");
		piloto.setEmail("pilototeste2@hotmail.com");
		piloto.setFoneWhatsapp("62992535292");
		piloto.setCmaClass("2");
		piloto.setCmaValidity(new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2019"));
		piloto.setPpaLicense("128764");
		piloto.setPcaLicense("876456");
		// piloto.setPlaLicense("");
		piloto.setMnteValidity(new SimpleDateFormat("dd/MM/yyyy").parse("10/08/2020"));
		piloto.setMlteValidity(new SimpleDateFormat("dd/MM/yyyy").parse("03/04/2019"));
		piloto.setIfraValidity(new SimpleDateFormat("dd/MM/yyyy").parse("14/02/2017"));
		piloto.setInvaValidity(new SimpleDateFormat("dd/MM/yyyy").parse("17/01/2020"));
		piloto.setStudent(true);
		piloto.setInvaFliesAtSchool(false);
		piloto.setBank("itau");
		piloto.setAccount("543-5");
		piloto.setAgency("0874-9");
		piloto.setCpf("32145258720");

		PilotDAO pilotDAO = new PilotDAO();
		pilotDAO.salvar(piloto);
	}

	@Test
	@Ignore
	public void listar() {
		PilotDAO pilotDAO = new PilotDAO();
		List<Pilot> listaDePilotos = pilotDAO.listar();

		System.out.println("Encontrados: " + listaDePilotos.size());
		
		for(Pilot pilot : listaDePilotos){
		System.out.println("Nome: " + pilot.getName() + " - Canac: " + pilot.getCanac());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		PilotDAO pilotDAO = new PilotDAO();
		Pilot pilot = pilotDAO.buscar(codigo);

		if (pilot == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println(pilot.getCodigo() + " - " + pilot.getName());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 2L;
		PilotDAO pilotDAO = new PilotDAO();
		Pilot pilot = pilotDAO.buscar(codigo);

		if (pilot == null) {
			System.out.println("Nenhum piloto excluido.");
		} else {
			pilotDAO.excluir(pilot);
			System.out.println("Piloto excluido:");
			System.out.println(pilot.getCodigo() + " - " + pilot.getName());
		}
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 3L;
		PilotDAO pilotDAO = new PilotDAO();
		Pilot pilot = pilotDAO.buscar(codigo);
		
		if (pilot == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Piloto editado - Antes:");
			System.out.println(pilot.getCodigo() + " - " + pilot.getName()
			+ " - " + pilot.getBank());
			
			pilot.setName("Pilot teste 2");
			pilot.setBank("Itaú");
			pilotDAO.editar(pilot);
			
			System.out.println("Piloto editado - Depois:");
			System.out.println(pilot.getCodigo() + " - " + pilot.getName()
			+ " - " + pilot.getBank());
		}
	}
}
