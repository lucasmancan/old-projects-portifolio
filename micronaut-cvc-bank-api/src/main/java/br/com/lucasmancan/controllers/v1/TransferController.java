package br.com.lucasmancan.controllers.v1;

import br.com.lucasmancan.dtos.CreateTransferDTO;
import br.com.lucasmancan.dtos.TransferDTO;
import br.com.lucasmancan.services.TransferService;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import lombok.AllArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@Controller("v1/transfers")
@AllArgsConstructor
@Secured(SecurityRule.IS_AUTHENTICATED)
public class TransferController {

    private final TransferService transferService;

    @Post
    public TransferDTO create(@Body @Valid CreateTransferDTO createTransferDTO) {
        return transferService.create(createTransferDTO);
    }

    @Get("/{id}")
    public TransferDTO findById(@PathVariable Long id) {
        return transferService.findById(id);
    }

    @Get
    public List<TransferDTO> findAll() {
        return transferService.findAll();
    }
}
