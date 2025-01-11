package com.example.api.model;


import com.example.api.dto.dtoDesenvolvedor.DtoCadastraDesenvolvedor;
import com.example.api.dto.dtoDesenvolvedor.DtoIdDesenvolvedor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Desenvolvedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Desenvolvedor() {
    }

    public Desenvolvedor(Long id) {
    }

    public Desenvolvedor(DtoCadastraDesenvolvedor dados) {
        this.nome = dados.nome();
        this.dataFundacao = dados.dataFundacao();
        this.website = dados.website();
        this.sede = dados.sede();
    }

    public Desenvolvedor(DtoIdDesenvolvedor id) {
        this.id = id.id();
    }
}
