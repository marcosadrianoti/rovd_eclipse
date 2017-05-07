package br.com.ciacpla.rovdigital.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.ciacpla.rovdigital.entity.Lesson;
import br.com.ciacpla.rovdigital.entity.Pilot;

public class LessonDAOTest {

	@Test
	@Ignore
	public void salvar() throws ParseException {

		Long codigoPiloto = 2L;
		PilotDAO pilotDAO = new PilotDAO();
		Pilot pilot = pilotDAO.buscar(codigoPiloto);

		Lesson lesson = new Lesson();

		lesson.setTeacher(pilot);
		lesson.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2019"));
		lesson.setTime(new BigDecimal("5"));
		lesson.setTheoreticalCourse(true);
		lesson.setGroundSchool(false);
		lesson.setSubject("Apenas um teste2");

		LessonDAO lessonDAO = new LessonDAO();
		lessonDAO.salvar(lesson);
	}

	@Test
	@Ignore
	public void listar() {

		LessonDAO lessonDAO = new LessonDAO();
		List<Lesson> listaDeAulas = lessonDAO.listar();

		System.out.println("Encontrados: " + listaDeAulas.size());

		for (Lesson lesson : listaDeAulas) {
			System.out.println("Professor: " + lesson.getTeacher().getName());
			System.out.println("Data: " + lesson.getDate());
			System.out.println("Tempo: " + lesson.getTime());
			System.out.println("Teórica: " + lesson.isTheoreticalCourse());
			System.out.println("Ground: " + lesson.isGroundSchool());
			System.out.println("Assunto: " + lesson.getSubject());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 2L;
		LessonDAO lessonDAO = new LessonDAO();
		Lesson lesson = lessonDAO.buscar(codigo);

		if (lesson == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Professor: " + lesson.getTeacher().getName());
			System.out.println("Data: " + lesson.getDate());
			System.out.println("Tempo: " + lesson.getTime());
			System.out.println("Teórica: " + lesson.isTheoreticalCourse());
			System.out.println("Ground: " + lesson.isGroundSchool());
			System.out.println("Assunto: " + lesson.getSubject());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 2L;
		LessonDAO lessonDAO = new LessonDAO();
		Lesson lesson = lessonDAO.buscar(codigo);

		if (lesson == null) {
			System.out.println("Nenhuma aula excluida.");
		} else {
			lessonDAO.excluir(lesson);
			System.out.println("Aula excluida:");
			System.out.println("Professor: " + lesson.getTeacher().getName());
			System.out.println("Data: " + lesson.getDate());
			System.out.println("Tempo: " + lesson.getTime());
			System.out.println("Teórica: " + lesson.isTheoreticalCourse());
			System.out.println("Ground: " + lesson.isGroundSchool());
			System.out.println("Assunto: " + lesson.getSubject());
		}
	}
	
	@Test
	@Ignore
	public void editar() throws ParseException{
		
		Long codigoPiloto = 1L;
		PilotDAO pilotDAO = new PilotDAO();
		Pilot pilot = pilotDAO.buscar(codigoPiloto);
		
		Long codigo = 1L;
		LessonDAO lessonDAO = new LessonDAO();
		Lesson lesson = lessonDAO.buscar(codigo);
		
		if (lesson == null) {
			System.out.println("Nenhuma aula encontrada.");
		} else {
			System.out.println("Aula editado - Antes:");
			System.out.println("Professor: " + lesson.getTeacher().getName());
			System.out.println("Data: " + lesson.getDate());
			System.out.println("Tempo: " + lesson.getTime());
			System.out.println("Teórica: " + lesson.isTheoreticalCourse());
			System.out.println("Ground: " + lesson.isGroundSchool());
			System.out.println("Assunto: " + lesson.getSubject());
			
			lesson.setTeacher(pilot);
			lesson.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("10/08/2018"));
			lesson.setTime(new BigDecimal("2.0"));
			lesson.setTheoreticalCourse(false);
			lesson.setGroundSchool(true);
			lesson.setSubject("Qual o assunto?");
			lessonDAO.editar(lesson);
			
			System.out.println("Depois editado - Depois:");
			System.out.println("Professor: " + lesson.getTeacher().getName());
			System.out.println("Data: " + lesson.getDate());
			System.out.println("Tempo: " + lesson.getTime());
			System.out.println("Teórica: " + lesson.isTheoreticalCourse());
			System.out.println("Ground: " + lesson.isGroundSchool());
			System.out.println("Assunto: " + lesson.getSubject());
		}
	}
}
