package progress_body.dominio;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Esta clase modela la entidad del negocio que representa un registro
 * de medidas corporales.
 */
public class Registro {
    private int id; // Identificador único del registro
    private double peso; // Peso en kilogramos
    private double bicepIzquierdo; // Medida del bíceps izquierdo en centímetros
    private double bicepDerecho; // Medida del bíceps derecho en centímetros
    private double cintura; // Medida de la cintura en centímetros
    private double cuadriceps; // Medida del cuadríceps en centímetros
    private double pantorrillas; // Medida de las pantorrillas en centímetros
    private Timestamp fecha; // Fecha y hora del registro

    /**
     * Constructor por defecto que inicializa un nuevo objeto Registro.
     */
    public Registro() {
    }

    /**
     * Constructor que inicializa un nuevo objeto Registro con un id.
     *
     * @param id El identificador único del registro.
     */
    public Registro(int id) {
        this.id = id;
    }

    /**
     * Constructor que inicializa un nuevo objeto Registro con las medidas corporales y la fecha.
     *
     * @param peso Peso en kilogramos.
     * @param bicepIzquierdo Medida del bíceps izquierdo en centímetros.
     * @param bicepDerecho Medida del bíceps derecho en centímetros.
     * @param cintura Medida de la cintura en centímetros.
     * @param cuadriceps Medida del cuadríceps en centímetros.
     * @param pantorrillas Medida de las pantorrillas en centímetros.
     * @param fecha Fecha y hora del registro.
     */
    public Registro(double peso, double bicepIzquierdo, double bicepDerecho,
                    double cintura, double cuadriceps, double pantorrillas,
                    Timestamp fecha) {
        this.peso = peso;
        this.bicepIzquierdo = bicepIzquierdo;
        this.bicepDerecho = bicepDerecho;
        this.cintura = cintura;
        this.cuadriceps = cuadriceps;
        this.pantorrillas = pantorrillas;
        this.fecha = fecha;
    }

    /**
     * Constructor que inicializa un nuevo objeto Registro con un id y las medidas corporales.
     *
     * @param id El identificador único del registro.
     * @param peso Peso en kilogramos.
     * @param bicepIzquierdo Medida del bíceps izquierdo en centímetros.
     * @param bicepDerecho Medida del bíceps derecho en centímetros.
     * @param cintura Medida de la cintura en centímetros.
     * @param cuadriceps Medida del cuadríceps en centímetros.
     * @param pantorrillas Medida de las pantorrillas en centímetros.
     * @param fecha Fecha y hora del registro.
     */
    public Registro(int id, double peso, double bicepIzquierdo, double bicepDerecho,
                    double cintura, double cuadriceps, double pantorrillas,
                    Timestamp fecha) {
        this(peso, bicepIzquierdo, bicepDerecho, cintura, cuadriceps, pantorrillas, fecha);
        this.id = id;
    }

    // Métodos getter y setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getBicepIzquierdo() {
        return bicepIzquierdo;
    }

    public void setBicepIzquierdo(double bicepIzquierdo) {
        this.bicepIzquierdo = bicepIzquierdo;
    }

    public double getBicepDerecho() {
        return bicepDerecho;
    }

    public void setBicepDerecho(double bicepDerecho) {
        this.bicepDerecho = bicepDerecho;
    }

    public double getCintura() {
        return cintura;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public double getCuadriceps() {
        return cuadriceps;
    }

    public void setCuadriceps(double cuadriceps) {
        this.cuadriceps = cuadriceps;
    }

    public double getPantorrillas() {
        return pantorrillas;
    }

    public void setPantorrillas(double pantorrillas) {
        this.pantorrillas = pantorrillas;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Registro.
     *
     * @return Cadena que representa los atributos del registro.
     */
    @Override
    public String toString() {
        return "Registro{" +
                "id=" + id +
                ", peso=" + peso +
                ", bicepIzquierdo=" + bicepIzquierdo +
                ", bicepDerecho=" + bicepDerecho +
                ", cintura=" + cintura +
                ", cuadriceps=" + cuadriceps +
                ", pantorrillas=" + pantorrillas +
                ", fecha=" + fecha +
                '}';
    }

    /**
     * Compara este objeto con otro para determinar si son iguales.
     *
     * @param o Objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registro registro = (Registro) o;
        return id == registro.id &&
                Double.compare(peso, registro.peso) == 0 &&
                Double.compare(bicepIzquierdo, registro.bicepIzquierdo) == 0 &&
                Double.compare(bicepDerecho, registro.bicepDerecho) == 0 &&
                Double.compare(cintura, registro.cintura) == 0 &&
                Double.compare(cuadriceps, registro.cuadriceps) == 0 &&
                Double.compare(pantorrillas, registro.pantorrillas) == 0 &&
                Objects.equals(fecha, registro.fecha);
    }

    /**
     * Devuelve un código hash para el objeto Registro.
     *
     * @return Código hash del objeto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, peso, bicepIzquierdo, bicepDerecho,
                cintura, cuadriceps, pantorrillas, fecha);
    }
}
