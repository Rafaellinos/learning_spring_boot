package com.apicrud.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class Cliente {

    private Long id;

    private String nome;

    private Date dataNascimento;

}
