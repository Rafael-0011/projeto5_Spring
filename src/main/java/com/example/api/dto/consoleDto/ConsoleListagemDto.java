package com.example.api.dto.consoleDto;

import com.example.api.model.Console;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;


public record ConsoleListagemDto(
        @Schema(example = "1")
        Long id,
        String nome,
        LocalDate dataLancamento,
        String empresa
) {
    public ConsoleListagemDto(Console console) {
        this(
                console.getId(),
                console.getNome(),
                console.getDataLancamento(),
                console.getEmpresa()
        );
    }
}
