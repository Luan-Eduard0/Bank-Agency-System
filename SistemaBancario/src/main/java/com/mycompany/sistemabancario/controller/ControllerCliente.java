/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabancario.controller;

import com.mycompany.sistemabancario.execptions.AgenciasException;
import com.mycompany.sistemabancario.model.dao.clienteDao;
import com.mycompany.sistemabancario.model.domain.Clientes;
import com.mycompany.sistemabancario.utils.GerarMensagens;
import com.mycompany.sistemabancario.view.Table.TabelaCliente;
import com.mycompany.sistemabancario.view.TelaCadastroClientes;
import com.mycompany.sistemabancario.view.TelaNovoCliente;



/**
 *
 * @author alunos
 */
public class ControllerCliente {
    
    
     public void salvar(TelaNovoCliente t) throws AgenciasException{
        
        if (t.getTxtNome().getText().isBlank()) {
            throw new AgenciasException("O nome não foi informado");
        }
        if (t.getTxtEndereco().getText().isBlank()) {
            throw new AgenciasException("O endereço não foi informado");
        }
        if (t.getTxtTelefone().getText().isBlank()) {
            throw new AgenciasException("O telefone não foi informado");
        }
        
        var cliente = new Clientes(null, t.getTxtNome().getText(),
                t.getTxtCpf().getText(), t.getTxtEmail().getText(),
                t.getTxtTelefone().getText(), t.getTxtEndereco().getText());
        
        var clienteDao = new clienteDao();
        clienteDao.inserir(cliente);
        
        GerarMensagens.alerta(t, "Salvo com sucesso!");
        t.dispose();
        
    }
     public void pesquisar(TelaCadastroClientes t) {
         TabelaCliente tabelaCliente = (TabelaCliente) t.getjTable1().getModel();
        var clienteDao = new clienteDao();
        tabelaCliente.setRegistros(clienteDao.buscaTodosClientes());
    }
}
