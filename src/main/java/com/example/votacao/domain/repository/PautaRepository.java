package com.example.votacao.domain.repository;

import com.example.votacao.domain.model.Pauta;

public interface PautaRepository {

    Pauta inserir(Pauta pauta);
    Pauta buscarPauta(Long id);
    void editarPauta(Pauta pauta);
}
