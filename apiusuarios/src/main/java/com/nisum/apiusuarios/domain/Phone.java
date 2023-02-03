package com.nisum.apiusuarios.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Table;

import java.io.Serializable;

@Data
@Entity
@Builder
@Table(appliesTo = "phone")
public class Phone implements Serializable {
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

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String number;

    @Column(name = "city_code", nullable = false)
    private String cityCode;

    @Column(name = "country_code", nullable = false)
    private String countryCode;

}
