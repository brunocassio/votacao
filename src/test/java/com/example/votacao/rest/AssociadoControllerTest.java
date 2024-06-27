package com.example.votacao.rest;

import com.example.votacao.application.mapper.AssociadoMapper;
import com.example.votacao.application.request.IncluirAssociadoRequest;
import com.example.votacao.application.rest.AssociadoController;
import com.example.votacao.domain.model.Associado;
import com.example.votacao.domain.service.AssociadoService;
import com.example.votacao.util.Responses;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class AssociadoControllerTest {

    @InjectMocks
    private AssociadoController associadoController;
    @Mock
    private AssociadoService associadoService;
    @Mock
    private AssociadoMapper associadoMapper;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(associadoController).build();
    }

    @Test
    public void testarIncluirAssociado() throws Exception {
        Associado model = Associado.builder().nome("Bruno").cpf("01234567891").id(0L).build();
        Mockito.when(associadoMapper.fromRequestToModel(Mockito.any(IncluirAssociadoRequest.class))).thenReturn(model);
        Mockito.when(associadoService.incluir(Mockito.any(Associado.class))).thenReturn(model);
        mockMvc.perform(post("/v1/associado").content(Responses.EXPECTED_INSERT_REPONSE).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}
