package com.example.api.model;

import com.example.api.dto.dtoConsole.DtoIdConsole;
import com.example.api.dto.dtoDesenvolvedor.DtoCadastraDesenvolvedor;
import com.example.api.dto.dtoDesenvolvedor.DtoIdDesenvolvedor;
import com.example.api.dto.dtoJogo.DtoCadastraJogo;
import com.example.api.dto.dtoJogo.JogoListagemDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private LocalDate dataLancamento;
    private String website;
    @ManyToOne
    @JoinColumn(name = "desenvolvedor_id")
    private Desenvolvedor desenvolvedor;
    private String genero;
    private String urlCapa;
    @ManyToMany
    @JoinTable(
            name = "jogo_console",
            joinColumns = @JoinColumn(name = "jogo_id"),
            inverseJoinColumns = @JoinColumn(name = "console_id"))
    private List<Console> console;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Desenvolvedor getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getUrlCapa() {
        return urlCapa;
    }

    public void setUrlCapa(String urlCapa) {
        this.urlCapa = urlCapa;
    }

    public List<Console> getConsole() {
        return console;
    }

    public void setConsole(List<Console> console) {
        this.console = console;
    }

    public Jogo() {
    }

    public Jogo(DtoCadastraJogo dados) {
        this.descricao = dados.descricao();
        this.dataLancamento = dados.dataLancamento();
        this.website = dados.website();
        this.desenvolvedor = new Desenvolvedor(dados.desenvolvedor());
        this.genero = dados.genero();
        this.urlCapa = dados.urlCapa();
        this.console = dados.console().stream()
                .map(Console::new)
                .toList();
    }

    public Jogo(JogoListagemDto jogo) {
        this.id = jogo.id();
        this.descricao = jogo.descricao();
        this.dataLancamento = jogo.dataLancamento();
        this.website = jogo.website();
        this.desenvolvedor = new Desenvolvedor(jogo.desenvolvedor().id());
        this.genero = jogo.genero();
        this.urlCapa = jogo.urlCapa();
        this.console = jogo.console().stream()
                .map(Console::new)
                .toList();
    }



}
