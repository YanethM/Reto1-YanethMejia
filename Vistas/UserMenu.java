package Vistas;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UserMenu extends javax.swing.JFrame {

    //2 Atributos
    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    ResultSet rs;
    DefaultTableModel contenidoTablaEmpleados;
    private JLabel label = new JLabel();

    public UserMenu() {
        initComponents();
        this.setLocationRelativeTo(this);
        listarEmpleados();
    }

//1. Método para listar los empleados en la tabla

    public void listarEmpleados() {
        String query = "SELECT * FROM empleados";
        try {
            connection = conexion.getConnection();
            //createStatement es un método abstracto
            st = connection.createStatement();
            rs = st.executeQuery(query);
            //3 Alamacenar respuesta del query en un objeto
            Object[] empleados = new Object[7];
            //4 Consultamos el model de la tabla y vemos que se encuentra vacío
            contenidoTablaEmpleados = (DefaultTableModel) tblEmpleados.getModel();
            //5 Creamos un ciclo para recorrer todos los resultados del query
            while (rs.next()) {
                empleados[0] = rs.getInt("idEmp");
                empleados[1] = rs.getString("nombreEmp");
                empleados[2] = rs.getString("apellidos");
                empleados[3] = rs.getString("tipoDocumento");
                empleados[4] = rs.getString("documento");
                empleados[5] = rs.getString("correo");

                //6 Creamos una fila por cada registro encontrado en la base de datos
                System.out.println("idEmp: " + empleados[0] + ", nombre: " + empleados[1]
                        + ", documento: " + empleados[2] + " " + empleados[3] + ", correo: "
                        + empleados[4]);
                contenidoTablaEmpleados.addRow(empleados);
                tblEmpleados.setModel(contenidoTablaEmpleados);
            }
        } catch (SQLException e) {
            System.out.println("No se pudo cargar la información de los empleados");
        }
    }

    public void eliminarDatosTablaEmpleado() {
        // getRowCount realiza un conteo de la cantidad de registros que lista la tabla
        for (int i = 0; i < tblEmpleados.getRowCount(); i++) {
            contenidoTablaEmpleados.removeRow(i);
            i -= 1;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAddUser = new javax.swing.JButton();
        btnEditUser = new javax.swing.JButton();
        btnDeleteUser = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido(s)", "Tipo documento", "Documento", "Correo", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        jLabel2.setText("Empleados");

        jLabel3.setText("Misión TIC 2022");

        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/addUser.png"))); // NOI18N
        btnAddUser.setText("Nuevo");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        btnEditUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/editUser.png"))); // NOI18N
        btnEditUser.setText("Editar");
        btnEditUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditUserActionPerformed(evt);
            }
        });

        btnDeleteUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/deleteUser.png"))); // NOI18N
        btnDeleteUser.setText("Eliminar");
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(btnEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(209, 209, 209)
                                .addComponent(jLabel2))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(188, 188, 188)
                                .addComponent(jLabel3)))))
                .addContainerGap(336, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 968, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditUser)
                    .addComponent(btnDeleteUser))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Empleados", jPanel1);
        jTabbedPane1.addTab("Linea de ventas", jTabbedPane2);
        jTabbedPane1.addTab("Productos", jTabbedPane3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditUserActionPerformed

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        //Creamos una instancia del JDialog para crear usuario
        AddUserForm addUser = new AddUserForm(this, true);
        addUser.setVisible(true);
        eliminarDatosTablaEmpleado();
        listarEmpleados();
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        //1. Capturar el número de fila seleccionada
        int row = tblEmpleados.getSelectedRow();
        System.out.println("Fila seleccionada" + row);
        //2. Validar si el usuario no ha seleccionado una fila
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Selecciona un empleado.", "", JOptionPane.WARNING_MESSAGE);
        } else {
            //3. Indicamos de la fila de empleado (id, nombre, tipo doc, doc, correo)
            //fila 0 columna 0 = id
            int id = Integer.parseInt(tblEmpleados.getValueAt(row, 0).toString());
            //Tener en cuenta que los datos de la tabla estan en tipo Object
            //fila 0 columna 1 = nombre empleado
            String nombre = (String) tblEmpleados.getValueAt(row, 1);
            String apellidos = (String) tblEmpleados.getValueAt(row, 2);
            String tipoDocumento = (String) tblEmpleados.getValueAt(row, 3);
            String documento = (String) tblEmpleados.getValueAt(row, 4);
            String correo = (String) tblEmpleados.getValueAt(row, 5);
            System.out.println("Id: " + id + ", empleado: " + nombre + " " + apellidos
                    + ", tipo documento: " + tipoDocumento + ", numero: " + documento
                    + ", correo: " + correo);
            //4. Instanciamos el JDialog para mostrar la información del empleado seleccionado
            ShowUserForm showUserForm = new ShowUserForm(this, true);
            showUserForm.recibeDatos(id, nombre, apellidos, documento, correo);
            showUserForm.setVisible(true);
            //5. Actualizamos la información de la tabla en caso de que se hubiese editado el empleado
            eliminarDatosTablaEmpleado();
            listarEmpleados();
        }
    }//GEN-LAST:event_tblEmpleadosMouseClicked

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
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnEditUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable tblEmpleados;
    // End of variables declaration//GEN-END:variables
}
