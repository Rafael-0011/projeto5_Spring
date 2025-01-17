package com.example.api.controller;

import com.example.api.dto.desenvolvedorDto.DesenvolvedorAtualizarDto;
import com.example.api.dto.desenvolvedorDto.DesenvolvedorCadastraDto;
import com.example.api.dto.desenvolvedorDto.DesenvolvedorListagemDto;
import com.example.api.model.Desenvolvedor;
import com.example.api.repository.DesenvolvedorRepository;
import com.example.api.service.ServiceModel.DesenvolvedoraService;
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
@RequestMapping("/desenvolverdor")
public class DesenvolverdorController {

    private final DesenvolvedorRepository desenvolvedorRepository;
    private final DesenvolvedoraService desenvolvedoraService;

    public DesenvolverdorController(DesenvolvedorRepository desenvolvedorRepository, DesenvolvedoraService desenvolvedoraService) {
        this.desenvolvedorRepository = desenvolvedorRepository;
        this.desenvolvedoraService = desenvolvedoraService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DesenvolvedorListagemDto> cadastraDesenvolverdor(@RequestBody @Valid DesenvolvedorCadastraDto cadastraDesenvolvedor) {
        try {
            Desenvolvedor dados = desenvolvedorRepository.save(new Desenvolvedor(cadastraDesenvolvedor));
            return ResponseEntity.ok(new DesenvolvedorListagemDto(dados));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping()
    public ResponseEntity<Page<DesenvolvedorListagemDto>> getList(@PageableDefault(size = 10) Pageable pageable) {
        try {
            Page<DesenvolvedorListagemDto> listagemDesenvolvedors = desenvolvedorRepository.findAll(pageable).map(DesenvolvedorListagemDto::new);
            return ResponseEntity.ok(listagemDesenvolvedors);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesenvolvedorListagemDto> getDesenvolvedor(@PathVariable Long id) {
        try {
            return desenvolvedorRepository.findById(id)
                    .map(desenvolvedor -> ResponseEntity.ok(new DesenvolvedorListagemDto(desenvolvedor)))
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            throw new RuntimeException("Erro");
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DesenvolvedorAtualizarDto> alteraDesenvolvedor(@RequestBody DesenvolvedorAtualizarDto atualizarDesenvolvedor) {
        try {
            Desenvolvedor dados = desenvolvedorRepository.getReferenceById(atualizarDesenvolvedor.id());
            Desenvolvedor dadosAtualizado = desenvolvedoraService.atualizarInformacaoDesenvolvedor(atualizarDesenvolvedor, dados);
            return ResponseEntity.ok(new DesenvolvedorAtualizarDto(dadosAtualizado));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletaDesenvolvedor(@PathVariable Long id) {
        try {
            desenvolvedorRepository.deleteById(id);
            return ResponseEntity.ok("Deletado desenvolvedor");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
