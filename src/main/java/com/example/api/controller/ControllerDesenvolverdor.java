package com.example.api.controller;

import com.example.api.dto.dtoDesenvolvedor.DtoAtualizarDesenvolvedor;
import com.example.api.dto.dtoDesenvolvedor.DtoCadastraDesenvolvedor;
import com.example.api.dto.dtoDesenvolvedor.DtoListagemDesenvolvedor;
import com.example.api.dto.dtoDesenvolvedor.DtoObterdesenvolverdor;
import com.example.api.model.Desenvolvedor;
import com.example.api.repository.RepositoryDesenvolvedor;
import com.example.api.service.ServiceDesenvolvedor;
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
@RequestMapping("/desenvolverdora")
public class ControllerDesenvolverdor {

    private final RepositoryDesenvolvedor repositoryDesenvolvedor;
    private final ServiceDesenvolvedor serviceDesenvolvedor;

    public ControllerDesenvolverdor(RepositoryDesenvolvedor repositoryDesenvolvedor, ServiceDesenvolvedor serviceDesenvolvedor) {
        this.repositoryDesenvolvedor = repositoryDesenvolvedor;
        this.serviceDesenvolvedor = serviceDesenvolvedor;
    }


    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastraDesenvolverdor(@RequestBody @Valid DtoCadastraDesenvolvedor cadastraDesenvolvedor) {
        try {
            repositoryDesenvolvedor.save(new Desenvolvedor(cadastraDesenvolvedor));
            return ResponseEntity.ok(cadastraDesenvolvedor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping()
    public ResponseEntity<Page<DtoListagemDesenvolvedor>> getList(@PageableDefault(size = 10) Pageable pageable) {
        try {
            Page<DtoListagemDesenvolvedor> listagemDesenvolvedors = repositoryDesenvolvedor.findAll(pageable).map(DtoListagemDesenvolvedor::new);
            return ResponseEntity.ok(listagemDesenvolvedors);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDesenvolvedor(@PathVariable Long id) {
        try {
           return repositoryDesenvolvedor.findById(id)
                    .map(desenvolvedor -> ResponseEntity.ok(new DtoObterdesenvolverdor(desenvolvedor)))
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            throw new RuntimeException("Erro");
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DtoAtualizarDesenvolvedor> alteraDesenvolvedor(@RequestBody DtoAtualizarDesenvolvedor atualizarDesenvolvedor) {
        try {
            Desenvolvedor dados = repositoryDesenvolvedor.getReferenceById(atualizarDesenvolvedor.id());
            serviceDesenvolvedor.atualizarInformacaoDesenvolvedor(atualizarDesenvolvedor, dados);
            return ResponseEntity.ok(atualizarDesenvolvedor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaDesenvolvedor(@PathVariable Long id) {
        try {
            repositoryDesenvolvedor.deleteById(id);
            return ResponseEntity.ok("Deletado desenvolvedor");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
