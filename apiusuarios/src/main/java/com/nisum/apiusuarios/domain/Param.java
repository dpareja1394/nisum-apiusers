package com.nisum.apiusuarios.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Table;

import java.io.Serializable;

import static lombok.Builder.*;

@Data
@Entity
@NoArgsConstructor
@Table(appliesTo = "param")
public class Param implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column()
    private String id;

    @Column(name = "val", nullable = false)
    private String val;
}
