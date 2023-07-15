package br.com.lucasmancan.math.implementations;

import br.com.lucasmancan.math.implementations.interfaces.Operator;
import br.com.lucasmancan.math.models.OperationResult;

import java.math.BigDecimal;
import java.util.List;

public class CountOperator implements Operator {

    @Override
    public BigDecimal calculate(List<Integer> valores) {
        return BigDecimal.valueOf(valores.size());
    }
}
