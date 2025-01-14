package com.example.api.service.ServiceModel;

import com.example.api.dto.jogoDto.JogoAtualizarDto;
import com.example.api.model.Console;
import com.example.api.model.Desenvolvedor;
import com.example.api.model.Jogo;
import com.example.api.service.GlobalService;
import org.springframework.stereotype.Service;

@Service
public class JogoService {

    private final GlobalService globalService;

    public JogoService(GlobalService globalService) {
        this.globalService = globalService;
    }

    public Jogo atualizarInformacaoJogo(JogoAtualizarDto dados, Jogo jogo) {
        globalService.atualizaDados(dados.nome(), jogo::setNome);
        globalService.atualizaDados(dados.descricao(), jogo::setDescricao);
        globalService.atualizaDados(dados.dataLancamento(), jogo::setDataLancamento);
        globalService.atualizaDados(dados.website(), jogo::setWebsite);
        globalService.atualizaDados(dados.desenvolvedor(), dev -> jogo.setDesenvolvedor(new Desenvolvedor(dev)));
        globalService.atualizaDados(dados.genero(), jogo::setGenero);
        globalService.atualizaDados(dados.urlCapa(), jogo::setUrlCapa);
        globalService.atualizaDados(dados.console(), consoles ->
                jogo.setConsole(consoles.stream().map(Console::new).toList()));
        return jogo;
    }

}
