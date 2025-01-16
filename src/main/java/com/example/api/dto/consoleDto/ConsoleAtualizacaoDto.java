package com.example.api.dto.consoleDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record ConsoleAtualizacaoDto(
        @Schema(example = "1")
        @NotBlank Long id,
        String nome,
        LocalDate dataLancamento,
        String empresa
) {
}
