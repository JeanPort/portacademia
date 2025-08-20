package com.jean.portacademia.api.model.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PlanoInput {

    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotNull
    @Positive
    private BigDecimal valor;
}
