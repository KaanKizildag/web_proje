package webprogramlama.demo.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webprogramlama.demo.core.emailsender.EmailSenderService;
import webprogramlama.demo.core.rapor.ReportService;
import webprogramlama.demo.core.rapor.entity.RaporKriterleriDTO;
import webprogramlama.demo.enums.ExportReportType;
import webprogramlama.demo.service.FilmService;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/report")
public class ReportResource {

    private ReportService reportService;
    private final FilmService filmService;
    private final EmailSenderService emailSenderService;

    public ReportResource(ReportService reportService, FilmService filmService, EmailSenderService emailSenderService) {
        this.reportService = reportService;
        this.filmService = filmService;
        this.emailSenderService = emailSenderService;
    }

    @GetMapping(value = "/pdf")
    public ResponseEntity<ByteArrayResource> generateSimplePdfReport() {
        List<RaporKriterleriDTO> report = filmService.findAll()
                .stream()
                .map(film -> RaporKriterleriDTO.builder()
                        .description(film.getDescription())
                        .title(film.getTitle())
                        .id(film.getId())
                        .build())
                .collect(Collectors.toList());
        try {
            ByteArrayResource byteArrayResource = reportService.generateSimpleReport(report, ExportReportType.PDF);
//            sendEmail(byteArrayResource);
            return new ResponseEntity<>(byteArrayResource, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity( HttpStatus.BAD_REQUEST);
        }
    }

    private void sendEmail(ByteArrayResource byteArrayResource) {
        try {
            emailSenderService.sendMailWithAttachment(
                    "huseyinkaan.kizildag@gmail.com",
                    "rapor dosyası ektedir",
                    "rapor dosyası",
                    byteArrayResource.getInputStream()
            );
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }

}
