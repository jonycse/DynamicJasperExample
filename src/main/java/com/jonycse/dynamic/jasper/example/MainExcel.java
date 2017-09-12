package com.jonycse.dynamic.jasper.example;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;

public class MainExcel {
	
	private static final Logger logger = Logger.getLogger(MainExcel.class);

	public static void main(String[] args) throws Exception {

		System.out.println("======== Excel ======");
		SimpleReport report = new SimpleReport(ReportType.EXCEL);
		report.generateReport();

		String path="report.xls";
		JRXlsExporter exporter = new JRXlsExporter();

		File outputFile = new File(path);
		FileOutputStream fos = new FileOutputStream(outputFile);

		exporter.setParameter(JRExporterParameter.JASPER_PRINT, report.getJasperPrint());
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, fos); //and output stream

		//Excel specific parameter
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
		exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);

		exporter.exportReport();


		System.out.println("Class: "+Class.forName("java.lang.String").getName());
	}
}
