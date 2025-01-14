package com.example.api.model;

import com.example.api.dto.consoleDto.ConsoleCadastraDto;
import com.example.api.dto.consoleDto.ConsoleIdDto;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Console {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nome;
    private LocalDate dataLancamento;
    @Column(unique = true, nullable = false)
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

    public Console() {
    }

    public Console(ConsoleCadastraDto dados) {
        this.nome = dados.nome();
        this.dataLancamento = dados.dataLancamento();
        this.empresa = dados.empresa();
    }

    public Console(ConsoleIdDto id) {
        this.id = id.id();
    }

    public Console(Long id, String nome, LocalDate dataLancamento, String empresa) {
        this.id = id;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.empresa = empresa;
    }

}
