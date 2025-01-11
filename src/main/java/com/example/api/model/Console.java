package com.example.api.model;

import com.example.api.dto.dtoConsole.DtoCadastraConsole;
import com.example.api.dto.dtoConsole.DtoIdConsole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Console {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataLancamento;
    private String empresa;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Console() {
    }

    public Console(DtoCadastraConsole dados) {
        this.nome = dados.nome();
        this.dataLancamento = dados.dataLancamento();
        this.empresa = dados.empresa();
    }

    public Console(DtoIdConsole id) {
        this.id = id.id();
    }

    public Console(Long id, String nome, LocalDate dataLancamento, String empresa) {
        this.id = id;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.empresa = empresa;
    }

}
