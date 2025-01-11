package com.example.api.dto.dtoConsole;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;


public record DtoCadastraConsole(
        @NotBlank
        String nome,
        @NotBlank
        LocalDate dataLancamento,
        @NotBlank
        String empresa
) {

}
