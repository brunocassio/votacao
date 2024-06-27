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
@Table(name = "ASSOCIADO")
public class AssociadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cpf;
    @OneToMany(mappedBy = "associado")
    private List<VotoEntity> votos;
}
