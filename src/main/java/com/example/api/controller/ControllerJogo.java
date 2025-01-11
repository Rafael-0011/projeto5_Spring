package com.example.api.controller;


import com.example.api.dto.dtoConsole.DtoAtualizacaoConsole;
import com.example.api.dto.dtoDesenvolvedor.DtoCadastraDesenvolvedor;
import com.example.api.dto.dtoJogo.DtoCadastraJogo;
import com.example.api.dto.dtoJogo.JogoAtualizarDto;
import com.example.api.dto.dtoJogo.JogoListagemDadosCompletosDto;
import com.example.api.dto.dtoJogo.JogoListagemDto;
import com.example.api.model.Jogo;
import com.example.api.repository.RepositoryJogo;
import com.example.api.service.ServiceJogo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;

@Controller
@RestController
@RequestMapping("/jogo")
public class ControllerJogo {

    private final RepositoryJogo repositoryJogo;
    private final ServiceJogo serviceJogo;

    public ControllerJogo(RepositoryJogo repositoryJogo, ServiceJogo serviceJogo) {
        this.repositoryJogo = repositoryJogo;
        this.serviceJogo = serviceJogo;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastraJogo(@RequestBody DtoCadastraJogo cadastraJogo) {
        Jogo dados = repositoryJogo.save(new Jogo(cadastraJogo));
        DtoCadastraJogo te = new DtoCadastraJogo(dados);
        return ResponseEntity.ok(te);
    }

    @GetMapping
    public Page<JogoListagemDto> getListJogo(@PageableDefault(size = 10) Pageable pageable) {
        return repositoryJogo.findAll(pageable).map(JogoListagemDto::new);
    }

   /*
     @GetMapping
    public Page<JogoListagemDadosCompletosDto> getListCompleteJogo(@PageableDefault(size = 10)Pageable pageable) {
        return repositoryJogo.findAll(pageable).map(JogoListagemDadosCompletosDto::new);
    }
    */

    @PutMapping
    @Transactional
    public ResponseEntity<JogoAtualizarDto> atualizarJogo(@RequestBody JogoAtualizarDto jogoAtualizarDto) {
        Jogo dados = repositoryJogo.getReferenceById(jogoAtualizarDto.id());
        serviceJogo.atualizarInformacaoJogo(jogoAtualizarDto, dados);
        JogoAtualizarDto a = new JogoAtualizarDto(dados);
        return ResponseEntity.ok(a);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarJogo(@PathVariable Long id) {
        repositoryJogo.deleteById(id);
        return ResponseEntity.ok("Jogo Deletado");
    }
}
