package com.example.todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//Classe todo, onde cada objeto terá os atributos como nome, if unico, descricao, status se foi realizado ou nao e a prioridade.
@Entity
public class Todo {
    //@GeneratedValue - o valor do campo será gerado automaticAmente no banco de dados
    //strategy = GenerationType.IDENTITY - estratégia de geração do valor da chave primária será baseada em um mecanismo de auto incremento do banco de dados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private boolean realizado;
    private int prioridade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
}
