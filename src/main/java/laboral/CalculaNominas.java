package laboral;

public class CalculaNominas {

    private static void escribe(Empleado empleado) {
        empleado.imprime();
        System.out.println("Sueldo: " + Nomina.sueldo(empleado));
    }

    public static void main(String[] args) {
        try {
            Empleado e1 = new Empleado("James Cosling", "32000032G", 'M', 4, 7);
            Empleado e2 = new Empleado("Ada Lovelace", 'F', "32000031G");

            System.out.println("DATOS INICIALES");
            escribe(e1);
            escribe(e2);
            System.out.println("--------------------");

            e2.incrAnyo();
            e1.setCategoria(9);

            System.out.println("DATOS DESPÚES DE LOS CAMBIOS");
            escribe(e1);
            escribe(e2);

        } catch (DatosNoCorrectosException e) {
            System.out.println("Datos no correctos");
        }

    }
}
