package br.com.ciac.rovdigital.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial") //Anotação do java para ignorar avisos do tipo serial.
@MappedSuperclass //Indica que não será usado para formar tabala.
public class EntidadeGenerica implements Serializable{ //é uma classe de apoio para gerar chaves em outras classes.
	
	@Id //Indica que é uma chave primária.
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Gerar a chave autoincrementada.
	private Integer codigo;
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
}
