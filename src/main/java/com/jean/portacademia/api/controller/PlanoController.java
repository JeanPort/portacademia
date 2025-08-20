package com.jean.portacademia.api.controller;

import com.jean.portacademia.api.assembler.PlanoInputDisassembler;
import com.jean.portacademia.api.assembler.PlanoModelAssembler;
import com.jean.portacademia.api.model.PlanoModel;
import com.jean.portacademia.api.model.input.PlanoInput;
import com.jean.portacademia.domain.service.CadastroPlanoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planos")
public class PlanoController {

    private final CadastroPlanoService cadastroPlano;
    private final PlanoModelAssembler assembler;
    private final PlanoInputDisassembler disassembler;

    public PlanoController(CadastroPlanoService cadastroPlano, PlanoModelAssembler assembler, PlanoInputDisassembler disassembler) {
        this.cadastroPlano = cadastroPlano;
        this.assembler = assembler;
        this.disassembler = disassembler;
    }

    @GetMapping
    public ResponseEntity<List<PlanoModel>> lista(){
        var planos = cadastroPlano.buscarTodos();
        return ResponseEntity.ok(assembler.toCollectModel(planos));
    }

    @GetMapping("/{planoId}")
    public ResponseEntity<PlanoModel> buscar(@PathVariable Long planoId){
        var plano = cadastroPlano.buscarOuFalhar(planoId);
        return ResponseEntity.ok(assembler.toModel(plano));
    }

    @PostMapping
    public ResponseEntity<PlanoModel> inserir(@RequestBody @Valid PlanoInput input){
        var plano = disassembler.toDomain(input);
        plano = cadastroPlano.salvar(plano);
        return ResponseEntity.status(HttpStatus.CREATED).body(assembler.toModel(plano));
    }

    @PutMapping("/{planoId}")
    public ResponseEntity<PlanoModel> atualizar(@PathVariable Long planoId, @RequestBody @Valid PlanoInput input){
        var plano = cadastroPlano.buscarOuFalhar(planoId);
        disassembler.copyToDomain(input, plano);
        plano = cadastroPlano.salvar(plano);
        return ResponseEntity.ok(assembler.toModel(plano));
    }

}
