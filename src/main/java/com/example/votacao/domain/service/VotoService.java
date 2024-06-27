package com.example.votacao.domain.service;

import com.example.votacao.domain.model.Associado;
import com.example.votacao.domain.model.Pauta;
import com.example.votacao.domain.model.ResultadoVotacao;
import com.example.votacao.domain.model.Voto;

import java.util.List;

public interface VotoService {
    List<Voto> buscarVotosPorPauta(Long idPauta);
    void validarVoto(String voto);
    String registrarVoto(List<Voto> votosPorPauta, Associado associado, String voto, Pauta pauta);
    ResultadoVotacao calcularResultadoVotacao(List<Voto> votosPorPauta);
}
