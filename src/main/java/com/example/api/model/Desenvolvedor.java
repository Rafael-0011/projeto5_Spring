package com.example.api.model;


import com.example.api.dto.desenvolvedorDto.DesenvolvedorCadastraDto;
import com.example.api.dto.desenvolvedorDto.DesenvolvedorIdDto;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Desenvolvedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;
    private LocalDate dataFundacao;
    private String website;
    private String sede;

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public Desenvolvedor() {
    }

    public Desenvolvedor(Long id) {
    }

    public Desenvolvedor(DesenvolvedorCadastraDto dados) {
        this.nome = dados.nome();
        this.dataFundacao = dados.dataFundacao();
        this.website = dados.website();
        this.sede = dados.sede();
    }

    public Desenvolvedor(DesenvolvedorIdDto id) {
        this.id = id.id();
    }
}
