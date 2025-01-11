package com.example.api.dto.dtoDesenvolvedor;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DtoAtualizarDesenvolvedor(
        @NotBlank  Long id,
        String nome,
        LocalDate dataFundacao,
        String website,
        String sede
) {
}
