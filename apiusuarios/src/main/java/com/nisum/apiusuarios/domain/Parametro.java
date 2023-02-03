package com.nisum.apiusuarios.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Table;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(appliesTo = "parametro")
public class Parametro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column()
    private String id;

    @Column(nullable = false)
    private String valor;
}
