package com.example.votacao.infrastructure.repository.jpa;

import com.example.votacao.infrastructure.repository.entity.AssociadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAssociadoRepository extends JpaRepository<AssociadoEntity, Long> {
}
