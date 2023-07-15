package br.com.lucasmancan.math.models;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

import javax.validation.Payload;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class Operation {

    @NotNull(message = "The property 'acao' is required")
    @JsonEnumDefaultValue()
    private OperationType acao;

    @NotNull(message = "The property 'numeros' is required")
    @NotEmpty(message = "The property 'numeros' can not be empty")
    private List<Integer> numeros;

    public Operation(OperationType acao, List<Integer> numeros) {
        this.acao = acao;
        this.numeros = numeros;
    }

    public OperationType getAcao() {
        return acao;
    }

    public void setAcao(OperationType acao) {
        this.acao = acao;
    }

    public List<Integer> getNumeros() {
        return numeros;
    }

    public void setNumeros(List<Integer> numeros) {
        this.numeros = numeros;
    }
}
