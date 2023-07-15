package br.com.lucasmancan.medtech.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DrugDTO {
    private String id;
    private String name;
    private String details;
}
