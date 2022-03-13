package webprogramlama.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Description;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webprogramlama.demo.entity.Film;
import webprogramlama.demo.enums.ExportReportType;
import webprogramlama.demo.service.FilmService;
import webprogramlama.demo.service.ReportService;

import java.io.IOException;
import java.util.List;

@Description(value = "Jasper Report Resource Handler")
@RestController
@RequestMapping("/api/report")
public class ReportResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportResource.class);

    private ReportService reportService;
    private final FilmService filmService;

    /**
     * Constructor dependency injector.
     *
     * @param reportService - report service dependency
     * @param filmService
     */
    public ReportResource(ReportService reportService, FilmService filmService) {
        this.reportService = reportService;
        this.filmService = filmService;
    }


    /**
     * Endpoint for generating simple PDF report
     *
     * @param film - report data
     * @return byte array resource (generated file in bytes)
     */
//    @PostMapping(value = "/pdf", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ByteArrayResource> generateSimplePDFReport(@Valid @RequestBody Film film) {
//        LOGGER.info("Payload for generating simple PDF report: {}", film);
//        try {
//            ByteArrayResource byteArrayResource = reportService.generateSimpleReport(film, ExportReportType.PDF);
//            return new ResponseEntity<>(byteArrayResource, HttpStatus.OK);
//        } catch (IOException e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    /**
     * Endpoint for generating simple DOCx report
     *
     * @param report - report data
     * @return byte array resource (generated file in bytes)
     */
    @PostMapping(value = "/pdf", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ByteArrayResource> generateSimpleDOCxReport() {
        List<Film> report = filmService.findAll();
        try {
            ByteArrayResource byteArrayResource = reportService.generateSimpleReport(report, ExportReportType.PDF);
            return new ResponseEntity<>(byteArrayResource, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


//    @PostMapping(value = "/data-source", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ByteArrayResource> generateDataSourceReport() {
//        List<Film> reportDataSource = filmService.findAll();
//        LOGGER.info("Payload for generating report with data source: {}", reportDataSource);
//        try {
//            ByteArrayResource byteArrayResource = reportService.generateDataSourceReport(
//                    reportDataSource, ExportReportType.PDF
//            );
//            return new ResponseEntity<>(byteArrayResource, HttpStatus.OK);
//        } catch (IOException e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
}
