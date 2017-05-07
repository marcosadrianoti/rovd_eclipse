package br.com.ciacpla.rovdigital.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.ciacpla.rovdigital.entity.CategoryAircraft;

public class CategoryAircraftDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		CategoryAircraft categoria = new CategoryAircraft();
		categoria.setCategory("MLTE");

		CategoryAircraftDAO categoryAircraftDAO = new CategoryAircraftDAO();
		categoryAircraftDAO.salvar(categoria);
	}
	
	@Test
	@Ignore
	public void listar() {
		CategoryAircraftDAO categoryAircraftDAO = new CategoryAircraftDAO();
		List<CategoryAircraft> resultado = categoryAircraftDAO.listar();

		System.out.println("Encontrados: " + resultado.size());
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		CategoryAircraftDAO categoryAircraftDAO = new CategoryAircraftDAO();
		CategoryAircraft categoria = categoryAircraftDAO.buscar(codigo);

		if (categoria == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println(categoria.getCodigo() + " - " + categoria.getCategory());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 3L;
		CategoryAircraftDAO categoryAircraftDAO = new CategoryAircraftDAO();
		CategoryAircraft categoria = categoryAircraftDAO.buscar(codigo);

		if (categoria == null) {
			System.out.println("Nenhum registro excluido.");
		} else {
			categoryAircraftDAO.excluir(categoria);
			System.out.println("Registro excluido:");
			System.out.println(categoria.getCodigo() + " - " + categoria.getCategory());
		}
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 4L;
		CategoryAircraftDAO categoryAircraftDAO = new CategoryAircraftDAO();
		CategoryAircraft categoria = categoryAircraftDAO.buscar(codigo);
		
		if (categoria == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Registro editado - antes:");
			System.out.println(categoria.getCodigo() + " - " + categoria.getCategory());
			
			categoria.setCategory("TEST");
			categoryAircraftDAO.editar(categoria);
			
			System.out.println("Registro editado - depois:");
			System.out.println(categoria.getCodigo() + " - " + categoria.getCategory());
		}
	}
}
