package com.omkbron.dynamic.jasper.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.log4j.Logger;

import ar.com.fdvs.dj.domain.AutoText;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;
import ar.com.fdvs.dj.domain.builders.GroupBuilder;
import ar.com.fdvs.dj.domain.constants.GroupLayout;
import ar.com.fdvs.dj.domain.constants.HorizontalAlign;
import ar.com.fdvs.dj.domain.entities.DJGroup;
import ar.com.fdvs.dj.domain.entities.columns.PropertyColumn;

public class SimpleReport extends BaseReport {

	private static final Logger logger = Logger.getLogger(SimpleReport.class);
	
	@Override
	public DynamicReport buildReport() throws Exception {
		logger.debug("Build report");
		FastReportBuilder builder = new FastReportBuilder();
		builder.setMargins(20, 40, 30, 30);
		builder.setDetailHeight(10);
		builder.setTitle("Babel report");
		builder.setSubtitle("Generated on: " + new Date());
		builder.addColumn("Name", "name", String.class.getName(), 30);
		builder.addColumn("Email", "email", String.class.getName(), 45);
		builder.addColumn("Mobile", "mobile", String.class.getName(), 45);
		builder.addAutoText(AutoText.AUTOTEXT_PAGE_X_OF_Y, AutoText.POSITION_FOOTER, AutoText.ALIGMENT_RIGHT);
		builder.setPrintBackgroundOnOddRows(true);
		builder.setUseFullPageWidth(true);
		GroupBuilder gb1 = new GroupBuilder();
		
		DJGroup group1 = gb1.setCriteriaColumn((PropertyColumn) builder.getColumn(0))
				.setGroupLayout(GroupLayout.VALUE_IN_HEADER)
				.build();
		
		builder.addGroup(group1);
		getParams().put("paramAlgo", "Monthly");
		builder.setTemplateFile("template-report.jrxml");
		return builder.build();
	}

	private Object getDataSourceReport() {
		List<Persona> lista = new ArrayList<Persona>();
		for (int i = 0; i <= 5; i++) {
			Persona persona = new Persona();
			persona.setName("Omar");
			persona.setEmail("Velasco" + i);
			persona.setMobile("Peña" + i);
			lista.add(persona);
		}
	return lista;
}

	@Override
	public JRDataSource getDataSource() {
		List<Persona> lista = new ArrayList<Persona>();
		for (int i = 0; i <= 5; i++) {
			Persona persona = new Persona();
			persona.setName("Bob");
			persona.setEmail("bob" + i+"@gmail.com");
			persona.setMobile("01757-45848" + i);
			lista.add(persona);
		}
		for (int i = 0; i <= 9; i++) {
			Persona persona = new Persona();
			persona.setName("Alice");
			persona.setEmail("alice" + i+"@gmail.com");
//			persona.setMobile("01757-45848" + i);
			lista.add(persona);
		}
		for (int i = 0; i <= 3; i++) {
			Persona persona = new Persona();
			persona.setName("Tom");
//			persona.setEmail("tom" + i+"@gmail.com");
			persona.setMobile("01505-45897" + i);
			lista.add(persona);
		}
		JRDataSource dataSource = new JRBeanCollectionDataSource(lista);
		return dataSource;
	}
	
	
}
