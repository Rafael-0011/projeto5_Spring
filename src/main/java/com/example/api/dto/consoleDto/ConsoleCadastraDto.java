package com.example.api.dto.consoleDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public record ConsoleCadastraDto(
        @NotBlank
        String nome,
        @NotNull
        LocalDate dataLancamento,
        @NotBlank
        String empresa
) {

}
