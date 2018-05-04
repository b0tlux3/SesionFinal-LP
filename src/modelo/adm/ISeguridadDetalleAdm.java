/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.adm;

import java.util.ArrayList;
import modelo.Detalle;

/**
 *
 * @author Usuario-Clone0
 */
public interface ISeguridadDetalleAdm {
    
    public ArrayList listarDetalle();
        
        public void addDetalle(Detalle detalle);
        
        public void updateDetalle(Detalle detalle);
        
        public void deleteDetalle(Detalle detalle);
    
}
