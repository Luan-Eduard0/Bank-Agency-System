/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabancario.model.domain;

/**
 *
 * @author alunos
 */
public class Conta {
    
    private Integer id;
    private Integer cliente_id;
    private Integer agencia_id;
    private Double saldo;

    public Conta(){}
    
    public Conta(Integer id, Integer cliente_id, Integer agencia_id, Double saldo) {
        this.id = id;
        this.cliente_id = cliente_id;
        this.agencia_id = agencia_id;
        this.saldo = saldo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Integer cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Integer getAgencia_id() {
        return agencia_id;
    }

    public void setAgencia_id(Integer agencia_id) {
        this.agencia_id = agencia_id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" + "id=" + id + ", cliente_id=" + cliente_id + ", agencia_id=" + agencia_id + ", saldo=" + saldo + '}';
    }
    
    
    
}
