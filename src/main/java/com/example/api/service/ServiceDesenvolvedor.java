package com.example.api.service;

import com.example.api.dto.dtoDesenvolvedor.DtoAtualizarDesenvolvedor;
import com.example.api.model.Desenvolvedor;
import org.springframework.stereotype.Service;

@Service
public class ServiceDesenvolvedor {


    public void atualizarInformacaoDesenvolvedor(DtoAtualizarDesenvolvedor dados, Desenvolvedor desenvolvedor) {
        if (dados.id() != null) {
            desenvolvedor.setId(dados.id());
        }
        if (dados.nome() != null) {
            desenvolvedor.setNome(dados.nome());
        }
        if (dados.dataFundacao() != null) {
            desenvolvedor.setDataFundacao(dados.dataFundacao());
        }
        if (dados.website() != null) {
            desenvolvedor.setWebsite(dados.website());
        }
        if (dados.sede() != null) {
            desenvolvedor.setSede(dados.sede());
        }
    }
}
