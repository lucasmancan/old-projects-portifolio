/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bsmvomeia.dal;
import java.sql.*;
/**
 *
 * @author Mancan
 */
public class ModuloConexao {
    
    // methodo que estabelece conexao
    
    public static Connection conector(){
        java.sql.Connection conexao = null;
        
        String driver = "com.mysql.jdbc.Driver";
        //armazenando informações referentes ao banco
        String url = "jdbc:mysql://localhost:3306/bsm";
        
        String user = "root";
        String password = "";
        
        // estabelecendo conecao
         try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user,password);
            return conexao;
        } catch (Exception e) {
            
            
        /*System.out.println(e);*/
             
            return null;
        }
    }
    
}
