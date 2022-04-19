/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faee.repository;

import br.com.faee.ConexaoBD;
import br.com.faee.model.ExameMedico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.LocalDate;

/**
 *
 * @author mauricio
 */
public class ExameMedicoRepository {

    public void salvar(ExameMedico exameMedico, ConexaoBD connect) throws SQLException {
        PreparedStatement pst = connect.con.prepareStatement("insert into exame_medico(id,pessoa_id,data_validade) values (?,?,?)");
        pst.setInt(1, exameMedico.getId());
        pst.setInt(2, exameMedico.getPessoaId());
        pst.setDate(3, new java.sql.Date(exameMedico.getDataValidade().toDate().getTime()));
        pst.execute();
    }

    public List<ExameMedico> todos(ConexaoBD connect) throws SQLException {
        connect.executaSQL("select * from exame_medico");
        List<ExameMedico> lista = new ArrayList<>();
        while (connect.rs.next()) {
            ExameMedico exameMedico = new ExameMedico(connect.rs.getInt("id"), connect.rs.getInt("pessoa_id"), LocalDate.parse(connect.rs.getString("data_validade")));
            lista.add(exameMedico);
        }
        return lista;
    }

    public void alterar(ExameMedico exameMedico, ConexaoBD connect) throws SQLException {
        PreparedStatement pst = connect.con.prepareStatement("update exame_medico set pessoa_id = ?,data_validade = ? where id = ?");
        pst.setInt(1, exameMedico.getPessoaId());
        pst.setDate(2, new java.sql.Date(exameMedico.getDataValidade().toDate().getTime()));
        pst.setInt(3, exameMedico.getId());
        pst.execute();
    }

}
