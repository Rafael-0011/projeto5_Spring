package com.example.api.service.ServiceModel;

import com.example.api.dto.consoleDto.ConsoleAtualizacaoDto;
import com.example.api.model.Console;
import com.example.api.service.GlobalService;
import org.springframework.stereotype.Service;

@Service
public class ConsoleService {

    private final GlobalService globalService;

    public ConsoleService(GlobalService globalService) {
        this.globalService = globalService;
    }

    public Console atualizarInformacaoConsoler(ConsoleAtualizacaoDto dados, Console console) {
        globalService.atualizaDados(dados.nome(),console::setNome);
        globalService.atualizaDados(dados.dataLancamento(),console::setDataLancamento);
        globalService.atualizaDados(dados.empresa(),console::setEmpresa);
        return console;
    }
}
