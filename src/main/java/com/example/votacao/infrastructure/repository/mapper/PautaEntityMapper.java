package com.example.votacao.infrastructure.repository.mapper;

import com.example.votacao.domain.model.Pauta;
import com.example.votacao.infrastructure.repository.entity.PautaEntity;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface PautaEntityMapper {

    PautaEntity toEntity(Pauta model);
    Pauta toModel(PautaEntity entity);

}
