package modelo.adm;

import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Usuario;

public class SeguridadAdmSQLOra implements
        ISeguridadAdm {

    public Usuario validarUsuario(String usuario, String clave) {
        Usuario usuObj = null;

        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();

        try {

            PreparedStatement ps = conn.prepareStatement(
                    "select usuario_id, tipo_id from tb_users where usuario_name =  ? and usuario_password = ? and activo=?");
            ps.setString(1, usuario);
            ps.setString(2, clave);
            ps.setString(3, "1");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                usuObj = new Usuario();
                usuObj.setId_usuario(rs.getString(1));
                usuObj.setNombre_usuario(rs.getString(2));
                usuObj.setClave_usuario(rs.getString(3));
                usuObj.setTipoUsuario(rs.getString(4));
            }
            rs.close();
            ps.close();
            conn.close();
           
        } catch (Exception e) {
            System.out.println("No se pudo validar las credenciales en la base de datos. Mensaje: " + e.getMessage());
            
        }
        return usuObj;
    }

    @Override
    public ArrayList<Usuario> listarUsuario() {
        ArrayList listaUsuarios = new ArrayList();
        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select u.usuario_id, usuario_name, usuario_password,  r.tipo_name from tb_users u, tb_user_roles r where u.tipo_id=r.tipo_id and u.activo='1' order by u.usuario_id");
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setId_usuario(rs.getString(1));
                usu.setNombre_usuario(rs.getString(2));
                usu.setClave_usuario(rs.getString(3));
                usu.setTipoUsuario(rs.getString(4));
                listaUsuarios.add(usu);
            }
            
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("No se pudo obtener los registros de la base de datos. Mensaje: " + e.getMessage());
        }
 
        return listaUsuarios;
    }

    @Override
    public void addUsuario(Usuario usu) {

        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();

        Usuario usua = new Usuario();

        try {
            String idUsuario = usu.getId_usuario();
            String nombreUsuario = usu.getNombre_usuario();
            String passwordUsuario = usu.getClave_usuario();
            String tipoUsuario = usu.getTipoUsuario();
            PreparedStatement pst = conn.prepareStatement("insert into tb_users (usuario_id, usuario_name, usuario_password, tipo_id, activo) values (?,?,?,?,?)");

            pst.setString(1, idUsuario);
            pst.setString(2, nombreUsuario);
            pst.setString(3, passwordUsuario);
            pst.setString(4, tipoUsuario);
            pst.setString(5, "1");
            ResultSet rs = pst.executeQuery();

            rs.close();
            pst.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Se tiene el siguiente error: " + e.getMessage());
        }

    }

    @Override
    public void updateUsuario(Usuario usue) {
        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();

        Usuario usua = new Usuario();

        try {
            String idUsuario = usue.getId_usuario();
            String nombreUsuario = usue.getNombre_usuario();
            String passwordUsuario = usue.getClave_usuario();
            String tipoUsuario = usue.getTipoUsuario();
            PreparedStatement pst = conn.prepareStatement("update tb_users set usuario_name=?, usuario_password=?, tipo_id=? where usuario_id=?");

            pst.setString(1, nombreUsuario);
            pst.setString(2, passwordUsuario);
            pst.setString(3, tipoUsuario);
            pst.setString(4, idUsuario);
            pst.executeUpdate();
            pst.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Se tiene el siguiente error: " + e.getMessage());
        }

    }

    @Override
    public void deleteUsuario(Usuario usu) {
          Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();
        Usuario usua = new Usuario();

        try {
            String idUsuario = usu.getId_usuario();
            PreparedStatement pst = conn.prepareStatement("update tb_users set activo=? where usuario_id=?");

            pst.setString(1, "0");
            pst.setString(2, idUsuario);
            pst.executeUpdate();
            pst.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Se tiene el siguiente error: " + e.getMessage());
        }
        
    }

}
