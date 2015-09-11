package com.bankonet.metier;

import com.bankonet.report.IReportGenerator;

public class ReportService {
	private IReportGenerator generator;
	private String auteur;

	public ReportService(IReportGenerator generator) {
		this.generator = generator;
	}

	public void setGenerator(IReportGenerator generator) {
		this.generator = generator;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public void generateAnnualReport() {
		this.generator.generate(auteur);
	}

	public void generateMonthlyReport() {
		this.generator.generate(auteur);
	}

	public void generateDailyReport() {
		this.generator.generate(auteur);
	}
}
