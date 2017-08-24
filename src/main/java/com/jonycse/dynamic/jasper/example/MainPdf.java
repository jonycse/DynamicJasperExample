package com.jonycse.dynamic.jasper.example;

import net.sf.jasperreports.engine.JasperExportManager;

import org.apache.log4j.Logger;

public class MainPdf {
	
	private static final Logger logger = Logger.getLogger(MainPdf.class);
	
	public static void main(String[] args) throws Exception {
		logger.info("Dynamic jasper example");
		SimpleReport report = new SimpleReport(ReportType.PDF);
		report.generateReport();
		JasperExportManager.exportReportToPdfFile(report.getJasperPrint(), "report.pdf");
	}


}
