package com.example.votacao.domain.service;

import com.example.votacao.domain.model.Associado;
import com.example.votacao.domain.repository.AssociadoRepository;

public class DomainAssociadoService implements AssociadoService{

    private final AssociadoRepository associadoRepository;

    public DomainAssociadoService(AssociadoRepository associadoRepository) {
        this.associadoRepository = associadoRepository;
    }

    @Override
    public Associado incluir(Associado associado) {
        return associadoRepository.incluir(associado);
    }

    @Override
    public Associado buscarAssociadoById(Long id) {
        return associadoRepository.buscarAssociadoById(id);
    }
}
