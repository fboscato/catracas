/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faee.repository;

import br.com.faee.ConexaoBD;
import br.com.faee.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mauricio
 */
public class UsuarioRepository {
    
    
//     ConexaoBD connect = new ConexaoBD();
    
    public void salvar(Usuario usuario, ConexaoBD connect) throws SQLException{
//        connect.conexao();
        PreparedStatement pst = connect.con.prepareStatement("insert into usuario(id,pessoa_id,tipo_usuario) values (?,?,?)");
        pst.setInt(1, usuario.getId());
        pst.setInt(2, usuario.getPessoaId());
        pst.setString(3, usuario.getTipoUsuario());
        pst.execute();
//        connect.desconecta();
    }
    
    public List<Usuario> todos(ConexaoBD connect) throws SQLException{
//        connect.conexao();
        connect.executaSQL("select * from usuario");
        List<Usuario> lista = new ArrayList<Usuario>();
        while(connect.rs.next()){
            Usuario usuario = new Usuario(connect.rs.getInt("id"),connect.rs.getInt("pessoa_id"),connect.rs.getString("tipo_usuario"));
            lista.add(usuario);
        }
//        connect.desconecta();
        return lista;
    }
    
    public void alterar(Usuario usuario, ConexaoBD connect) throws SQLException{
//        connect.conexao();
        PreparedStatement pst = connect.con.prepareStatement("update usuario set pessoa_id=?,tipo_usuario=? where id=?");
        pst.setInt(1,usuario.getPessoaId());
        pst.setString(2,usuario.getTipoUsuario());
        pst.setInt(3, usuario.getId());
        pst.execute();
//        connect.desconecta();
    }
    
}
