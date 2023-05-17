/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabancario.view.Table;
import com.mycompany.sistemabancario.model.domain.Clientes;
/**
 *
 * @author luan
 */
public class TabelaCliente extends AbstractTable<Clientes> {
    public TabelaCliente(){
     this("id","nome","cpf","Telefone","Email","Endereço");
     
    }

    public TabelaCliente(String... colunas) {
        super(colunas);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Clientes cliente = getRegistros().get(rowIndex);
      return switch(columnIndex){
          case 0 ->cliente.getId();
          case 1 ->cliente.getNome();
          case 2 ->cliente.getCpf();
          case 3 ->cliente.getTelefone();
          case 4 ->cliente.getEmail();
          case 5 ->cliente.getEndereco();
          default -> null;    
    
              
      };
    }
    }
    
   
