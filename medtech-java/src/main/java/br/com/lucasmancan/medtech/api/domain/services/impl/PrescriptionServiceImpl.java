package br.com.lucasmancan.medtech.api.domain.services.impl;

import br.com.lucasmancan.medtech.api.configurations.email.services.EmailService;
import br.com.lucasmancan.medtech.api.domain.dto.PrescriptionDTO;
import br.com.lucasmancan.medtech.api.domain.dto.SearchText;
import br.com.lucasmancan.medtech.api.domain.entities.Prescription;
import br.com.lucasmancan.medtech.api.domain.entities.PrescriptionItem;
import br.com.lucasmancan.medtech.api.domain.entities.Status;
import br.com.lucasmancan.medtech.api.domain.exceptions.InternalException;
import br.com.lucasmancan.medtech.api.domain.exceptions.NotFoundException;
import br.com.lucasmancan.medtech.api.domain.exceptions.ReportException;
import br.com.lucasmancan.medtech.api.domain.services.PrescriptionService;
import br.com.lucasmancan.medtech.api.infraestructure.repositories.springData.PrescriptionRepositorySD;
import br.com.lucasmancan.medtech.api.infraestructure.security.exceptions.ValidationException;
import br.com.lucasmancan.medtech.api.infraestructure.security.utils.AppSecurityContext;
import br.com.lucasmancan.medtech.api.infraestructure.security.utils.ParseUtils;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.apache.commons.io.FileUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Optional;


@Service
@Log
@AllArgsConstructor
public class PrescriptionServiceImpl extends AbstractService<Prescription, PrescriptionRepositorySD> implements PrescriptionService {

    private final AppSecurityContext appSecurityContext;
    private final EmailService emailService;

    @Override
    @Transactional(readOnly = true)
    public Page<PrescriptionDTO> search(Pageable pageable, SearchText searchText) {

        if (searchText.isEmpty())
            return repository.findAll(pageable, appSecurityContext.getCurrentAccountId());

        return repository.findAllWithCustomSearch(pageable, appSecurityContext.getCurrentAccountId(), searchText.toString());
    }

    @Override
    @Transactional(readOnly = true)
    public byte[] generatePrescription(String prescriptionId) {
        Prescription prescription = repository.fetchAllById(prescriptionId);

        if (prescription == null)
            throw new NotFoundException();

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, out);
        } catch (DocumentException e) {
            throw new ReportException("Error trying to generate prescription report");
        }

        try {

            PdfWriter.getInstance(document, out);
            document.open();

            // Add Text to PDF file ->
            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK);
            Paragraph para = new Paragraph(prescription.getCustomer().getName(), font);
            para.setAlignment(Element.ALIGN_LEFT);
            document.add(para);

            Font font32 = FontFactory.getFont(FontFactory.HELVETICA, 9, BaseColor.GRAY);
            Paragraph para32 = new Paragraph("Cód: " + prescription.getId(), font32);
            para.setAlignment(Element.ALIGN_LEFT);
            document.add(para32);

            document.add(Chunk.NEWLINE);


//            Font font2 = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
//            Paragraph para2 = new Paragraph("Paciente: " + prescription.getCustomer().getName(), font2);
//            para.setAlignment(Element.ALIGN_LEFT);
//            document.add(para2);

            Font font3 = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
            Paragraph para3 = new Paragraph("Data de criação: " + ParseUtils.parseDate(prescription.getCreatedAt()), font3);
            para.setAlignment(Element.ALIGN_LEFT);
            document.add(para3);

            Font font4 = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
            Paragraph para4 = new Paragraph("Expira em: " + ParseUtils.parseDate(prescription.getExpiresAt()), font3);
            para.setAlignment(Element.ALIGN_LEFT);
            document.add(para4);
            document.add(Chunk.NEWLINE);


            PdfPTable table = new PdfPTable(2);
            // Add PDF Table Header ->
//            Stream.of("Medicamento", "Detalhes")
//                    .forEach(headerTitle -> {
//                        PdfPCell header = new PdfPCell();
//                        header.setPadding(5);
//                        header.setPaddingLeft(5);
//                        header.setPaddingRight(5);
//                        header.setBorder(0);
//
//                        Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//                        header.setPhrase(new Phrase(headerTitle, headFont));
//                        table.addCell(header);
//                    });

            for (PrescriptionItem item : prescription.getItems()) {

                PdfPCell firstNameCell = new PdfPCell(new Phrase(item.getDrug().getName()));
                firstNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                firstNameCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                firstNameCell.setBorderWidth(0);

                firstNameCell.setPadding(10);

                table.addCell(firstNameCell);

                PdfPCell lastNameCell = new PdfPCell(new Phrase(String.valueOf(item.getDetails())));
                lastNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                lastNameCell.setHorizontalAlignment(Element.ALIGN_LEFT);

                lastNameCell.setBorderWidth(0);
                lastNameCell.setPadding(10);
                table.addCell(lastNameCell);
            }
            document.add(table);
            document.add(Chunk.NEWLINE);

            Font fon34 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.GRAY);
            Paragraph para88 = new Paragraph("CRM: " + prescription.getUser().getDocument(), fon34);
            para.setAlignment(Element.ALIGN_LEFT);
            document.add(para88);

            Font fon5 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.DARK_GRAY);
            Paragraph para5 = new Paragraph(prescription.getUser().getName(), fon5);
            para.setAlignment(Element.ALIGN_LEFT);
            document.add(para5);

            document.add(Chunk.NEWLINE);


            Font fon6 = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.DARK_GRAY);
            Paragraph para6 = new Paragraph("Assinatura: _____________________", fon6);
            para.setAlignment(Element.ALIGN_LEFT);
            document.add(para6);
            document.add(Chunk.NEWLINE);

            document.close();
        } catch (DocumentException e) {
            throw new ReportException("Error trying to generate prescription report");
        }

        return out.toByteArray();
    }

    @Override
    public void sendPrescriptionToCustomer(String prescriptionId) {
        Optional<Prescription> optional = repository.findWithCustomer(prescriptionId);

        if (optional.isEmpty()) {
            throw new ValidationException("Dados de paciente não encontrados para a receita: " + prescriptionId);
        }

        var map = new HashMap<String, Object>();
        map.put("customerName", optional.get().getCustomer().getName());

        var byteArrayPrescription = this.generatePrescription(prescriptionId);

        try {
            var file = File.createTempFile("receita-" + prescriptionId, ".pdf");
            FileUtils.writeByteArrayToFile(file, byteArrayPrescription);
            emailService.sendTemplateMessage(optional.get().getCustomer().getEmail(),
                    "customer-prescription",
                    map,
                    Collections.singletonList(file));
        } catch (IOException e) {
            throw new InternalException("Ocorreu um erro ao enviar receita para o paciente, tente novamente mais tarde");
        }
    }

    @Override
    public Prescription clone(String prescriptionId) {

        var prescription = repository.fetchAllById(prescriptionId);

        var newPrescription = new Prescription();
        newPrescription.setCustomerId(prescription.getCustomerId());
        newPrescription.setExpiresAt(prescription.getExpiresAt());
        newPrescription.setStatus(Status.active);
        newPrescription.setUserId(prescription.getUserId());

        for (PrescriptionItem prescriptionItem : prescription.getItems()) {
            PrescriptionItem pi = new PrescriptionItem();
            pi.setDetails(prescriptionItem.getDetails());
            pi.setDrugId(prescriptionItem.getDrugId());
            newPrescription.getItems().add(pi);
        }

        newPrescription.setDetails("Cópia " + prescriptionId + " " + prescription.getDetails());
        return this.save(newPrescription);
    }
}
