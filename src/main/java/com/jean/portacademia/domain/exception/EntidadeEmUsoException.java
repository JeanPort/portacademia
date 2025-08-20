package com.jean.portacademia.domain.exception;

public class EntidadeEmUsoException extends NegocioException{

    private static  final String MSG_ENTIDADE_EM_USO = "Entidade de codigo %d não pode ser removida pois esta em uso";

    public EntidadeEmUsoException(String message) {
        super(message);
    }

    public EntidadeEmUsoException(Long planoId) {
        this(String.format(MSG_ENTIDADE_EM_USO, planoId));
    }
}
