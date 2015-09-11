package com.bankonet.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorValue("C")
public class Client extends Personne {
	@Embedded
	private Adresse adresse;

	@Embedded
	private List<CompteEpargne> cptEp;

	@Embedded
	private List<CompteCourant> cptCr;

	@Size(min = 2, max = 16)
	@NotNull
	private String login;

	@Size(min = 6, max = 50)
	@NotNull
	private String motDePasse;

	public Client() {
	}

	public Client(String nom, String prenom, String login, String motDePasse, Adresse adresse) {
		super(nom, prenom);
		this.login = login;
		this.motDePasse = motDePasse;
		this.adresse = adresse;
	}

	public Client(Adresse adresse, List<CompteEpargne> cptEp, List<CompteCourant> cptCr, String login, String motDePasse) {
		super();
		this.adresse = adresse;
		this.cptEp = cptEp;
		this.cptCr = cptCr;
		this.login = login;
		this.motDePasse = motDePasse;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String toString() {
		return super.toString() + "\n" + adresse;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<CompteEpargne> getCptEp() {
		return cptEp;
	}

	public void setCptEp(List<CompteEpargne> cptEp) {
		this.cptEp = cptEp;
	}

	public List<CompteCourant> getCptCr() {
		return cptCr;
	}

	public void setCptCr(List<CompteCourant> cptCr) {
		this.cptCr = cptCr;
	}
}
