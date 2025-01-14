package com.example.api.dto.desenvolvedorDto;

import com.example.api.model.Desenvolvedor;

import java.time.LocalDate;

public record DesenvolvedorListagemDto(
        Long id,
        String nome,
        LocalDate dataFundacao,
        String website,
        String sede
) {

    public DesenvolvedorListagemDto(Desenvolvedor desenvolvedor) {
        this(
                desenvolvedor.getId(),
                desenvolvedor.getNome(),
                desenvolvedor.getDataFundacao(),
                desenvolvedor.getWebsite(),
                desenvolvedor.getSede()
        );
    }
}
