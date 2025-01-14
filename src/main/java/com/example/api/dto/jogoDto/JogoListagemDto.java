package com.example.api.dto.jogoDto;

import com.example.api.dto.consoleDto.ConsoleIdDto;
import com.example.api.dto.desenvolvedorDto.DesenvolvedorIdDto;
import com.example.api.model.Jogo;

import java.time.LocalDate;
import java.util.List;


public record JogoListagemDto(
        Long id,
        String descricao,
        LocalDate dataLancamento,
        String website,
        DesenvolvedorIdDto desenvolvedor,
        String genero,
        String urlCapa,
        List<ConsoleIdDto> console

) {
    public JogoListagemDto(Jogo jogo) {
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
