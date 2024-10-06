package progress_body.datos;

import progress_body.conexion.Conexion;
import progress_body.dominio.Registro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa las operaciones de acceso a datos para la entidad Registro.
 * Proporciona métodos para listar, buscar, agregar, modificar y eliminar registros en la base de datos.
 */
public class RegistroDAO implements IRegistroDAO {

    /**
     * Lista todos los registros de la base de datos.
     *
     * @return Una lista de objetos {@link Registro} que representan todos los registros en la base de datos.
     */
    @Override
    public List<Registro> listarRegistros() {
        List<Registro> registros = new ArrayList<>(); // Se instancia la lista
        String sql = "SELECT * FROM registro ORDER BY id";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // Se obtienen los datos del ResultSet y se crean objetos Registro
                Registro registro = new Registro(
                        rs.getInt("id"),
                        rs.getDouble("peso"),
                        rs.getDouble("bicepIzquierdo"),
                        rs.getDouble("bicepDerecho"),
                        rs.getDouble("cintura"),
                        rs.getDouble("cuadriceps"),
                        rs.getDouble("pantorrillas"),
                        rs.getTimestamp("fecha")
                );
                registros.add(registro); // Se añade el registro a la lista
            }
        } catch (SQLException e) {
            System.out.println("No se listaron los registros. \n" + e.getMessage());
        }
        return registros; // Retorna la lista de registros
    }

    /**
     * Busca un registro en la base de datos utilizando el ID del objeto proporcionado.
     *
     * @param registro El objeto {@link Registro} que contiene el ID a buscar. No debe ser nulo.
     * @return true si se encontró el registro; false en caso contrario.
     * @throws IllegalArgumentException si el objeto registro es nulo.
     */
    @Override
    public boolean buscarRegistro(Registro registro) {
        if (registro == null) {
            throw new IllegalArgumentException("El registro no puede ser nulo");
        }

        String sql = "SELECT * FROM registro WHERE id=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, registro.getId());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) { // Si se encuentra el registro
                // Se actualizan los campos del objeto Registro con los datos de la base de datos
                registro.setPeso(rs.getDouble("peso"));
                registro.setBicepIzquierdo(rs.getDouble("bicepIzquierdo"));
                registro.setBicepDerecho(rs.getDouble("bicepDerecho"));
                registro.setCintura(rs.getDouble("cintura"));
                registro.setCuadriceps(rs.getDouble("cuadriceps"));
                registro.setPantorrillas(rs.getDouble("pantorrillas"));
                registro.setFecha(rs.getTimestamp("fecha"));
                return true;
            }
        } catch (SQLException e) {
            System.out.println("No se encontró el registro. \n" + e.getMessage());
        }
        return false; // Retorna false si no se encontró el registro
    }

    /**
     * Verifica si un ID existe en la base de datos.
     *
     * @param id El ID a buscar. Debe ser mayor a cero.
     * @return true si el ID existe; false en caso contrario.
     * @throws IllegalArgumentException si el id es menor o igual a cero.
     */
    @Override
    public boolean registroExiste(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor a cero.");
        }

        String sql = "SELECT 1 FROM registro WHERE id = ? LIMIT 1";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            return rs.next(); // Retorna true si hay un resultado

        } catch (SQLException e) {
            System.out.println("No se encontró el registro. \n" + e.getMessage());
        }

        return false; // Retorna false si ocurrió un error
    }

    /**
     * Agrega un nuevo registro a la base de datos.
     *
     * Este método inserta un objeto {@link Registro} en la tabla 'registro'.
     *
     * @param registro El objeto {@link Registro} a agregar. No debe ser nulo.
     * @return true si el registro fue agregado exitosamente; false en caso contrario.
     * @throws IllegalArgumentException si el objeto registro es nulo.
     */
    @Override
    public boolean agregarRegistro(Registro registro) {
        if (registro == null) {
            throw new IllegalArgumentException("El registro no puede ser nulo.");
        }

        String sql = "INSERT INTO registro (peso, bicepIzquierdo, bicepDerecho, cintura, cuadriceps, pantorrillas) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, registro.getPeso());
            ps.setDouble(2, registro.getBicepIzquierdo());
            ps.setDouble(3, registro.getBicepDerecho());
            ps.setDouble(4, registro.getCintura());
            ps.setDouble(5, registro.getCuadriceps());
            ps.setDouble(6, registro.getPantorrillas());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0; // Retorna true si se afectó al menos una fila

        } catch (SQLException e) {
            System.out.println("No se pudo agregar el registro. \n" + e.getMessage());
        }
        return false; // Retorna false si ocurrió un error
    }

    /**
     * Modifica un registro existente en la base de datos.
     *
     * @param registro El objeto Registro con los datos actualizados. No debe ser nulo.
     * @return true si el registro fue modificado exitosamente; false en caso contrario.
     * @throws IllegalArgumentException si el objeto registro es nulo.
     */
    @Override
    public boolean modificarRegistro(Registro registro) {
        if (registro == null) {
            throw new IllegalArgumentException("El registro no puede ser nulo.");
        }

        String sql = "UPDATE registro SET peso=?, bicepIzquierdo=?, bicepDerecho=?, cintura=?, cuadriceps=?, pantorrillas=? WHERE id=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, registro.getPeso());
            ps.setDouble(2, registro.getBicepIzquierdo());
            ps.setDouble(3, registro.getBicepDerecho());
            ps.setDouble(4, registro.getCintura());
            ps.setDouble(5, registro.getCuadriceps());
            ps.setDouble(6, registro.getPantorrillas());
            ps.setInt(7, registro.getId()); // Asegúrate de incluir el ID para identificar qué actualizar

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0; // Retorna true si se afectó al menos una fila

        } catch (SQLException e) {
            System.out.println("No se pudo modificar el registro: " + e.getMessage());
        }
        return false; // Retorna false si ocurrió un error
    }

    /**
     * Elimina un registro de la base de datos utilizando su ID.
     *
     * @param registro El objeto {@link Registro} a eliminar. No debe ser nulo.
     * @return true si el registro fue eliminado exitosamente; false en caso contrario.
     * @throws IllegalArgumentException si el objeto registro es nulo.
     */
    @Override
    public boolean eliminarRegistro(Registro registro) {
        if (registro == null) {
            throw new IllegalArgumentException("El registro no puede ser nulo.");
        }

        String sql = "DELETE FROM registro WHERE id = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, registro.getId());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0; // Retorna true si se afectó al menos una fila

        } catch (SQLException e) {
            System.out.println("No se pudo eliminar el registro: " + e.getMessage());
        }

        return false; // Retorna false si ocurrió un error
    }
}