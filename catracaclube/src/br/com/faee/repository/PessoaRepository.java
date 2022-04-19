/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faee.repository;

import br.com.faee.ConexaoBD;
import br.com.faee.model.Pessoa;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mauricio/lucas chaves
 */
public class PessoaRepository {
    
    public void salvar(Pessoa pessoa, ConexaoBD connect) throws SQLException{
        PreparedStatement pst = connect.con.prepareStatement("insert into pessoa(id,nome,barcode,rfid,biometria, cpf) values (?,?,?,?,?,?)");
        pst.setInt(1, pessoa.getId());
        pst.setString(2, pessoa.getNome());
        pst.setBigDecimal(3, pessoa.getBarcode());
        pst.setBigDecimal(4, pessoa.getRfid());
        pst.setInt(5, pessoa.getBiometria());
        pst.setString(6, pessoa.getCpf());
        pst.execute();
    }
    
    public List<Pessoa> todos(ConexaoBD connect) throws SQLException{
        connect.executaSQL("select * from pessoa");
        List<Pessoa> lista = new ArrayList<>();
        while(connect.rs.next()){
            Pessoa pessoa = new Pessoa(
                connect.rs.getInt("id"),
                connect.rs.getString("nome"),
                connect.rs.getBigDecimal("barcode"),
                connect.rs.getBigDecimal("rfid"),
                connect.rs.getInt("biometria"), 
                connect.rs.getString("cpf")
            );
            lista.add(pessoa);
        }
        return lista;
    }
    public void alterar(Pessoa pessoa, ConexaoBD connect) throws SQLException{
        PreparedStatement pst = connect.con.prepareStatement("update pessoa set nome = ?,barcode = ?,rfid = ?,biometria = ?, cpf = ?, ultimo_acesso = ? where id = ?");
        pst.setString(1,pessoa.getNome());
        pst.setBigDecimal(2,pessoa.getBarcode());
        pst.setBigDecimal(3, pessoa.getRfid());
        pst.setInt(4, pessoa.getBiometria());
        pst.setString(5, pessoa.getCpf());
        pst.setTimestamp(6, pessoa.getUltimoAcesso() != null ? new Timestamp(pessoa.getUltimoAcesso().toDate().getTime()) : null);
        pst.setInt(7, pessoa.getId());
        pst.execute();
    }
    public void excluir(Pessoa pessoa, ConexaoBD connect) throws SQLException{
        PreparedStatement pst = connect.con.prepareStatement("delete from pessoa where id = ?");
        pst.setInt(1,pessoa.getId());
        pst.execute();
    }
}
