package com.example.api.dto.dtoDesenvolvedor;

import com.example.api.model.Desenvolvedor;

import java.time.LocalDate;

public record DtoObterdesenvolverdor(
        Long id,
        String nome,
        LocalDate dataFundacao,
        String website,
        String sede
) {

    public DtoObterdesenvolverdor(Desenvolvedor desenvolvedor) {
        this(
                desenvolvedor.getId(),
                desenvolvedor.getNome(),
                desenvolvedor.getDataFundacao(),
                desenvolvedor.getWebsite(),
                desenvolvedor.getSede()
        );
    }
}
