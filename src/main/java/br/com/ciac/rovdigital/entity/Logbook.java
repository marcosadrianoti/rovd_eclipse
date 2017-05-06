package br.com.ciac.rovdigital.entity;

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
public class Logbook extends EntidadeGenerica{
	
	@Column(length=10, nullable=false)
	private String numberLogbook;
	
	@ManyToOne
	@JoinColumn(nullable=false)
    private Aircraft aircraft;
	
	@Column(precision=6, scale=1, nullable=false)
    private BigDecimal startTotalTime;
	
	@Column
	@Temporal(TemporalType.DATE)
    private Date startDate;
	
	@Column(precision=6, scale=1)
    private BigDecimal finalTotalTime;
	
	@Column
	@Temporal(TemporalType.DATE)
    private Date finalDate;

	public String getNumberLogbook() {
		return numberLogbook;
	}

	public void setNumberLogbook(String numberLogbook) {
		this.numberLogbook = numberLogbook;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public BigDecimal getStartTotalTime() {
		return startTotalTime;
	}

	public void setStartTotalTime(BigDecimal startTotalTime) {
		this.startTotalTime = startTotalTime;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public BigDecimal getFinalTotalTime() {
		return finalTotalTime;
	}

	public void setFinalTotalTime(BigDecimal finalTotalTime) {
		this.finalTotalTime = finalTotalTime;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}
	
}
