/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.faee;


import org.apache.log4j.BasicConfigurator;
import java.sql.SQLException;
/**
 *
 * 
 */
public class main {

    public static void main(String[] args) throws SQLException {
        BasicConfigurator.configure();
        new FrmClient();
    }

}