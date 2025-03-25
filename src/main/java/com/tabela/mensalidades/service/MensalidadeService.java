package com.tabela.mensalidades.service;

import com.tabela.mensalidades.entity.Associado;
import com.tabela.mensalidades.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensalidadeService {

    @Autowired
    private AssociadoRepository associadoRepository;

    public MensalidadeService(AssociadoRepository associadoRepository) {
        this.associadoRepository = associadoRepository;
    }

    public double calcularMensalidade(String cpf) {
        Associado associado = associadoRepository.findByCpf(cpf);
        double valorBase = 0.0;
        switch (associado.getTipoVeiculo()) {
            case CARRO -> valorBase = 100.00;
            case SUV -> valorBase = 180.00;
            case CAMINHAO -> valorBase = 250.00;
            case MOTO -> valorBase = 70.00;
            default -> throw new IllegalArgumentException("Tipo inválido de veículo");
        }
        return valorBase;
    }

    public double calcularFranquia(String cpf){
        Associado associado = associadoRepository.findByCpf(cpf);

        double franquiaPercentualCarro = 0.08;
        double franquiaPercentualCaminhao = 0.12;
        double franquiaPercentualMoto = 0.5;
        double franquiaPercentualSUV = 0.12;

        double valorBase= calcularMensalidade(cpf);
        switch (associado.getTipoVeiculo()){
            case CARRO -> valorBase *= franquiaPercentualCarro;
            case SUV -> valorBase *= franquiaPercentualSUV;
            case CAMINHAO -> valorBase *= franquiaPercentualCaminhao;
            case MOTO -> valorBase *= franquiaPercentualMoto;
        }

        if (associado.getAge()<25){
            valorBase *=1.10;
        }
        if(associado.getRegiao().equals("RJ") || associado.getRegiao().equals("SP")){
            valorBase *= 1.20;
        }
        return valorBase;
    }

    public Associado salvarAssociado(Associado associado){
        return associadoRepository.save(associado);
    }







}
