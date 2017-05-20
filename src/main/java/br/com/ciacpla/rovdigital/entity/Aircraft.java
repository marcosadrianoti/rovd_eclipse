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
public class Aircraft extends GenericEntity{
	
	@Column(length=5, nullable=false)
	private String icaoRegistry;
	
	@ManyToOne
	@JoinColumn(nullable=false)
    private CategoryAircraft category;
	
	@Column(length=15, nullable=false)
    private String manufacturer;
	
	@Column(length=4, nullable=false)
    private String aircraftCode;
	
	@Column(length=10, nullable=false)
    private String serialNumber;
	
	@Column(length=4, nullable=false)
    private String yearManufacture;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
    private Date iamDate;
	
	@Column(precision=6, scale=1, nullable=false)
    private BigDecimal tsnAirframe;
	
	@Column(precision=6, scale=1, nullable=false)
    private BigDecimal tsnPowerPlant;
	
	@Column(precision=6, scale=1, nullable=false)
    private BigDecimal tsnPropeller;

	public String getIcaoRegistry() {
		return icaoRegistry;
	}

	public void setIcaoRegistry(String icaoRegistry) {
		this.icaoRegistry = icaoRegistry;
	}

	public CategoryAircraft getCategory() {
		return category;
	}

	public void setCategory(CategoryAircraft category) {
		this.category = category;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getAircraftCode() {
		return aircraftCode;
	}

	public void setAircraftCode(String aircraftCode) {
		this.aircraftCode = aircraftCode;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getYearManufacture() {
		return yearManufacture;
	}

	public void setYearManufacture(String yearManufacture) {
		this.yearManufacture = yearManufacture;
	}

	public Date getIamDate() {
		return iamDate;
	}

	public void setIamDate(Date iamDate) {
		this.iamDate = iamDate;
	}

	public BigDecimal getTsnAirframe() {
		return tsnAirframe;
	}

	public void setTsnAirframe(BigDecimal tsnAirframe) {
		this.tsnAirframe = tsnAirframe;
	}

	public BigDecimal getTsnPowerPlant() {
		return tsnPowerPlant;
	}

	public void setTsnPowerPlant(BigDecimal tsnPowerPlant) {
		this.tsnPowerPlant = tsnPowerPlant;
	}

	public BigDecimal getTsnPropeller() {
		return tsnPropeller;
	}

	public void setTsnPropeller(BigDecimal tsnPropeller) {
		this.tsnPropeller = tsnPropeller;
	}
	
}
