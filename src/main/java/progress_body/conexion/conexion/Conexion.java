package progress_body.conexion.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConexion() throws SQLException {
        String db = "progress_body_db";
        String url = "jdbc:mysql://localhost:3306/" + db;
        String user = "root";
        String pass = "root1234";

        try {
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("Error, al establecer la conexión a la base de datos MySql: " + e.getMessage());
            throw new SQLException("Error, Las credenciales incorrectas o el servidor apagado.");
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

