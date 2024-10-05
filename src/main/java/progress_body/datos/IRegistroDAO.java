package progress_body.datos;

import progress_body.dominio.Registro;
import java.util.List;

/**
 * Interfaz para las operaciones de acceso a datos relacionadas con la entidad Registro.
 */
public interface IRegistroDAO {

    /**
     * Lista todos los registros almacenados.
     *
     * @return Una lista de objetos Registro.
     */
    List<Registro> listarRegistros();

    /**
     * Busca un registro por su identificador.
     *
     * @param id El identificador del registro.
     * @return true si el registro existe, false en caso contrario.
     */
    boolean buscarRegistro(int id);

    /**
     * Verifica si un registro existe dado su identificador.
     *
     * @param id El identificador del registro.
     * @return true si el registro existe, false en caso contrario.
     */
    boolean registroExiste(int id);

    /**
     * Agrega un nuevo registro.
     *
     * @param registro El objeto Registro a agregar.
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    boolean agregarRegistro(Registro registro);

    /**
     * Modifica un registro existente.
     *
     * @param registro El objeto Registro con los datos actualizados.
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    boolean modificarRegistro(Registro registro);

    /**
     * Elimina un registro existente.
     *
     * @param registro El objeto Registro a eliminar.
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    boolean eliminarRegistro(Registro registro);
}
