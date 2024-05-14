
package desafio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Clase que representa una ventana modal para mostrar la lista de películas favoritas por un usuario.
 */
public class ListaFavoritas extends javax.swing.JDialog {

    int xMouse, yMouse; //estas variables servirán para localizar la posición del ratón 
    

    /**
     * Constructor de la clase.
     *
     * @param parent El JFrame padre.
     * @param modal  Indica si la ventana es modal o no.
     */
    public ListaFavoritas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null); //con esto la pantalla saldrá centrada
        inicializarTabla();
        cargarTitulosFavoritas();
        
    }

    /**
     * Método para obtener el nombre de usuario actual.
     *
     * @return El nombre de usuario actual.
     */
    private String obtenerUsuarioActual() {
        String usuarioActual = Login.getUsuario(); // Llama al método para obtener el nombre de usuario actual desde tu clase de login
        if (usuarioActual != null && !usuarioActual.isEmpty()) {
            return usuarioActual;
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo obtener el nombre de usuario actual.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    
    /**
     * Método para obtener el ID del usuario actual basado en el nombre de usuario.
     *
     * @param usuario El nombre de usuario.
     * @return El ID del usuario.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    
    private int obtenerIdUsuario(String usuario) throws SQLException {
        String sql = "SELECT id_usuario FROM usuarios WHERE usuario = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Desafio", "sa", "contraseña1234");
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id_usuario");
                } else {
                    // Si no se encuentra ningún usuario con el nombre especificado, podrías lanzar una excepción o devolver un valor predeterminado
                    // En este caso, devolveré -1 como indicador de que no se encontró ningún usuario
                    return -1;
                }
            }
        }
    }
    
 
    /**
     * Método para inicializar la tabla.
     */
    private void inicializarTabla() {
        // Crear el modelo  y asignarlo a la tabla
        Object[][] data = {}; // Los datos se cargarán posteriormente
        ModeloCatalogo modelo = new ModeloCatalogo(data);
        tablaFavoritas.setModel(modelo);
    }
    
    /**
     * Método para cargar los datos en la tabla.
     *
     * @param datos Los datos a cargar.
     */
    public void cargarDatos(Object[][] datos) {
        ModeloCatalogo modelo = (ModeloCatalogo) tablaFavoritas.getModel();
        modelo.setData(datos);
        modelo.fireTableDataChanged();
    }
    
    /**
     * Método para cargar los títulos de las películas vistas desde la base de datos.
     */
    private void cargarTitulosFavoritas() {
    // Obtener el nombre de usuario actual
    String usuarioActual = obtenerUsuarioActual();
    if (usuarioActual == null) {
        // Si no se puede obtener el nombre de usuario actual, no se puede continuar
        return;
    }
    
    // Conectar a la base de datos
    try (Connection connection = Conexion.getConnection()) {
        // Obtener el ID del usuario actual
        int idUsuario = obtenerIdUsuario(usuarioActual);
        if (idUsuario == -1) {
            // Si no se puede obtener el ID del usuario actual, no se puede continuar
            return;
        }
        
        // Consulta SQL para obtener los títulos de las películas favoritas por el usuario actual
        String sql = "SELECT peliculas.titulo FROM listas " +
                     "JOIN peliculas ON listas.id_pelicula = peliculas.id_pelicula " +
                     "WHERE listas.id_usuario = ? AND listas.tipo_lista = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Establecer los parámetros de la consulta
            statement.setInt(1, idUsuario);
            statement.setString(2, "Favorita");
            
            try (ResultSet resultSet = statement.executeQuery()) {
                // Crear una lista para almacenar los títulos
                List<String> titulosFavoritas = new ArrayList<>();
                // Iterar sobre los resultados y añadir los títulos a la lista
                while (resultSet.next()) {
                    titulosFavoritas.add(resultSet.getString("titulo"));
                }
                
                // Ordenar los títulos alfabéticamente
                Collections.sort(titulosFavoritas);
                    
                // Convertir la lista de títulos a un arreglo bidimensional para el modelo de la tabla
                Object[][] data = new Object[titulosFavoritas.size()][1];
                for (int i = 0; i < titulosFavoritas.size(); i++) {
                    data[i][0] = titulosFavoritas.get(i);
                }
                
                // Obtener el modelo de la tabla y cargar los datos
                ModeloCatalogo modelo = (ModeloCatalogo) tablaFavoritas.getModel();
                modelo.setData(data);
                modelo.fireTableDataChanged();
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Manejar cualquier error de SQL
    }
}
  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFavoritas = new javax.swing.JTable();
        headerFavoritas = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(693, 519));
        setMinimumSize(new java.awt.Dimension(693, 519));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaFavoritas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaFavoritas.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        tablaFavoritas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaFavoritas.setOpaque(false);
        tablaFavoritas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaFavoritasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaFavoritas);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 420, 370));

        headerFavoritas.setBackground(new java.awt.Color(255, 255, 255));
        headerFavoritas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerFavoritasMouseDragged(evt);
            }
        });
        headerFavoritas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerFavoritasMousePressed(evt);
            }
        });
        headerFavoritas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        headerFavoritas.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 130, 50));

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        jLabel2.setText("Películas favoritas");
        headerFavoritas.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 300, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/favoritas_pequeño.png"))); // NOI18N
        headerFavoritas.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 30, 30));

        jPanel3.add(headerFavoritas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaFavoritasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaFavoritasMouseClicked
        // Obtener la fila y la columna de la celda clicada
    int row = tablaFavoritas.rowAtPoint(evt.getPoint());
    int col = tablaFavoritas.columnAtPoint(evt.getPoint());
    
    // Verificar si la celda clicada pertenece a la columna del título 
    if (col == 0) {
        // Obtener el título de la película de la fila seleccionada
        String tituloPelicula = (String) tablaFavoritas.getValueAt(row, col);
        
        // Mostrar ventana emergente con opciones
        int option = JOptionPane.showOptionDialog(
            this,
            "¿Qué acción desea realizar?",
            "Opciones",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[]{"Mostrar Detalles", "Eliminar de la lista"},
            null
        );
        
        // Procesar la opción seleccionada
        switch (option) {
            case JOptionPane.YES_OPTION:
                // Llamar al método para mostrar los detalles de la película en la ficha técnica
                mostrarDetallesPelicula(tituloPelicula);
                break;
            case JOptionPane.NO_OPTION:
                // Llamar al método para eliminar la película de la lista y actualizar la tabla
                eliminarPeliculaDeLista(tituloPelicula);
                break;
            default:
                // No se seleccionó ninguna opción o se cerró la ventana
                break;
        }
    }

    }//GEN-LAST:event_tablaFavoritasMouseClicked

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
                                               
    setVisible(false); // Oculta el diálogo ListaFavoritas
    getParent().setVisible(true); // Muestra el JFrame padre

    }//GEN-LAST:event_btnVolverActionPerformed

    private void headerFavoritasMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerFavoritasMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x- xMouse, y - yMouse);
    }//GEN-LAST:event_headerFavoritasMouseDragged

    private void headerFavoritasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerFavoritasMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerFavoritasMousePressed

    // Método para obtener los detalles de una película
private void mostrarDetallesPelicula(String titulo) {
    // Consulta SQL para obtener los detalles de la película
    String sql = "SELECT p.titulo, "
               + "p.año, "
               + "p.duracion, "
               + "p.nota, "
               + "STUFF((SELECT ', ' + g.nombre_genero "
               +        "FROM peliculas_generos pg "
               +        "JOIN generos g ON pg.id_genero = g.id_genero "
               +        "WHERE pg.id_pelicula = p.id_pelicula "
               +        "FOR XML PATH('')), 1, 2, '') AS generos, "
               + "STUFF((SELECT ', ' + d.nombre_director "
               +        "FROM peliculas_directores pd "
               +        "JOIN directores d ON pd.id_director = d.id_director "
               +        "WHERE pd.id_pelicula = p.id_pelicula "
               +        "FOR XML PATH('')), 1, 2, '') AS directores "
               + "FROM peliculas p "
               + "WHERE p.titulo = ?";
    
    try (Connection connection = Conexion.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, titulo);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                // Obtener los detalles de la película
                String tituloPelicula = resultSet.getString("titulo");
                int año = resultSet.getInt("año");
                int duracion = resultSet.getInt("duracion");
                double notaMedia = resultSet.getDouble("nota");
                String generos = resultSet.getString("generos");
                String directores = resultSet.getString("directores");
                
                // Creamos una instancia de ficha
                Ficha ficha = new Ficha(null, true);
                
                // Establecer la imagen del póster
                String rutaImagen = "/posters/" + titulo + ".jpg";
                ImageIcon imagen = new ImageIcon(getClass().getResource(rutaImagen));
                ficha.setPoster(imagen);
                
                
                // Llamar a los setters de Ficha para establecer los detalles de la película
                ficha.setTitulo(tituloPelicula);
                ficha.setAño(año);
                ficha.setGenero(generos);
                ficha.setDirector(directores);
                ficha.setDuracion(duracion);
                ficha.setNota(notaMedia);
                               
                
                // Mostrar el diálogo de Ficha
                ficha.setVisible(true);
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Manejar cualquier error de SQL
    }
}
 


// Método para eliminar películad de la lista
private void eliminarPeliculaDeLista(String titulo) {
    // Obtener el nombre de usuario actual
    String usuarioActual = obtenerUsuarioActual();
    if (usuarioActual == null) {
        // Si no se puede obtener el nombre de usuario actual, no se puede continuar
        return;
    }
    
    // Conectar a la base de datos
    try (Connection connection = Conexion.getConnection()) {
        // Obtener el ID del usuario actual
        int idUsuario = obtenerIdUsuario(usuarioActual);
        if (idUsuario == -1) {
            // Si no se puede obtener el ID del usuario actual, no se puede continuar
            return;
        }
        
        // Consulta SQL para eliminar la película de la lista de películas favoritas
        String sql = "DELETE FROM listas WHERE id_usuario = ? AND tipo_lista = ? AND id_pelicula = (SELECT id_pelicula FROM peliculas WHERE titulo = ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Establecer los parámetros de la consulta
            statement.setInt(1, idUsuario);
            statement.setString(2, "Favorita");
            statement.setString(3, titulo);
            
            // Ejecutar la consulta
            int rowsAffected = statement.executeUpdate();
            
            // Verificar si se eliminó la película correctamente
            if (rowsAffected > 0) {
                // Mostrar un mensaje de éxito
                JOptionPane.showMessageDialog(this, "La película \"" + titulo + "\" ha sido eliminada de la lista de películas favoritas.", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
                
                // Recargar los títulos de películas favoritas en la tabla
                cargarTitulosFavoritas();
            } else {
                // Mostrar un mensaje de error si la película no se pudo eliminar
                JOptionPane.showMessageDialog(this, "No se pudo eliminar la película \"" + titulo + "\" de la lista de películas favoritas.", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Manejar cualquier error de SQL
        JOptionPane.showMessageDialog(this, "Error al intentar eliminar la película \"" + titulo + "\" de la lista de películas favoritas.", "Error de SQL", JOptionPane.ERROR_MESSAGE);
    }
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
            java.util.logging.Logger.getLogger(ListaFavoritas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaFavoritas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaFavoritas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaFavoritas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListaFavoritas dialog = new ListaFavoritas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel headerFavoritas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaFavoritas;
    // End of variables declaration//GEN-END:variables
}
