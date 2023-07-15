package br.com.lucasmancan.services;

import br.com.lucasmancan.dtos.TransferSummary;

import java.math.BigDecimal;

public interface FeeService {

    /**
     * Calculates transfer fee based in requirements
     *
     * @param summary transfer information
     * @return
     */
    BigDecimal calculateByTransfer(TransferSummary summary);
}
