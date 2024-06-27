package com.example.votacao.infrastructure.repository.jpa;

import com.example.votacao.infrastructure.repository.entity.VotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaVotoRepository extends JpaRepository<VotoEntity, Long> {

    List<VotoEntity> findByPautaId(Long pautaId);
}
