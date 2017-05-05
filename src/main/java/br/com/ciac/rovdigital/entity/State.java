package br.com.ciac.rovdigital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity //indica que é uma entidade do hibernate para gerar tabela.
public class State extends EntidadeGenerica{ //herdou a chave primaria.
	
	@Column(length = 2, nullable = false)
	private String acronym;
	
	@Column(length = 50, nullable = false)
	private String name;

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
}
