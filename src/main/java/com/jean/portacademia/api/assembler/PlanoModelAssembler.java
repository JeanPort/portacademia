package com.jean.portacademia.api.assembler;

import com.jean.portacademia.api.model.PlanoModel;
import com.jean.portacademia.domain.entity.Plano;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlanoModelAssembler {

    private final ModelMapper mapper;

    public PlanoModelAssembler(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public PlanoModel toModel(Plano plano){
        return mapper.map(plano, PlanoModel.class);
    }

    public List<PlanoModel> toCollectModel(List<Plano> planos){
        return planos.stream().map(this::toModel).toList();
    }
}
