package com.example.api.service.ServiceModel;

import com.example.api.dto.desenvolvedorDto.DesenvolvedorAtualizarDto;
import com.example.api.model.Desenvolvedor;
import com.example.api.service.GlobalService;
import org.springframework.stereotype.Service;

@Service
public class DesenvolvedoraService {

    private final GlobalService globalService;

    public DesenvolvedoraService(GlobalService globalService) {
        this.globalService = globalService;
    }

    public Desenvolvedor atualizarInformacaoDesenvolvedor(DesenvolvedorAtualizarDto dados, Desenvolvedor desenvolvedor) {
        globalService.atualizaDados(dados.nome(), desenvolvedor::setNome);
        globalService.atualizaDados(dados.dataFundacao(), desenvolvedor::setDataFundacao);
        globalService.atualizaDados(dados.website(), desenvolvedor::setWebsite);
        globalService.atualizaDados(dados.sede(), desenvolvedor::setSede);
        return desenvolvedor;
    }
}
