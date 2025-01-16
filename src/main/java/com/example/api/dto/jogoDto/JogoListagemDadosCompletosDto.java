package com.example.api.dto.jogoDto;

import com.example.api.dto.consoleDto.ConsoleListagemDto;
import com.example.api.dto.desenvolvedorDto.DesenvolvedorListagemDto;
import com.example.api.model.Jogo;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.List;

public record JogoListagemDadosCompletosDto(
        @Schema(example = "1")
        Long id,
        String descricao,
        LocalDate dataLancamento,
        String website,
        DesenvolvedorListagemDto desenvolvedor,
        String genero,
        String urlCapa,
        List<ConsoleListagemDto> Console
) {

    public JogoListagemDadosCompletosDto(Jogo jogo) {
        this(
                jogo.getId(),
                jogo.getDescricao(),
                jogo.getDataLancamento(),
                jogo.getWebsite(),
                new DesenvolvedorListagemDto(jogo.getDesenvolvedor()),
                jogo.getGenero(),
                jogo.getUrlCapa(),
                jogo.getConsole().stream()
                        .map(ConsoleListagemDto::new)
                        .toList()

        );
    }
}
