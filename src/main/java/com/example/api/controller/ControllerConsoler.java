package com.example.api.controller;

import com.example.api.dto.dtoConsole.DtoAtualizacaoConsole;
import com.example.api.dto.dtoConsole.DtoCadastraConsole;
import com.example.api.dto.dtoConsole.DtoListagemConsole;
import com.example.api.model.Console;
import com.example.api.repository.RepositoryConsoler;
import com.example.api.service.ServiceConsole;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/consoler")
public class ControllerConsoler {

    private final RepositoryConsoler repositoryConsoler;
    private final ServiceConsole serviceConsole;

    public ControllerConsoler(RepositoryConsoler repositoryConsoler, ServiceConsole serviceConsole) {
        this.repositoryConsoler = repositoryConsoler;
        this.serviceConsole = serviceConsole;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastraConsoler(@Valid @RequestBody  DtoCadastraConsole dtoCadastraConsole) {
        try {
            repositoryConsoler.save(new Console(dtoCadastraConsole));
            return ResponseEntity.status(201).body(dtoCadastraConsole);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public ResponseEntity<Page<DtoListagemConsole>> obterListaConsoler(@PageableDefault(size = 10) Pageable paginacao) {
        try {
            Page<DtoListagemConsole> listagemConsoles = repositoryConsoler.findAll(paginacao).map(DtoListagemConsole::new);
            return ResponseEntity.ok(listagemConsoles);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obterConsiler(@PathVariable Long id) {
        try {
            Console dados = repositoryConsoler.getReferenceById(id);
            DtoListagemConsole dto = new DtoListagemConsole(dados);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DtoAtualizacaoConsole> alteraConsole(@RequestBody DtoAtualizacaoConsole dtoAtualizacaoConsole) {
        try {
            Console dados = repositoryConsoler.getReferenceById(dtoAtualizacaoConsole.id());
            serviceConsole.atualizarInformacaoConsoler(dtoAtualizacaoConsole, dados);
            return ResponseEntity.status(200).body(dtoAtualizacaoConsole);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deletaConsoler(@PathVariable Long id) {
        try {
            repositoryConsoler.deleteById(id);
            return ResponseEntity.status(200).body("Console Deletado");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
