package br.com.lucasmancan.medtech.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements Serializable {
    private String id;
    private Date createdAt;
    private String name;
}
