package com.tabela.mensalidades.service;


import com.tabela.mensalidades.entity.Associado;
import com.tabela.mensalidades.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AssociadoService {

    @Autowired
    private AssociadoRepository associadoRepository;

    public AssociadoService(AssociadoRepository associadoRepository) {
        this.associadoRepository = associadoRepository;
    }

    public Associado salvarAssociado(Associado associado){
        return associadoRepository.save(associado);
    }

    public boolean deletarAssociadoByCpf(String cpf){
        Associado associado = associadoRepository.findByCpf(cpf);
        if(associado != null){
            associadoRepository.delete(associado);
            return true;
        }
        return false;
    }
}
