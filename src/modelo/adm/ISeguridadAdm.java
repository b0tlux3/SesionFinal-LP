package modelo.adm;

import java.util.ArrayList;
import modelo.Usuario;

public interface ISeguridadAdm {
    public Usuario validarUsuario
        (String usuario, String clave);   
        
        public ArrayList listarUsuario();
        
        public void addUsuario(Usuario usu);
        
        public void updateUsuario(Usuario usu);
        
        public void deleteUsuario(Usuario usu);

}
