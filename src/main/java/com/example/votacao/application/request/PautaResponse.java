package com.example.votacao.application.request;

public record PautaResponse(Long id, String titulo, String descricao, boolean votacaoAberta) {
}
