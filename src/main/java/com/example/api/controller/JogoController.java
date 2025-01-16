package com.example.api.controller;


import com.example.api.dto.jogoDto.JogoCadastraDto;
import com.example.api.dto.jogoDto.JogoAtualizarDto;
import com.example.api.dto.jogoDto.JogoListagemDadosCompletosDto;
import com.example.api.dto.jogoDto.JogoListagemDto;
import com.example.api.model.Jogo;
import com.example.api.repository.JogoRepository;
import com.example.api.service.ServiceModel.JogoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RestController
@RequestMapping("/jogo")
public class JogoController {

    private final JogoRepository jogoRepository;
    private final JogoService jogoService;

    public JogoController(JogoRepository jogoRepository, JogoService jogoService) {
        this.jogoRepository = jogoRepository;
        this.jogoService = jogoService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<JogoListagemDto> cadastraJogo(@RequestBody JogoCadastraDto cadastraJogo) {
        jogoService.validaDados(cadastraJogo);
        Jogo dados = jogoRepository.save(new Jogo(cadastraJogo));
        return ResponseEntity.ok(new JogoListagemDto(dados));
    }

    @GetMapping
    public Page<JogoListagemDto> getListJogo(@PageableDefault(size = 10) Pageable pageable) {
        return jogoRepository.findAll(pageable).map(JogoListagemDto::new);
    }

     @GetMapping("/{id}")
    public ResponseEntity<JogoListagemDadosCompletosDto> getObterJogo(@PathVariable Long id) {
         Optional<Jogo> dados = jogoRepository.findById(id);

         return ResponseEntity.ok(new JogoListagemDadosCompletosDto(dados.get()));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<JogoAtualizarDto> atualizarJogo(@RequestBody JogoAtualizarDto jogoAtualizarDto) {
        Jogo dados = jogoRepository.getReferenceById(jogoAtualizarDto.id());
        Jogo dadosAtualizado = jogoService.atualizarInformacaoJogo(jogoAtualizarDto, dados);
        return ResponseEntity.ok(new JogoAtualizarDto(dadosAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarJogo(@PathVariable Long id) {
        jogoRepository.deleteById(id);
        return ResponseEntity.ok("Jogo Deletado");
    }
}
