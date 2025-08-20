package com.jean.portacademia.domain.exception;

public class PlanoNaoEncontradaException extends EntidadeNaoEncontradaException{

    private static final String MSG_PLANO_NAO_ENCONTRADO = "O plano de codigo %d não foi encontrado";

    public PlanoNaoEncontradaException(Long planoId) {
        super(String.format(MSG_PLANO_NAO_ENCONTRADO, planoId));
    }
}
