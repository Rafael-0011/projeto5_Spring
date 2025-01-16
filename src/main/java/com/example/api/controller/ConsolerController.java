package com.example.api.controller;

import com.example.api.dto.consoleDto.ConsoleAtualizacaoDto;
import com.example.api.dto.consoleDto.ConsoleCadastraDto;
import com.example.api.dto.consoleDto.ConsoleListagemDto;
import com.example.api.model.Console;
import com.example.api.repository.ConsolerRepository;
import com.example.api.service.ServiceModel.ConsoleService;
import io.swagger.v3.oas.annotations.media.Schema;
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
public class ConsolerController {

    private final ConsolerRepository consolerRepository;
    private final ConsoleService consoleService;

    public ConsolerController(ConsolerRepository consolerRepository, ConsoleService consoleService) {
        this.consolerRepository = consolerRepository;
        this.consoleService = consoleService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastraConsoler(@Valid @RequestBody ConsoleCadastraDto consoleCadastraDto) {
        try {
            Console console = consolerRepository.save(new Console(consoleCadastraDto));
            return ResponseEntity.status(201).body(new ConsoleListagemDto(console));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    @Schema(description = "page", example = "2")
    public ResponseEntity<Page<ConsoleListagemDto>> obterListaConsoler(@PageableDefault(size = 10) Pageable paginacao) {
        try {
            Page<ConsoleListagemDto> listagemConsoles = consolerRepository.findAll(paginacao).map(ConsoleListagemDto::new);
            return ResponseEntity.ok(listagemConsoles);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obterConsiler(@PathVariable Long id) {
        try {
            Console dados = consolerRepository.getReferenceById(id);
            return ResponseEntity.ok( new ConsoleListagemDto(dados));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ConsoleListagemDto> alteraConsole(@RequestBody ConsoleAtualizacaoDto consoleAtualizacaoDto) {
        try {
            Console dados = consolerRepository.getReferenceById(consoleAtualizacaoDto.id());
            Console dadosAlterados = consoleService.atualizarInformacaoConsoler(consoleAtualizacaoDto, dados);
            return ResponseEntity.status(200).body(new ConsoleListagemDto(dadosAlterados));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deletaConsoler(@PathVariable Long id) {
        try {
            consolerRepository.deleteById(id);
            return ResponseEntity.status(200).body("Console Deletado");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
