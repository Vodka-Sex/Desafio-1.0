
package desafio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author juan
 */


/**
     Clase que inicia el programa
     */
public class Desafio extends Application {
    
    /**
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        Conexion.verificarConexion();
        
        Login login = new Login();
        login.setCursor(null); //esto debería evitar que el cursor aparezca en un elemento por defecto
        login.setVisible(true);
        
        try {
    // Obtener una conexión a la base de datos
    Connection connection = Conexion.getConnection();

   /* // Preparar la consulta SQL para seleccionar los directores
    String sql = "SELECT id_director, nombre_director FROM directores";
    PreparedStatement statement = connection.prepareStatement(sql);
    
    // Ejecutar la consulta y obtener el resultado
    ResultSet resultSet = statement.executeQuery();
    
    // Procesar el resultado
    while (resultSet.next()) {
        // Obtener los datos de cada fila (id_director y nombre_director)
        int idDirector = resultSet.getInt("id_director");
        String nombreDirector = resultSet.getString("nombre_director");
        
        // Hacer algo con los datos, por ejemplo, imprimirlos
        System.out.println("ID Director: " + idDirector + ", Nombre Director: " + nombreDirector);
    }
    
    // Cerrar recursos
    resultSet.close();
    statement.close();
    connection.close(); */
} catch (SQLException e) {
    // Manejar cualquier excepción que pueda ocurrir al ejecutar la consulta
    e.printStackTrace();
}

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
