package laboral;

public class Nomina {

    /**
     * Array que tiene los sueldos dependiendo la categoria en la empresa
     */
    private static final int SUELDO_BASE[] = {50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000, 230000};

    /**
     * Este metodo calcula el sueldo de un empleado basandose en su categoria
     * @param e Empleado del que se quiere calcular
     * @return Sueldo total del empleado
     */
    public static int sueldo (Empleado e) {
        int sueldoBase = SUELDO_BASE[e.getCategoria() - 1];
        return sueldoBase + 5000 * e.anyos;
    }
}
