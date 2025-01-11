package com.example.api.dto.dtoDesenvolvedor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DtoCadastraDesenvolvedor(
        @NotBlank String nome,
        @NotNull  LocalDate dataFundacao,
        @NotBlank String website,
        @NotBlank String sede
) {

}
