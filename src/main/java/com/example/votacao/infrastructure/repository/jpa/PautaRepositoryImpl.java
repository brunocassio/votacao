package com.example.votacao.infrastructure.repository.jpa;

import com.example.votacao.domain.exception.PautaNotFoundException;
import com.example.votacao.domain.model.Pauta;
import com.example.votacao.domain.repository.PautaRepository;
import com.example.votacao.infrastructure.repository.entity.PautaEntity;
import com.example.votacao.infrastructure.repository.entity.VotoEntity;
import com.example.votacao.infrastructure.repository.mapper.PautaEntityMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PautaRepositoryImpl implements PautaRepository {

    private final JpaPautaRepository jpaPautaRepository;
    private final PautaEntityMapper pautaEntityMapper;

    public PautaRepositoryImpl(JpaPautaRepository jpaPautaRepository, PautaEntityMapper pautaEntityMapper) {
        this.jpaPautaRepository = jpaPautaRepository;
        this.pautaEntityMapper = pautaEntityMapper;
    }

    @Override
    public Pauta inserir(Pauta pauta) {
        return pautaEntityMapper.toModel(jpaPautaRepository.save(pautaEntityMapper.toEntity(pauta)));
    }

    @Override
    public Pauta buscarPauta(Long id) {
        return pautaEntityMapper.toModel(jpaPautaRepository.findById(id).orElseThrow(PautaNotFoundException::new));
    }

    @Override
    public void editarPauta(Pauta pauta) {
        jpaPautaRepository.save(pautaEntityMapper.toEntity(pauta));
    }
}
