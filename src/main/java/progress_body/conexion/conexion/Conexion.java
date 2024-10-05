package progress_body.conexion.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta clase proporciona un método para establecer y gestionar la conexión a una base de datos MySQL.
 */
public class Conexion {
    /**
     * Establece una conexión a la base de datos MySQL.
     *
     * @return Connection - Un objeto de tipo Connection si se establece la conexión correctamente.
     * @throws SQLException - Si no se puede establecer la conexión, ya sea por credenciales incorrectas o por el servidor apagado.
     */
    public static Connection getConexion() throws SQLException {
        String db = "progress_body_db"; // Nombre de la base de datos
        String url = "jdbc:mysql://localhost:3306/" + db; // URL de conexión a la base de datos MySQL
        String user = "root"; // Usuario de la base de datos
        String pass = "root1234"; // Contraseña del usuario

        try {
            // Se retorna un objeto de tipo Connection si la conexión se establece correctamente.
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("Error al establecer la conexión a la base de datos MySQL: " + e.getMessage());
            throw new SQLException("Error: Credenciales incorrectas o el servidor está apagado.");
        }
    }

//    public static void main(String[] args) {
//        Connection con = null;
//        try {
//            con = Conexion.getConexion();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//
//        }
//
//        if (con != null) {
//            System.out.println("Hola");
//        }
//
//
//    }
}

