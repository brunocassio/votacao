package com.example.votacao.domain.service;

import com.example.votacao.domain.model.Pauta;

import java.util.Optional;

public interface PautaService {

    Pauta inserir(Pauta pauta);
    Pauta buscarPauta(Long id);
    void editarPauta(Pauta pauta);
    void encerrarVotacao(Long id, Long duracao);
}
