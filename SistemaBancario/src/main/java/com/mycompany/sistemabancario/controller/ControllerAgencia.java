package com.mycompany.sistemabancario.controller;

import com.mycompany.sistemabancario.execptions.AgenciasException;
import com.mycompany.sistemabancario.model.dao.AgenciasDao;
import com.mycompany.sistemabancario.model.domain.Agencias;
import com.mycompany.sistemabancario.utils.GerarMensagens;
import com.mycompany.sistemabancario.view.Table.TabelaAgencia;
import com.mycompany.sistemabancario.view.TelaCadastroAgencia;
import com.mycompany.sistemabancario.view.TelaNovaAgencia;

public class ControllerAgencia {

    public void salvar(TelaNovaAgencia t) throws AgenciasException {

        if (t.getTxtNome().getText().isBlank()) {
            throw new AgenciasException("O nome não foi informado");
        }
        if (t.getTxtEndereco().getText().isBlank()) {
            throw new AgenciasException("O endereço não foi informado");
        }
        if (t.getTxtTelefone().getText().isBlank()) {
            throw new AgenciasException("O telefone não foi informado");
        }

        var agencia = new Agencias(null, t.getTxtNome().getText(), t.getTxtEndereco().getText(), t.getTxtTelefone().getText());

        var agenciaDao = new AgenciasDao();
        agenciaDao.inserir(agencia);

        GerarMensagens.alerta(t, "Salvo com sucesso!");
        t.dispose();

    }

    public void pesquisar(TelaCadastroAgencia t) {
        TabelaAgencia tabelaAgencia = (TabelaAgencia) t.getjTable1().getModel();
        var agenciaDao = new AgenciasDao();
        tabelaAgencia.setRegistros(agenciaDao.buscaTodasAgencias());
    }
}
