package br.com.lucasmancan.medtech.api.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Token extends AbstractEntity {

    private String tokenCode = UUID.randomUUID().toString().substring(0, 8);

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "user_id", updatable = false, nullable = false)
    private String userId;

    @Column(name = "expires_at")
    private Date expiresAt;
}
