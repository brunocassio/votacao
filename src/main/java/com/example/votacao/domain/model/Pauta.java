package com.example.votacao.domain.model;


import java.util.List;


public class Pauta {

    private Long id;
    private String titulo;
    private String descricao;
    private boolean votacaoAberta;
    private List<Voto> votos;

    public Pauta(Long id, String titulo, String descricao, boolean votacaoAberta, List<Voto> votos) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.votacaoAberta = votacaoAberta;
        this.votos = votos;
    }

    public Pauta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isVotacaoAberta() {
        return votacaoAberta;
    }

    public void setVotacaoAberta(boolean votacaoAberta) {
        this.votacaoAberta = votacaoAberta;
    }

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }
}
