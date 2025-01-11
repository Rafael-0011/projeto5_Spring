package com.example.api.dto.dtoConsole;

import com.example.api.model.Console;

import java.time.LocalDate;


public record DtoListagemConsole(
        Long id,
        String nome,
        LocalDate dataLancamento,
        String empresa
) {

    public DtoListagemConsole(Console console) {
        this(
                console.getId(),
                console.getNome(),
                console.getDataLancamento(),
                console.getEmpresa()
        );
    }
}
