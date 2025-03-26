package com.tabela.mensalidades.config;


public class SecurityConfig {

    String cpf = associado.getCpf();
    int soma = 0;
    int n = 10;

    for(int i = 0; i<=8 ; i++){
        int digito = Character.getNumericValue(cpf.charAt(i));
        int soma = digito * n;
        n--;
    }
      int primeiroDigito = (soma * 10) % 11;
      if(primeiroDigito == 10){
          primeiroDigito = 0;
    }
      int soma = 0;
      int n = 11;
      for(int i = 0; i<=9; i++){
        int digito = Character.getNumericValue(cpf.charAt(i));
        int soma = digito * n;
        n--;
    }
      int segundoDigito = (soma * 10) % 11;
      if( segundoDigito == 10){
          segundoDigito = 0;
    }
}
