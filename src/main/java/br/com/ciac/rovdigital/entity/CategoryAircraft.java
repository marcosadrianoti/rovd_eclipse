package br.com.ciac.rovdigital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class CategoryAircraft extends EntidadeGenerica{
	
	@Column(length=4, nullable=false)
	private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
