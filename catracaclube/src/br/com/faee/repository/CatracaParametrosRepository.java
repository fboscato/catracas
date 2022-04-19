package br.com.faee.repository;


import br.com.faee.ConexaoBD;
import br.com.faee.model.Catraca;
import br.com.faee.model.CatracaParametros;
import br.com.faee.model.ExameFisico;
import java.sql.Connection;
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
 * @author mauri
 */
public class CatracaParametrosRepository {
    
//    ConexaoBD connect = new ConexaoBD();
    
    public void salvar(CatracaParametros catracaParametros, ConexaoBD connect) throws SQLException{
//        connect.conexao();
        PreparedStatement pst = connect.con.prepareStatement("insert into catraca_parametros_catraca(id,catraca_id,parametro_catraca_id) values (?,?,?)");
        pst.setInt(1, catracaParametros.getId());
        pst.setInt(2, catracaParametros.getCatracaId());
        pst.setInt(3, catracaParametros.getParametroCatracaId());
        pst.execute();
//        connect.desconecta();
    }
    public List<CatracaParametros> todos(ConexaoBD connect) throws SQLException{
//        connect.conexao();
        connect.executaSQL("select * from catraca_parametros_catraca");
        List<CatracaParametros> listaCatracaParametros = new ArrayList<CatracaParametros>();
        while(connect.rs.next()){
            CatracaParametros catracaParametros = new CatracaParametros(connect.rs.getInt("id"),connect.rs.getInt("catraca_id"),
                    connect.rs.getInt("parametro_catraca_id"));
            listaCatracaParametros.add(catracaParametros);
        }
//        connect.desconecta();
        return listaCatracaParametros;
    }
    
    public void excluir(Integer id, ConexaoBD connect) throws SQLException{
//        connect.conexao();
        PreparedStatement pst = connect.con.prepareStatement("delete from catraca_parametros_catraca where id=?");
        pst.setLong(1, id);
        pst.execute();
//        connect.desconecta();
    }
    
    public void alterar(CatracaParametros catracaParametros, ConexaoBD connect) throws SQLException{
//        connect.conexao();
        PreparedStatement pst = connect.con.prepareStatement("update catraca_parametros_catraca set catraca_id=?,parametro_catraca_id=? where id=?");
        pst.setInt(1, catracaParametros.getCatracaId());
        pst.setInt(2, catracaParametros.getParametroCatracaId());
        pst.setInt(3, catracaParametros.getId());
        pst.execute();
//        connect.desconecta();
    }
}
