package com.example.api.service.ServiceModel;

import com.example.api.dto.consoleDto.ConsoleIdDto;
import com.example.api.dto.desenvolvedorDto.DesenvolvedorListagemDto;
import com.example.api.dto.jogoDto.JogoAtualizarDto;
import com.example.api.dto.jogoDto.JogoCadastraDto;
import com.example.api.dto.jogoDto.JogoListagemDto;
import com.example.api.model.Console;
import com.example.api.model.Desenvolvedor;
import com.example.api.model.Jogo;
import com.example.api.repository.ConsolerRepository;
import com.example.api.repository.DesenvolvedorRepository;
import com.example.api.repository.JogoRepository;
import com.example.api.service.GlobalService;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JogoService {

    private final GlobalService globalService;
    private final DesenvolvedorRepository desenvolvedorRepository;
    private final ConsolerRepository consolerRepository;


    public JogoService(GlobalService globalService, DesenvolvedorRepository desenvolvedorRepository, ConsolerRepository consolerRepository) {
        this.globalService = globalService;
        this.desenvolvedorRepository = desenvolvedorRepository;
        this.consolerRepository = consolerRepository;
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

    public void validaDados(JogoCadastraDto dados) {
        Optional<Desenvolvedor> findDadosDev = desenvolvedorRepository.findById(dados.desenvolvedor().id());
        List<Long> consoleIds = dados.console().stream()
                .map(ConsoleIdDto::id)
                .collect(Collectors.toList());

        List<Console> consoles = consolerRepository.findByIdIn(consoleIds);

        if (findDadosDev.isEmpty() && consoles.isEmpty()) {
            throw new RuntimeException("Desenvolvedor ou Consoler nao encontrado");
        }
        if (findDadosDev.isEmpty() || consoles.isEmpty()) {
            throw new RuntimeException("Desenvolvedor ou Consoler nao encontrado");
        }
    }

}
