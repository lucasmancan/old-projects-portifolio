package br.com.lucasmancan.pms.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "people")
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotNull
    @JsonProperty("nome")
    private String name;

    @Max(120)
    @Min(0)
    @JsonProperty("idade")
    private Integer age;

    @NotNull
    @JsonProperty("salario")
    private BigDecimal salary;

    @JsonIgnore
    private LocalDateTime createdAt;

    @JsonProperty("alteracao")
    private LocalDateTime updatedAt;

    @PreUpdate
    void update(){
        this.updatedAt = LocalDateTime.now();
    }


    @PrePersist
    void persist(){
        this.updatedAt = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
    }
}
