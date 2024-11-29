package com.example.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/*
	id_clan			bigint primary key auto_increment,
    nome_clan		varchar(50) not null,
    soprannome_clan	varchar(50)
*/
@Entity
@Table(name="Clan")
public class Clan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_clan")
	private Long idClan;
	
	@Column(name="nome_clan", nullable = false, length = 50)
	private String nomeClan;
	
	
	@Column(name="sprannome_clan", nullable = false, length = 50)
	private String soprannomeClan;

	public Clan () {}

	public Long getIdClan() {
		return idClan;
	}

	public void setIdClan(Long idClan) {
		this.idClan = idClan;
	}

	public String getNomeClan() {
		return nomeClan;
	}

	public void setNomeClan(String nomeClan) {
		this.nomeClan = nomeClan;
	}

	public String getSoprannomeClan() {
		return soprannomeClan;
	}

	public void setSoprannomeClan(String soprannomeClan) {
		this.soprannomeClan = soprannomeClan;
	}

	@Override
	public String toString() {
		return "Clan [idClan=" + idClan + ", nomeClan=" + nomeClan + ", soprannomeClan=" + soprannomeClan + "]";
	}
	
	
	
}
