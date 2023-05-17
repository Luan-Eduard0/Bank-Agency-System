/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabancario.view.Table;

import com.mycompany.sistemabancario.model.domain.Agencias;

/**
 *
 * @author luan
 */
public class TabelaAgencia extends AbstractTable<Agencias> {

    
    
    public TabelaAgencia() {
       this("id", "nome", "Endereço","Telefone");
    }
    public TabelaAgencia(String... colunas) {
        super(colunas);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Agencias agencia = getRegistros().get(rowIndex);
        return switch(columnIndex) {
            case 0 -> agencia.getId();
            case 1 -> agencia.getNome();
            case 2 -> agencia.getEndereco();
            case 3 -> agencia.getTelefone();
            default -> null;
    };
  }
    
 
    
 }
