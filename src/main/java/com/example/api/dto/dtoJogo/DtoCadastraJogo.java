package com.example.api.dto.dtoJogo;

import com.example.api.dto.dtoConsole.DtoIdConsole;
import com.example.api.dto.dtoDesenvolvedor.DtoIdDesenvolvedor;
import com.example.api.model.Console;
import com.example.api.model.Desenvolvedor;
import com.example.api.model.Jogo;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

public record DtoCadastraJogo(
        @NotBlank String descricao,
        @NotBlank LocalDate dataLancamento,
        @NotBlank String website,
        @NotBlank DtoIdDesenvolvedor desenvolvedor,
        @NotBlank String genero,
        @NotBlank String urlCapa,
        @NotBlank List<DtoIdConsole> console
) {
    public DtoCadastraJogo(Jogo jogo) {
        this(
                jogo.getDescricao(),
                jogo.getDataLancamento(),
                jogo.getWebsite(),
                new DtoIdDesenvolvedor(jogo.getDesenvolvedor().getId()),
                jogo.getGenero(),
                jogo.getUrlCapa(),
                jogo.getConsole().stream()
                        .map(console -> new DtoIdConsole(console.getId()))
                        .toList()

        );
    }



}
