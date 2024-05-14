
package desafio;

import java.awt.Color;
import java.awt.Font;
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
 * Clase que representa la ventana de inicio de sesión.
 */
public class Login extends javax.swing.JFrame {

    int xMouse, yMouse; //estas variables servirán para localizar la posición del ratón
    private static String usuario; // Variable estática
    private static String contraseña;
    
    
    /**
     * Constructor de la clase. Inicializa los componentes de la ventana.
     */
    public Login() {
        initComponents();
       
        this.setTitle("LOGIN");
        this.setSize(812, 580);
        this.setLocationRelativeTo(null); //con esto la pantalla saldrá centrada
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogRegistrarse = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        labelBannerLogin1 = new javax.swing.JLabel();
        labelCrearCuenta = new javax.swing.JLabel();
        labelContraseñaCrear = new javax.swing.JLabel();
        separatorContraseña1 = new javax.swing.JSeparator();
        labelUsuarioCrear = new javax.swing.JLabel();
        txtUsuarioRegistrar = new javax.swing.JTextField();
        separatorUsuario1 = new javax.swing.JSeparator();
        txtPassRegistrar = new javax.swing.JPasswordField();
        panelBarraSuperior2 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        btnRegistrarse = new javax.swing.JButton();
        labelBannerLogin2 = new javax.swing.JLabel();
        labelContraseñaCrearConfirmar = new javax.swing.JLabel();
        txtPassConfirmar = new javax.swing.JPasswordField();
        separatorContraseña2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        labelBannerLogin = new javax.swing.JLabel();
        labelIniciarSesion = new javax.swing.JLabel();
        labelContraseña = new javax.swing.JLabel();
        separatorContraseña = new javax.swing.JSeparator();
        labelUsuario = new javax.swing.JLabel();
        txtfieldUsuario = new javax.swing.JTextField();
        separatorUsuario = new javax.swing.JSeparator();
        txtfieldContraseña = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        panelBarraSuperior = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnEntrar = new javax.swing.JButton();
        labelRegistrate = new javax.swing.JLabel();

        dialogRegistrarse.setMinimumSize(new java.awt.Dimension(812, 580));
        dialogRegistrarse.setUndecorated(true);
        dialogRegistrarse.setResizable(false);
        dialogRegistrarse.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setMaximumSize(new java.awt.Dimension(812, 580));
        jPanel2.setMinimumSize(new java.awt.Dimension(812, 580));
        jPanel2.setPreferredSize(new java.awt.Dimension(812, 580));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelBannerLogin1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login.png"))); // NOI18N
        labelBannerLogin1.setText("jLabel1");
        jPanel2.add(labelBannerLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 580));

        labelCrearCuenta.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        labelCrearCuenta.setForeground(new java.awt.Color(255, 255, 255));
        labelCrearCuenta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelCrearCuenta.setText("CREAR CUENTA");
        jPanel2.add(labelCrearCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 310, 40));

        labelContraseñaCrear.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        labelContraseñaCrear.setForeground(new java.awt.Color(255, 255, 255));
        labelContraseñaCrear.setText("CONTRASEÑA");
        jPanel2.add(labelContraseñaCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 190, -1));

        separatorContraseña1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(separatorContraseña1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 330, 20));

        labelUsuarioCrear.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        labelUsuarioCrear.setForeground(new java.awt.Color(255, 255, 255));
        labelUsuarioCrear.setText("USUARIO");
        jPanel2.add(labelUsuarioCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 110, -1));

        txtUsuarioRegistrar.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtUsuarioRegistrar.setForeground(new java.awt.Color(153, 153, 153));
        txtUsuarioRegistrar.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtUsuarioRegistrar.setText("Introduce tu nombre de usuario");
        txtUsuarioRegistrar.setBorder(null);
        txtUsuarioRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUsuarioRegistrarMouseClicked(evt);
            }
        });
        txtUsuarioRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioRegistrarActionPerformed(evt);
            }
        });
        jPanel2.add(txtUsuarioRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 330, 30));

        separatorUsuario1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(separatorUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 330, 20));

        txtPassRegistrar.setForeground(new java.awt.Color(153, 153, 153));
        txtPassRegistrar.setText("********");
        txtPassRegistrar.setBorder(null);
        txtPassRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPassRegistrarMouseClicked(evt);
            }
        });
        jPanel2.add(txtPassRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 330, 30));

        panelBarraSuperior2.setBackground(new java.awt.Color(51, 51, 51));
        panelBarraSuperior2.setForeground(new java.awt.Color(51, 51, 51));
        panelBarraSuperior2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelBarraSuperior2MouseDragged(evt);
            }
        });
        panelBarraSuperior2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelBarraSuperior2MousePressed(evt);
            }
        });
        panelBarraSuperior2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVolver.setBackground(new java.awt.Color(242, 242, 242));
        btnVolver.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
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
        panelBarraSuperior2.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 130, 50));

        jPanel2.add(panelBarraSuperior2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 50));

        btnRegistrarse.setBackground(new java.awt.Color(242, 242, 242));
        btnRegistrarse.setFont(new java.awt.Font("Courier New", 0, 16)); // NOI18N
        btnRegistrarse.setText("REGISTRARSE");
        btnRegistrarse.setBorder(null);
        btnRegistrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrarseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarseMouseExited(evt);
            }
        });
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, 130, 40));

        labelBannerLogin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login.png"))); // NOI18N
        labelBannerLogin2.setText("jLabel1");
        jPanel2.add(labelBannerLogin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 580));

        labelContraseñaCrearConfirmar.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        labelContraseñaCrearConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        labelContraseñaCrearConfirmar.setText("CONFIRMAR CONTRASEÑA");
        jPanel2.add(labelContraseñaCrearConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 350, -1));

        txtPassConfirmar.setForeground(new java.awt.Color(153, 153, 153));
        txtPassConfirmar.setText("********");
        txtPassConfirmar.setBorder(null);
        txtPassConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPassConfirmarMouseClicked(evt);
            }
        });
        jPanel2.add(txtPassConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 330, 30));

        separatorContraseña2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(separatorContraseña2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 330, 20));

        dialogRegistrarse.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setMaximumSize(new java.awt.Dimension(812, 580));
        jPanel1.setMinimumSize(new java.awt.Dimension(812, 580));
        jPanel1.setPreferredSize(new java.awt.Dimension(812, 580));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelBannerLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login.png"))); // NOI18N
        labelBannerLogin.setText("jLabel1");
        jPanel1.add(labelBannerLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 580));

        labelIniciarSesion.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        labelIniciarSesion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelIniciarSesion.setText("INICIAR SESIÓN");
        jPanel1.add(labelIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 310, 40));

        labelContraseña.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        labelContraseña.setText("CONTRASEÑA");
        jPanel1.add(labelContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 190, -1));

        separatorContraseña.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(separatorContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 330, 20));

        labelUsuario.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        labelUsuario.setText("USUARIO");
        jPanel1.add(labelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 110, -1));

        txtfieldUsuario.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtfieldUsuario.setForeground(new java.awt.Color(153, 153, 153));
        txtfieldUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtfieldUsuario.setText("Introduce tu nombre de usuario");
        txtfieldUsuario.setBorder(null);
        txtfieldUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtfieldUsuarioMouseClicked(evt);
            }
        });
        txtfieldUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfieldUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtfieldUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 330, 30));

        separatorUsuario.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(separatorUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 330, 20));

        txtfieldContraseña.setForeground(new java.awt.Color(153, 153, 153));
        txtfieldContraseña.setText("********");
        txtfieldContraseña.setBorder(null);
        txtfieldContraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfieldContraseñaFocusGained(evt);
            }
        });
        txtfieldContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtfieldContraseñaMouseClicked(evt);
            }
        });
        jPanel1.add(txtfieldContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 330, 30));

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel1.setText("¿No tienes una cuenta?");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 480, 170, 20));

        panelBarraSuperior.setBackground(new java.awt.Color(255, 255, 255));
        panelBarraSuperior.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelBarraSuperiorMouseDragged(evt);
            }
        });
        panelBarraSuperior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelBarraSuperiorMousePressed(evt);
            }
        });
        panelBarraSuperior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setBackground(new java.awt.Color(242, 242, 242));
        btnSalir.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        btnSalir.setText("X");
        btnSalir.setBorder(null);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setFocusable(false);
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });
        panelBarraSuperior.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 60, 50));

        jPanel1.add(panelBarraSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 50));

        btnEntrar.setBackground(new java.awt.Color(242, 242, 242));
        btnEntrar.setFont(new java.awt.Font("Courier New", 0, 16)); // NOI18N
        btnEntrar.setText("ENTRAR");
        btnEntrar.setBorder(null);
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEntrarMouseExited(evt);
            }
        });
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 130, 40));

        labelRegistrate.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        labelRegistrate.setText("REGÍSTRATE");
        labelRegistrate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelRegistrate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRegistrateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelRegistrateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelRegistrateMouseExited(evt);
            }
        });
        jPanel1.add(labelRegistrate, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, 80, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtfieldUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfieldUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfieldUsuarioActionPerformed

    private void panelBarraSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBarraSuperiorMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_panelBarraSuperiorMousePressed

    private void panelBarraSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBarraSuperiorMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x- xMouse, y - yMouse);
    }//GEN-LAST:event_panelBarraSuperiorMouseDragged

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        btnSalir.setBackground(new Color(96,133,139));
        btnSalir.setForeground(Color.white);
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        btnSalir.setBackground(new Color(242,242,242));
        btnSalir.setForeground(Color.black);
    }//GEN-LAST:event_btnSalirMouseExited

    private void btnEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseEntered
        btnEntrar.setBackground(new Color(96,133,139));
        btnEntrar.setForeground(Color.white);
    }//GEN-LAST:event_btnEntrarMouseEntered

    private void btnEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseExited
        btnEntrar.setBackground(new Color(242,242,242));
        btnEntrar.setForeground(Color.black);
    }//GEN-LAST:event_btnEntrarMouseExited

    private void labelRegistrateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRegistrateMouseEntered
        // Obtener el texto actual de la etiqueta
        String labelText = labelRegistrate.getText();
    
        // Agregar formato HTML para subrayar el texto
        labelRegistrate.setText("<html><u>" + labelText + "</u></html>");

    }//GEN-LAST:event_labelRegistrateMouseEntered

    private void labelRegistrateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRegistrateMouseExited
        // Obtener el texto actual de la etiqueta
    String labelText = labelRegistrate.getText();
    
    // Eliminar el formato HTML de subrayado del texto
    labelText = labelText.replaceAll("<html><u>", "");
    labelText = labelText.replaceAll("</u></html>", "");
    
    // Establecer el texto modificado en la etiqueta
    labelRegistrate.setText(labelText);
    }//GEN-LAST:event_labelRegistrateMouseExited

    private void txtfieldUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfieldUsuarioMouseClicked
        if (txtfieldUsuario.getText().equals("Introduce tu nombre de usuario")){
            txtfieldUsuario.setText("");
            txtfieldUsuario.setForeground(Color.black);
        }
        
        if (String.valueOf(txtfieldContraseña.getPassword()).isEmpty()){
            txtfieldContraseña.setText("********");
            txtfieldContraseña.setForeground(Color.gray);
        }          
    }//GEN-LAST:event_txtfieldUsuarioMouseClicked

    private void txtfieldContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfieldContraseñaMouseClicked
        
    }//GEN-LAST:event_txtfieldContraseñaMouseClicked

    private void txtUsuarioRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioRegistrarMouseClicked
        if (txtUsuarioRegistrar.getText().equals("Introduce tu nombre de usuario")){
            txtUsuarioRegistrar.setText("");
            txtUsuarioRegistrar.setForeground(Color.black);
        }
        
        if (String.valueOf(txtPassRegistrar.getPassword()).isEmpty()){
            txtPassRegistrar.setText("********");
            txtPassRegistrar.setForeground(Color.gray);
        }
        
        if (String.valueOf(txtPassConfirmar.getPassword()).isEmpty()){
            txtPassConfirmar.setText("********");
            txtPassConfirmar.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtUsuarioRegistrarMouseClicked

    private void txtUsuarioRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioRegistrarActionPerformed

    private void txtPassRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassRegistrarMouseClicked
        if (String.valueOf(txtPassRegistrar.getPassword()).equals("********")){
            txtPassRegistrar.setText("");
            txtPassRegistrar.setForeground(Color.black);
        }
        
        if (String.valueOf(txtUsuarioRegistrar.getText()).isEmpty()){
            txtUsuarioRegistrar.setText("Introduce tu nombre de usuario");
            txtUsuarioRegistrar.setForeground(Color.gray);
        }
        
        if (String.valueOf(txtPassConfirmar.getPassword()).isEmpty()){
            txtPassConfirmar.setText("********");
            txtPassConfirmar.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtPassRegistrarMouseClicked

    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverMouseClicked

    private void btnVolverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverMouseEntered

    private void btnVolverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverMouseExited

    private void panelBarraSuperior2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBarraSuperior2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x- xMouse, y - yMouse);
    }//GEN-LAST:event_panelBarraSuperior2MouseDragged

    private void panelBarraSuperior2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBarraSuperior2MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_panelBarraSuperior2MousePressed

    private void btnRegistrarseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarseMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarseMouseEntered

    private void btnRegistrarseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarseMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarseMouseExited

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
       dialogRegistrarse.setVisible(false);
       setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtPassConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassConfirmarMouseClicked
        if (String.valueOf(txtPassConfirmar.getPassword()).equals("********")){
            txtPassConfirmar.setText("");
            txtPassConfirmar.setForeground(Color.black);
        }
        
        if (String.valueOf(txtUsuarioRegistrar.getText()).isEmpty()){
            txtUsuarioRegistrar.setText("Introduce tu nombre de usuario");
            txtUsuarioRegistrar.setForeground(Color.gray);
        }
        
        if (String.valueOf(txtPassRegistrar.getPassword()).isEmpty()){
            txtPassRegistrar.setText("********");
            txtPassRegistrar.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtPassConfirmarMouseClicked

    private void labelRegistrateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRegistrateMouseClicked
        setVisible(false); //esto oculta la pantalla mientras se abre el jdialog
        dialogRegistrarse.setLocationRelativeTo(null); //con esto la pantalla saldrá centrada
        dialogRegistrarse.setVisible(true);
    }//GEN-LAST:event_labelRegistrateMouseClicked

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        
       /**
 * Método que se ejecuta al hacer clic en el botón de registrarse.
 * 
 * @param evt Evento de acción que desencadena este método.
 */ 
        
        String usuario = txtUsuarioRegistrar.getText();
        String contraseña = String.valueOf(txtPassRegistrar.getPassword());
        String confirmarContraseña = String.valueOf(txtPassConfirmar.getPassword());
    
        // Validaciones
        if (usuario.isEmpty() || contraseña.isEmpty() || confirmarContraseña.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        if (!contraseña.equals(confirmarContraseña)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        try {
            // Verificar si el nombre de usuario ya existe en la base de datos
            if (usuarioExistente(usuario)) {
                JOptionPane.showMessageDialog(this, "El nombre de usuario ya está en uso", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (SQLException ex) {
            // Se manejará la excepción en el método usuarioExistente
            return; // Salir del método si ocurre un error al verificar el usuario existente
        }
        
        // Encriptar la contraseña antes de almacenarla en la base de datos
        String contraseñaEncriptada = encriptarContraseña(contraseña);
        
        // Conexión a la base de datos y consulta SQL para insertar un nuevo usuario
        try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Desafio", "sa", "contraseña1234")) {
            String sql = "INSERT INTO usuarios (usuario, contraseña) VALUES (?, ?)";
            
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, usuario);
                statement.setString(2, contraseñaEncriptada);
                
                int filasInsertadas = statement.executeUpdate();
                
                if (filasInsertadas > 0) {
                    JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo registrar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
         /**
 * Método que se ejecuta al hacer clic en el botón de entrar.
 * 
 * @param evt Evento de acción que desencadena este método.
 */

         String usuario = txtfieldUsuario.getText();
         String contraseña = String.valueOf(txtfieldContraseña.getPassword());
                
    
        try {
            if (verificarCredenciales(usuario, contraseña)) {
                JOptionPane.showMessageDialog(this, "Inicio de sesión correcto", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                setUsuario(usuario); // Guardar el nombre de usuario
                setContraseña(contraseña); //Guardar la contraseña
                
        // Abrir la siguiente ventana después del inicio de sesión
                Pantalla pantalla = new Pantalla(); // 
                pantalla.setVisible(true); // 
                
                this.dispose(); // Cierra la ventana de inicio de sesión
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al verificar las credenciales", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void txtfieldContraseñaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfieldContraseñaFocusGained
        if (String.valueOf(txtfieldContraseña.getPassword()).equals("********")){
            txtfieldContraseña.setText("");
            txtfieldContraseña.setForeground(Color.black);
        }
        
        if (txtfieldUsuario.getText().isEmpty()){
            txtfieldUsuario.setText("Introduce tu nombre de usuario");
            txtfieldUsuario.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtfieldContraseñaFocusGained

    /////////////////////////
    /* MÉTODOS ADICIONALES */
    ////////////////////////
    
    
    
   /**
 * Método para verificar si ya existe un usuario con el nombre especificado.
 * 
 * @param usuario Nombre de usuario a verificar.
 * @return {@code true} si ya existe un usuario con el nombre especificado, {@code false} en caso contrario.
 * @throws SQLException Si ocurre un error al interactuar con la base de datos.
 */
    
    private boolean usuarioExistente(String usuario) throws SQLException {
    try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Desafio", "sa", "contraseña1234")) {
        String sql = "SELECT * FROM usuarios WHERE usuario = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                // Si se devuelve alguna fila, significa que el usuario ya existe
                return resultSet.next();
            }
        }
    } catch (SQLException ex) {
        // Manejar el error de conexión a la base de datos
        JOptionPane.showMessageDialog(this, "Error al verificar el usuario existente", "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
        throw ex; // Propagar la excepción para que quien llame a este método pueda manejarla adecuadamente si es necesario
    }
}
    
    
  /**
 * Método para encriptar contraseñas utilizando el algoritmo SHA-256.
 *
 * @param contraseña La contraseña a encriptar.
 * @return La representación hexadecimal del hash resultante.
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
 * Método para verificar las credenciales de inicio de sesión.
 *
 * @param usuario     El nombre de usuario.
 * @param contraseña  La contraseña.
 * @return true si las credenciales son válidas, false de lo contrario.
 * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
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
     *
     * @param usuario
     */
    public static void setUsuario(String usuario) {
        Login.usuario = usuario;
    }

    /**
     *
     * @return
     */
    public static String getUsuario() {
        return usuario;
    }
    
    /**
     *
     * @param contraseña
     */
    public static void setContraseña(String contraseña) {
        Login.contraseña = contraseña;
    }
    
    /**
     *
     * @return
     */
    public static String getContraseña() {
        return contraseña;
    }
    
    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVolver;
    private javax.swing.JDialog dialogRegistrarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelBannerLogin;
    private javax.swing.JLabel labelBannerLogin1;
    private javax.swing.JLabel labelBannerLogin2;
    private javax.swing.JLabel labelContraseña;
    private javax.swing.JLabel labelContraseñaCrear;
    private javax.swing.JLabel labelContraseñaCrearConfirmar;
    private javax.swing.JLabel labelCrearCuenta;
    private javax.swing.JLabel labelIniciarSesion;
    private javax.swing.JLabel labelRegistrate;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JLabel labelUsuarioCrear;
    private javax.swing.JPanel panelBarraSuperior;
    private javax.swing.JPanel panelBarraSuperior2;
    private javax.swing.JSeparator separatorContraseña;
    private javax.swing.JSeparator separatorContraseña1;
    private javax.swing.JSeparator separatorContraseña2;
    private javax.swing.JSeparator separatorUsuario;
    private javax.swing.JSeparator separatorUsuario1;
    private javax.swing.JPasswordField txtPassConfirmar;
    private javax.swing.JPasswordField txtPassRegistrar;
    private javax.swing.JTextField txtUsuarioRegistrar;
    private javax.swing.JPasswordField txtfieldContraseña;
    private javax.swing.JTextField txtfieldUsuario;
    // End of variables declaration//GEN-END:variables
}
