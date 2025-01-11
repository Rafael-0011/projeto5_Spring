package com.example.api.dto.dtoConsole;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DtoAtualizacaoConsole(
       @NotBlank Long id,
        String nome,
        LocalDate dataLancamento,
        String empresa
) {
}
