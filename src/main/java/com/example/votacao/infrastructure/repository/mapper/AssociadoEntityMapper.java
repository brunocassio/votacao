package com.example.votacao.infrastructure.repository.mapper;

import com.example.votacao.domain.model.Associado;
import com.example.votacao.infrastructure.repository.entity.AssociadoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssociadoEntityMapper {

    AssociadoEntity toEntity(Associado associado);
    Associado toModel(AssociadoEntity entity);
}
