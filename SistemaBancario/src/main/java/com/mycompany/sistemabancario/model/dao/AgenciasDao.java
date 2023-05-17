package com.mycompany.sistemabancario.model.dao;

import com.mycompany.sistemabancario.conection.mysql;
import com.mycompany.sistemabancario.model.domain.Agencias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgenciasDao {

    public void inserir(Agencias agencia) {
        String sql = """
                     INSERT INTO agencias(NOME, ENDERECO, TELEFONE)
                     VALUES(?,?,?);
                     """;

        try (Connection con = mysql.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, agencia.getNome());
            stmt.setString(2, agencia.getEndereco());
            stmt.setString(3, agencia.getTelefone());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AgenciasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Agencias> buscaTodasAgencias() {
        String sql = """
                     SELECT * FROM agencias;
                     """;
        List<Agencias> agencias = new ArrayList<>();
        try (Connection con = mysql.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                var agencia = new Agencias();
                agencia.setId(rs.getInt("id"));
                agencia.setNome(rs.getString("nome"));
                agencia.setEndereco(rs.getString("endereco"));
                agencia.setTelefone(rs.getString("telefone"));
                agencias.add(agencia);
            }
            return agencias;
        } catch (SQLException ex) {
            Logger.getLogger(AgenciasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return agencias;
    }

    public int deletar(Integer id) {
        String sql = """
                 DELETE FROM agencias WHERE ID =  ?;
                 """;
        try (Connection con = mysql.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AgenciasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static void main(String[] args) {
        var AgenciasDao = new AgenciasDao();

        //Inserir
        Agencias agl = new Agencias(null, "BB", "Centro", "Telefone");
        AgenciasDao.inserir(agl);
        //Listar
        AgenciasDao.buscaTodasAgencias().forEach(System.out::println);
        //Deletar
        AgenciasDao.deletar(11);
    }
}
