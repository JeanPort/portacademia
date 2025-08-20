package com.jean.portacademia.domain.service.impl;

import com.jean.portacademia.domain.exception.EntidadeEmUsoException;
import com.jean.portacademia.domain.exception.PlanoNaoEncontradaException;
import com.jean.portacademia.domain.entity.Plano;
import com.jean.portacademia.domain.repository.PlanoRepository;
import com.jean.portacademia.domain.service.CadastroPlanoService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CadastroPlanoServiceImpl implements CadastroPlanoService {

    private final PlanoRepository planoRepository;

    public CadastroPlanoServiceImpl(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    @Override
    @Transactional
    public Plano salvar(Plano plano) {
        return planoRepository.save(plano);
    }

    @Override
    public Plano buscarOuFalhar(Long planoId) {
        return planoRepository.findById(planoId).orElseThrow(() -> new PlanoNaoEncontradaException(planoId));
    }

    @Override
    public List<Plano> buscarTodos() {
        return planoRepository.findAll();
    }

    @Override
    @Transactional
    public void remover(Long planoId) {
        try {
            var plano = buscarOuFalhar(planoId);
            planoRepository.delete(plano);
        }catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(planoId);
        }

    }
}
