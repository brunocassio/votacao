package com.example.votacao.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Voto {

    private Long id;
    private String opcao;
    private Pauta pauta;
    private Associado associado;
}
