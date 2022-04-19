package br.com.faee.repository;


import br.com.faee.model.Catraca;
import br.com.faee.ConexaoBD;
import br.com.faee.model.ParametroCatraca;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mauriciao
 */
public class CatracaRepository {
    
    public void salvar(Catraca catraca, ConexaoBD connect) throws SQLException{
        PreparedStatement pst = connect.con.prepareStatement("insert into catraca(id,nome,ip,status_conexao, tempo_bloqueio) values (?,?,?,?,?)");
        pst.setInt(1, catraca.getId());
        pst.setString(2, catraca.getNome());
        pst.setString(3, catraca.getIp());
        pst.setString(4, catraca.getStatusConexao());
        pst.setInt(5, catraca.getTempoBloqueio());
        pst.execute();
    }
    public List<Catraca> todos(ConexaoBD connect) throws SQLException{
        connect.executaSQL("select * from catraca ");
        List<Catraca> listaCatraca = new ArrayList<>();
        while(connect.rs.next()){
            Catraca catraca = new Catraca(connect.rs.getInt("id"),connect.rs.getString("nome")
            ,connect.rs.getString("ip"),connect.rs.getString("status_conexao"), connect.rs.getInt("tempo_bloqueio"));
            listaCatraca.add(catraca);
        }
        return listaCatraca;
    }
    public List<Catraca> todosComParametros(ConexaoBD connect) throws SQLException{
        connect.executaSQL("select * from catraca ");
        List<Catraca> listaCatraca = new ArrayList<>();
        while(connect.rs.next()){
            Catraca catraca = new Catraca(connect.rs.getInt("id"),connect.rs.getString("nome"),
                connect.rs.getString("ip"),connect.rs.getString("status_conexao"), connect.rs.getInt("tempo_bloqueio"));
            connect.executaSQL("select pc.id, pc.descricao, pc.dias from parametro_catraca AS pc JOIN catraca_parametros_catraca AS cp ON pc.id = cp.parametro_catraca_id where cp.catraca_id = "+connect.rs.getInt("id"));
            while(connect.rs.next()){
                ParametroCatraca parametroCatraca = new ParametroCatraca(connect.rs.getInt("id"),connect.rs.getString("descricao"), connect.rs.getInt("dias"));
                catraca.getParametros().add(parametroCatraca);
            }
            listaCatraca.add(catraca);
        }
        return listaCatraca;
    }
    public void excluir(Integer id, ConexaoBD connect) throws SQLException{
        PreparedStatement pst = connect.con.prepareStatement("delete from catraca where id = ? ");
        pst.setLong(1, id);
        pst.execute();
    }
    
    public void alterar(Catraca catraca, ConexaoBD connect) throws SQLException{
        PreparedStatement pst = connect.con.prepareStatement("update catraca set ip = ?,nome = ?, tempo_bloqueio = ? where id = ?");
        pst.setString(1, catraca.getIp());
        pst.setString(2, catraca.getNome());
        pst.setInt(3, catraca.getTempoBloqueio());
        pst.setInt(3, catraca.getId());
        pst.execute();
    }
    
    public void alterarStatus(Integer id,String status, ConexaoBD connect) throws SQLException{
        PreparedStatement pst = connect.con.prepareStatement("update catraca set status_conexao = ? where id = ?");
        pst.setString(1, status);
        pst.setInt(2, id);
        pst.execute();
    }
}
