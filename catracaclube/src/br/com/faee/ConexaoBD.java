/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faee;

import java.sql.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author mauricio
 */
public class ConexaoBD {
    //jdbc:postgresql://localhost:5432/catraca
    public Statement stm;
    public ResultSet rs;
    private String driver = "org.postgresql.Driver";
    private String caminho = "jdbc:postgresql://localhost:5432/db_prd_app";
    private String usuario = "postgres";
    private String senha = "postgres";
    public Connection con;
    
    public void conexao(){
        try {
            System.setProperty("jdbc.Drivers", driver);
            con=DriverManager.getConnection(caminho,usuario,senha);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao se conectar com o banco de dados\n"+ex.getMessage());
        }
    }
    
    public void desconecta(){
        try{
            con.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão com BD \n"+ex.getMessage());
        }
    }
    
    public void executaSQL(String sql) throws SQLException{
        stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
        rs = stm.executeQuery(sql);
    }
}
