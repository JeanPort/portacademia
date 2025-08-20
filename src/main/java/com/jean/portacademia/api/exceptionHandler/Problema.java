package com.jean.portacademia.api.exceptionHandler;

import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Builder
public class Problema {

    private String menssagem;
    private Integer status;
    private OffsetDateTime timestamp;
    private List<Erro> erros;

    @Getter
    @Builder
    public static class Erro{
        private String nome;
        private String menssagem;
    }
}
