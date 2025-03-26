package com.tabela.mensalidades.service;

import com.tabela.mensalidades.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CpfService {

    @Autowired
    private AssociadoRepository associadoRepository;

    public CpfService(AssociadoRepository associadoRepository) {
        this.associadoRepository = associadoRepository;
    }

    public boolean validarCpf(String cpf){

        int soma = 0;
        int n = 10;
        for(int i = 0 ; i <= 8 ; i++){
            int digito = Character.getNumericValue(cpf.charAt(i));
            soma += digito * n;
            n--;
        }
        int digito1 = (soma * 10) % 11;
        if(digito1 == 10){
            digito1 = 0;
        }

        soma = 0;
        n = 11;
        for(int i = 0 ; i <= 9 ; i++){
            int digito = Character.getNumericValue(cpf.charAt(i));
            soma += digito * n;
            n--;
        }
        int digito2 = (soma * 10) % 11;
        if(digito2 == 10){
            digito2 = 0;
        }

        return digito1 == (cpf.charAt(9)-'0') && digito2 == (cpf.charAt(10)-'0');
    }
}
