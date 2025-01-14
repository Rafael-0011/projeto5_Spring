package com.example.api.dto.jogoDto;

import com.example.api.dto.consoleDto.ConsoleIdDto;
import com.example.api.dto.desenvolvedorDto.DesenvolvedorIdDto;
import com.example.api.model.Jogo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record JogoCadastraDto(
        Long id,
        @NotBlank String descricao,
        @NotNull LocalDate dataLancamento,
        @NotBlank String website,
        @NotBlank DesenvolvedorIdDto desenvolvedor,
        @NotBlank String genero,
        @NotBlank String urlCapa,
        @NotNull List<ConsoleIdDto> console
) {
    public JogoCadastraDto(Jogo jogo) {
        this(
                jogo.getId(),
                jogo.getDescricao(),
                jogo.getDataLancamento(),
                jogo.getWebsite(),
                new DesenvolvedorIdDto(jogo.getDesenvolvedor().getId()),
                jogo.getGenero(),
                jogo.getUrlCapa(),
                jogo.getConsole().stream()
                        .map(console -> new ConsoleIdDto(console.getId()))
                        .toList()

        );
    }


}
