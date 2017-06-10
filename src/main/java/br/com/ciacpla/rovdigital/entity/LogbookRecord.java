package br.com.ciacpla.rovdigital.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class LogbookRecord extends GenericEntity{
	
	@OneToOne
	@JoinColumn(nullable=false)
	private Logbook logbook;
	
    @Column(length=2, nullable=false)
	private String pageLogbook;
    
    @ManyToOne
	@JoinColumn(nullable=false)
    private Aircraft aircraft;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @ManyToOne
    @JoinColumn(nullable=false)
    private Airport from;
    
    @ManyToOne
    @JoinColumn(nullable=false)
    private Airport to;
    
    @Column()
	@Temporal(TemporalType.TIME)
	private Date startTime;

	@Column()
	@Temporal(TemporalType.TIME)
	private Date finalTime;
	
	@Column(precision=3, scale=1, nullable=false)
	private BigDecimal totalTime;
	
	@Column(precision=3, scale=1, nullable=false)
	private BigDecimal totalTac;
    
    @Column(precision=3, scale=1)
    private BigDecimal dayTime;
    
    @Column(precision=3, scale=1)
    private BigDecimal nigthTime;
    
    @Column(precision=3, scale=1)
    private BigDecimal vfrTime;
    
    @Column(precision=3, scale=1)
    private BigDecimal ifrrTime;
    
    @Column(precision=3, scale=1)
    private BigDecimal ifrcTime;
    
    @Column(nullable=false)
    private Integer landings;
    
    @Column(length=2, nullable=false)
    private String nat;
    
    @ManyToOne //Marcação de relacionamento feito na classe filha.
    @JoinColumn(nullable = false) //Personalizar colunas de chaves estrangeiras. true = agregação, false = composição.
    private Pilot pilot1;
    
    @ManyToOne //Marcação de relacionamento feito na classe filha.
    @JoinColumn(nullable = true) //Personalizar colunas de chaves estrangeiras. true = agregação, false = composição.
    private Pilot pilot2;
    
    @Column(nullable=false)
    private boolean solo;
    
    @Column(length=100)
    private String obs;
    
    @ManyToOne //Marcação de relacionamento feito na classe filha.
	@JoinColumn(nullable = true) //Personalizar colunas de chaves estrangeiras. true = agregação, false = composição.
	private User userCrossChecked;

	public Logbook getLogbook() {
		return logbook;
	}

	public void setLogbook(Logbook logbook) {
		this.logbook = logbook;
	}

	public String getPageLogbook() {
		return pageLogbook;
	}

	public void setPageLogbook(String pageLogbook) {
		this.pageLogbook = pageLogbook;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public Airport getFrom() {
		return from;
	}

	public void setFrom(Airport from) {
		this.from = from;
	}

	public Airport getTo() {
		return to;
	}

	public void setTo(Airport to) {
		this.to = to;
	}

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

	public BigDecimal getTotalTac() {
		return totalTac;
	}

	public void setTotalTac(BigDecimal totalTac) {
		this.totalTac = totalTac;
	}

	public BigDecimal getDayTime() {
		return dayTime;
	}

	public void setDayTime(BigDecimal dayTime) {
		this.dayTime = dayTime;
	}

	public BigDecimal getNigthTime() {
		return nigthTime;
	}

	public void setNigthTime(BigDecimal nigthTime) {
		this.nigthTime = nigthTime;
	}

	public BigDecimal getVfrTime() {
		return vfrTime;
	}

	public void setVfrTime(BigDecimal vfrTime) {
		this.vfrTime = vfrTime;
	}

	public BigDecimal getIfrrTime() {
		return ifrrTime;
	}

	public void setIfrrTime(BigDecimal ifrrTime) {
		this.ifrrTime = ifrrTime;
	}

	public BigDecimal getIfrcTime() {
		return ifrcTime;
	}

	public void setIfrcTime(BigDecimal ifrcTime) {
		this.ifrcTime = ifrcTime;
	}

	public Integer getLandings() {
		return landings;
	}

	public void setLandings(Integer landings) {
		this.landings = landings;
	}

	public String getNat() {
		return nat;
	}

	public void setNat(String nat) {
		this.nat = nat;
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

	public boolean isSolo() {
		return solo;
	}

	@Transient //Indica ao hibernate que não é uma coluna na tabela
	public String isSoloFormated() {
		return formatar(solo);
	}

	public void setSolo(boolean solo) {
		this.solo = solo;
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
	
	@Transient
	public String formatar(Boolean campo) {
		String Formated = "Não";
		if(campo == true){
			Formated = "Sim";
		}
		return Formated;
	}
}
