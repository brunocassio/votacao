package com.example.votacao.application.mapper;

import com.example.votacao.domain.model.Voto;
import com.example.votacao.infrastructure.repository.entity.VotoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VotoMapper {

    Voto toModel(VotoEntity votoEntity);
    VotoEntity toEntity(Voto voto);

}
