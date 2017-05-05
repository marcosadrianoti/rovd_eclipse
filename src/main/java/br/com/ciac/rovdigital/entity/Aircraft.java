package br.com.ciac.rovdigital.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Aircraft extends EntidadeGenerica{
	
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
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
    private Date yearManufacture;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
    private Date iamDate;
	
	@Column(precision=6, scale=1, nullable=false)
    private float tsnAirframe;
	
	@Column(precision=6, scale=1, nullable=false)
    private float tsnPowerPlant;
	
	@Column(precision=6, scale=1, nullable=false)
    private float tsnPropeller;

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

	public Date getYearManufacture() {
		return yearManufacture;
	}

	public void setYearManufacture(Date yearManufacture) {
		this.yearManufacture = yearManufacture;
	}

	public Date getIamDate() {
		return iamDate;
	}

	public void setIamDate(Date iamDate) {
		this.iamDate = iamDate;
	}

	public float getTsnAirframe() {
		return tsnAirframe;
	}

	public void setTsnAirframe(float tsnAirframe) {
		this.tsnAirframe = tsnAirframe;
	}

	public float getTsnPowerPlant() {
		return tsnPowerPlant;
	}

	public void setTsnPowerPlant(float tsnPowerPlant) {
		this.tsnPowerPlant = tsnPowerPlant;
	}

	public float getTsnPropeller() {
		return tsnPropeller;
	}

	public void setTsnPropeller(float tsnPropeller) {
		this.tsnPropeller = tsnPropeller;
	}
	
}
