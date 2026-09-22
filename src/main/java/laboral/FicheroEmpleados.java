package laboral;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FicheroEmpleados {

    public static ArrayList<Empleado> leerEmpleados() throws IOException, DatosNoCorrectosException {

        ArrayList<Empleado> empleados = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("empleados.txt"));
        String linea;

        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(";");

            String nombre = datos[0];
            String dni = datos[1];
            char sexo = datos[2].charAt(0);
            int categoria = Integer.parseInt(datos[3]);
            int anyos = Integer.parseInt(datos[4]);

            Empleado emp = new Empleado(nombre, dni, sexo, categoria, anyos);

            empleados.add(emp);

        }
        br.close();
        return empleados;

    }
}
