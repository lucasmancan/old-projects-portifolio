package br.com.lucasmancan.medtech.api.infraestructure.controllers;

import br.com.lucasmancan.medtech.api.domain.entities.PrescriptionItem;
import br.com.lucasmancan.medtech.api.domain.services.PrescriptionItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("items")
@RestController
public class PrescriptionItemController extends AbstractController<PrescriptionItem, PrescriptionItemService> {

    @ResponseBody
    @GetMapping("/sale/{prescriptionId}")
    public List<PrescriptionItem> findByPrescription(@PathVariable String prescriptionId) {
        return service.findByPrescriptionId(prescriptionId);
    }


}
