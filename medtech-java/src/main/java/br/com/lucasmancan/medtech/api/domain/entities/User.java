package br.com.lucasmancan.medtech.api.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User extends AbstractEntity {

    @JsonIgnore
    private String password;

    @NotEmpty
    private String name;

    private String document;

    @NotEmpty
    private String phone;

    @Email
    private String email;
    private String details;

}
