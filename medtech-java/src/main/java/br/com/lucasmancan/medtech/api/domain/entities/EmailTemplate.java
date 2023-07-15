package br.com.lucasmancan.medtech.api.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailTemplate extends AbstractEntity {

    @NotEmpty
    private String code;
    @NotEmpty
    private String subject;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "html_body")
    private String htmlBody;
}
