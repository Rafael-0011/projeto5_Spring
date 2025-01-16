package com.example.api.dto.desenvolvedorDto;

import com.example.api.model.Desenvolvedor;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DesenvolvedorAtualizarDto(
        @Schema(example = "1")
        @NotBlank  Long id,
        String nome,
        LocalDate dataFundacao,
        String website,
        String sede
) {
    public DesenvolvedorAtualizarDto(Desenvolvedor desenvolvedor) {
        this(
                desenvolvedor.getId(),
                desenvolvedor.getNome(),
                desenvolvedor.getDataFundacao(),
                desenvolvedor.getWebsite(),
                desenvolvedor.getSede()


        );
    }

}
