package br.com.lucasmancan.converters;

import br.com.lucasmancan.dtos.CreateTransferDTO;
import br.com.lucasmancan.dtos.TransferDTO;
import br.com.lucasmancan.entities.Transfer;

public interface TransferConverter extends Converter<Transfer, TransferDTO> {
    Transfer dtoToEntity(CreateTransferDTO z);
}
