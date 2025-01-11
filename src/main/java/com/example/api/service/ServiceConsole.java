package com.example.api.service;

import com.example.api.dto.dtoConsole.DtoAtualizacaoConsole;
import com.example.api.model.Console;
import org.springframework.stereotype.Service;

@Service
public class ServiceConsole {

    public void atualizarInformacaoConsoler(DtoAtualizacaoConsole dados, Console console) {
        if (dados.id() != null) {
            console.setId(dados.id());
        }
        if (dados.nome() != null) {
            console.setNome(dados.nome());
        }
        if (dados.dataLancamento() != null) {
            console.setDataLancamento(dados.dataLancamento());
        }
        if (dados.empresa() != null) {
            console.setEmpresa(dados.empresa());
        }
    }


}
