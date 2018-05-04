/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class Conexion {
     String url ="jdbc:oracle:thin:@localhost:1521:XE";
    String user="hr";
    String clave="hr";
    
    public Connection getConnection(){
    Connection conn = null;
    try {
        Class.forName("oracle.jdbc.OracleDriver");
        conn = DriverManager.getConnection(url, user, clave);        
        conn.setAutoCommit(true);
    } catch (Exception e) {
        System.out.println("No se pudo generar la conexión. Mensaje:" + e.getMessage());
        
    }
    
    return conn;

}
}
