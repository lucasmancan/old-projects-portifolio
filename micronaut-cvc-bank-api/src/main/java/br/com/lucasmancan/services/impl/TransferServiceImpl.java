package br.com.lucasmancan.services.impl;

import br.com.lucasmancan.converters.TransferConverter;
import br.com.lucasmancan.dtos.BalanceUpdate;
import br.com.lucasmancan.dtos.CreateTransferDTO;
import br.com.lucasmancan.dtos.TransferDTO;
import br.com.lucasmancan.dtos.TransferSummary;
import br.com.lucasmancan.exceptions.NotFoundException;
import br.com.lucasmancan.repositories.TransferRepository;
import br.com.lucasmancan.security.services.SecurityService;
import br.com.lucasmancan.services.BalanceService;
import br.com.lucasmancan.services.FeeService;
import br.com.lucasmancan.services.TransferService;
import lombok.AllArgsConstructor;

import javax.inject.Singleton;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
@AllArgsConstructor
public class TransferServiceImpl implements TransferService {

    private final FeeService feeService;
    private final TransferRepository transferRepository;
    private final TransferConverter transferConverter;
    private final SecurityService appSecurityContext;
    private final BalanceService balanceService;

    @Override
    public TransferDTO create(CreateTransferDTO createTransferDTO) {
        var transfer = transferConverter.dtoToEntity(createTransferDTO);

        transfer.setScheduledAt(LocalDateTime.now());

        BigDecimal feeValue = feeService.calculateByTransfer(
                new TransferSummary(transfer.getTransferAmount(),
                        transfer.getScheduledAt(),
                        transfer.getTransferDate()));

        transfer.setOriginId(appSecurityContext.getCurrentAccountId());
        transfer.setFee(feeValue);
        transfer.setAmount(transfer.getTransferAmount().add(transfer.getFee()));

        transfer = transferRepository.save(transfer);

        balanceService.updateBalance(
                new BalanceUpdate(transfer.getBeneficiaryId(),
                        transfer.getOriginId(),
                        transfer.getTransferAmount(),
                        transfer.getAmount()));

        return transferConverter.entityToDTO(transfer);
    }

    @Override
    public TransferDTO findById(Long id) {
        return transferRepository.findById(id)
                .map(transferConverter::entityToDTO)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<TransferDTO> findAll() {
        return transferRepository.findAllByOriginId(appSecurityContext.getCurrentAccountId())
                .stream().map(transferConverter::entityToDTO).collect(Collectors.toList());
    }
}
