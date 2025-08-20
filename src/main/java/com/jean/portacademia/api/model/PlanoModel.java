package com.jean.portacademia.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanoModel {

    private Long id;
    private String nome;
    private String descricao;
    private String valor;
}
