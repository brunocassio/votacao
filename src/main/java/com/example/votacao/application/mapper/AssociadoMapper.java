package com.example.votacao.application.mapper;

import com.example.votacao.application.request.IncluirAssociadoRequest;
import com.example.votacao.application.response.IncluirAssociadoResponse;
import com.example.votacao.domain.model.Associado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssociadoMapper {

    Associado fromRequestToModel(IncluirAssociadoRequest request);
    IncluirAssociadoResponse fromModelToResponse(Associado associado);
}
