package com.bankonet.model;

public class Compte {
	int id;
	String libelle;
	float solde;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public Compte() {
		super();
	}

	public Compte(int id, String libelle, float solde) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.solde = solde;
	}

}
