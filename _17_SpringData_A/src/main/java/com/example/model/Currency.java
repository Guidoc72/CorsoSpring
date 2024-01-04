// CLASSE ENTITY
package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "currency") //Optional only if you need to indicate the table's name, different from class name
public class Currency {
	
	@Id //Identify which is the primary key
	@GeneratedValue(strategy = GenerationType.SEQUENCE) //Indicate the way to generate the ID
	private Long id;
	private String code;
	private String description;
	private Boolean enabled;
	
	@Column(name = "decimal_places") 	//Optional: Indicate the name and the length of the column
	private Integer decimalPlaces;

    public Currency() {}

	public Currency(Long id, String code, String description, Boolean enable, Integer decimalPlaces) {
		setId(id);
		setCode(code);
		setDescription(description);
		setEnable(enable);
		setDecimalPlaces(decimalPlaces);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEnable() {
		return enabled;
	}

	public void setEnable(Boolean enabled) {
		this.enabled = enabled;
	}

	public Integer getDecimalPlaces() {
		return decimalPlaces;
	}

	public void setDecimalPlaces(Integer decimalPlaces) {
		this.decimalPlaces = decimalPlaces;
	}



}

