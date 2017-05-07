package br.com.ciacpla.rovdigital.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Pilot extends GenericEntity{
	
	@Column(length=50, nullable=false)
	private String name;
	
	@Column(length=6, nullable=false)
    private String canac;
	
	@Column(length=50, nullable=false)
    private String email;
	
	@Column(length=50)
    private String foneWhatsapp;
	
	@Column(length=1, nullable=false)
    private String cmaClass;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
    private Date cmaValidity;
	
	@Column(length=6)
    private String ppaLicense;
	
	@Column(length=6)
    private String pcaLicense;
	
	@Column(length=6)
    private String plaLicense;
    
    @Column()
	@Temporal(TemporalType.DATE)
    private Date mnteValidity;
    
    @Column()
	@Temporal(TemporalType.DATE)
    private Date mlteValidity;
    
    @Column()
	@Temporal(TemporalType.DATE)
    private Date ifraValidity;
    
    @Column()
	@Temporal(TemporalType.DATE)
    private Date invaValidity;
    
    @Column(nullable=false)
    private boolean student;

    @Column(nullable=false)
	private boolean invaFliesAtSchool;
	
	@Column(length=20)
    private String bank;
	
	@Column(length=10)
    private String agency;
	
	@Column(length=10)
    private String account;
	
	@Column(length=11)
    private String cpf;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCanac() {
		return canac;
	}

	public void setCanac(String canac) {
		this.canac = canac;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoneWhatsapp() {
		return foneWhatsapp;
	}

	public void setFoneWhatsapp(String foneWhatsapp) {
		this.foneWhatsapp = foneWhatsapp;
	}

	public String getCmaClass() {
		return cmaClass;
	}

	public void setCmaClass(String cmaClass) {
		this.cmaClass = cmaClass;
	}

	public Date getCmaValidity() {
		return cmaValidity;
	}

	public void setCmaValidity(Date cmaValidity) {
		this.cmaValidity = cmaValidity;
	}

	public String getPpaLicense() {
		return ppaLicense;
	}

	public void setPpaLicense(String ppaLicense) {
		this.ppaLicense = ppaLicense;
	}

	public String getPcaLicense() {
		return pcaLicense;
	}

	public void setPcaLicense(String pcaLicense) {
		this.pcaLicense = pcaLicense;
	}

	public String getPlaLicense() {
		return plaLicense;
	}

	public void setPlaLicense(String plaLicense) {
		this.plaLicense = plaLicense;
	}

	public Date getMnteValidity() {
		return mnteValidity;
	}

	public void setMnteValidity(Date mnteValidity) {
		this.mnteValidity = mnteValidity;
	}

	public Date getMlteValidity() {
		return mlteValidity;
	}

	public void setMlteValidity(Date mlteValidity) {
		this.mlteValidity = mlteValidity;
	}

	public Date getIfraValidity() {
		return ifraValidity;
	}

	public void setIfraValidity(Date ifraValidity) {
		this.ifraValidity = ifraValidity;
	}

	public Date getInvaValidity() {
		return invaValidity;
	}

	public void setInvaValidity(Date invaValidity) {
		this.invaValidity = invaValidity;
	}
	
	public boolean isInvaFliesAtSchool() {
		return invaFliesAtSchool;
	}

	public void setInvaFliesAtSchool(boolean invaFliesAtSchool) {
		this.invaFliesAtSchool = invaFliesAtSchool;
	}

	public boolean isStudent() {
		return student;
	}
	
	public void setStudent(boolean student) {
		this.student = student;
	}
	
	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
