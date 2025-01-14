package com.example.api.service;

import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class GlobalService {


    public <T> void atualizaDados (T valor , Consumer<T> setter){
        if (valor != null && !(valor instanceof String && ((String)valor).isEmpty())){
            setter.accept(valor);
        }
    }

    public <T> void atualizaData(T localDate, Consumer<T> setter) {
        if (localDate != null){
            setter.accept(localDate);
        }
    }
}
