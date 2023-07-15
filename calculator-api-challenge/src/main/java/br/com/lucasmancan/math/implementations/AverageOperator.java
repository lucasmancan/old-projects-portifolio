package br.com.lucasmancan.math.implementations;

import br.com.lucasmancan.math.implementations.interfaces.Operator;
import br.com.lucasmancan.math.models.OperationResult;

import java.math.BigDecimal;
import java.util.List;

public class AverageOperator implements Operator {
    @Override
    public BigDecimal calculate(List<Integer> valores) {

        Integer value = valores.stream().reduce(Integer::sum).orElse(0);

        return BigDecimal.valueOf(value)
                .divide(BigDecimal.valueOf(valores.size()));
    }
}
