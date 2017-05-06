package br.com.ciacpla.rovdigital.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial") //Anotação do java para ignorar avisos do tipo serial.
@MappedSuperclass //Indica que não será usado para formar tabala.
public class GenericEntity implements Serializable{ //é uma classe de apoio para gerar chaves em outras classes.
	
	@Id //Indica que é uma chave primária.
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Gerar a chave autoincrementada.
	private Long codigo;
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
}
