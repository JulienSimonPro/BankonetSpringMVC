package com.bankonet.model;

public class CompteCourant extends Compte {
	float debit_autorisé;

	public float getDebit_autorisé() {
		return debit_autorisé;
	}

	public void setDebit_autorisé(float debit_autorisé) {
		this.debit_autorisé = debit_autorisé;
	}

	public CompteCourant() {
		super();
	}

	public CompteCourant(float debit_autorisé) {
		super();
		this.debit_autorisé = debit_autorisé;
	}
}
