package com.example.votacao.domain.service;

import com.example.votacao.domain.model.Associado;

public interface AssociadoService {

    Associado incluir(Associado associado);
    Associado buscarAssociadoById(Long id);
}
