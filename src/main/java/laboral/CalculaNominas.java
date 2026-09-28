package laboral;

import persistencia.*;

import java.sql.SQLException;
import java.util.ArrayList;
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
                sc.nextLine();

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
                        System.out.println("Dime el DNI del empleado a modificar");
                        String dniOriginal = sc.nextLine();
                        Empleado emp = EmpleadoDAO.buscarPorDni(dniOriginal);
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
                            sc.nextLine();

                            switch (opcion) {
                                case 1: {
                                    System.out.println("Nuevo nombre: ");
                                    emp.nombre = sc.nextLine();
                                    System.out.println("Nombre modificado correctamente");
                                    break;
                                }
                                case 2: {
                                    System.out.println("Nuevo DNI: ");
                                    emp.dni = sc.nextLine();
                                    System.out.println("DNI modificado correctamente");
                                    break;
                                }
                                case 3: {
                                    System.out.println("Nuevo sexo");
                                    emp.sexo = sc.nextLine().charAt(0);
                                    System.out.println("Sexo modificado correctamente");
                                    break;
                                }
                                case 4: {
                                    System.out.println("Nueva categoria: ");
                                    int categoria = sc.nextInt();
                                    sc.nextLine();
                                    emp.setCategoria(categoria);
                                    System.out.println("Categoria modificada correctamente");
                                    break;
                                }
                                case 5: {
                                    System.out.println("Nuevo años: ");
                                    emp.anyos = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Años modificados correctamente");
                                    break;
                                }
                                case 0: {
                                    EmpleadoDAO.actualizar(emp, dniOriginal);
                                    System.out.println("Empleado actualizado correctamente");
                                    break;
                                }
                                default: {
                                    System.out.println("Opcion invalida");
                                }
                            }

                        } while (opcion2 != 0);
                    }
                    case 4: {
                        System.out.println("DNI del empleado a recalcular sueldo: ");
                        String dni = sc.nextLine();

                        Empleado emp = EmpleadoDAO.buscarPorDni(dni);

                        if (emp == null) {
                            System.out.println("No existe ningun empleado con ese DNI");
                            break;
                        }

                        int sueldoNuevo = Nomina.sueldo(emp);
                        NominaDAO.actualizarSueldo(dni, sueldoNuevo);

                        System.out.println("Sueldo recalculado correctamente.");
                        System.out.println("Nuevo sueldo: " + sueldoNuevo);

                        break;
                    }
                    case 5: {
                        ArrayList<Empleado> empleados = EmpleadoDAO.obtenerTodos();

                        for (Empleado emp : empleados) {
                            int sueldoNuevo = Nomina.sueldo(emp);
                            NominaDAO.actualizarSueldo(emp.dni, sueldoNuevo);
                        }
                        System.out.println("Sueldos recalculados y actualizados correctamente.");
                        break;
                    }
                    case 6: {
                        System.out.println("Esta sin terminar");
                    }
                    case 0: {
                        System.out.println("Saliendo...");
                        break;
                    }
                }
            } while (opcion != 0);

        } catch (SQLException e) {
            System.out.println("Datos no correctos");
        } catch (DatosNoCorrectosException e) {
            System.out.println("Datos invalidos");;
        }


    }
}
