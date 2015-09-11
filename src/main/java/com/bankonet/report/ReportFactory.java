package com.bankonet.report;

public class ReportFactory {
	public static ReportGenerator createReport(String reportType) {
		if (reportType.toUpperCase().equals("HTML")) {
			return new HtmlReportGenerator();
		} else if (reportType.toUpperCase().equals("PDF")) {
			return new PdfReportGenerator();
		}
		throw new RuntimeException();
	}
}
