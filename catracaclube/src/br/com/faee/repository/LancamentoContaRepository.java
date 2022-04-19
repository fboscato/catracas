/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faee.repository;

import br.com.faee.ConexaoBD;
import br.com.faee.model.LancamentoConta;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.LocalDate;

/**
 *
 * @author mauricio
 */
public class LancamentoContaRepository {

//    ConexaoBD connect = new ConexaoBD();
    public void salvar(LancamentoConta lancamentoConta, ConexaoBD connect) throws SQLException {
//        connect.conexao();
        PreparedStatement pst = connect.con.prepareStatement("insert into lancamento_conta(id,pessoa_id,data_vencimento,data_pagamento)"
                + " values (?,?,?,?)");
        pst.setInt(1, lancamentoConta.getId());
        pst.setInt(2, lancamentoConta.getPessoaId());
        pst.setDate(3, new java.sql.Date(lancamentoConta.getDataVencimento().toDate().getTime()));
        pst.setDate(4, new java.sql.Date(lancamentoConta.getDataPagamento().toDate().getTime()));
        pst.execute();
//        connect.desconecta();
    }

    public List<LancamentoConta> todos(ConexaoBD connect) throws SQLException {
        connect.executaSQL("select * from lancamento_conta where data_vencimento > '2020-01-01' and data_pagamento > '2020-01-01'");
        List<LancamentoConta> listaLancamentoConta = new ArrayList<>();
        while (connect.rs.next()) {
            LancamentoConta lancamentoConta = new LancamentoConta(connect.rs.getInt("id"), connect.rs.getInt("pessoa_id"),
                    LocalDate.parse(connect.rs.getString("data_vencimento")),
                    LocalDate.parse(connect.rs.getString("data_pagamento")));
            listaLancamentoConta.add(lancamentoConta);
        }
        return listaLancamentoConta;
    }

    public void alterar(LancamentoConta lancamentoConta, ConexaoBD connect) throws SQLException {
        PreparedStatement pst = connect.con.prepareStatement("update lancamento_conta set pessoa_id=?, data_vencimento=?, data_pagamento=? where id=?");
        pst.setInt(1, lancamentoConta.getPessoaId());
        pst.setDate(2, lancamentoConta.getDataVencimentoSQL());
        pst.setDate(3, lancamentoConta.getDataPagamentoSQL());
        pst.setInt(4, lancamentoConta.getId());
        System.out.println(pst);
        pst.execute();
    }

    public void excluir(LancamentoConta lancamentoConta, ConexaoBD connect) throws SQLException {
//        connect.conexao();
        PreparedStatement pst = connect.con.prepareStatement("delete from lancamento_conta where id=?");
        pst.setInt(1, lancamentoConta.getId());
        pst.execute();
//        connect.desconecta();
    }
}
