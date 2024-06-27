package com.example.votacao.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Associado {

    private Long id;
    private String nome;
    private String cpf;
    private List<Voto> votos;
}
