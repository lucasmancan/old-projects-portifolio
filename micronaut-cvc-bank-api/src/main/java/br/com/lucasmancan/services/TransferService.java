package br.com.lucasmancan.services;

import br.com.lucasmancan.dtos.CreateTransferDTO;
import br.com.lucasmancan.dtos.TransferDTO;

import java.util.List;


public interface TransferService {

    /**
     * Create a Transfer and apply validations
     *
     * @param createTransferDTO
     * @return
     */
    TransferDTO create(CreateTransferDTO createTransferDTO);

    TransferDTO findById(Long id);

    List<TransferDTO> findAll();
}
