package com.example.api.service;

import com.example.api.dto.dtoJogo.JogoAtualizarDto;
import com.example.api.model.Console;
import com.example.api.model.Desenvolvedor;
import com.example.api.model.Jogo;
import org.springframework.stereotype.Service;

@Service
public class ServiceJogo {

    public void atualizarInformacaoJogo(JogoAtualizarDto dados, Jogo jogo) {
        if (dados.descricao() != null) {
            jogo.setDescricao(dados.descricao());
        }
        if (dados.dataLancamento() != null) {
            jogo.setDataLancamento(dados.dataLancamento());
        }
        if (dados.website() != null) {
            jogo.setWebsite(dados.website());
        }
        if (dados.desenvolvedor() != null) {
            jogo.setDesenvolvedor(new Desenvolvedor(dados.desenvolvedor()));
        }
        if (dados.genero() != null) {
            jogo.setGenero(dados.genero());
        }
        if (dados.urlCapa() != null) {
            jogo.setUrlCapa(dados.urlCapa());
        }
        if (dados.console() != null && !dados.console().isEmpty()) {
            jogo.setConsole(dados.console()
                    .stream()
                    .map(Console::new)
                    .toList());
        }
    }
}
