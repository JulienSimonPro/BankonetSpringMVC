package com.bankonet.model;

public class CompteEpargne extends Compte {
	int taux_interet;
	int plafont;

	public int getTaux_interet() {
		return taux_interet;
	}

	public void setTaux_interet(int taux_interet) {
		this.taux_interet = taux_interet;
	}

	public int getPlafont() {
		return plafont;
	}

	public void setPlafont(int plafont) {
		this.plafont = plafont;
	}

	public CompteEpargne() {
		super();
	}

	public CompteEpargne(int taux_interet, int plafont) {
		super();
		this.taux_interet = taux_interet;
		this.plafont = plafont;
	}
}
