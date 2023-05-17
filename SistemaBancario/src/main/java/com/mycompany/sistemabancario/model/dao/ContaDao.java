/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabancario.model.dao;

import com.mycompany.sistemabancario.conection.mysql;
import com.mycompany.sistemabancario.model.domain.Conta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alunos
 */
public class ContaDao {
    
    public void inserir(Conta conta){
        String sql = """
                     INSERT INTO CONTAS (CLIENTE_ID, AGENCIA_ID, SALDO)
                     VALUES(?,?,?);
                     """;
        
                    try (Connection con = mysql.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
                        stmt.setInt(1, conta.getCliente_id());
                        stmt.setInt(2, conta.getAgencia_id());
                        stmt.setDouble(3, conta.getSaldo());
                        stmt.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(ContaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Conta> buscaTodasContas(){
        String sql = """
                     SELECT * FROM CONTAS;
                     """;
        List<Conta> contas = new ArrayList<>();
        try (Connection con = mysql.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
        ResultSet rs = stmt.executeQuery();
            while (rs.next()) {                
                var conta = new Conta();
                conta.setId(rs.getInt("id"));
                conta.setCliente_id(rs.getInt("cliente_id"));
                conta.setAgencia_id(rs.getInt("agencia_id"));
                conta.setSaldo(rs.getDouble("saldo"));
                contas.add(conta);
            }
    return contas;
    }   catch (SQLException ex) {
            Logger.getLogger(ContaDao.class.getName()).log(Level.SEVERE, null, ex);
        }return contas;
    }
    
    
    public static void main(String[] args) {
        var contaDao = new ContaDao();
        
        Conta cnt = new Conta(null, 41, 9, 999.);
        contaDao.inserir(cnt);
        
        contaDao.buscaTodasContas().forEach(System.out::println);
    }
    
}
