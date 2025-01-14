package com.example.api.dto.consoleDto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record ConsoleAtualizacaoDto(
       @NotBlank Long id,
        String nome,
        LocalDate dataLancamento,
        String empresa
) {
}
