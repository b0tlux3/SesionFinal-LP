/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.adm;

import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Producto;

/**
 *
 * @author Usuario-Clone0
 */
public class SeguridadProductoAdmSQLOra implements ISeguridadProductoAdm {

    @Override
    public ArrayList<Producto> listarProducto() {
        ArrayList listaProductos = new ArrayList();
        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select p.id_producto, p.descripcion, p.uni_medida, p.precio_costo, p.stock, p.nro_producto, e.extranjero from tb_producto p, tb_extranjero e where p.cod_extranjero=e.cod_extranjero and p.activo='1' order by p.descripcion");
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setIdProducto(rs.getString(1));
                prod.setDescProducto(rs.getString(2));
                prod.setUniProducto(rs.getString(3));
                prod.setPreProducto(rs.getString(4));
                prod.setStockProducto(rs.getString(5));
                prod.setNroProducto(rs.getString(6));
                prod.setExtraProducto(rs.getString(7));
                listaProductos.add(prod);
            }

            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("No se pudo obtener los registros de la base de datos. Mensaje: " + e.getMessage());
        }

        return listaProductos;
    }

    @Override
    public void addProducto(Producto prod) {
        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();

        Producto proda = new Producto();

        try {
            String idProducto = prod.getIdProducto();
            String descProducto = prod.getDescProducto();
            String uniProducto = prod.getUniProducto();
            String preProducto = prod.getPreProducto();
            String stockProducto = prod.getStockProducto();
            String nroProducto = prod.getNroProducto();
            String extraProducto = prod.getExtraProducto();
            PreparedStatement pst = conn.prepareStatement("INSERT INTO tb_producto (id_producto, descripcion, uni_medida, precio_costo, stock, nro_producto, cod_extranjero, activo) values (?,?,?,?,?,?,?,?)");

            pst.setString(1, idProducto);
            pst.setString(2, descProducto);
            pst.setString(3, uniProducto);
            pst.setString(4, preProducto);
            pst.setString(5, stockProducto);
            pst.setString(6, nroProducto);
            pst.setString(7, extraProducto);
            pst.setString(8, "1");
            ResultSet rs = pst.executeQuery();

            rs.close();
            pst.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Se tiene el siguiente error: " + e.getMessage());
        }

    }

    @Override
    public void updateProducto(Producto prod) {
        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();

        Producto proda = new Producto();

        try {
            String idProducto = prod.getIdProducto();
            String descProducto = prod.getDescProducto();
            String uniProducto = prod.getUniProducto();
            String preProducto = prod.getPreProducto();
            String stockProducto = prod.getStockProducto();
            String nroProducto = prod.getNroProducto();
            String extraProducto = prod.getExtraProducto();
            PreparedStatement pst = conn.prepareStatement("update tb_producto set descripcion=?, uni_medida=?, precio_costo=?, stock=?, nro_producto=?, cod_extranjero=? where id_producto=?");

            pst.setString(1, descProducto);
            pst.setString(2, uniProducto);
            pst.setString(3, preProducto);
            pst.setString(4, stockProducto);
            pst.setString(5, nroProducto);
            pst.setString(6, extraProducto);
            pst.setString(7, idProducto);
            pst.executeUpdate();
            pst.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Se tiene el siguiente error: " + e.getMessage());
        }

    }

    @Override
    public void deleteProducto(Producto prod) {
        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();
        Producto proda = new Producto();

        try {
            String idProducto = prod.getIdProducto();
            PreparedStatement pst = conn.prepareStatement("update tb_producto set activo=? where id_producto=?");

            pst.setString(1, "0");
            pst.setString(2, idProducto);
            pst.executeUpdate();
            pst.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Se tiene el siguiente error: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Producto> ventaProducto(Producto prod) {

        ArrayList ventaProd = new ArrayList();

        String idProducto = prod.getIdProducto();
        String descProducto = prod.getDescProducto();
        String uniProducto = prod.getUniProducto();
        String preProducto = prod.getPreProducto();
        String stockProducto = prod.getStockProducto();
        String nroProducto = prod.getNroProducto();
        String extraProducto = prod.getExtraProducto();

        return ventaProd;

    }

}
