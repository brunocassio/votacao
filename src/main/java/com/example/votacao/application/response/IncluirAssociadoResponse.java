package com.example.votacao.application.response;

import com.example.votacao.domain.model.Voto;

import java.util.List;

public record IncluirAssociadoResponse(int id, String nome, String cpf, List<Voto> votos) {
}
