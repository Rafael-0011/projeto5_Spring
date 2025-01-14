package com.example.api.dto.consoleDto;

import com.example.api.model.Console;

import java.time.LocalDate;


public record ConsoleListagemDto(
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
