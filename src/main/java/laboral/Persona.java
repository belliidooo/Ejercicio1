package laboral;

public class Persona {

    /** Propiedades de las personas */

    public String nombre;
    public String dni;
    public char sexo;

    /** Constructor con todas las propiedades */

    public Persona(String nombre, String dni, char sexo) {
        this.nombre = nombre;
        this.dni = dni;
        this.sexo = sexo;
    }

    /** Constructor con las propiedades nombre y sexo.
     * El DNI indicamos que es una cadena vacia
     * si el constructor no lo especifica */

    public Persona(String nombre, char sexo) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.dni = "";
    }

    /** setDni lo usamos para establecer un DNI */

    public void setDni(String dni) {
        this.dni = dni;
    }

    /** Este metodo nos muestra en pantalla el nombre y el DNI */

    public void imprime() {
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
    }
}
