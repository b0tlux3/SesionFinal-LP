package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class TestConecta {
    public static void main(String[] args){
        
        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select usuario_id, usuario_name, usuario_password from tb_users");
            int i = 0;
            while (rs.next()) {
                i++;
                System.out.print(i+"   ");
                System.out.println("ID: "+ rs.getString(1));
                System.out.println("    Usuario: "+ rs.getString(2));
                System.out.println("    Clave: "+ rs.getString(3));
            }
            
        } catch (Exception e) {
            System.out.println("Se tiene el siguiente error: " + e.getMessage() );
        }
        
    }
}
