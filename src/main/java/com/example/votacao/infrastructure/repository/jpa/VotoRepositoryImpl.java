package com.example.votacao.infrastructure.repository.jpa;

import com.example.votacao.application.mapper.VotoMapper;
import com.example.votacao.domain.model.Voto;
import com.example.votacao.domain.repository.VotoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VotoRepositoryImpl implements VotoRepository {

    private final JpaVotoRepository jpaVotoRepository;
    private final VotoMapper votoMapper;

    public VotoRepositoryImpl(JpaVotoRepository jpaVotoRepository, VotoMapper votoMapper) {
        this.jpaVotoRepository = jpaVotoRepository;
        this.votoMapper = votoMapper;
    }

    @Override
    public List<Voto> findByPautaId(Long pautaId) {
        return jpaVotoRepository.findByPautaId(pautaId).stream().map(votoMapper::toModel).toList();
    }

    @Override
    public void registrarVoto(Voto voto) {
         jpaVotoRepository.save(votoMapper.toEntity(voto));
    }
}
