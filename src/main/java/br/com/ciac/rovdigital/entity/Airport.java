package br.com.ciac.rovdigital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity //indica que é uma entidade do hibernate para gerar tabela.
public class Airport  extends EntidadeGenerica{
	
	@Column(length = 4, nullable = false) //Personalizar colunas
	private String icaoCode;
	
	@Column(length = 15, nullable = false) //Personalizar colunas
	private String city;
	
	@ManyToOne //Marcação de relacionamento feito na classe filha.
	@JoinColumn(nullable = false) //Personalizar colunas de chaves estrangeiras. true = agregação, false = composição.
	private State state;

	public String getIcaoCode() {
		return icaoCode;
	}

	public void setIcaoCode(String icaoCode) {
		this.icaoCode = icaoCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
}
