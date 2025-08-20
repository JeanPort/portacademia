package com.jean.portacademia.domain.service;

import com.jean.portacademia.domain.entity.Plano;

import java.util.List;

public interface CadastroPlanoService {

    Plano salvar(Plano plano);
    Plano buscarOuFalhar(Long planoId);
    List<Plano> buscarTodos();
    void remover(Long planoId);
}
