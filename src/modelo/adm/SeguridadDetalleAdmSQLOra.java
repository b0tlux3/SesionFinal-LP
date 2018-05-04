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
import modelo.Detalle;

/**
 *
 * @author Usuario-Clone0
 */
public class SeguridadDetalleAdmSQLOra implements ISeguridadDetalleAdm {

    @Override
    public ArrayList<Detalle> listarDetalle() {
        ArrayList listaDetalles = new ArrayList();
        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select d.cod_transaccion, d.fec_transaccion, d.cantidad, d.fec_entrega, d.pre_movimiento, d.tot_movimiento, p.descripcion, t.tipo_transaccion from tb_detalletransaccion d, tb_tipotransaccion t, tb_producto p where d.id_producto=p.id_producto and d.id_transaccion=t.id_transaccion and d.activo='1' order by d.cod_transaccion");
            while (rs.next()) {
                Detalle detalle = new Detalle();
                detalle.setCodTransaccion(rs.getString(1));
                detalle.setFecTransaccion(rs.getString(2));
                detalle.setCantTransaccion(rs.getString(3));
                detalle.setFecEntrega(rs.getString(4));
                detalle.setPreMovimiento(rs.getString(5));
                detalle.setTotMovimienot(rs.getString(6));
                detalle.setDescProducto(rs.getString(7));
                detalle.setTipoTransaccion(rs.getString(8));
                listaDetalles.add(detalle);
            }

            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("No se pudo obtener los registros de la base de datos. Mensaje: " + e.getMessage());
        }

        return listaDetalles;

    }

    @Override
    public void addDetalle(Detalle detalle) {
        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();

        Detalle detallea = new Detalle();

        try {
            String codTransaccion = detalle.getCodTransaccion();
            String fecTransaccion = detalle.getFecTransaccion();
            String cantTransaccion = detalle.getCantTransaccion();
            String fecEntrega = detalle.getFecEntrega();
            String preMovimiento = detalle.getPreMovimiento();
            String totMovimiento = detalle.getTotMovimienot();
            String descProducto = detalle.getDescProducto();
            String tipoTransaccion = detalle.getTipoTransaccion();
            PreparedStatement pst = conn.prepareStatement("INSERT INTO tb_detalletransaccion (cod_transaccion, fec_transaccion, cantidad, fec_entrega, pre_movimiento, tot_movimiento, id_producto, id_transaccion, activo) values (?,?,?,?,?,?,?,?,?)");

            pst.setString(1, codTransaccion);
            pst.setString(2, fecTransaccion);
            pst.setString(3, cantTransaccion);
            pst.setString(4, fecEntrega);
            pst.setString(5, preMovimiento);
            pst.setString(6, totMovimiento);
            pst.setString(7, descProducto);
            pst.setString(8, tipoTransaccion);
            pst.setString(9, "1");
            ResultSet rs = pst.executeQuery();

            rs.close();
            pst.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Se tiene el siguiente error: " + e.getMessage());
        }

    }

    @Override
    public void updateDetalle(Detalle detalle) {
        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();

        Detalle detallea = new Detalle();

        try {
            String codTransaccion = detalle.getCodTransaccion();
            String fecTransaccion = detalle.getFecTransaccion();
            String cantTransaccion = detalle.getCantTransaccion();
            String fecEntrega = detalle.getFecEntrega();
            String preMovimiento = detalle.getPreMovimiento();
            String totMovimiento = detalle.getTotMovimienot();
            String descProducto = detalle.getDescProducto();
            String tipoTransaccion = detalle.getTipoTransaccion();

            PreparedStatement pst = conn.prepareStatement("update tb_detalletransaccion set fec_transaccion=?, cantidad=?, fec_entrega=?, pre_movimiento=?, tot_movimiento=?, id_producto=?, id_transaccion=? where cod_transaccion=?");

            pst.setString(1, fecTransaccion);
            pst.setString(2, cantTransaccion);
            pst.setString(3, fecEntrega);
            pst.setString(4, preMovimiento);
            pst.setString(5, totMovimiento);
            pst.setString(6, descProducto);
            pst.setString(7, tipoTransaccion);
            pst.setString(8, codTransaccion);
            pst.executeUpdate();
            pst.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Se tiene el siguiente error: " + e.getMessage());
        }

    }

    @Override
    public void deleteDetalle(Detalle detalle) {
        Conexion conecta = new Conexion();
        Connection conn = conecta.getConnection();

        Detalle detallea = new Detalle();

        try {
            String codTransaccion = detalle.getCodTransaccion();
            PreparedStatement pst = conn.prepareStatement("update tb_detalletransaccion set activo=? where cod_transaccion=?");

            pst.setString(1, "0");
            pst.setString(2, codTransaccion);
            pst.executeUpdate();
            pst.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Se tiene el siguiente error: " + e.getMessage());
        }

    }

}
