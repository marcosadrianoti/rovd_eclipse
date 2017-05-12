package br.com.ciacpla.rovdigital.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity //indica que é uma entidade do hibernate para gerar tabela.
public class Lesson extends GenericEntity{
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
    private Date date;
	
	@ManyToOne //Marcação de relacionamento feito na classe filha.
	@JoinColumn(nullable = false) //Personalizar colunas de chaves estrangeiras. true = agregação, false = composição.
	private Pilot teacher;
	
	@ManyToOne //Marcação de relacionamento feito na classe filha.
	@JoinColumn(nullable = false) //Personalizar colunas de chaves estrangeiras. true = agregação, false = composição.
	private Pilot Student;
	
	@Column(precision=3, scale=1, nullable=false)
    private BigDecimal groundSchool;
	
	@Column(precision=3, scale=1, nullable=false)
	private BigDecimal theoreticalCourse;
    
	@Column(length=50, nullable=false)
    private String subject;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Pilot getTeacher() {
		return teacher;
	}

	public void setTeacher(Pilot teacher) {
		this.teacher = teacher;
	}

	public Pilot getStudent() {
		return Student;
	}

	public void setStudent(Pilot student) {
		Student = student;
	}

	public BigDecimal getGroundSchool() {
		return groundSchool;
	}

	public void setGroundSchool(BigDecimal groundSchool) {
		this.groundSchool = groundSchool;
	}

	public BigDecimal getTheoreticalCourse() {
		return theoreticalCourse;
	}

	public void setTheoreticalCourse(BigDecimal theoreticalCourse) {
		this.theoreticalCourse = theoreticalCourse;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
