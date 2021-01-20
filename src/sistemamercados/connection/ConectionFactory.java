/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamercados.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcelo
 */
public class ConectionFactory {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mercado?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "pass123";
/*Metódo que entra em contato com a conexão */
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return (Connection) DriverManager.getConnection(URL,USER,PASS);
                    } catch (ClassNotFoundException | SQLException ex) {
           throw new RuntimeException(" Erro na Conexão: " +ex);
        }
    }
 /**Método que fecha a conexão com o D
     * @param con*/
    public static void closeConnection(Connection con){
        if(con!= null){
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
  /**Método que fecha a conexão com o D
     * @param con
     * @param stmt
     */
        public static void closeConnection(Connection con, PreparedStatement stmt){
            closeConnection(con);
            try {
                if(stmt!= null){
                    stmt.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
                public static void closeConnection(Connection con, PreparedStatement stmt,ResultSet rs){
            closeConnection(con,stmt);
            try {
               if(rs!=null){
                   rs.close();
               }
            } catch (SQLException ex) {
                Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
}
