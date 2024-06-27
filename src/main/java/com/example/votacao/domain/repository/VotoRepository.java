package com.example.votacao.domain.repository;

import com.example.votacao.domain.model.Voto;

import java.util.List;

public interface VotoRepository {

    List<Voto> findByPautaId(Long pautaId);
    void registrarVoto(Voto voto);
}
