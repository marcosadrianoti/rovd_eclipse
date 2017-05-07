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
    
	@ManyToOne //Marcação de relacionamento feito na classe filha.
	@JoinColumn(nullable = false) //Personalizar colunas de chaves estrangeiras. true = agregação, false = composição.
	private Pilot teacher;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
    private Date date;
	
	@Column(precision=3, scale=1, nullable=false)
    private BigDecimal time;
    
	@Column(nullable = false)
    private boolean theoreticalCourse;
	
	@Column(nullable = false)
    private boolean groundSchool;
	
	@Column(length=50, nullable=false)
    private String subject;

	public Pilot getTeacher() {
		return teacher;
	}

	public void setTeacher(Pilot teacher) {
		this.teacher = teacher;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getTime() {
		return time;
	}

	public void setTime(BigDecimal time) {
		this.time = time;
	}

	public boolean isTheoreticalCourse() {
		return theoreticalCourse;
	}

	public void setTheoreticalCourse(boolean theoreticalCourse) {
		this.theoreticalCourse = theoreticalCourse;
	}

	public boolean isGroundSchool() {
		return groundSchool;
	}

	public void setGroundSchool(boolean groundSchool) {
		this.groundSchool = groundSchool;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}
