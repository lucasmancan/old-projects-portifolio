package br.com.lucasmancan.medtech.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse implements Serializable {
    private List<String> errors;
    private String message;
    private int status;
    private LocalDateTime timestamp;
}
