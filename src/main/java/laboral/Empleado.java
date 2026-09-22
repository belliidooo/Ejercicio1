package laboral;

public class Empleado extends Persona{

    /** Propiedades de empleado (usando
     * tambien las de personas con el extends) */

    private int categoria;
    public int anyos;

    /** Constructor con los parametros de persona
     * mas los creados anteriormente. Tambien usamos
     * if para que los datos introducidos sean correctos */

    public Empleado (String nombre, String dni, char sexo, int categoria, int anyos)  throws DatosNoCorrectosException{
        super(nombre, dni, sexo);
        if (categoria < 1 || categoria > 10 || anyos < 0) {
            throw new DatosNoCorrectosException();
        }
        this.categoria = categoria;
        this.anyos = anyos;
    }

    /** Constructor de empleados pero definiendo la
     * categoria y los años si no son introducidos */

    public Empleado(String nombre, char sexo, String dni) throws DatosNoCorrectosException {
        this(nombre, dni, sexo, 1, 0);
    }

    /** Este metodo fija la categoria siguiendo las
     * restricciones del if. Lanzando una excepcion en
     * caso erroneo */

    public void setCategoria(int nuevaCategoria) throws DatosNoCorrectosException{
        if (nuevaCategoria < 1 || nuevaCategoria > 10) {
            throw new DatosNoCorrectosException();
        }
        nuevaCategoria = categoria;
    }

    public int getCategoria() {
        return categoria;
    }

    public void incrAnyo() {
        anyos++;
    }

    public void imprime() {
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("Sexo: " + sexo);
        System.out.println("Categoría: " + categoria);
        System.out.println("Años trabajados: " + anyos);
    }
}
