package br.com.lucasmancan.services.impl;

import br.com.lucasmancan.dtos.TransferSummary;
import br.com.lucasmancan.services.FeeService;
import br.com.lucasmancan.services.impl.calculators.Calculator;

import javax.inject.Singleton;
import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

@Singleton
public class FeeServiceImpl implements FeeService {

    @Override
    public BigDecimal calculateByTransfer(TransferSummary transfer) {

        long differenceInDays = ChronoUnit.DAYS.between(transfer.getScheduledAt(), transfer.getTransferDate());

        Calculator calculator = Calculator.getInstance(differenceInDays);

        return calculator.calculate(transfer.getTransferAmount());
    }
}

