package com.example.votacao.domain.service;

import com.example.votacao.domain.model.Pauta;
import com.example.votacao.domain.repository.PautaRepository;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DomainPautaService implements PautaService{

    private final PautaRepository pautaRepository;
    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

    public DomainPautaService(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    @Override
    public Pauta inserir(Pauta pauta) {
        return pautaRepository.inserir(pauta);
    }

    @Override
    public Pauta buscarPauta(Long id) {
        return pautaRepository.buscarPauta(id);
    }

    @Override
    public void editarPauta(Pauta pauta) {
        pautaRepository.editarPauta(pauta);
    }

    @Override
    public void encerrarVotacao(Long id, Long duracao) {
        executorService.schedule(() -> encerrarVotacao(id), duracao, TimeUnit.MINUTES);
    }

    private void encerrarVotacao(Long id) {
        Pauta pauta = pautaRepository.buscarPauta(id);
        pauta.setVotacaoAberta(false);
        pautaRepository.editarPauta(pauta);
    }
}
