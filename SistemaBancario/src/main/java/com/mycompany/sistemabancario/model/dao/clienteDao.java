    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabancario.model.dao;

import com.mycompany.sistemabancario.conection.mysql;
import com.mycompany.sistemabancario.model.domain.Clientes;
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
public class clienteDao {
    
    public void inserir(Clientes cliente){
    
    String sql = """
                 INSERT INTO clientes(NOME, CPF, EMAIL, TELEFONE, ENDERECO)
                 VALUES (?,?,?,?,?);
                 """;
    
            try (Connection con = mysql.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getCpf());
                stmt.setString(3, cliente.getEmail());
                stmt.setString(4, cliente.getTelefone());
                stmt.setString(5, cliente.getEndereco());
                stmt.execute();
            } catch (SQLException ex) {
            Logger.getLogger(clienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List<Clientes> buscaTodosClientes(){
        String sql = """
                     SELECT * FROM clientes;
                     """;
        List<Clientes> clientes = new ArrayList<>();
                try (Connection con = mysql.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()){
                    var cliente = new Clientes();
                    cliente.setId(rs.getInt("id"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setTelefone(rs.getString("telefone"));
                    cliente.setEndereco(rs.getString("endereco"));
                    clientes.add(cliente);
                }      
        return clientes;
    }   catch (SQLException ex) {
            Logger.getLogger(clienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    
   }
    
    public int deletar(Integer id){
        String sql = """
                     DELETE FROM clientes WHERE ID = ?;
                     """;
        try (Connection con = mysql.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate();    
    }   catch (SQLException ex) {
            Logger.getLogger(clienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static void main(String[] args) {
        var clienteDao = new clienteDao();
        
        
        Clientes clt = new Clientes(null, "Nome teste", "123456987", "email@teste", "88997744", "Rua de teste");
        clienteDao.inserir(clt);
        
        clienteDao.buscaTodosClientes().forEach(System.out::println);
    }
    
}
