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
public class RodRecord extends GenericEntity{
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column()
	@Temporal(TemporalType.TIME)
	private Date startTime;

	@Column()
	@Temporal(TemporalType.TIME)
	private Date finalTime;

	@Column(precision=3, scale=1, nullable=false)
	private BigDecimal totalTime;
	
	@Column(precision=3, scale=1)
	private BigDecimal startTac;

	@Column(precision=3, scale=1)
	private BigDecimal finalTac;
	
	@Column(precision=3, scale=1, nullable=false)
	private BigDecimal totalTac;

	@Column(nullable=false)
	private Integer landings;

	@Column(length=10)
	private String mission;
	
	@ManyToOne //Marcação de relacionamento feito na classe filha.
	@JoinColumn(nullable = false) //Personalizar colunas de chaves estrangeiras. true = agregação, false = composição.
	private Pilot pilot1;

	@ManyToOne //Marcação de relacionamento feito na classe filha.
	@JoinColumn(nullable = true) //Personalizar colunas de chaves estrangeiras. true = agregação, false = composição.
	private Pilot pilot2;
	
	@Column(length=100)
	private String obs;
	
	@ManyToOne //Marcação de relacionamento feito na classe filha.
	@JoinColumn(nullable = true) //Personalizar colunas de chaves estrangeiras. true = agregação, false = composição.
	private User userCrossChecked;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getFinalTime() {
		return finalTime;
	}

	public void setFinalTime(Date finalTime) {
		this.finalTime = finalTime;
	}

	public BigDecimal getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(BigDecimal totalTime) {
		this.totalTime = totalTime;
	}

	public BigDecimal getStartTac() {
		return startTac;
	}

	public void setStartTac(BigDecimal statTac) {
		this.startTac = statTac;
	}

	public BigDecimal getFinalTac() {
		return finalTac;
	}

	public void setFinalTac(BigDecimal finalTac) {
		this.finalTac = finalTac;
	}

	public BigDecimal getTotalTac() {
		return totalTac;
	}

	public void setTotalTac(BigDecimal totalTac) {
		this.totalTac = totalTac;
	}

	public Integer getLandings() {
		return landings;
	}

	public void setLandings(Integer landings) {
		this.landings = landings;
	}

	public String getMission() {
		return mission;
	}

	public void setMission(String mission) {
		this.mission = mission;
	}

	public Pilot getPilot1() {
		return pilot1;
	}

	public void setPilot1(Pilot pilot1) {
		this.pilot1 = pilot1;
	}

	public Pilot getPilot2() {
		return pilot2;
	}

	public void setPilot2(Pilot pilot2) {
		this.pilot2 = pilot2;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public User getUserCrossChecked() {
		return userCrossChecked;
	}

	public void setUserCrossChecked(User userCrossChecked) {
		this.userCrossChecked = userCrossChecked;
	}
	
}
