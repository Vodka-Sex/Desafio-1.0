package desafio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author juan
 */

/**
   Clase dedicada a realizar la conexión con la base de datos
     */
public class Conexion {
    
    // Credenciales para la conexión a la base de datos
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Desafio";
    private static final String USER = "sa";
    private static final String PASSWORD = "contraseña1234";
    
    /**
     * Método para establecer la conexión con la base de datos.
     * @return La conexión establecida.
     * @throws SQLException Si ocurre un error al establecer la conexión.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    /**
     * Método para verificar si la conexión a la base de datos es exitosa.
     */
    public static void verificarConexion() {
        try {
            Connection connection = getConnection();
            System.out.println("Conexión exitosa a la base de datos.");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al establecer la conexión a la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }    
}