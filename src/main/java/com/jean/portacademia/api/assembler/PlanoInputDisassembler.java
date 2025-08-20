package com.jean.portacademia.api.assembler;

import com.jean.portacademia.api.model.input.PlanoInput;
import com.jean.portacademia.domain.entity.Plano;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PlanoInputDisassembler {

    private final ModelMapper mapper;

    public PlanoInputDisassembler(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Plano toDomain(PlanoInput input){
        return mapper.map(input, Plano.class);
    }

    public void copyToDomain(PlanoInput input, Plano plano){
        mapper.map(input, plano);
    }
}
