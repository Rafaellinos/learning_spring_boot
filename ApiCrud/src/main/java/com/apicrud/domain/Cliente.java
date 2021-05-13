package com.apicrud.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Builder
@Data
@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    public Cliente() {
        super();
    }

    public Cliente(Long id, String nome) {
        super();
        this.id = id;
        this.nome = nome;
    }

    public Cliente(Long id, String nome, Date dataNascimento) {
        super();
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

}
