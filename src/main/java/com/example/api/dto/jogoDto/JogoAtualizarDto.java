package com.example.api.dto.jogoDto;

import com.example.api.dto.consoleDto.ConsoleIdDto;
import com.example.api.dto.desenvolvedorDto.DesenvolvedorIdDto;
import com.example.api.model.Jogo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

public record JogoAtualizarDto(
        @Schema(example = "1")
        @NotBlank
        Long id,
        String nome,
        String descricao,
        LocalDate dataLancamento,
        String website,
        DesenvolvedorIdDto desenvolvedor,
        String genero,
        String urlCapa,
        List<ConsoleIdDto> console
) {
    public JogoAtualizarDto(Jogo jogo) {
        this(
                jogo.getId(),
                jogo.getNome(),
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
