
package desafio;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author juan
 */


/**
 * Clase que muestra el catálogo de películas y permite interactuar con ellas
 */
public class Catalogo extends javax.swing.JDialog {

   int xMouse, yMouse; //estas variables servirán para localizar la posición del ratón 
   private String usuarioActual;
   
    /* Constructor */

    /**
     *
     * @param parent
     * @param modal
     */

    public Catalogo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null); //con esto la pantalla saldrá centrada
        obtenerUsuarioActual();
        inicializarTabla();
        cargarTitulos();
        if ("admin".equals(usuarioActual)) {
                lblAñadir.setVisible(true);
                btnAñadir.setVisible(true); // Mostrar el botón del admin
        }else{
            lblAñadir.setVisible(false);
            btnAñadir.setVisible(false);
            
        }
    }

    private void inicializarTabla() {
        // Crear el modelo del catálogo y asignarlo a la tabla
        Object[][] data = {}; // Los datos se cargarán posteriormente
        ModeloCatalogo modelo = new ModeloCatalogo(data);
        tablaCatalogo.setModel(modelo);
    }
    
    // Este método se llama desde otro lugar para cargar los datos en la tabla

    /**
     *
     * @param datos
     */
    public void cargarDatos(Object[][] datos) {
        ModeloCatalogo modelo = (ModeloCatalogo) tablaCatalogo.getModel();
        modelo.setData(datos);
        modelo.fireTableDataChanged();
    }
    
    // Método para cargar los títulos desde la base de datos
    private void cargarTitulos() {
        // Conectar a la base de datos
        try (Connection connection = Conexion.getConnection()) {
            // Consulta SQL para obtener los títulos de las películas
            String sql = "SELECT titulo FROM peliculas";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                // Crear una lista para almacenar los títulos
                java.util.List<String> titulos = new java.util.ArrayList<>();
                // Iterar sobre los resultados y añadir los títulos a la lista
                while (resultSet.next()) {
                    titulos.add(resultSet.getString("titulo"));
                }
                
                // Ordenar los títulos alfabéticamente
                Collections.sort(titulos);
                    
                // Convertir la lista de títulos a un arreglo bidimensional para el modelo de la tabla
                Object[][] data = new Object[titulos.size()][1];
                for (int i = 0; i < titulos.size(); i++) {
                    data[i][0] = titulos.get(i);
                }
                // Obtener el modelo de la tabla y cargar los datos
                ModeloCatalogo modelo = (ModeloCatalogo) tablaCatalogo.getModel();
                modelo.setData(data);
                modelo.fireTableDataChanged();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejar cualquier error de SQL
        }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCatalogo = new javax.swing.JTable();
        panelHeaderCatalogo = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        lblAñadir = new javax.swing.JLabel();
        btnAñadir = new javax.swing.JButton();
        labelFondoCine = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        radioTitulo = new javax.swing.JRadioButton();
        radioDirector = new javax.swing.JRadioButton();
        radioAño = new javax.swing.JRadioButton();
        radioGenero = new javax.swing.JRadioButton();
        radioDuracion = new javax.swing.JRadioButton();
        radioPuntuacion = new javax.swing.JRadioButton();
        txtPuntuacionMax = new javax.swing.JTextField();
        txtPuntuacionMin = new javax.swing.JTextField();
        txtDuracionMin = new javax.swing.JTextField();
        txtDuracionMax = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        campoBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaCatalogo.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        tablaCatalogo.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaCatalogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCatalogoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCatalogo);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 660, 400));

        panelHeaderCatalogo.setOpaque(false);
        panelHeaderCatalogo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelHeaderCatalogoMouseDragged(evt);
            }
        });
        panelHeaderCatalogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelHeaderCatalogoMousePressed(evt);
            }
        });
        panelHeaderCatalogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(242, 242, 242));
        jButton1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jButton1.setText("← Volver");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelHeaderCatalogo.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 140, 40));

        lblAñadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/plus.png"))); // NOI18N
        panelHeaderCatalogo.add(lblAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 30, 30));

        btnAñadir.setBackground(new java.awt.Color(242, 242, 242));
        btnAñadir.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        btnAñadir.setText("Añadir");
        btnAñadir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAñadir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAñadir.setFocusable(false);
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });
        panelHeaderCatalogo.add(btnAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 120, 30));

        jPanel1.add(panelHeaderCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 520));

        labelFondoCine.setBackground(new java.awt.Color(153, 255, 255));
        labelFondoCine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Sala de cine.jpg"))); // NOI18N
        jPanel1.add(labelFondoCine, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 620));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 0, 20, 620));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Courier New", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BUSCAR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 60, 140, 30));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 90, 150, -1));

        radioTitulo.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(radioTitulo);
        radioTitulo.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        radioTitulo.setForeground(new java.awt.Color(255, 255, 255));
        radioTitulo.setText("Por título");
        radioTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTituloActionPerformed(evt);
            }
        });
        jPanel1.add(radioTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 120, -1, -1));

        radioDirector.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(radioDirector);
        radioDirector.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        radioDirector.setForeground(new java.awt.Color(255, 255, 255));
        radioDirector.setText("Por director");
        radioDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDirectorActionPerformed(evt);
            }
        });
        jPanel1.add(radioDirector, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 150, -1, -1));

        radioAño.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(radioAño);
        radioAño.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        radioAño.setForeground(new java.awt.Color(255, 255, 255));
        radioAño.setText("Por año");
        radioAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAñoActionPerformed(evt);
            }
        });
        jPanel1.add(radioAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 180, -1, -1));

        radioGenero.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(radioGenero);
        radioGenero.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        radioGenero.setForeground(new java.awt.Color(255, 255, 255));
        radioGenero.setText("Por género");
        jPanel1.add(radioGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 210, -1, -1));

        radioDuracion.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(radioDuracion);
        radioDuracion.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        radioDuracion.setForeground(new java.awt.Color(255, 255, 255));
        radioDuracion.setText("Por duración");
        radioDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDuracionActionPerformed(evt);
            }
        });
        jPanel1.add(radioDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 240, -1, -1));

        radioPuntuacion.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(radioPuntuacion);
        radioPuntuacion.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        radioPuntuacion.setForeground(new java.awt.Color(255, 255, 255));
        radioPuntuacion.setText("Por puntuación");
        radioPuntuacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPuntuacionActionPerformed(evt);
            }
        });
        jPanel1.add(radioPuntuacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 330, -1, -1));
        jPanel1.add(txtPuntuacionMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 390, 40, 20));
        jPanel1.add(txtPuntuacionMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 360, 40, 20));
        jPanel1.add(txtDuracionMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 270, 40, 20));
        jPanel1.add(txtDuracionMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 300, 40, 20));

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Máx.");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 390, -1, -1));

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Min.");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 360, -1, -1));

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Min.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 270, -1, -1));

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Máx.");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 300, -1, -1));
        jPanel1.add(campoBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 440, 170, 30));

        btnBuscar.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 480, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                                           
    setVisible(false); // Oculta el diálogo actual (Catalogo)
    getParent().setVisible(true); // Muestra el JFrame padre


    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaCatalogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCatalogoMouseClicked
                                                  
     // Obtenemos la fila y la columna de la celda clicada (queremos que solo se active el evento al clicar en el título)
        int row = tablaCatalogo.rowAtPoint(evt.getPoint());
        int col = tablaCatalogo.columnAtPoint(evt.getPoint());

        // Verificamos si la celda clicada pertenece a la columna del título 
        if (col == 0) {
            // Obtener el título de la película de la fila seleccionada
            String tituloPelicula = (String) tablaCatalogo.getValueAt(row, col);

            // Verificamos si el usuario logueado es administrador
            if (esAdministrador(usuarioActual)) {
                // Mostrar opciones adicionales para el administrador
                String[] opciones = {"Mostrar detalles", "Modificar película", "Eliminar película"};
                int opcionSeleccionada = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Opciones de Administrador", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

                // Este switch maneja las opciones al hacer click en la tabla y depende de si eres admin o no
                switch (opcionSeleccionada) {
                    case 0: //función para todos los usuarios
                        mostrarDetallesPelicula(tituloPelicula);
                        break;
                    case 1: // Modificar película (exclusivo de admin)
                        modificarPelicula(tituloPelicula);
                        break;
                    case 2: // Eliminar película (exclusivo de admin)
                        eliminarPelicula(tituloPelicula);
                        cargarTitulos();
                        break;
                    default:
                        // No se seleccionó ninguna opción válida
                        break;
                }
            } else {
                // Si el usuario no es administrador, simplemente mostrar detalles de la película
                mostrarDetallesPelicula(tituloPelicula);
            }
        }
    
    



    }//GEN-LAST:event_tablaCatalogoMouseClicked

    private void panelHeaderCatalogoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHeaderCatalogoMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_panelHeaderCatalogoMousePressed

    private void panelHeaderCatalogoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHeaderCatalogoMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x- xMouse, y - yMouse);
    }//GEN-LAST:event_panelHeaderCatalogoMouseDragged

    private void radioPuntuacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPuntuacionActionPerformed
        // Deshabilitar el campo de búsqueda
            campoBusqueda.setEnabled(false); //deshabilitamos campoBusqueda para que el usuario sepa que no lo necesita en este caso
    }//GEN-LAST:event_radioPuntuacionActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        /**
 * Acción realizada al hacer clic en el botón de búsqueda.
 * 
 * Se obtiene el texto ingresado en el campo de búsqueda y se convierte a minúsculas.
 * Luego, se determina qué radio button está seleccionado y se realiza la búsqueda 
 * correspondiente según el criterio seleccionado.
 * 
 * @param evt Evento de acción generado al hacer clic en el botón de búsqueda.
 */

    // Obtener el texto ingresado en el campo de búsqueda
    String textoBusqueda = campoBusqueda.getText().trim().toLowerCase(); // Convertir a minúsculas
    
    // Determinar qué radio button está seleccionado
    if (radioTitulo.isSelected()) {
        buscarPorTitulo(textoBusqueda);
    } else if (radioDirector.isSelected()) {
        buscarPorDirector(textoBusqueda);
    } else if (radioAño.isSelected()) {
        buscarPorAño(textoBusqueda);
    //} else if (radioGenero.isSelected()) {
        //buscarPorGenero(textoBusqueda);
    } else if (radioDuracion.isSelected()) {
        // Obtener el texto de los campos de duración
        String textoDuracionMin = txtDuracionMin.getText().trim();
        String textoDuracionMax = txtDuracionMax.getText().trim();

        // Verificar si ambos campos están vacíos
        if (textoDuracionMin.isEmpty() && textoDuracionMax.isEmpty()) {
            // Si ambos campos están vacíos, mostrar un mensaje de error
            JOptionPane.showMessageDialog(this, "Por favor, introduzca al menos un valor numérico para la duración.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método para evitar más procesamiento
        }

        // Variables para almacenar las duraciones
        int duracionMin = 0;
        int duracionMax = 0;

        // Convertir el texto de los campos de duración en enteros (si no están vacíos)
        if (!textoDuracionMin.isEmpty()) {
            try {
                duracionMin = Integer.parseInt(textoDuracionMin);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, introduzca un valor numérico válido para la duración mínima.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir del método si hay un error de conversión
            }
        }

        if (!textoDuracionMax.isEmpty()) {
            try {
                duracionMax = Integer.parseInt(textoDuracionMax);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, introduzca un valor numérico válido para la duración máxima.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir del método si hay un error de conversión
            }
        }

        // Llamar al método de búsqueda por duración
        buscarPorDuracion(duracionMin, duracionMax);   
    } else if (radioPuntuacion.isSelected()) {
        // Obtener el texto de los campos de puntuación
        String textoPuntuacionMin = txtPuntuacionMin.getText().trim();
        String textoPuntuacionMax = txtPuntuacionMax.getText().trim();

        // Verificar si ambos campos están vacíos
        if (textoPuntuacionMin.isEmpty() && textoPuntuacionMax.isEmpty()) {
            // Si ambos campos están vacíos, mostrar un mensaje de error
            JOptionPane.showMessageDialog(this, "Por favor, introduzca al menos un valor numérico para la puntuación.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método para evitar más procesamiento
        }

        // Variables para almacenar las puntuaciones
        float puntuacionMin = 0.0f;
        float puntuacionMax = 0.0f;

        // Convertir el texto de los campos de puntuación en flotantes (si no están vacíos)
        if (!textoPuntuacionMin.isEmpty()) {
            try {
                puntuacionMin = Float.parseFloat(textoPuntuacionMin);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, introduzca un valor numérico válido para la puntuación mínima.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir del método si hay un error de conversión
            }
        }

        if (!textoPuntuacionMax.isEmpty()) {
            try {
                puntuacionMax = Float.parseFloat(textoPuntuacionMax);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, introduzca un valor numérico válido para la puntuación máxima.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir del método si hay un error de conversión
            }
        }

        // Llamar al método de búsqueda por puntuación
        buscarPorPuntuacion(puntuacionMin, puntuacionMax);
    } else {
        // Si no se ha seleccionado ningún radio button, mostrar un mensaje de error
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un criterio de búsqueda.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void radioDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDuracionActionPerformed
        // Deshabilitar el campo de búsqueda
            campoBusqueda.setEnabled(false); //deshabilitamos campoBusqueda para que el usuario sepa que no lo necesita en este caso
    }//GEN-LAST:event_radioDuracionActionPerformed

    private void radioTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTituloActionPerformed
        // Deshabilitar el campo de búsqueda
            campoBusqueda.setEnabled(true); //necesitamos activarlo por si se ha deshabilitado con el radio duracion o puntuacion
    }//GEN-LAST:event_radioTituloActionPerformed

    private void radioDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDirectorActionPerformed
        // Deshabilitar el campo de búsqueda
            campoBusqueda.setEnabled(true); //necesitamos activarlo por si se ha deshabilitado con el radio duracion o puntuacion
    }//GEN-LAST:event_radioDirectorActionPerformed

    private void radioAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAñoActionPerformed
        // Deshabilitar el campo de búsqueda
            campoBusqueda.setEnabled(true); //necesitamos activarlo por si se ha deshabilitado con el radio duracion o puntuacion
    }//GEN-LAST:event_radioAñoActionPerformed

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        
        /**
 * Acción realizada al hacer clic en el botón de añadir película.
 * 
 * Se solicitan los datos de la película al usuario utilizando ventanas emergentes.
 * Si el usuario cancela alguna operación o no ingresa ciertos datos requeridos,
 * se muestra un mensaje de error correspondiente.
 * Finalmente, se inserta la película en la base de datos y se muestra un mensaje
 * de éxito o error según el resultado de la operación.
 * 
 * @param evt Evento de acción generado al hacer clic en el botón de añadir película.
 */




        // Solicitar los datos de la película al usuario utilizando ventanas emergentes
    String titulo = JOptionPane.showInputDialog(this, "1. Ingrese el título de la película:", "Agregar Película", JOptionPane.QUESTION_MESSAGE);
    if (titulo == null || titulo.isEmpty()) {
        // El usuario canceló la operación o no ingresó ningún título
        return;
    }

    String director = JOptionPane.showInputDialog(this, "2. Ingrese el director de la película:", "Agregar Película", JOptionPane.QUESTION_MESSAGE);
    if (director == null) {
        // El usuario canceló la operación
        return;
    }

    String añoStr = JOptionPane.showInputDialog(this, "3. Ingrese el año de la película:", "Agregar Película", JOptionPane.QUESTION_MESSAGE);
    if (añoStr == null || !esNumero(añoStr)) {
        JOptionPane.showMessageDialog(this, "El año debe ser un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    int año = Integer.parseInt(añoStr);

    String genero = JOptionPane.showInputDialog(this, "4. Ingrese el género de la película:", "Agregar Película", JOptionPane.QUESTION_MESSAGE);
    if (genero == null) {
        // El usuario canceló la operación
        return;
    }

    String duracionStr = JOptionPane.showInputDialog(this, "5. Ingrese la duración de la película (en minutos):", "Agregar Película", JOptionPane.QUESTION_MESSAGE);
    if (duracionStr == null || !esNumero(duracionStr)) {
        JOptionPane.showMessageDialog(this, "La duración debe ser un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    int duracion = Integer.parseInt(duracionStr);

    String notaStr = JOptionPane.showInputDialog(this, "6. Ingrese la nota de la película:", "Agregar Película", JOptionPane.QUESTION_MESSAGE);
    if (notaStr == null || !esNumeroDecimal(notaStr)) {
        JOptionPane.showMessageDialog(this, "La nota debe ser un número decimal válido.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    double nota = Double.parseDouble(notaStr);

    // Insertar la película en la base de datos
    int idPelicula = insertarPelicula(titulo, año, duracion, nota, director, genero);
    if (idPelicula != -1) {
        JOptionPane.showMessageDialog(this, "Película agregada correctamente con ID: " + idPelicula, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "Error al agregar la película.", "Error", JOptionPane.ERROR_MESSAGE);
  }
    
    }//GEN-LAST:event_btnAñadirActionPerformed

    /**
 * Muestra los detalles de una película seleccionada.
 * 
 * Este método realiza una consulta SQL para obtener los detalles de la película
 * cuyo título se proporciona como parámetro. Luego, crea una instancia de la
 * ventana Ficha y establece los detalles obtenidos (título, año, género, director,
 * duración y nota media). Finalmente, muestra la ventana Ficha con los detalles de la película.
 * 
 * @param titulo El título de la película de la cual se desean mostrar los detalles.
 */
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





    /**
 * Busca películas por título y actualiza la tabla del catálogo con los resultados.
 * 
 * @param textoBusqueda El texto utilizado para buscar películas por título.
 */
    private void buscarPorTitulo(String textoBusqueda) {
        
        
        // Conectar a la base de datos y buscar por título
        try (Connection connection = Conexion.getConnection()) {
            // Consulta SQL para buscar por título
            String sql = "SELECT titulo FROM peliculas WHERE LOWER(titulo) LIKE ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // Establecer el parámetro de la consulta
                statement.setString(1, "%" + textoBusqueda + "%");
                
                // Ejecutar la consulta
                try (ResultSet resultSet = statement.executeQuery()) {
                    // Crear una lista para almacenar los títulos encontrados
                    List<String> titulos = new ArrayList<>();
                    // Iterar sobre los resultados y añadir los títulos a la lista
                    while (resultSet.next()) {
                        titulos.add(resultSet.getString("titulo"));
                    }
                    
                    // Convertir la lista de títulos a un arreglo bidimensional para el modelo de la tabla
                    Object[][] data = new Object[titulos.size()][1];
                    for (int i = 0; i < titulos.size(); i++) {
                        data[i][0] = titulos.get(i);
                    }
                    // Obtener el modelo de la tabla y cargar los datos
                    ModeloCatalogo modelo = (ModeloCatalogo) tablaCatalogo.getModel();
                    modelo.setData(data);
                    modelo.fireTableDataChanged();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejar cualquier error de SQL
            JOptionPane.showMessageDialog(this, "Error al buscar por título.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    /**
 * Busca películas por director y actualiza la tabla del catálogo con los resultados.
 * 
 * @param textoBusqueda El texto utilizado para buscar películas por el nombre del director.
 */
    
    private void buscarPorDirector(String textoBusqueda) {
    // Conectar a la base de datos
    try (Connection connection = Conexion.getConnection()) {
        // Consulta SQL para obtener los títulos de las películas dirigidas por el director buscado
        String sql = "SELECT p.titulo FROM peliculas p " +
                     "JOIN peliculas_directores pd ON p.id_pelicula = pd.id_pelicula " +
                     "JOIN directores d ON pd.id_director = d.id_director " +
                     "WHERE LOWER(d.nombre_director) LIKE ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Establecer el parámetro de búsqueda con comodines para permitir la coincidencia parcial
            statement.setString(1, "%" + textoBusqueda + "%");
            
            try (ResultSet resultSet = statement.executeQuery()) {
                // Crear una lista para almacenar los títulos de películas encontradas
                List<String> titulos = new ArrayList<>();
                
                // Iterar sobre los resultados y añadir los títulos a la lista
                while (resultSet.next()) {
                    titulos.add(resultSet.getString("titulo"));
                }
                
                // Convertir la lista de títulos a un arreglo bidimensional para el modelo de la tabla
                Object[][] data = new Object[titulos.size()][1];
                for (int i = 0; i < titulos.size(); i++) {
                    data[i][0] = titulos.get(i);
                }
                
                // Obtener el modelo de la tabla y cargar los datos
                ModeloCatalogo modelo = (ModeloCatalogo) tablaCatalogo.getModel();
                modelo.setData(data);
                modelo.fireTableDataChanged();
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Manejar cualquier error de SQL
    }
}


/**
 * Busca películas por año y actualiza la tabla del catálogo con los resultados.
 * 
 * @param textoBusqueda El texto que representa el año de lanzamiento de las películas a buscar.
 */
private void buscarPorAño(String textoBusqueda) {
    // Conectar a la base de datos
    try (Connection connection = Conexion.getConnection()) {
        // Consulta SQL para obtener los títulos de las películas lanzadas en el año buscado
        String sql = "SELECT titulo FROM peliculas WHERE año = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Convertir el texto de búsqueda a un entero (año)
            int año = Integer.parseInt(textoBusqueda);
            
            // Establecer el parámetro de búsqueda
            statement.setInt(1, año);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                // Crear una lista para almacenar los títulos de películas encontradas
                List<String> titulos = new ArrayList<>();
                
                // Iterar sobre los resultados y añadir los títulos a la lista
                while (resultSet.next()) {
                    titulos.add(resultSet.getString("titulo"));
                }
                
                // Convertir la lista de títulos a un arreglo bidimensional para el modelo de la tabla
                Object[][] data = new Object[titulos.size()][1];
                for (int i = 0; i < titulos.size(); i++) {
                    data[i][0] = titulos.get(i);
                }
                
                // Obtener el modelo de la tabla y cargar los datos
                ModeloCatalogo modelo = (ModeloCatalogo) tablaCatalogo.getModel();
                modelo.setData(data);
                modelo.fireTableDataChanged();
            }
        }
    } catch (NumberFormatException ex) {
        // Manejar el error si el texto de búsqueda no es un número válido
        JOptionPane.showMessageDialog(this, "Por favor, introduzca un año válido.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Manejar cualquier error de SQL
    }
}


    
        /**
 * Busca películas por duración y actualiza la tabla del catálogo con los resultados.
 * 
 * @param duracionMin La duración mínima de las películas a buscar.
 * @param duracionMax La duración máxima de las películas a buscar.
 */
    private void buscarPorDuracion(int duracionMin, int duracionMax) {
        // Conectar a la base de datos
        try (Connection connection = Conexion.getConnection()) {
            // Consulta SQL base
            String sql = "SELECT titulo FROM peliculas WHERE 1 = 1";
            // Lista para almacenar los parámetros para la consulta preparada
            List<Object> parametros = new ArrayList<>();

            // Construir la consulta y añadir parámetros según los valores proporcionados
            if (duracionMin > 0) {
                sql += " AND duracion >= ?";
                parametros.add(duracionMin);
            }
            if (duracionMax > 0) {
                sql += " AND duracion <= ?";
                parametros.add(duracionMax);
            }

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // Establecer los parámetros de la consulta preparada
                for (int i = 0; i < parametros.size(); i++) {
                    statement.setObject(i + 1, parametros.get(i));
                }

                try (ResultSet resultSet = statement.executeQuery()) {
                    // Crear una lista para almacenar los títulos de películas encontradas
                    List<String> titulos = new ArrayList<>();

                    // Iterar sobre los resultados y añadir los títulos a la lista
                    while (resultSet.next()) {
                        titulos.add(resultSet.getString("titulo"));
                    }

                    // Convertir la lista de títulos a un arreglo bidimensional para el modelo de la tabla
                    Object[][] data = new Object[titulos.size()][1];
                    for (int i = 0; i < titulos.size(); i++) {
                        data[i][0] = titulos.get(i);
                    }

                    // Obtener el modelo de la tabla y cargar los datos
                    ModeloCatalogo modelo = (ModeloCatalogo) tablaCatalogo.getModel();
                    modelo.setData(data);
                    modelo.fireTableDataChanged();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejar cualquier error de SQL
        }
    }

    /**
 * Busca películas por puntuación y actualiza la tabla del catálogo con los resultados.
 * 
 * @param puntuacionMin La puntuación mínima de las películas a buscar.
 * @param puntuacionMax La puntuación máxima de las películas a buscar.
 */
private void buscarPorPuntuacion(float puntuacionMin, float puntuacionMax) {
    // Conectar a la base de datos
    try (Connection connection = Conexion.getConnection()) {
        // Consulta SQL base
        String sql = "SELECT titulo FROM peliculas WHERE 1 = 1";
        // Lista para almacenar los parámetros para la consulta preparada
        List<Object> parametros = new ArrayList<>();

        // Construir la consulta y añadir parámetros según los valores proporcionados
        if (puntuacionMin > 0) {
            sql += " AND nota >= ?";
            parametros.add(puntuacionMin);
        }
        if (puntuacionMax > 0) {
            sql += " AND nota <= ?";
            parametros.add(puntuacionMax);
        }

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Establecer los parámetros de la consulta preparada
            for (int i = 0; i < parametros.size(); i++) {
                statement.setObject(i + 1, parametros.get(i));
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                // Crear una lista para almacenar los títulos de películas encontradas
                List<String> titulos = new ArrayList<>();

                // Iterar sobre los resultados y añadir los títulos a la lista
                while (resultSet.next()) {
                    titulos.add(resultSet.getString("titulo"));
                }

                // Convertir la lista de títulos a un arreglo bidimensional para el modelo de la tabla
                Object[][] data = new Object[titulos.size()][1];
                for (int i = 0; i < titulos.size(); i++) {
                    data[i][0] = titulos.get(i);
                }

                // Obtener el modelo de la tabla y cargar los datos
                ModeloCatalogo modelo = (ModeloCatalogo) tablaCatalogo.getModel();
                modelo.setData(data);
                modelo.fireTableDataChanged();
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Manejar cualquier error de SQL
    }
}

/**
 * Obtiene el ID de una película basado en su título.
 * 
 * @param titulo El título de la película.
 * @return El ID de la película, o -1 si no se encuentra ninguna película con el título dado.
 */
private int obtenerIdPeliculaPorTitulo(String titulo) {
    int idPelicula = -1;
    
    String sql = "SELECT id_pelicula FROM peliculas WHERE titulo = ?";
    
    try (Connection connection = Conexion.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {
        
        statement.setString(1, titulo);
        
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                idPelicula = resultSet.getInt("id_pelicula");
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Manejar cualquier error de SQL
    }
    
    return idPelicula;
}




/* MÉTODOS PARA COMPROBAR EL USUARIO */

/**
 * Obtiene el nombre de usuario actual.
 * 
 * @return El nombre de usuario actual, o null si no se puede obtener.
 */
    private void obtenerUsuarioActual() {
        usuarioActual = Login.getUsuario(); // Asignar el valor de usuario actual a la variable de instancia
        if (usuarioActual == null || usuarioActual.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se pudo obtener el nombre de usuario actual.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


/**
 * Verifica si un usuario es administrador.
 * 
 * @param usuarioActual El nombre de usuario actual.
 * @return true si el usuario actual es "admin", false en caso contrario.
 */
    public static boolean esAdministrador(String usuarioActual) {
    // Si el usuario actual es "admin", considerarlo como administrador
    if (usuarioActual.equals("admin")) {
        return true;
    }
    // Si el usuario no es "admin", devolver false
    return false;
}

    /* MÉTODOS EXCLUSIVOS PARA EL ADMINISTRADOR */
    
    
    /**
 * Elimina una película de la base de datos.
 * 
 * @param titulo El título de la película a eliminar.
 * @return true si la película se eliminó correctamente, false si ocurrió un error o la película no se encontró.
 */
    private boolean eliminarPelicula(String titulo) {
    int idPelicula = obtenerIdPeliculaPorTitulo(titulo);
    
    try (Connection connection = Conexion.getConnection()) {
        // Eliminar los registros relacionados en la tabla 'peliculas_directores'
        String sqlDeleteDirectores = "DELETE FROM peliculas_directores WHERE id_pelicula = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlDeleteDirectores)) {
            statement.setInt(1, idPelicula);
            statement.executeUpdate();
        }

        // Eliminar los registros relacionados en la tabla 'peliculas_generos'
        String sqlDeleteGeneros = "DELETE FROM peliculas_generos WHERE id_pelicula = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlDeleteGeneros)) {
            statement.setInt(1, idPelicula);
            statement.executeUpdate();
        }

        // Eliminar la película de la tabla 'peliculas'
        String sqlDeletePelicula = "DELETE FROM peliculas WHERE id_pelicula = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlDeletePelicula)) {
            statement.setInt(1, idPelicula);
            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false;
}

    /**
 * Inserta una nueva película en la base de datos.
 * 
 * @param titulo El título de la película.
 * @param año El año de lanzamiento de la película.
 * @param duracion La duración de la película en minutos.
 * @param nota La nota media de la película.
 * @param director El nombre del director de la película.
 * @param genero El género de la película.
 * @return El ID de la película insertada, o -1 si ocurrió un error.
 */
private int insertarPelicula(String titulo, int año, int duracion, double nota, String director, String genero) {
    int idPelicula = -1;
    
    try {
        // Obtener o insertar el ID del director
        int idDirector = obtenerIdDirector(director);
        if (idDirector == -1) {
            // Si el director no existe, insertarlo en la base de datos y obtener su ID
            idDirector = insertarDirector(director);
        }
        
        // Obtener el ID del género
        int idGenero = obtenerIdGenero(genero);
        if (idGenero == -1) {
            // Si el género no existe en la base de datos, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "El género especificado no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        
        // Insertar la película en la tabla peliculas
        String sqlInsertPelicula = "INSERT INTO peliculas (titulo, año, duracion, nota) VALUES (?, ?, ?, ?)";
        try (Connection connection = Conexion.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlInsertPelicula, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, titulo);
            statement.setInt(2, año);
            statement.setInt(3, duracion);
            statement.setDouble(4, nota);

            int filasAfectadas = statement.executeUpdate();
            
            // Verificar si se insertó la película correctamente
            if (filasAfectadas > 0) {
                // Obtener el ID de la película generada
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        idPelicula = generatedKeys.getInt(1);
                        
                        // Insertar el director de la película en la tabla peliculas_directores
                        String sqlInsertDirector = "INSERT INTO peliculas_directores (id_pelicula, id_director) VALUES (?, ?)";
                        try (PreparedStatement directorStatement = connection.prepareStatement(sqlInsertDirector)) {
                            directorStatement.setInt(1, idPelicula);
                            directorStatement.setInt(2, idDirector);
                            directorStatement.executeUpdate();
                        }
                        
                        // Insertar el género de la película en la tabla peliculas_generos
                        String sqlInsertGenero = "INSERT INTO peliculas_generos (id_pelicula, id_genero) VALUES (?, ?)";
                        try (PreparedStatement generoStatement = connection.prepareStatement(sqlInsertGenero)) {
                            generoStatement.setInt(1, idPelicula);
                            generoStatement.setInt(2, idGenero);
                            generoStatement.executeUpdate();
                        }
                    }
                }
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Manejar cualquier error de SQL
    }
    
    return idPelicula;
}


   
    /**
 * Verifica si una cadena representa un número entero.
 * 
 * @param texto La cadena a verificar.
 * @return true si la cadena representa un número entero, false de lo contrario.
 */
private boolean esNumero(String texto) {
    try {
        Integer.parseInt(texto);
        return true;
    } catch (NumberFormatException ex) {
        return false;
    }
}

/**
 * Verifica si una cadena representa un número decimal.
 * 
 * @param texto La cadena a verificar.
 * @return true si la cadena representa un número decimal, false de lo contrario.
 */
private boolean esNumeroDecimal(String texto) {
    try {
        Double.parseDouble(texto);
        return true;
    } catch (NumberFormatException ex) {
        return false;
    }
}

/**
 * Obtiene el ID del director a partir de su nombre.
 * 
 * @param director El nombre del director.
 * @return El ID del director, o -1 si no se encuentra.
 */
private int obtenerIdDirector(String director) {
    int idDirector = -1; // Valor predeterminado en caso de que el director no exista
    
    try (Connection connection = Conexion.getConnection();
         PreparedStatement statement = connection.prepareStatement("SELECT id_director FROM directores WHERE nombre_director = ?")) {
        statement.setString(1, director);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                idDirector = resultSet.getInt("id_director");
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    
    return idDirector;
}

/**
 * Inserta un nuevo director en la base de datos y obtiene su ID.
 * 
 * @param director El nombre del director a insertar.
 * @return El ID del director insertado, o -1 si ocurrió un error.
 */
private int insertarDirector(String director) {
    int idDirector = -1; // Valor predeterminado en caso de error
    
    try (Connection connection = Conexion.getConnection();
         PreparedStatement statement = connection.prepareStatement("INSERT INTO directores (nombre_director) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
        statement.setString(1, director);
        int affectedRows = statement.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Fallo al insertar el director, no se agregaron filas.");
        }
        
        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                idDirector = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Fallo al insertar el director, no se obtuvo el ID generado.");
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    
    return idDirector;
}

/**
 * Obtiene el ID del género a partir de su nombre.
 * 
 * @param genero El nombre del género.
 * @return El ID del género, o -1 si no se encuentra.
 */
private int obtenerIdGenero(String genero) {
    int idGenero = -1; // Valor predeterminado en caso de que el género no exista
    
    try (Connection connection = Conexion.getConnection();
         PreparedStatement statement = connection.prepareStatement("SELECT id_genero FROM generos WHERE nombre_genero = ?")) {
        statement.setString(1, genero);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                idGenero = resultSet.getInt("id_genero");
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    
    return idGenero;
}

/**
 * Inserta un nuevo género en la base de datos y obtiene su ID.
 * 
 * @param genero El nombre del género a insertar.
 * @return El ID del género insertado, o -1 si ocurrió un error.
 */
private int insertarGenero(String genero) {
    int idGenero = -1; // Valor predeterminado en caso de error
    
    try (Connection connection = Conexion.getConnection();
         PreparedStatement statement = connection.prepareStatement("INSERT INTO generos (nombre_genero) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
        statement.setString(1, genero);
        int affectedRows = statement.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Fallo al insertar el género, no se agregaron filas.");
        }
        
        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                idGenero = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Fallo al insertar el género, no se obtuvo el ID generado.");
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    
    return idGenero;
}

/**
 * Muestra un diálogo para modificar los detalles de una película.
 * 
 * @param tituloPelicula El título de la película a modificar.
 */
    private void modificarPelicula(String tituloPelicula) {
        JTextField txtTitulo = new JTextField();
        JTextField txtAño = new JTextField();
        JTextField txtDuracion = new JTextField();
        JTextField txtNota = new JTextField();
        JTextField txtDirector = new JTextField();
        JTextField txtGenero = new JTextField();

        Object[] message = {
                "Título:", txtTitulo,
                "Año:", txtAño,
                "Duración (minutos):", txtDuracion,
                "Nota:", txtNota,
                "Director:", txtDirector,
                "Género:", txtGenero
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Modificar Película", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String nuevoTitulo = txtTitulo.getText();
            int nuevoAño = Integer.parseInt(txtAño.getText());
            int nuevaDuracion = Integer.parseInt(txtDuracion.getText());
            double nuevaNota = Double.parseDouble(txtNota.getText());
            String nuevoDirector = txtDirector.getText();
            String nuevoGenero = txtGenero.getText();

            boolean exito = modificarPeliculaEnBD(tituloPelicula, nuevoTitulo, nuevoAño, nuevaDuracion, nuevaNota, nuevoDirector, nuevoGenero);
            if (exito) {
                JOptionPane.showMessageDialog(null, "Película modificada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar la película.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
 
    /**
 * Modifica los detalles de una película en la base de datos.
 * 
 * @param tituloOriginal El título original de la película que se está modificando.
 * @param nuevoTitulo El nuevo título de la película.
 * @param nuevoAño El nuevo año de lanzamiento de la película.
 * @param nuevaDuracion La nueva duración en minutos de la película.
 * @param nuevaNota La nueva nota de la película.
 * @param nuevoDirector El nuevo director de la película.
 * @param nuevoGenero El nuevo género de la película.
 * @return true si la película se modificó correctamente, false si no.
 */
    private boolean modificarPeliculaEnBD(String tituloOriginal, String nuevoTitulo, int nuevoAño, int nuevaDuracion, double nuevaNota, String nuevoDirector, String nuevoGenero) {
    try {
        // Obtener el ID de la película que se está modificando
        int idPelicula = obtenerIdPeliculaPorTitulo(tituloOriginal);
        if (idPelicula == -1) {
            JOptionPane.showMessageDialog(null, "No se encontró la película especificada.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Obtener el ID del nuevo director
        int idNuevoDirector = obtenerIdDirector(nuevoDirector);
        if (idNuevoDirector == -1) {
            // Si el nuevo director no existe en la base de datos, insertarlo y obtener su ID
            idNuevoDirector = insertarDirector(nuevoDirector);
            if (idNuevoDirector == -1) {
                JOptionPane.showMessageDialog(null, "Error al insertar el nuevo director.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        // Obtener el ID del nuevo género
        int idNuevoGenero = obtenerIdGenero(nuevoGenero);
        if (idNuevoGenero == -1) {
            // Si el nuevo género no existe en la base de datos, insertarlo y obtener su ID
            idNuevoGenero = insertarGenero(nuevoGenero);
            if (idNuevoGenero == -1) {
                JOptionPane.showMessageDialog(null, "Error al insertar el nuevo género.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        // Actualizar los detalles de la película en la tabla peliculas
        String sqlUpdatePelicula = "UPDATE peliculas SET titulo = ?, año = ?, duracion = ?, nota = ? WHERE id_pelicula = ?";
        try (Connection connection = Conexion.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlUpdatePelicula)) {
            statement.setString(1, nuevoTitulo);
            statement.setInt(2, nuevoAño);
            statement.setInt(3, nuevaDuracion);
            statement.setDouble(4, nuevaNota);
            statement.setInt(5, idPelicula);

            int filasAfectadas = statement.executeUpdate();

            // Verificar si se actualizó la película correctamente en la tabla peliculas
            if (filasAfectadas > 0) {
                // Actualizar el director de la película en la tabla peliculas_directores
                String sqlUpdateDirector = "UPDATE peliculas_directores SET id_director = ? WHERE id_pelicula = ?";
                try (PreparedStatement directorStatement = connection.prepareStatement(sqlUpdateDirector)) {
                    directorStatement.setInt(1, idNuevoDirector);
                    directorStatement.setInt(2, idPelicula);
                    directorStatement.executeUpdate();
                }

                // Actualizar el género de la película en la tabla peliculas_generos
                String sqlUpdateGenero = "UPDATE peliculas_generos SET id_genero = ? WHERE id_pelicula = ?";
                try (PreparedStatement generoStatement = connection.prepareStatement(sqlUpdateGenero)) {
                    generoStatement.setInt(1, idNuevoGenero);
                    generoStatement.setInt(2, idPelicula);
                    generoStatement.executeUpdate();
                }

                return true;
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Manejar cualquier error de SQL
    }

    return false;
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
            java.util.logging.Logger.getLogger(Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Catalogo dialog = new Catalogo(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnBuscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelFondoCine;
    private javax.swing.JLabel lblAñadir;
    private javax.swing.JPanel panelHeaderCatalogo;
    private javax.swing.JRadioButton radioAño;
    private javax.swing.JRadioButton radioDirector;
    private javax.swing.JRadioButton radioDuracion;
    private javax.swing.JRadioButton radioGenero;
    private javax.swing.JRadioButton radioPuntuacion;
    private javax.swing.JRadioButton radioTitulo;
    private javax.swing.JTable tablaCatalogo;
    private javax.swing.JTextField txtDuracionMax;
    private javax.swing.JTextField txtDuracionMin;
    private javax.swing.JTextField txtPuntuacionMax;
    private javax.swing.JTextField txtPuntuacionMin;
    // End of variables declaration//GEN-END:variables
}
