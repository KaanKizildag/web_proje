package webprogramlama.demo.service;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import webprogramlama.demo.entity.Film;
import webprogramlama.demo.enums.ExportReportType;

import javax.mail.MessagingException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportService.class);

    private final EmailSenderService emailSenderService;

    public ReportService(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    public ByteArrayResource generateSimpleReport(List<Film> dataList, ExportReportType exportReportType) throws IOException {

        // todo dosya yolunu veri tabanında oku.

        ClassPathResource compileReport = new ClassPathResource("raporlar/filmReport.jasper");

        // generate parameters
        Map<String, Object> reportParameters = new HashMap<>();

        // generate reports based on export type.
        switch (exportReportType) {
            case PDF:
                ByteArrayResource raporDosyasi = exportReportToPDF(compileReport.getInputStream(), reportParameters, dataList);
                try {
                    emailSenderService.sendMailWithAttachment(
                            "huseyinkaan.kizildag@gmail.com",
                            "rapor dosyası ektedir",
                            "rapor dosyası",
                            raporDosyasi.getInputStream()
                    );
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                return raporDosyasi;
            default:
                return null;
        }
    }

    private ByteArrayResource exportReportToPDF(InputStream jasperReport, Map<String, Object> parameters, List<Film> data) {
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
                    new JRBeanCollectionDataSource(data));

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

            byte[] reportContent = outputStream.toByteArray();
            return new ByteArrayResource(reportContent);
        } catch (Exception e) {
            LOGGER.error("Exporting report to PDF error: {}", e.getMessage());
            return null;
        }
    }

}
