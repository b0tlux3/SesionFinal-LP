/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.adm;

import java.util.ArrayList;
import modelo.Producto;

/**
 *
 * @author Usuario-Clone0
 */
public interface ISeguridadProductoAdm {
    
  
        
        public ArrayList listarProducto();
        
        public void addProducto(Producto prod);
        
        public void updateProducto(Producto prod);
        
        public void deleteProducto(Producto prod);
        
        public ArrayList ventaProducto(Producto prod);

    
}
