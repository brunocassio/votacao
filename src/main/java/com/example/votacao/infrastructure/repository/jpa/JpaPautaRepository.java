package com.example.votacao.infrastructure.repository.jpa;

import com.example.votacao.infrastructure.repository.entity.PautaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPautaRepository extends JpaRepository<PautaEntity, Long> {
}
