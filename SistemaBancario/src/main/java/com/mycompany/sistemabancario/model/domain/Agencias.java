/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabancario.model.domain;

/**
 *
 * @author alunos
 */
public class Agencias {
    private Integer id;
    private String nome;
    private String endereco;
    private String telefone;

public Agencias(){}

public Agencias(Integer id, String nome, String endereco, String telefone){
this.id=id;
this.nome = nome;
this.endereco= endereco;
this.telefone = telefone;

}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Agencias{" + "id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + '}';
    }

    
    
}
