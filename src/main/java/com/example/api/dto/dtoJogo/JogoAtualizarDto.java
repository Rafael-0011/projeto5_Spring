package com.example.api.dto.dtoJogo;

import com.example.api.dto.dtoConsole.DtoIdConsole;
import com.example.api.dto.dtoDesenvolvedor.DtoIdDesenvolvedor;
import com.example.api.model.Desenvolvedor;
import com.example.api.model.Jogo;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

public record JogoAtualizarDto(
        @NotBlank Long id,
        String descricao,
        LocalDate dataLancamento,
        String website,
        DtoIdDesenvolvedor desenvolvedor,
        String genero,
        String urlCapa,
        List<DtoIdConsole> console
) {
    public JogoAtualizarDto(Jogo jogo) {
        this(
                jogo.getId(),
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
