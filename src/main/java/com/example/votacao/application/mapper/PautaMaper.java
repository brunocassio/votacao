package com.example.votacao.application.mapper;

import com.example.votacao.application.request.PautaRequest;
import com.example.votacao.application.request.PautaResponse;
import com.example.votacao.domain.model.Pauta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PautaMaper {

    Pauta toModel(PautaRequest request);
    PautaResponse toResponse(Pauta pauta);
}
