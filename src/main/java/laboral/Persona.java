package laboral;

/** Representa a una persona con su nombre, DNI y sexo.
 * @author Alberto
 * @version 1.0
 */

public class Persona {

    /** Propiedades de las personas
     * @param nombre Nombre del empleado
     * @param dni Dni del empleado
     * @param sexo Sexo del empleado*/

    public String nombre;
    public String dni;
    public char sexo;

    /** Constructor con todas las propiedades de la persona.
     * @param nombre Nombre de la persona.
     * @param dni DNI de la persona.
     * @param sexo Sexo de la persona.
     */

    public Persona(String nombre, String dni, char sexo) {
        this.nombre = nombre;
        this.dni = dni;
        this.sexo = sexo;
    }

    /** Constructor con las propiedades nombre y sexo.
     * El DNI se inicializa como una cadena vacia.
     * @param nombre Nombre de la persona.
     * @param sexo Sexo de la persona.
     */

    public Persona(String nombre, char sexo) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.dni = "";
    }

    /** Modifica el DNI de la persona.
     * @param dni Nuevo DNI de la persona.
     */

    public void setDni(String dni) {
        this.dni = dni;
    }

    /** Este metodo nos muestra en pantalla el nombre y el DNI */

    public void imprime() {
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
    }
}
