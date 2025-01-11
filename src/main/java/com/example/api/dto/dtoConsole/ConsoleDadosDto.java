package com.example.api.dto.dtoConsole;

import com.example.api.model.Console;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record ConsoleDadosDto(
        @NotBlank
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        LocalDate dataLancamento,
        @NotBlank
        String empresa
) {
    public ConsoleDadosDto(Console console) {
        this(
                console.getId(),
                console.getNome(),
                console.getDataLancamento(),
                console.getEmpresa()
        );
    }

}