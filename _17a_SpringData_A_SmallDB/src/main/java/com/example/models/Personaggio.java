package com.example.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/*
	id_pg			bigint primary key auto_increment,
    giocatore		varchar(30) not null,
    nome_pg			varchar(50) not null,
    natura			varchar(30) not null,
    clan			bigint,
    carattere		varchar(30) not null,
    generazione		int not null,  -- da 0 a 10
    profilo			varchar(300),
    sire			varchar(30),
    umanita			int,
    forza_volonta  	int,  -- da 0 a 10
    forza_volonta_attuale	int,  -- da 0 a 10
    punti_sangue	int,  --  da 0 a 10
    punti_sangue_attuali	int,  --  da 0 a 10
    punti_exp		int,
    constraint fk_Clan_Personaggi foreign key (clan) references Clan(id_clan)
*/

public class Personaggio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pg")
	private Long idPg;						// bigint primary key auto_increment,
	
	@Column (nullable = false, length = 30)
	private String giocatore;				// varchar(30) not null,
	
	@Column (name="nome_pg", nullable = false, length = 50)
	private String nomePg;					// varchar(50) not null,
	
	@Column (nullable = false, length = 30)
	private String natura;					// varchar(30) not null,
	
	private Long clan;						// bigint,
	
	@Column (nullable = false, length = 30)
	private String carattere;				// varchar(30) not null,
	
	@Column(nullable = false)
	private Integer generazione;			//  not null,  -- da 0 a 10
	
	@Column (length = 300)
	private String profilo;					// varchar(300),

	@Column (length = 30)
	private String sire;					// varchar(30),
	
	private Integer umanita;				// int,
	private Integer forza_volonta;  		// int,  -- da 0 a 10
	private Integer forza_volonta_attuale;	// int,  -- da 0 a 10
	private Integer punti_sangue;			// int,  --  da 0 a 10
	private Integer punti_sangue_attuali;	// int,  --  da 0 a 10
	private Integer punti_exp;				// int,
	
	public Personaggio () {}

	public Long getIdPg() {
		return idPg;
	}

	public void setIdPg(Long idPg) {
		this.idPg = idPg;
	}

	public String getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(String giocatore) {
		this.giocatore = giocatore;
	}

	public String getNomePg() {
		return nomePg;
	}

	public void setNomePg(String nomePg) {
		this.nomePg = nomePg;
	}

	public String getNatura() {
		return natura;
	}

	public void setNatura(String natura) {
		this.natura = natura;
	}

	public Long getClan() {
		return clan;
	}

	public void setClan(Long clan) {
		this.clan = clan;
	}

	public String getCarattere() {
		return carattere;
	}

	public void setCarattere(String carattere) {
		this.carattere = carattere;
	}

	public Integer getGenerazione() {
		return generazione;
	}

	public void setGenerazione(Integer generazione) {
		this.generazione = generazione;
	}

	public String getProfilo() {
		return profilo;
	}

	public void setProfilo(String profilo) {
		this.profilo = profilo;
	}

	public String getSire() {
		return sire;
	}

	public void setSire(String sire) {
		this.sire = sire;
	}

	public Integer getUmanita() {
		return umanita;
	}

	public void setUmanita(Integer umanita) {
		this.umanita = umanita;
	}

	public Integer getForza_volonta() {
		return forza_volonta;
	}

	public void setForza_volonta(Integer forza_volonta) {
		this.forza_volonta = forza_volonta;
	}

	public Integer getForza_volonta_attuale() {
		return forza_volonta_attuale;
	}

	public void setForza_volonta_attuale(Integer forza_volonta_attuale) {
		this.forza_volonta_attuale = forza_volonta_attuale;
	}

	public Integer getPunti_sangue() {
		return punti_sangue;
	}

	public void setPunti_sangue(Integer punti_sangue) {
		this.punti_sangue = punti_sangue;
	}

	public Integer getPunti_sangue_attuali() {
		return punti_sangue_attuali;
	}

	public void setPunti_sangue_attuali(Integer punti_sangue_attuali) {
		this.punti_sangue_attuali = punti_sangue_attuali;
	}

	public Integer getPunti_exp() {
		return punti_exp;
	}

	public void setPunti_exp(Integer punti_exp) {
		this.punti_exp = punti_exp;
	}

	@Override
	public String toString() {
		return "Personaggio [idPg=" + idPg + ", giocatore=" + giocatore + ", nomePg=" + nomePg + ", natura=" + natura
				+ ", clan=" + clan + ", carattere=" + carattere + ", generazione=" + generazione + ", profilo="
				+ profilo + ", sire=" + sire + ", umanita=" + umanita + ", forza_volonta=" + forza_volonta
				+ ", forza_volonta_attuale=" + forza_volonta_attuale + ", punti_sangue=" + punti_sangue
				+ ", punti_sangue_attuali=" + punti_sangue_attuali + ", punti_exp=" + punti_exp + "]";
	}
	
	
	
}
