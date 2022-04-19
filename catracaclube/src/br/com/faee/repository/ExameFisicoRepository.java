/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faee.repository;

import br.com.faee.ConexaoBD;
import br.com.faee.model.ExameFisico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.LocalDate;

/**
 *
 * @author mauricio
 */
public class ExameFisicoRepository {
    
//    ConexaoBD connect = new ConexaoBD();
    
    public void salvar(ExameFisico exameFisico, ConexaoBD connect) throws SQLException{
//        connect.conexao();
        PreparedStatement pst = connect.con.prepareStatement("insert into exame_fisico(id,pessoa_id,data_validade) values (?,?,?)");
        pst.setInt(1, exameFisico.getId());
        pst.setInt(2, exameFisico.getPessoaId());
        pst.setDate(3, new java.sql.Date(exameFisico.getDataValidade().toDate().getTime()));
        pst.execute();
//        connect.desconecta();
    }
    
    public List<ExameFisico> todos(ConexaoBD connect) throws SQLException{
//        connect.conexao();
        connect.executaSQL("select * from exame_fisico");
        List<ExameFisico> lista = new ArrayList<ExameFisico>();
        while(connect.rs.next()){
            ExameFisico exameFisico = new ExameFisico(connect.rs.getInt("id"),connect.rs.getInt("pessoa_id"),LocalDate.parse(connect.rs.getString("data_validade")));
            lista.add(exameFisico);
        }
//        connect.desconecta();
        return lista;
    }
    public void alterar(ExameFisico exameFisico, ConexaoBD connect) throws SQLException{
//        connect.conexao();
        PreparedStatement pst = connect.con.prepareStatement("update exame_fisico set pessoa_id=?,data_validade=? where id=?");
        pst.setInt(1, exameFisico.getPessoaId());
        pst.setDate(2, new java.sql.Date(exameFisico.getDataValidade().toDate().getTime()));
        pst.setInt(3, exameFisico.getId());
        pst.execute();
//        connect.desconecta();
    }
    
}
