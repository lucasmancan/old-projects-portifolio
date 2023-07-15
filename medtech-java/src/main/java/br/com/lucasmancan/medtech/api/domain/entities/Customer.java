package br.com.lucasmancan.medtech.api.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends AbstractEntity {

    @Enumerated(EnumType.ORDINAL)
    private Status status = Status.active;

    @JoinColumn(name = "user_id", updatable = false, nullable = false)
    private String userId;

    @NotEmpty
    private String name;

    @NotEmpty
    private String phone;

    @Email
    private String email;
    private String details;

}
