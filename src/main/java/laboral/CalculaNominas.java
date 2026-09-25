package laboral;

import persistencia.*;

import java.sql.SQLException;
import java.util.Scanner;

public class CalculaNominas {


    private static void escribe(Empleado empleado) {
        empleado.imprime();
        System.out.println("Sueldo: " + Nomina.sueldo(empleado));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        try {
            do {
                System.out.println("1 - Mostrar todos los empleados");
                System.out.println("2 - Mostrar el salario de un empleado expecifico");
                System.out.println("3 - Modificar datos de empleado");
                System.out.println("4 - Recalcular el sueldo de un empleado");
                System.out.println("5 - Recalcular todos los sueldos");
                System.out.println("6 - Copia de seguridad");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1: {
                        EmpleadoDAO.mostrar();
                        break;
                    }
                    case 2: {
                        System.out.println("DNI del empleado a mostrar su salario: ");
                        String dniMostrar = sc.nextLine();
                        NominaDAO.mostrarSalarioEspecifico(dniMostrar);
                        break;
                    }
                    case 3: {
                        int opcion2 = 0;
                        do {
                            System.out.println("1 - Nombre");
                            System.out.println("2 - DNI");
                            System.out.println("3 - Sexo");
                            System.out.println("4 - Categoria");
                            System.out.println("5 - Años trabajados");
                            System.out.println("0 - Salir");
                            System.out.println("Seleccione una opcion");
                            opcion = sc.nextInt();


                        } while (opcion2 != 0);
                    }
                }
            } while (opcion != 0);

        } catch (SQLException e) {
            System.out.println("Datos no correctos");
        }

    }
}
