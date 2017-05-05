package br.com.ciac.rovdigital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class HoursPack extends EntidadeGenerica{
	
	@ManyToOne //Marcação de relacionamento feito na classe filha.
	@JoinColumn(nullable = false) //Personalizar colunas de chaves estrangeiras. true = agregação, false = composição.
	private Pilot pilot;
	
	@Column(precision=3, scale=1, nullable=false)
    private float amountHours;
	
	@ManyToOne //Marcação de relacionamento feito na classe filha.
	@JoinColumn(nullable = false) //Personalizar colunas de chaves estrangeiras. true = agregação, false = composição.
    private CategoryAircraft categoryAircraft;
	
	@Column(precision=3, scale=1, nullable=false)
    private float currentBalance;
}
