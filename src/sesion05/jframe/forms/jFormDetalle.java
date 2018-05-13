/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion05.jframe.forms;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Detalle;
import modelo.Producto;
import modelo.Usuario;
import modelo.adm.ISeguridadAdm;
import modelo.adm.ISeguridadDetalleAdm;
import modelo.adm.ISeguridadProductoAdm;
import modelo.adm.SeguridadAdmSQLOra;
import modelo.adm.SeguridadDetalleAdmSQLOra;
import modelo.adm.SeguridadProductoAdmSQLOra;
import sesion05.jframe.principal.menuPrincipal2;

/**
 *
 * @author Usuario-Clone0
 */
public class jFormDetalle extends javax.swing.JFrame {

    DefaultTableModel modelo2 = new DefaultTableModel(null, new String[]{
        "Codigo", "Fecha",
        "Cantidad", "Entrega", "Precio", "Total", "Producto", "Transaccion"});
    boolean estado_txtFields = true;

    boolean funcEstado_txts(boolean estadoTxts) {
        boolean estado_txts = estadoTxts;
        if (estado_txts == true) {
            txtCodTransaccion.setEnabled(true);
            txtDescProducto.setEnabled(true);
            txtTotal.setEnabled(true);
            txtFecha.setEnabled(true);
            txtCantidad.setEnabled(true);
            txtEntrega.setEnabled(true);
            txtPrecio.setEnabled(true);
            txtTipoTransaccion.setEnabled(true);

            txtCodTransaccion.setText("");
            txtDescProducto.setText("");
            txtTotal.setText("");
            txtFecha.setText("");
            txtCantidad.setText("");
            txtEntrega.setText("");
            txtPrecio.setText("");
            txtTipoTransaccion.setText("");

            estado_txtFields = true;
        } else {
            txtCodTransaccion.setEnabled(false);
            txtDescProducto.setEnabled(false);
            txtTotal.setEnabled(false);
            txtFecha.setEnabled(false);
            txtCantidad.setEnabled(false);
            txtEntrega.setEnabled(false);
            txtPrecio.setEnabled(false);
            txtTipoTransaccion.setEnabled(false);

            estado_txtFields = false;

        }

        return estado_txts;
    }

    /**
     * Creates new form jFormUsuario
     */
    public jFormDetalle() {
        initComponents();

        ISeguridadDetalleAdm seguDetalleAdm = new SeguridadDetalleAdmSQLOra();
        ArrayList<Detalle> listaDetalles = seguDetalleAdm.listarDetalle();
        jTable2.putClientProperty("Terminate edit", Boolean.TRUE);
        for (int i = 0; i < listaDetalles.size(); i++) {
            modelo2.addRow(new Object[]{
                listaDetalles.get(i).getCodTransaccion(),
                listaDetalles.get(i).getFecTransaccion(),
                listaDetalles.get(i).getCantTransaccion(),
                listaDetalles.get(i).getFecEntrega(),
                listaDetalles.get(i).getPreMovimiento(),
                listaDetalles.get(i).getTotMovimienot(),
                listaDetalles.get(i).getDescProducto(),
                listaDetalles.get(i).getTipoTransaccion()

            });

        }
        btnEditar.setEnabled(false);
        lblFecha.setText("DD/MM/AAAA");
        lblEntrega.setText("DD/MM/AAAA");
        txtAreaLogs.setText("Bienvenido: \nAgregue nuevos movimientos o seleccione uno de la tabla...");
        ListSelectionModel model = jTable2.getSelectionModel();
        model.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {

                if (!model.isSelectionEmpty()) {
                    int selectRow = model.getMinSelectionIndex();
                    //JOptionPane.showMessageDialog(null, "Select Fila: " + selectRow);
                    int selectedRow = jTable2.getSelectedRow();
                    String setToTextField = new String();
                    for (int i = 0; i < jTable2.getColumnCount(); i++) {

                    }
                    // Finally set this to your JTextField.
                    txtCodTransaccion.setText(String.valueOf((jTable2.getValueAt(jTable2.getSelectedRow(), 0))));
                    txtFecha.setText(String.valueOf((jTable2.getValueAt(jTable2.getSelectedRow(), 1))));
                    txtCantidad.setText(String.valueOf((jTable2.getValueAt(jTable2.getSelectedRow(), 2))));
                    txtEntrega.setText(String.valueOf((jTable2.getValueAt(jTable2.getSelectedRow(), 3))));
                    txtPrecio.setText(String.valueOf((jTable2.getValueAt(jTable2.getSelectedRow(), 4))));
                    txtTotal.setText(String.valueOf((jTable2.getValueAt(jTable2.getSelectedRow(), 5))));
                    txtDescProducto.setText(String.valueOf((jTable2.getValueAt(jTable2.getSelectedRow(), 6))));
                    txtTipoTransaccion.setText(String.valueOf((jTable2.getValueAt(jTable2.getSelectedRow(), 7))));

                    funcEstado_txts(false);
                    System.out.println(" " + txtCodTransaccion.getText());
                    System.out.println("" + txtFecha.getText());
                    System.out.println("" + txtCantidad.getText());
                    System.out.println("" + txtEntrega.getText());
                    System.out.println("" + txtPrecio.getText());
                    System.out.println("" + txtTotal.getText());
                    System.out.println("" + txtDescProducto.getText());
                    System.out.println("" + txtTipoTransaccion.getText());
                    btnEditar.setEnabled(true);
                    btnRegistrar.setEnabled(false);
                    txtAreaLogs.setText("Bienvenido: \nEditar o eliminar el registro seleccionado...");
                }

            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaLogs = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCodTransaccion = new javax.swing.JTextField();
        txtDescProducto = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtEntrega = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTipoTransaccion = new javax.swing.JTextField();
        lblEntrega = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jsTProducto = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        }
        ;
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TABLA USUARIOS");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("MS Gothic", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Mantenimiento Tabla Detalles");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 516, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(99, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Codigo");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Fecha");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Cantidad");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Entrega");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        btnRegistrar.setBackground(new java.awt.Color(102, 102, 102));
        btnRegistrar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/add-icon.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        btnRegistrar.setFocusable(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel5.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 367, 109, -1));

        btnEditar.setBackground(new java.awt.Color(102, 102, 102));
        btnEditar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 0, 0));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/edituser1.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        btnEditar.setFocusable(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel5.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 367, 109, -1));

        btnEliminar.setBackground(new java.awt.Color(102, 102, 102));
        btnEliminar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/deleteuser1.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        btnEliminar.setFocusable(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel5.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 367, 109, -1));

        btnLimpiar.setBackground(new java.awt.Color(102, 102, 102));
        btnLimpiar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/edit_clear1.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        btnLimpiar.setFocusable(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel5.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 367, 105, -1));

        txtAreaLogs.setEditable(false);
        txtAreaLogs.setColumns(20);
        txtAreaLogs.setRows(5);
        txtAreaLogs.setEnabled(false);
        jScrollPane1.setViewportView(txtAreaLogs);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 405, 492, 90));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Precio");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Total");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Producto");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));
        jPanel5.add(txtCodTransaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 220, 27));
        jPanel5.add(txtDescProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 220, 27));
        jPanel5.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 220, 27));
        jPanel5.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 220, 27));
        jPanel5.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 220, 27));
        jPanel5.add(txtEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 220, 27));
        jPanel5.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 220, 27));

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Transaccion");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));
        jPanel5.add(txtTipoTransaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 220, 27));

        lblEntrega.setBackground(new java.awt.Color(0, 0, 0));
        lblEntrega.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblEntrega.setForeground(new java.awt.Color(0, 0, 0));
        lblEntrega.setText("Formato");
        lblEntrega.setEnabled(false);
        jPanel5.add(lblEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 90, 20));

        lblFecha.setBackground(new java.awt.Color(0, 0, 0));
        lblFecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(0, 0, 0));
        lblFecha.setText("Formato");
        lblFecha.setEnabled(false);
        jPanel5.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 90, 20));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 630));

        jPanel3.setForeground(new java.awt.Color(51, 51, 51));

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

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/detalleAdd1.png"))); // NOI18N

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setForeground(new java.awt.Color(51, 51, 51));

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jsTProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jsTProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
        );

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(29, 29, 29)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 760, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1253, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1253, 620));
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

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        if (estado_txtFields == true) {

            String codTransaccion = txtCodTransaccion.getText();
            String fecTransaccion = txtFecha.getText();
            String cantTransaccion = txtCantidad.getText();
            String fecEntrega = txtEntrega.getText();
            String preMovimiento = txtPrecio.getText();
            String totalMovimiento = txtTotal.getText();
            String descProducto = txtDescProducto.getText();
            String tipoTransaccion = txtTipoTransaccion.getText();

            Detalle addDetalles1 = new Detalle();
            addDetalles1.setCodTransaccion(codTransaccion);
            addDetalles1.setFecTransaccion(fecTransaccion);
            addDetalles1.setCantTransaccion(cantTransaccion);
            addDetalles1.setFecEntrega(fecEntrega);
            addDetalles1.setPreMovimiento(preMovimiento);
            addDetalles1.setTotMovimienot(totalMovimiento);
            addDetalles1.setDescProducto(descProducto);
            addDetalles1.setTipoTransaccion(tipoTransaccion);

            ISeguridadDetalleAdm seguDetalledAdm = new SeguridadDetalleAdmSQLOra();
            seguDetalledAdm.addDetalle(addDetalles1);
            System.out.println(" " + codTransaccion);
            System.out.println("" + fecTransaccion);
            System.out.println("" + cantTransaccion);
            System.out.println("" + fecEntrega);
            System.out.println("" + preMovimiento);
            System.out.println("" + totalMovimiento);
            System.out.println("" + descProducto);
            System.out.println("" + tipoTransaccion);

            System.out.println("Se agrega nuevo registro");
            ArrayList<Detalle> listaDetalles = seguDetalledAdm.listarDetalle();
            modelo2.setRowCount(0);

            for (int i = 0; i < listaDetalles.size(); i++) {
                modelo2.addRow(new Object[]{
                    listaDetalles.get(i).getCodTransaccion(),
                    listaDetalles.get(i).getFecTransaccion(),
                    listaDetalles.get(i).getCantTransaccion(),
                    listaDetalles.get(i).getFecEntrega(),
                    listaDetalles.get(i).getPreMovimiento(),
                    listaDetalles.get(i).getTotMovimienot(),
                    listaDetalles.get(i).getDescProducto(),
                    listaDetalles.get(i).getTipoTransaccion()

                });

            }

            ListSelectionModel model = jTable2.getSelectionModel();
            funcEstado_txts(true);
            txtAreaLogs.setText("Bienvenido: \nAgregue nuevos movimientos o seleccione uno de la tabla...");
            JOptionPane.showMessageDialog(null, "Movimiento registrado con exito!");

        } else {
            System.out.println("Cambiando Modo");
            JOptionPane.showMessageDialog(null, "Agregue nuevos movimientos");
            funcEstado_txts(true);

        }


    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        if (estado_txtFields == false) {
            JOptionPane.showMessageDialog(null, "Actualice los campos y luego click en Editar");
            txtCodTransaccion.setEnabled(false);
            txtFecha.setEnabled(true);
            txtCantidad.setEnabled(true);
            txtEntrega.setEnabled(true);
            txtPrecio.setEnabled(true);
            txtTotal.setEnabled(true);
            txtDescProducto.setEnabled(true);
            txtTipoTransaccion.setEnabled(true);

            estado_txtFields = true;
            btnRegistrar.setEnabled(false);

            txtAreaLogs.setText("Bienvenido: \nModicar registro, actualice campos y luego click en Editar...");
        } else {
            String codTransaccion = txtCodTransaccion.getText();
            String fecTransaccion = txtFecha.getText();
            String cantTransaccion = txtCantidad.getText();
            String fecEntrega = txtEntrega.getText();
            String preMovimiento = txtPrecio.getText();
            String totalMovimiento = txtTotal.getText();
            String descProducto = txtDescProducto.getText();
            String tipoTransaccion = txtTipoTransaccion.getText();

            Detalle addDetalles1 = new Detalle();
            addDetalles1.setCodTransaccion(codTransaccion);
            addDetalles1.setFecTransaccion(fecTransaccion);
            addDetalles1.setCantTransaccion(cantTransaccion);
            addDetalles1.setFecEntrega(fecEntrega);
            addDetalles1.setPreMovimiento(preMovimiento);
            addDetalles1.setTotMovimienot(totalMovimiento);
            addDetalles1.setDescProducto(descProducto);
            addDetalles1.setTipoTransaccion(tipoTransaccion);

            ISeguridadDetalleAdm seguDetalledAdm = new SeguridadDetalleAdmSQLOra();
            seguDetalledAdm.updateDetalle(addDetalles1);

            ArrayList<Detalle> listaDetalles = seguDetalledAdm.listarDetalle();

            modelo2.setRowCount(0);

            for (int i = 0; i < listaDetalles.size(); i++) {
                modelo2.addRow(new Object[]{
                    listaDetalles.get(i).getCodTransaccion(),
                    listaDetalles.get(i).getFecTransaccion(),
                    listaDetalles.get(i).getCantTransaccion(),
                    listaDetalles.get(i).getFecEntrega(),
                    listaDetalles.get(i).getPreMovimiento(),
                    listaDetalles.get(i).getTotMovimienot(),
                    listaDetalles.get(i).getDescProducto(),
                    listaDetalles.get(i).getTipoTransaccion()

                });

            }

            ListSelectionModel model = jTable2.getSelectionModel();
            System.out.println("" + addDetalles1.getCodTransaccion());
            System.out.println("" + addDetalles1.getFecTransaccion());
            System.out.println("" + addDetalles1.getCantTransaccion());
            System.out.println("" + addDetalles1.getFecEntrega());
            System.out.println("" + addDetalles1.getPreMovimiento());
            System.out.println("" + addDetalles1.getTotMovimienot());
            System.out.println("" + addDetalles1.getDescProducto());
            System.out.println("" + addDetalles1.getTipoTransaccion());

            JOptionPane.showMessageDialog(null, "El registro se ha actualizado con exito");
            btnRegistrar.setEnabled(true);
            funcEstado_txts(true);
            txtAreaLogs.setText("Bienvenido: \nAgregue nuevos movimientos o seleccione uno de la tabla...");

        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:

        if (estado_txtFields == false) {

            int response = JOptionPane.showConfirmDialog(null, "Realmente desea eliminar el registro: " + txtCodTransaccion.getText(), "Eliminar Registro",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.NO_OPTION) {
                System.out.println("Regreso");
                txtAreaLogs.setText("Bienvenido: \nSe va a eliminar el registro...");
            } else if (response == JOptionPane.YES_OPTION) {
                System.out.println("Registro eliminado...");

                String codTransaccion = txtCodTransaccion.getText();
                Detalle addDetalles1 = new Detalle();
                addDetalles1.setCodTransaccion(codTransaccion);

                ISeguridadDetalleAdm seguDetalledAdm = new SeguridadDetalleAdmSQLOra();
                seguDetalledAdm.updateDetalle(addDetalles1);

                ArrayList<Detalle> listaDetalles = seguDetalledAdm.listarDetalle();

                modelo2.setRowCount(0);

                for (int i = 0; i < listaDetalles.size(); i++) {
                    modelo2.addRow(new Object[]{
                        listaDetalles.get(i).getCodTransaccion(),
                        listaDetalles.get(i).getFecTransaccion(),
                        listaDetalles.get(i).getCantTransaccion(),
                        listaDetalles.get(i).getFecEntrega(),
                        listaDetalles.get(i).getPreMovimiento(),
                        listaDetalles.get(i).getTotMovimienot(),
                        listaDetalles.get(i).getDescProducto(),
                        listaDetalles.get(i).getTipoTransaccion()
                    });

                }

                ListSelectionModel model = jTable2.getSelectionModel();
                JOptionPane.showMessageDialog(null, "El registro se ha eliminado con exito");
                funcEstado_txts(true);
                btnRegistrar.setEnabled(true);
                txtAreaLogs.setText("Bienvenido: \nAgregue nuevos movimientos o seleccione uno de la tabla...");

            } else if (response == JOptionPane.CLOSED_OPTION) {
                System.out.println("Ha cerrado boton");
            }

        } else {

            JOptionPane.showMessageDialog(null, "Seleccion un registro ha eliminar");

        }


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        menuPrincipal2 menuPrin1 = new menuPrincipal2();
        dispose();
        menuPrin1.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        funcEstado_txts(true);
        btnEditar.setEnabled(false);
        btnRegistrar.setEnabled(true);
        txtAreaLogs.setText("Bienvenido: \nAgregue nuevos movimientos o seleccione uno de la tabla...");


    }//GEN-LAST:event_btnLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(jFormUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFormUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFormUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFormUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFormDetalle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JScrollPane jsTProducto;
    private javax.swing.JLabel lblEntrega;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JTextArea txtAreaLogs;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodTransaccion;
    private javax.swing.JTextField txtDescProducto;
    private javax.swing.JTextField txtEntrega;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTipoTransaccion;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
