/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Usuario;

/**
 *
 * @author Admin
 */
public class UsuarioAdm {
    public Usuario getUsuario(String userName){
        Usuario usu = new Usuario();
        
        /*
            Conectar a la BD y obtener los datos del usuario.
        Considerar clausula WHERE = userName
        */
        
        usu.setNombre_usuario(userName);
        usu.setClave_usuario("12345");
        return usu;
        
    }
    
   public Usuario validarUsuario(String usuario, String clave) {
    Usuario usuObj = null;
        
        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();

        try {

            PreparedStatement ps = conn.prepareStatement(
                    "select id_usuario, nombre_usuario, clave_usuario "
                            + "from "
                            + "tb_usuario where nombre_usuario = ? and "
                            + "clave_usuario = ?");
            ps.setString(1, usuario);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                usuObj = new Usuario();
                usuObj.setNombre_usuario(rs.getString(2));
                usuObj.setClave_usuario(rs.getString(3));
            }
            
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("No se pudo validar las credenciales en la base de datos. Mensaje: "+ e.getMessage());
        }           
        
        return usuObj;        
    }
}
