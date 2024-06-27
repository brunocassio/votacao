package com.example.votacao.application.rest;

import com.example.votacao.application.mapper.AssociadoMapper;
import com.example.votacao.application.request.IncluirAssociadoRequest;
import com.example.votacao.application.response.IncluirAssociadoResponse;
import com.example.votacao.domain.model.Associado;
import com.example.votacao.domain.service.AssociadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/associado")
public class AssociadoController {

    private final AssociadoService associadoService;
    private final AssociadoMapper associadoMapper;

    public AssociadoController(AssociadoService associadoService, AssociadoMapper associadoMapper) {
        this.associadoService = associadoService;
        this.associadoMapper = associadoMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<IncluirAssociadoResponse> incluirAssociado(@RequestBody IncluirAssociadoRequest request) {
        Associado associado = associadoMapper.fromRequestToModel(request);
        IncluirAssociadoResponse response = associadoMapper.fromModelToResponse(associadoService.incluir(associado));
        return ResponseEntity.ok(response);
    }
}
