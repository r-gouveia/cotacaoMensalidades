package com.tabela.mensalidades.entity;

import com.tabela.mensalidades.enums.Veiculo;
import jakarta.persistence.*;

@Entity
public class Associado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
    private String cpf;
    private double mensalidade;

    @Enumerated(EnumType.STRING)
    private Veiculo tipoVeiculo;

    private String regiao;

    public Associado(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Veiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(Veiculo tipoVeiculo) {
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
