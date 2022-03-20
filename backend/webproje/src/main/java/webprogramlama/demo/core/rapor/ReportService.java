package webprogramlama.demo.core.rapor;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import webprogramlama.demo.core.rapor.entity.RaporKriterleriDTO;
import webprogramlama.demo.enums.ExportReportType;
import webprogramlama.demo.service.RaporBilgisiService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportService.class);
    private final RaporBilgisiService raporBilgisiService;

    public ReportService(RaporBilgisiService raporBilgisiService) {
        this.raporBilgisiService = raporBilgisiService;
    }

    public ByteArrayResource generateSimpleReport(List<RaporKriterleriDTO> dataList, ExportReportType exportReportType) throws IOException {

        // todo RAPOR ID parametre ile alınmalı
        ClassPathResource compileReport = new ClassPathResource(raporBilgisiService.findById(1L).getDosya_yolu());

        Map<String, Object> reportParameters = new HashMap<>();
        reportParameters.put("musteriAdi", "müşterinin adı burada görünecektir.");

        switch (exportReportType) {
            case PDF:
                return exportReportToPDF(compileReport.getInputStream(), reportParameters, dataList);
            default:
                return null;
        }
    }

    private ByteArrayResource exportReportToPDF(InputStream jasperReport, Map<String, Object> parameters, List<RaporKriterleriDTO> data) {
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
