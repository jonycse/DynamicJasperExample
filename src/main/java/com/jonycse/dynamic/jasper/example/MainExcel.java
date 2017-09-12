package com.jonycse.dynamic.jasper.example;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
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


		exporter.setExporterInput(new SimpleExporterInput(report.getJasperPrint()));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(fos));
		SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();

		//Excel specific parameter
		configuration.setOnePagePerSheet(Boolean.FALSE);
		configuration.setRemoveEmptySpaceBetweenRows(Boolean.TRUE);
		configuration.setWhitePageBackground(Boolean.FALSE);
		//configuration.setDetectCellType(true);
		//configuration.setCollapseRowSpan(false);
		exporter.setConfiguration(configuration);

		exporter.exportReport();


		System.out.println("Class: "+Class.forName("java.lang.String").getName());
	}
}
