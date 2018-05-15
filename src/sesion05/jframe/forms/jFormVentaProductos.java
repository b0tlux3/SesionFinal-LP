
package sesion05.jframe.forms;

import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.DetalleVenta;
import modelo.Producto;
import modelo.adm.ISeguridadProductoAdm;
import modelo.adm.SeguridadProductoAdmSQLOra;
import sesion05.jframe.principal.menuPrincipal2;

public class jFormVentaProductos extends javax.swing.JFrame {

    DefaultTableModel modelo2 = new DefaultTableModel(null, new String[]{
        "Descripcion", "UniProducto", "Precio-Costo", "Stock"});

    DefaultTableModel modelo3 = new DefaultTableModel(null, new String[]{
        "Cantidad", "Producto", "Precio", "Importe"});

    public jFormVentaProductos() {
        initComponents();
txtCantidadVenta.setText("0");
        ISeguridadProductoAdm seguProdAdm = new SeguridadProductoAdmSQLOra();
        ArrayList<Producto> listaProductos = seguProdAdm.listarProducto();
        jTable2.putClientProperty("Terminate edit", Boolean.TRUE);
        for (int i = 0; i < listaProductos.size(); i++) {
            modelo2.addRow(new Object[]{
                listaProductos.get(i).getDescProducto(),
                listaProductos.get(i).getUniProducto(),
                listaProductos.get(i).getPreProducto(),
                listaProductos.get(i).getStockProducto(),});

        }

        ListSelectionModel model = jTable2.getSelectionModel();
        model.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {

                if (!model.isSelectionEmpty()) {
                    int selectRow = model.getMinSelectionIndex();
                    //JOptionPane.showMessageDialog(null, "Select Fila: " + selectRow);
                    int selectedRow = jTable2.getSelectedRow();
                    String setToTextField = new String();
                    /*
                    for (int i = 0; i < jTable2.getColumnCount(); i++) {

                    }
                     */
                    System.out.println(" " + String.valueOf((jTable2.getValueAt(jTable2.getSelectedRow(), 0))));
                    System.out.println(" " + String.valueOf((jTable2.getValueAt(jTable2.getSelectedRow(), 1))));
                    System.out.println(" " + String.valueOf((jTable2.getValueAt(jTable2.getSelectedRow(), 2))));
                    System.out.println(" " + String.valueOf((jTable2.getValueAt(jTable2.getSelectedRow(), 3))));

                }

               
            }

        });

    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jsTProducto = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        }
        ;
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jsTProducto1 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        }
        ;
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCantidadVenta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("MS Gothic", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Venta de Productos");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(216, 216, 216))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 68, 653, -1));

        jButton1.setBackground(new java.awt.Color(0, 102, 204));
        jButton1.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("X");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 0, 52, 42));

        jButton2.setBackground(new java.awt.Color(0, 102, 255));
        jButton2.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Menu Principal");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 134, 46));

        jsTProducto.setBackground(new java.awt.Color(51, 51, 51));
        jsTProducto.setBorder(null);
        jsTProducto.setForeground(new java.awt.Color(51, 51, 51));

        jTable2.setModel(modelo2);
        jTable2.setBackground(new java.awt.Color(255, 255, 255));
        jTable2.setForeground(new java.awt.Color(51, 51, 51));
        jTable2.setModel(modelo2);
        jTable2.setGridColor(new java.awt.Color(0, 0, 0));
        jTable2.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jsTProducto.setViewportView(jTable2);

        getContentPane().add(jsTProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 660, 140));

        jButton3.setBackground(new java.awt.Color(153, 255, 102));
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 140, 31));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Detalle Comprobante");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        jsTProducto1.setBackground(new java.awt.Color(51, 51, 51));
        jsTProducto1.setBorder(null);
        jsTProducto1.setForeground(new java.awt.Color(51, 51, 51));

        jTable3.setModel(modelo3);
        jTable3.setBackground(new java.awt.Color(255, 255, 255));
        jTable3.setForeground(new java.awt.Color(51, 51, 51));
        jTable3.setModel(modelo3);
        jTable3.setGridColor(new java.awt.Color(0, 0, 0));
        jTable3.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jsTProducto1.setViewportView(jTable3);

        getContentPane().add(jsTProducto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 653, 140));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Seleccione producto de la lista:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Cantidad:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, 30));
        getContentPane().add(txtCantidadVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 150, 80, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        JDialog.setDefaultLookAndFeelDecorated(true);
        int response = JOptionPane.showConfirmDialog(null, "Realmente salir?", "Confirmar",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION) {
            System.out.println("Regreso");
        } else if (response == JOptionPane.YES_OPTION) {
            System.out.println("Ha salido...");
            System.exit(0);
        } else if (response == JOptionPane.CLOSED_OPTION) {
            System.out.println("Ha cerrado boton");
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        menuPrincipal2 menuPrin1 = new menuPrincipal2();
        dispose();
        menuPrin1.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        JDialog.setDefaultLookAndFeelDecorated(true);
        int response = JOptionPane.showConfirmDialog(null, "Realmente desea agregar el producto a la cesta de venta?", "Confirmar",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION) {
            System.out.println("Regreso");
        } else if (response == JOptionPane.YES_OPTION) {
            System.out.println("Agregado producto...");
            boolean existe = false;
            double importe=0.0;
             String[] datos = new String[4];
                DetalleVenta venta1 = new DetalleVenta();
                ArrayList<DetalleVenta> listaDetalleVenta = new ArrayList();
                venta1.setCantidadVenta(txtCantidadVenta.getText());
                venta1.setProductoVenta(String.valueOf((jTable2.getValueAt(jTable2.getSelectedRow(), 0))));
                venta1.setPrecioVenta(String.valueOf((jTable2.getValueAt(jTable2.getSelectedRow(), 2))));
                //venta1.setImporteVenta;
                importe = Integer.parseInt(txtCantidadVenta.getText())*Integer.parseInt((String) jTable2.getValueAt(jTable2.getSelectedRow(), 2));
                venta1.setImporteVenta(String.valueOf(importe));
                listaDetalleVenta.add(venta1);

                for (int i = 0; i < listaDetalleVenta.size(); i++) {
                    datos[0] = venta1.getCantidadVenta();
                    datos[1] = venta1.getProductoVenta();
                    datos[2] = venta1.getPrecioVenta();
                    datos[3] = venta1.getImporteVenta();

                    modelo3.addRow(datos);

                }
                jTable3.setModel(modelo3);
            
            
            
            
            
            //System.exit(0);
        } else if (response == JOptionPane.CLOSED_OPTION) {
            System.out.println("Ha cerrado boton");

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jFormVentaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFormVentaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFormVentaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFormVentaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFormVentaProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JScrollPane jsTProducto;
    private javax.swing.JScrollPane jsTProducto1;
    private javax.swing.JTextField txtCantidadVenta;
    // End of variables declaration//GEN-END:variables
}
