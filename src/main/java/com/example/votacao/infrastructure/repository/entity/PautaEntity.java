package com.example.votacao.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "PAUTA")
public class PautaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descricao;
    private boolean votacaoAberta;
    @OneToMany(mappedBy = "pauta", fetch = FetchType.LAZY)
    private List<VotoEntity> votos;
}
