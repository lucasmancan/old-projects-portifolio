package br.com.lucasmancan.math.models;

import java.math.BigDecimal;

public final class OperationResult {


    private  BigDecimal total;


    private OperationResult(BigDecimal total) {
        this.total = total;
    }


    private OperationResult() {

    }

    public static OperationResult valueOf(BigDecimal total) {
        return new OperationResult(total);
    }

    public BigDecimal getTotal() {
        return total;
    }

}
