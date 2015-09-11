package com.bankonet.report;

public class PdfReportGenerator extends ReportGenerator implements IReportGenerator {

	public void generate() {
		System.out.println("PDF Generator");
	}

	public void generate(String auteur) {
		generate();
		System.out.println("-> auteur : " + auteur);
	}

}
