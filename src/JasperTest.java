
import java.io.File;
import java.util.HashMap;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class JasperTest {

	public static void main(String[] args) throws Exception{

		//Jaspersoft iReport Designer 4.0.1で作成したテンプレートファイルを指定
		File jasperFile = new File("report1.jasper");
		JasperReport jasper = (JasperReport)JRLoader.loadObject(jasperFile);

		//PDFファイルに埋め込むパラメータをセット
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("parameter1", "test");
		JasperPrint print = JasperFillManager.fillReport(jasper, params, new JREmptyDataSource());

		//出力するPDFのファイル名とファイルパスを指定
		String outputFile ="param_test.pdf";
		JasperExportManager.exportReportToPdfFile(print, outputFile);

	}

}
