package com.example.votacao.application.rest;

import com.example.votacao.application.response.RegistraVotoResponse;
import com.example.votacao.application.response.ResultadoVotacaoResponse;
import com.example.votacao.domain.exception.PautaNotFoundException;
import com.example.votacao.domain.model.Associado;
import com.example.votacao.domain.model.Pauta;
import com.example.votacao.domain.model.ResultadoVotacao;
import com.example.votacao.domain.model.Voto;
import com.example.votacao.domain.service.AssociadoService;
import com.example.votacao.domain.service.PautaService;
import com.example.votacao.domain.service.VotoService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/voto")
public class VotoController {

    private final PautaService pautaService;
    private final VotoService votoService;
    private final AssociadoService associadoService;

    public VotoController(PautaService pautaService, VotoService votoService, AssociadoService associadoService) {
        this.pautaService = pautaService;
        this.votoService = votoService;
        this.associadoService = associadoService;
    }

    @GetMapping("/{id}/contabilizar-votos")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResultadoVotacaoResponse> contabilizarVotos(@PathVariable("id") @Parameter(name = "id", description = "id da Pauta", example = "1") Long id ) {
        List<Voto> votosPorPauta = votoService.buscarVotosPorPauta(id);
        ResultadoVotacao resultadoVotacao = votoService.calcularResultadoVotacao(votosPorPauta);
        return ResponseEntity.ok(new ResultadoVotacaoResponse(resultadoVotacao.totalVotos(), resultadoVotacao.resultado()));
    }

    @PostMapping("/{id}/registrar-voto")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<RegistraVotoResponse> registrarVoto(
            @PathVariable("id") @Parameter(name = "id", description = "id da Pauta", example = "1") Long id,
            @RequestParam("associadoId") Long associadoId,
            @RequestParam("voto") @Parameter(name = "voto", description = "Opção do Voto", example = "S") String voto) {
        votoService.validarVoto(voto);
        Pauta pauta = pautaService.buscarPauta(id);

        if (!pauta.isVotacaoAberta()) {
            return ResponseEntity.ok(new RegistraVotoResponse("Votação encerrada para a pauta: " + pauta.getTitulo()));
        }
        List<Voto> votosPorPauta = votoService.buscarVotosPorPauta(id);
        Associado associado = associadoService.buscarAssociadoById(associadoId);

        return ResponseEntity.ok(new RegistraVotoResponse(votoService.registrarVoto(votosPorPauta, associado, voto, pauta)));
    }
}
