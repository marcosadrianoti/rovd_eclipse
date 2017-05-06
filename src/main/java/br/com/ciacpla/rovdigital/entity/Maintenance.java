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
public class Maintenance extends GenericEntity{
	
	@Column(length=6, nullable=false)
	private String serviceOrder;
	
	@ManyToOne
	@JoinColumn(nullable=false)
    private Aircraft aircraft;
	
	@Column
	@Temporal(TemporalType.DATE)
    private Date dateMaintenance;
	
	@Column(length=4, nullable=false)
    private String performedMaintenance;
	
	@Column(length=4, nullable=false)
    private String nextMaintenance;

	@Column(precision=3, scale=1, nullable=false)
	private BigDecimal availableTime;
	
	@Column(length=100)
    private String obs;

	public String getServiceOrder() {
		return serviceOrder;
	}

	public void setServiceOrder(String serviceOrder) {
		this.serviceOrder = serviceOrder;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public Date getDateMaintenance() {
		return dateMaintenance;
	}

	public void setDateMaintenance(Date dateMaintenance) {
		this.dateMaintenance = dateMaintenance;
	}

	public String getPerformedMaintenance() {
		return performedMaintenance;
	}

	public void setPerformedMaintenance(String performedMaintenance) {
		this.performedMaintenance = performedMaintenance;
	}

	public String getNextMaintenance() {
		return nextMaintenance;
	}

	public void setNextMaintenance(String nextMaintenance) {
		this.nextMaintenance = nextMaintenance;
	}

	public BigDecimal getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(BigDecimal availableTime) {
		this.availableTime = availableTime;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
}
