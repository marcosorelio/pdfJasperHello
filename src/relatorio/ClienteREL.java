package relatorio;

import java.util.List;

import model.Cliente;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ClienteREL {

	private String path; // path of report and done

	// Return the path, to the class can find the reports
	public ClienteREL() {
		// first include on bluid path
		this.path = "resources/";
		
	}

	// Print/Generate a client List
	public void imprimir(List<Cliente> clientes) throws Exception {
		JasperReport report = JasperCompileManager.compileReport(this.getPath() + "report.jrxml");
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(clientes));
		JasperExportManager.exportReportToPdfFile(print, this.getPath() + "ReportDone.pdf");
		System.out.println("Done :" + this.getPath() + "ReportDone.pdf");
	}

	public String getPath() {
		return this.path;
	}

}
