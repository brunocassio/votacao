package com.example.votacao.application.rest;

import com.example.votacao.application.mapper.PautaMaper;
import com.example.votacao.application.request.PautaRequest;
import com.example.votacao.application.request.PautaResponse;
import com.example.votacao.application.response.AbrirVotacaoResponse;
import com.example.votacao.domain.exception.PautaNotFoundException;
import com.example.votacao.domain.model.Pauta;
import com.example.votacao.domain.service.PautaService;
import com.example.votacao.infrastructure.repository.entity.PautaEntity;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/pauta")
public class PautaController {

    private PautaService pautaService;
    private PautaMaper pautaMaper;

    public PautaController(PautaService pautaService, PautaMaper pautaMaper) {
        this.pautaService = pautaService;
        this.pautaMaper = pautaMaper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PautaResponse> cadastrarPauta(@RequestBody PautaRequest request) {
        return ResponseEntity.ok(pautaMaper.toResponse(pautaService.inserir(pautaMaper.toModel(request))));
    }

    @PatchMapping("/{id}/abrir-votacao")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AbrirVotacaoResponse> abrirVotacao(@PathVariable("id") @Parameter(name = "id", description = "id da Pauta", example = "1") Long id,
                                                             @RequestParam(name = "duracao", required = false) Long duracao) {
        Pauta pauta = pautaService.buscarPauta(id);
        pauta.setVotacaoAberta(true);
        pautaService.editarPauta(pauta);
        pautaService.encerrarVotacao(id, duracao != null ? duracao : 1L);

        return ResponseEntity.ok(new AbrirVotacaoResponse("Votação iniciada para a pauta: " + pauta.getTitulo().toUpperCase() +
                ". A votação será encerrada em " + duracao + " minutos."));
    }
}
