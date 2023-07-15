package br.com.lucasmancan.medtech.api.infraestructure.controllers;

import br.com.lucasmancan.medtech.api.domain.dto.PrescriptionDTO;
import br.com.lucasmancan.medtech.api.domain.dto.SearchText;
import br.com.lucasmancan.medtech.api.domain.entities.Prescription;
import br.com.lucasmancan.medtech.api.domain.services.PrescriptionService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;

@RequestMapping("prescriptions")
@RestController
public class PrescriptionController extends AbstractController<Prescription, PrescriptionService> {

    @ResponseBody
    @GetMapping
    public Page<PrescriptionDTO> findAll(@PageableDefault(page = 0, size = 15)
                                         @SortDefault.SortDefaults({
                                                 @SortDefault(sort = "createdAt", direction = Sort.Direction.DESC)
                                         }) Pageable paginator,
                                         @RequestParam(required = false) String search) {
        return service.search(paginator, new SearchText(search));
    }


    @GetMapping(value = "{id}/pdf",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> prescriptionReport(@PathVariable String id) {

        var bis = new ByteArrayInputStream(service.generatePrescription(id));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=receita-" + id + ".pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @GetMapping(value = "{id}/send")
    public void send(@PathVariable String id) {
        service.sendPrescriptionToCustomer(id);
    }

    @GetMapping(value = "{id}/clone")
    public Prescription copy(@PathVariable String id) {
        return service.clone(id);
    }

}