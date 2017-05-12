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
@Entity
public class HoursPack extends GenericEntity{
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne //Marcação de relacionamento feito na classe filha.
	@JoinColumn(nullable = false) //Personalizar colunas de chaves estrangeiras. true = agregação, false = composição.
	private Pilot pilot;
	
	@ManyToOne //Marcação de relacionamento feito na classe filha.
	@JoinColumn(nullable = false) //Personalizar colunas de chaves estrangeiras. true = agregação, false = composição.
	private CategoryAircraft categoryAircraft;
	
	@Column(precision=4, scale=1, nullable=false)
    private BigDecimal amountHours;
	
	@Column(precision=4, scale=1, nullable=false)
    private BigDecimal currentBalance;

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public BigDecimal getAmountHours() {
		return amountHours;
	}

	public void setAmountHours(BigDecimal amountHours) {
		this.amountHours = amountHours;
	}

	public CategoryAircraft getCategoryAircraft() {
		return categoryAircraft;
	}

	public void setCategoryAircraft(CategoryAircraft categoryAircraft) {
		this.categoryAircraft = categoryAircraft;
	}

	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}
	
}
