package com.example.votacao.infrastructure.repository.jpa;

import com.example.votacao.domain.exception.AssociadoNotFoundException;
import com.example.votacao.domain.model.Associado;
import com.example.votacao.domain.repository.AssociadoRepository;
import com.example.votacao.infrastructure.repository.entity.AssociadoEntity;
import com.example.votacao.infrastructure.repository.mapper.AssociadoEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class AssociadoRepositoryImpl implements AssociadoRepository {

    private final JpaAssociadoRepository jpaAssociadoRepository;
    private final AssociadoEntityMapper associadoEntityMapper;

    public AssociadoRepositoryImpl(JpaAssociadoRepository jpaAssociadoRepository, AssociadoEntityMapper associadoEntityMapper) {
        this.jpaAssociadoRepository = jpaAssociadoRepository;
        this.associadoEntityMapper = associadoEntityMapper;
    }

    @Override
    public Associado incluir(Associado associado) {
        AssociadoEntity entity = associadoEntityMapper.toEntity(associado);
        AssociadoEntity savedEntity = jpaAssociadoRepository.save(entity);
        Associado model = associadoEntityMapper.toModel(savedEntity);
        return model;
    }

    @Override
    public Associado buscarAssociadoById(Long id) {
        return associadoEntityMapper.toModel(jpaAssociadoRepository.findById(id).orElseThrow(AssociadoNotFoundException::new));
    }
}
