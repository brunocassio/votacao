package com.example.votacao.domain.repository;

import com.example.votacao.domain.model.Associado;

public interface AssociadoRepository {

    Associado incluir(Associado associado);
    Associado buscarAssociadoById(Long id);
}
