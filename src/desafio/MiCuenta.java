
package desafio;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */



/**
 *
 Clase que permite al usuario modificar su nombre de usuario y contraseña
 */
public class MiCuenta extends javax.swing.JDialog {

    int xMouse, yMouse; //estas variables servirán para localizar la posición del ratón 
    
    /**
 * Constructor de la clase MiCuenta.
 * @param parent El Frame padre.
 * @param modal Indica si el diálogo es modal o no.
 */
    public MiCuenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setSize(530, 440);
        this.setLocationRelativeTo(null); //con esto la pantalla saldrá centrada
        Login.getUsuario();
        Login.getContraseña();
        
        // Obtener usuario y contraseña desde la clase Login
        String usuario = Login.getUsuario();
        String contraseña = Login.getContraseña();
        
        // Mostrar usuario y contraseña en los campos correspondientes
        txtMiCuentaUsuario.setText(usuario);
        txtMiCuentaPass.setText(contraseña);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtMiCuentaUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCambiarUsuario = new javax.swing.JButton();
        btnCambiarPass = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        headerMiCuenta = new javax.swing.JPanel();
        txtMiCuentaPass = new javax.swing.JPasswordField();
        tgglebtnMostrarPass = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFocusable(false);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 440));

        txtMiCuentaUsuario.setBackground(new java.awt.Color(242, 242, 242));
        txtMiCuentaUsuario.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        txtMiCuentaUsuario.setEnabled(false);
        txtMiCuentaUsuario.setFocusable(false);
        jPanel1.add(txtMiCuentaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 230, 30));

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 120, -1));

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 120, -1));

        btnCambiarUsuario.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        btnCambiarUsuario.setText("Cambiar ");
        btnCambiarUsuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCambiarUsuario.setFocusable(false);
        btnCambiarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnCambiarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 90, -1));

        btnCambiarPass.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        btnCambiarPass.setText("Cambiar");
        btnCambiarPass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCambiarPass.setFocusable(false);
        btnCambiarPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarPassActionPerformed(evt);
            }
        });
        jPanel1.add(btnCambiarPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 90, -1));

        btnVolver.setBackground(new java.awt.Color(242, 242, 242));
        btnVolver.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        btnVolver.setText("← Volver");
        btnVolver.setBorder(null);
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.setFocusable(false);
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVolverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVolverMouseExited(evt);
            }
        });
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 100, 40));

        headerMiCuenta.setOpaque(false);
        headerMiCuenta.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMiCuentaMouseDragged(evt);
            }
        });
        headerMiCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMiCuentaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout headerMiCuentaLayout = new javax.swing.GroupLayout(headerMiCuenta);
        headerMiCuenta.setLayout(headerMiCuentaLayout);
        headerMiCuentaLayout.setHorizontalGroup(
            headerMiCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );
        headerMiCuentaLayout.setVerticalGroup(
            headerMiCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel1.add(headerMiCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 60));

        txtMiCuentaPass.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        txtMiCuentaPass.setText("jPasswordField1");
        txtMiCuentaPass.setEnabled(false);
        txtMiCuentaPass.setFocusable(false);
        jPanel1.add(txtMiCuentaPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 230, 30));

        tgglebtnMostrarPass.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        tgglebtnMostrarPass.setText("Mostrar");
        tgglebtnMostrarPass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tgglebtnMostrarPass.setFocusable(false);
        tgglebtnMostrarPass.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tgglebtnMostrarPassItemStateChanged(evt);
            }
        });
        jPanel1.add(tgglebtnMostrarPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 90, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void headerMiCuentaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMiCuentaMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x- xMouse, y - yMouse);
    }//GEN-LAST:event_headerMiCuentaMouseDragged

    private void headerMiCuentaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMiCuentaMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMiCuentaMousePressed

    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverMouseClicked

    private void btnVolverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverMouseEntered

    private void btnVolverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverMouseExited

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

        setVisible(false); // Oculta el diálogo actual
        getParent().setVisible(true); // Muestra el JFrame padre
    }//GEN-LAST:event_btnVolverActionPerformed

    private void tgglebtnMostrarPassItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tgglebtnMostrarPassItemStateChanged
      /**
 * Verifica el estado del botón de alternancia y muestra u oculta la contraseña en el campo de texto correspondiente.
 */ 
        // Verificar el estado del toggle button
    if (tgglebtnMostrarPass.isSelected()) {
        txtMiCuentaPass.setEchoChar((char) 0); // Mostrar caracteres normales
        tgglebtnMostrarPass.setText("Ocultar");
    } else {
        txtMiCuentaPass.setEchoChar('*'); // Mostrar asteriscos
        tgglebtnMostrarPass.setText("Mostrar");
    }
    }//GEN-LAST:event_tgglebtnMostrarPassItemStateChanged

    private void btnCambiarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarUsuarioActionPerformed
        /**
 * Realiza el cambio de nombre de usuario cuando se hace clic en el botón correspondiente.
 */

        // Crear un JOptionPane para que el usuario introduzca el nuevo nombre de usuario
String nuevoUsuario = JOptionPane.showInputDialog(this, "Introduce tu nuevo nombre de usuario:", "Cambiar nombre de usuario", JOptionPane.PLAIN_MESSAGE);

// Verificar si el usuario ingresó un nombre de usuario válido
if (nuevoUsuario != null && !nuevoUsuario.isEmpty()) {
    // Actualizar el nombre de usuario en la base de datos
    try {
        String sql = "UPDATE usuarios SET usuario = ? WHERE usuario = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Desafio", "sa", "contraseña1234");
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nuevoUsuario);
            statement.setString(2, Login.getUsuario()); // Obtener el nombre de usuario actual
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                // La actualización fue exitosa, mostrar mensaje de éxito
                JOptionPane.showMessageDialog(this, "Nombre de usuario actualizado correctamente a: " + nuevoUsuario, "Éxito", JOptionPane.INFORMATION_MESSAGE);
                
                // Actualizar el nombre de usuario en la aplicación
                Login.setUsuario(nuevoUsuario);
                
                // Actualizar el campo de texto con el nuevo nombre de usuario
                txtMiCuentaUsuario.setText(nuevoUsuario);
                
                // Cerramos sesión y accedemos al login
                dispose();
                connection.close();
                Login login = new Login();
                login.setVisible(true);
            } else {
                // No se actualizó ningún registro, mostrar mensaje de error
                JOptionPane.showMessageDialog(this, "No se pudo actualizar el nombre de usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException ex) {
        // Manejar el error de SQL
        JOptionPane.showMessageDialog(this, "Error al intentar actualizar el nombre de usuario en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
} else {
    // El usuario canceló el diálogo o no ingresó ningún nombre de usuario
    JOptionPane.showMessageDialog(this, "Operación cancelada. El nombre de usuario no ha sido cambiado.", "Información", JOptionPane.INFORMATION_MESSAGE);
}

    }//GEN-LAST:event_btnCambiarUsuarioActionPerformed

    private void btnCambiarPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarPassActionPerformed
     /**
 * Realiza el cambio de contraseña cuando se hace clic en el botón correspondiente.
 */                                     
    String contraseñaActual = JOptionPane.showInputDialog(this, "Introduce tu contraseña actual:");
    if (contraseñaActual != null && !contraseñaActual.isEmpty()) {
        String nuevaContraseña = JOptionPane.showInputDialog(this, "Introduce tu nueva contraseña:");
        if (nuevaContraseña != null && !nuevaContraseña.isEmpty()) {
            // Obtener el usuario actual
            String usuario = txtMiCuentaUsuario.getText();
            
            try {
                // Verificar la contraseña actual antes de cambiarla
                if (verificarCredenciales(usuario, contraseñaActual)) {
                    // Encriptar la nueva contraseña antes de guardarla en la base de datos
                    String contraseñaEncriptada = encriptarContraseña(nuevaContraseña);
                    // Actualizar la contraseña en la base de datos
                    try {
                        // Actualizar la contraseña en la base de datos
                        String sql = "UPDATE usuarios SET contraseña = ? WHERE usuario = ?";
                        try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Desafio", "sa", "contraseña1234");
                                PreparedStatement statement = connection.prepareStatement(sql)) {
                            statement.setString(1, contraseñaEncriptada);
                            statement.setString(2, usuario);
                            int rowsUpdated = statement.executeUpdate();
                            if (rowsUpdated > 0) {
                                // La actualización fue exitosa
                                JOptionPane.showMessageDialog(this, "Contraseña actualizada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                                // Cerramos sesión y accedemos al login
                                dispose();
                                connection.close();
                                Login login = new Login();
                                login.setVisible(true);
                            } else {
                                // No se actualizó ningún registro
                                JOptionPane.showMessageDialog(this, "No se pudo actualizar la contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Error al intentar actualizar la contraseña en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "La contraseña actual es incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(MiCuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }  

    }//GEN-LAST:event_btnCambiarPassActionPerformed

        
    /**
 * Verifica las credenciales del usuario comparando el nombre de usuario y la contraseña proporcionados con los almacenados en la base de datos.
 * @param usuario El nombre de usuario.
 * @param contraseña La contraseña del usuario.
 * @return true si las credenciales son válidas, false si no lo son.
 * @throws SQLException Si ocurre un error al acceder a la base de datos.
 */  
        private boolean verificarCredenciales(String usuario, String contraseña) throws SQLException {
            String contraseñaEncriptada = encriptarContraseña(contraseña);
            String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?";

            try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Desafio", "sa", "contraseña1234");
                 PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, usuario);
                statement.setString(2, contraseñaEncriptada);

                try (ResultSet resultSet = statement.executeQuery()) {
                    return resultSet.next();
                }
            }
        }

    /**
 * Encripta una contraseña utilizando el algoritmo de hash SHA-256.
 * @param contraseña La contraseña a encriptar.
 * @return La contraseña encriptada como una cadena hexadecimal.
 */
    private String encriptarContraseña(String contraseña) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(contraseña.getBytes());
            
            // Convertir el hash a una cadena hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            
            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     *
     * @param args
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
            java.util.logging.Logger.getLogger(MiCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MiCuenta dialog = new MiCuenta(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarPass;
    private javax.swing.JButton btnCambiarUsuario;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel headerMiCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton tgglebtnMostrarPass;
    private javax.swing.JPasswordField txtMiCuentaPass;
    private javax.swing.JTextField txtMiCuentaUsuario;
    // End of variables declaration//GEN-END:variables
}
