package com.bankonet.report;

public class HtmlReportGenerator extends ReportGenerator implements IReportGenerator {

	public void generate() {
		System.out.println("HTML Generator");
	}

	public void generate(String auteur) {
		generate();
		System.out.println("-> auteur : " + auteur);
	}
}
