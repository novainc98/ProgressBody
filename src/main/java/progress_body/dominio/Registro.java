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
        setId(id); // Establece el id usando el setter para validar.
    }

    /**
     * Constructor que inicializa un nuevo objeto Registro con las medidas corporales y la fecha.
     *
     * @param peso           Peso en kilogramos.
     * @param bicepIzquierdo Medida del bíceps izquierdo en centímetros.
     * @param bicepDerecho   Medida del bíceps derecho en centímetros.
     * @param cintura        Medida de la cintura en centímetros.
     * @param cuadriceps     Medida del cuadríceps en centímetros.
     * @param pantorrillas   Medida de las pantorrillas en centímetros.
     * @param fecha          Fecha y hora del registro.
     */
    public Registro(double peso, double bicepIzquierdo, double bicepDerecho,
                    double cintura, double cuadriceps, double pantorrillas,
                    Timestamp fecha) {
        setPeso(peso); // Establece el peso usando el setter para validar.
        setBicepIzquierdo(bicepIzquierdo); // Establece la medida del bíceps izquierdo.
        setBicepDerecho(bicepDerecho); // Establece la medida del bíceps derecho.
        setCintura(cintura); // Establece la medida de la cintura.
        setCuadriceps(cuadriceps); // Establece la medida del cuadríceps.
        setPantorrillas(pantorrillas); // Establece la medida de las pantorrillas.
        setFecha(fecha); // Establece la fecha del registro.
    }

    /**
     * Constructor que inicializa un nuevo objeto Registro con un id y las medidas corporales.
     *
     * @param id             El identificador único del registro.
     * @param peso           Peso en kilogramos.
     * @param bicepIzquierdo Medida del bíceps izquierdo en centímetros.
     * @param bicepDerecho   Medida del bíceps derecho en centímetros.
     * @param cintura        Medida de la cintura en centímetros.
     * @param cuadriceps     Medida del cuadríceps en centímetros.
     * @param pantorrillas   Medida de las pantorrillas en centímetros.
     * @param fecha          Fecha y hora del registro.
     */
    public Registro(int id, double peso, double bicepIzquierdo, double bicepDerecho,
                    double cintura, double cuadriceps, double pantorrillas,
                    Timestamp fecha) {
        this(peso, bicepIzquierdo, bicepDerecho, cintura, cuadriceps, pantorrillas, fecha);
        this.id = id; // Asigna el id directamente.
    }

    // Métodos getter y setter

    public int getId() {
        return id; // Retorna el id del registro.
    }

    private void setId(int id) {
        try {
            if (id <= 0) {
                throw new IllegalArgumentException("El id debe ser mayor que 0."); // Verifica que el id sea positivo.
            }
            this.id = id; // Asigna el id si es válido.
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage()); // Muestra un mensaje de error.
        }
    }

    public double getPeso() {
        return peso; // Retorna el peso del registro.
    }

    public void setPeso(double peso) {
        try {
            if (peso <= 0) {
                throw new IllegalArgumentException("El peso debe ser mayor que 0."); // Verifica que el peso sea positivo.
            }
            this.peso = peso; // Asigna el peso si es válido.
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage()); // Muestra un mensaje de error.
        }
    }

    public double getBicepIzquierdo() {
        return bicepIzquierdo; // Retorna la medida del bíceps izquierdo.
    }

    public void setBicepIzquierdo(double bicepIzquierdo) {
        try {
            if (bicepIzquierdo <= 0) {
                throw new IllegalArgumentException("La medida del Bicep Izquierdo debe ser mayor que 0."); // Verifica que la medida sea positiva.
            }
            this.bicepIzquierdo = bicepIzquierdo; // Asigna la medida si es válida.
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage()); // Muestra un mensaje de error.
        }
    }

    public double getBicepDerecho() {
        return bicepDerecho; // Retorna la medida del bíceps derecho.
    }

    public void setBicepDerecho(double bicepDerecho) {
        try {
            if (bicepDerecho <= 0) {
                throw new IllegalArgumentException("La medida del Bicep Derecho debe ser mayor que 0."); // Verifica que la medida sea positiva.
            }
            this.bicepDerecho = bicepDerecho; // Asigna la medida si es válida.
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage()); // Muestra un mensaje de error.
        }
    }

    public double getCintura() {
        return cintura; // Retorna la medida de la cintura.
    }

    public void setCintura(double cintura) {
        try {
            if (cintura <= 0) {
                throw new IllegalArgumentException("La medida de la cintura debe ser mayor que 0."); // Verifica que la medida sea positiva.
            }
            this.cintura = cintura; // Asigna la medida si es válida.
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage()); // Muestra un mensaje de error.
        }
    }

    public double getCuadriceps() {
        return cuadriceps; // Retorna la medida del cuadríceps.
    }

    public void setCuadriceps(double cuadriceps) {
        try {
            if (cuadriceps <= 0) {
                throw new IllegalArgumentException("La medida del cuadriceps debe ser mayor que 0."); // Verifica que la medida sea positiva.
            }
            this.cuadriceps = cuadriceps; // Asigna la medida si es válida.
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage()); // Muestra un mensaje de error.
        }
    }

    public double getPantorrillas() {
        return pantorrillas; // Retorna la medida de las pantorrillas.
    }

    public void setPantorrillas(double pantorrillas) {
        try {
            if (pantorrillas <= 0) {
                throw new IllegalArgumentException("La medida de las pantorrillas debe ser mayor que 0."); // Verifica que la medida sea positiva.
            }
            this.pantorrillas = pantorrillas; // Asigna la medida si es válida.
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage()); // Muestra un mensaje de error.
        }
    }

    public Timestamp getFecha() {
        return fecha; // Retorna la fecha del registro.
    }

    private void setFecha(Timestamp fecha) {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser nula"); // Verifica que la fecha no sea nula.
        }
        this.fecha = fecha; // Asigna la fecha si es válida.
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
