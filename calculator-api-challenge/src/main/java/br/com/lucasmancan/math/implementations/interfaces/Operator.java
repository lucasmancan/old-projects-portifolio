package br.com.lucasmancan.math.implementations.interfaces;

import br.com.lucasmancan.math.models.OperationResult;

import java.math.BigDecimal;
import java.util.List;

public interface  Operator {
    BigDecimal calculate(List<Integer> valores);
}
