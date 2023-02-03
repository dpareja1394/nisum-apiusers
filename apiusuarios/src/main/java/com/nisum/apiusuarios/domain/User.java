package com.nisum.apiusuarios.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Table;

import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
@Builder
@Table(appliesTo = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column()
    @ColumnDefault("random_uuid()")
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Instant created;

    @Column()
    private Instant modified;

    @Column(name = "last_login", nullable = false)
    private Instant lastLogin;

    @Column(updatable = false, nullable = false)
    private String token;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
}
