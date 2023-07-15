package br.com.lucasmancan.math.models;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

public enum OperationType {
    soma, subtrai, media, total;

    @JsonCreator
    public static OperationType forValue(String value) {
        return Arrays.asList(OperationType.values()).stream().filter( enumValue -> enumValue.name().equalsIgnoreCase(value)).findFirst().orElse(null);
    }
}
