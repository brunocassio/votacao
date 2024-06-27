package com.example.votacao.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "VOTO")
public class VotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String opcao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pauta_id")
    private PautaEntity pauta;
    @ManyToOne
    @JoinColumn(name = "associado_id")
    private AssociadoEntity associado;

    public VotoEntity(Long id, String opcao, PautaEntity pauta, AssociadoEntity associado) {
        this.id = id;
        this.opcao = opcao;
        this.pauta = pauta;
        this.associado = associado;
    }

    public VotoEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpcao() {
        return opcao;
    }

    public void setOpcao(String opcao) {
        this.opcao = opcao;
    }

    public PautaEntity getPauta() {
        return pauta;
    }

    public void setPauta(PautaEntity pauta) {
        this.pauta = pauta;
    }

    public AssociadoEntity getAssociado() {
        return associado;
    }

    public void setAssociado(AssociadoEntity associado) {
        this.associado = associado;
    }
}
