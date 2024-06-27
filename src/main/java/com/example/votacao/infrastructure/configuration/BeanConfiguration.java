package com.example.votacao.infrastructure.configuration;

import com.example.votacao.VotacaoApplication;
import com.example.votacao.domain.repository.AssociadoRepository;
import com.example.votacao.domain.repository.PautaRepository;
import com.example.votacao.domain.repository.VotoRepository;
import com.example.votacao.domain.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = VotacaoApplication.class)
public class BeanConfiguration {

    @Bean
    AssociadoService associadoService(AssociadoRepository associadoRepository) {
        return new DomainAssociadoService(associadoRepository);
    }

    @Bean
    PautaService pautaService(PautaRepository pautaRepository) {
        return new DomainPautaService(pautaRepository);
    }

    @Bean
    VotoService votoService(VotoRepository votoRepository) {
        return new DomainVotoService(votoRepository);
    }

}
