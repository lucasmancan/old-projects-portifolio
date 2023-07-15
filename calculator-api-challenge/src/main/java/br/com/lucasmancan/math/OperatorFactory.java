package br.com.lucasmancan.math;

import br.com.lucasmancan.math.implementations.AverageOperator;
import br.com.lucasmancan.math.implementations.CountOperator;
import br.com.lucasmancan.math.implementations.SubtractionOperator;
import br.com.lucasmancan.math.implementations.SumOperator;
import br.com.lucasmancan.math.implementations.interfaces.Operator;
import br.com.lucasmancan.math.models.OperationType;

public abstract class OperatorFactory {
    public static Operator create(OperationType acao){

        Operator operator = null;

        switch (acao){
            case soma:
                operator = new SumOperator();
            break;
            case media:
                operator = new AverageOperator();
                break;
            case subtrai:
                operator = new SubtractionOperator();
                break;
            case total:
                operator = new CountOperator();
                break;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }


        return operator;
    }
}
