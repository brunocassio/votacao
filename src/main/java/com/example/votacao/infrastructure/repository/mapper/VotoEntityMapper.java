package com.example.votacao.infrastructure.repository.mapper;

import com.example.votacao.domain.model.Voto;
import com.example.votacao.infrastructure.repository.entity.VotoEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VotoEntityMapper {

    List<VotoEntity> toEntityList(List<Voto> modelList);
}
