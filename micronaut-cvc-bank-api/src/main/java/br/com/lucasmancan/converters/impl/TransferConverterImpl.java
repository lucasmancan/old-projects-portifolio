package br.com.lucasmancan.converters.impl;

import br.com.lucasmancan.converters.TransferConverter;
import br.com.lucasmancan.dtos.CreateTransferDTO;
import br.com.lucasmancan.dtos.TransferDTO;
import br.com.lucasmancan.entities.Transfer;

import javax.inject.Singleton;

@Singleton
public class TransferConverterImpl implements TransferConverter {
    @Override
    public Transfer dtoToEntity(TransferDTO transferDTO) {
        return Transfer.builder()
                .amount(transferDTO.getAmount())
                .beneficiaryId(transferDTO.getBeneficiaryId())
                .fee(transferDTO.getFee())
                .transferAmount(transferDTO.getTransferAmount())
                .scheduledAt(transferDTO.getScheduledAt())
                .transferDate(transferDTO.getTransferDate())
                .id(transferDTO.getId())
                .build();
    }

    @Override
    public TransferDTO entityToDTO(Transfer transfer) {
        return TransferDTO.builder()
                .amount(transfer.getAmount())
                .beneficiaryId(transfer.getBeneficiaryId())
                .fee(transfer.getFee())
                .id(transfer.getId())
                .transferAmount(transfer.getTransferAmount())
                .scheduledAt(transfer.getScheduledAt())
                .transferDate(transfer.getTransferDate())
                .build();
    }

    @Override
    public Transfer dtoToEntity(CreateTransferDTO z) {
        return Transfer.builder()
                .beneficiaryId(z.getBeneficiaryId())
                .transferAmount(z.getTransferAmount())
                .transferDate(z.getTransferDate())
                .build();
    }
}
