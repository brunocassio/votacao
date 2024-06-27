package com.example.votacao.domain.service;

import com.example.votacao.domain.exception.VotoInvalidoException;
import com.example.votacao.domain.model.Associado;
import com.example.votacao.domain.model.Pauta;
import com.example.votacao.domain.model.ResultadoVotacao;
import com.example.votacao.domain.model.Voto;
import com.example.votacao.domain.repository.VotoRepository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class DomainVotoService implements VotoService{

    private final VotoRepository votoRepository;

    public DomainVotoService(VotoRepository votoRepository) {
        this.votoRepository = votoRepository;
    }

    @Override
    public List<Voto> buscarVotosPorPauta(Long idPauta) {
        return votoRepository.findByPautaId(idPauta);
    }

    @Override
    public void validarVoto(String voto) {
        if (!voto.matches("^[SN]$")) {
            throw new VotoInvalidoException();
        }
    }

    @Override
    public String registrarVoto(List<Voto> votosPorPauta, Associado associado, String voto, Pauta pauta) {

        if (!votosPorPauta.isEmpty()) {
            if (votosPorPauta.stream().anyMatch(v -> Objects.equals(v.getAssociado().getId(), associado.getId()))) {
                return "Associado já votou nesta pauta.";
            } else {
                registrarVoto(voto, pauta, associado);
                return "Voto registrado com sucesso para a pauta: " + pauta.getTitulo();
            }
        } else {
            registrarVoto(voto, pauta, associado);
            return "Voto registrado com sucesso para a pauta: " + pauta.getTitulo();
        }
    }

    @Override
    public ResultadoVotacao calcularResultadoVotacao(List<Voto> votosPorPauta) {
        Map<String, Long> contagemPorValor = votosPorPauta.stream()
                .collect(Collectors.groupingBy(Voto::getOpcao, Collectors.counting()));

        long contadorS = contagemPorValor.getOrDefault("S", 0L);
        long contadorN = contagemPorValor.getOrDefault("N", 0L);
        long totalVotos = votosPorPauta.size();

        String resultado = contadorS > contadorN ? "S" : (contadorS < contadorN ? "N" : "EMPATE");
        return new ResultadoVotacao(totalVotos, resultado);
    }

    private void registrarVoto(String voto, Pauta pauta, Associado associado) {
        Voto votoDoAssociado = Voto.builder()
                .opcao(voto)
                .pauta(pauta)
                .associado(associado)
                .build();
        votoRepository.registrarVoto(votoDoAssociado);
    }
}
