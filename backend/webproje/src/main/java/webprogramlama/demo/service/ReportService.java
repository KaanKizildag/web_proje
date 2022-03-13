package webprogramlama.demo.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import webprogramlama.demo.entity.Film;
import webprogramlama.demo.enums.ExportReportType;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportService.class);

    /**
     * Method for generating simple report
     *
     * @param film - provided data object
     * @return byte array resource ()
     */
    public ByteArrayResource generateSimpleReport(List<Film> film, ExportReportType exportReportType) throws IOException {

        // todo burada compile ile almak zaman kaybı yaşatıyor
        //  .jasper dosyasından okumayı öğren!

        // todo dosya yolunu veri tabanında oku.
        JasperReport compileReport = null;
        try {
            compileReport = JasperCompileManager
                    .compileReport(new FileInputStream("src/main/resources/reports/jrxml/filmReport.jrxml"));
        } catch (JRException e) {
            e.printStackTrace();
        }

        // generate parameters
        Map<String, Object> reportParameters = new HashMap<>();

        // generate reports based on export type.
        switch (exportReportType) {
            case PDF:
                return exportReportToPDF(compileReport, reportParameters, film);
            default:
                return null;
        }
    }

    /**
     * Method for generating data source report
     *
     * @param reportList       - provided report list
     * @param exportReportType - export type flag
     * @return byte array resource (generated file)
     * @throws IOException - input | output exception
     */

    /**
     * Method for generating report parameters.
     *
     * @param reportParameters - reference to report parameters (passed by reference).
     * @param reportData       - report data object
     */

    /**
     * Method for exporting report to PDF.
     *
     * @param jasperReport - target report stream
     * @param parameters   - generated parameters
     * @return byte array resource (file content)
     */
    private ByteArrayResource exportReportToPDF(JasperReport jasperReport, Map<String, Object> parameters, List<Film> film) {
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
                    new JRBeanCollectionDataSource(film));

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

            byte[] reportContent = outputStream.toByteArray();
            return new ByteArrayResource(reportContent);
        } catch (Exception e) {
            LOGGER.error("Exporting report to PDF error: {}", e.getMessage());
            return null;
        }
    }

    /**
     * Method for exporting report to DOCx format
     *
     * @param targetStream - target report stream
     * @param parameters   - generated parameters
     * @return byte array resource (generated report file).
     */
    private ByteArrayResource exportReportToDOCx(InputStream targetStream, Map<String, Object> parameters) {
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(targetStream, parameters, new JREmptyDataSource());
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            JRDocxExporter exporter = new JRDocxExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));

            // the line bellow is only for demo purpose.
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(
                    new File("src/main/resources/reports/reports.docx"))
            );

            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
            exporter.exportReport();

            byte[] reportContent = outputStream.toByteArray();
            return new ByteArrayResource(reportContent);
        } catch (Exception e) {
            LOGGER.error("Exporting report to DOCx error: {}", e.getMessage());
            return null;
        }
    }

}
