package com.example.api.dto.dtoJogo;

import com.example.api.dto.dtoConsole.DtoIdConsole;
import com.example.api.dto.dtoConsole.DtoListagemConsole;
import com.example.api.dto.dtoDesenvolvedor.DtoIdDesenvolvedor;
import com.example.api.dto.dtoDesenvolvedor.DtoListagemDesenvolvedor;
import com.example.api.model.Jogo;

import java.time.LocalDate;
import java.util.List;

public record JogoListagemDadosCompletosDto(
        Long id,
        String descricao,
        LocalDate dataLancamento,
        String website,
        DtoListagemDesenvolvedor desenvolvedor,
        String genero,
        String urlCapa,
        List<DtoListagemConsole> Console
) {

    public JogoListagemDadosCompletosDto(Jogo jogo) {
        this(
                jogo.getId(),
                jogo.getDescricao(),
                jogo.getDataLancamento(),
                jogo.getWebsite(),
                new DtoListagemDesenvolvedor(jogo.getDesenvolvedor()),
                jogo.getGenero(),
                jogo.getUrlCapa(),
                jogo.getConsole().stream()
                        .map(DtoListagemConsole::new)
                        .toList()

        );
    }
}
