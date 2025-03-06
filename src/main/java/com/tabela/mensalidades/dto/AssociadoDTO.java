package com.tabela.mensalidades.dto;

import com.tabela.mensalidades.entity.Associado;

public class AssociadoDTO {
    private String nome;
    private String cpf;
    private String tipoVeiculo;
    private String regiao;
    private double mensalidade;

    public AssociadoDTO(Associado associado) {
        this.nome = associado.getName();
        this.cpf = associado.getCpf();
        this.tipoVeiculo = associado.getTipoVeiculo().name();
        this.regiao = associado.getRegiao();
        this.mensalidade = associado.getMensalidade();
    }

    public AssociadoDTO(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(double mensalidade) {
        this.mensalidade = mensalidade;
    }
}
