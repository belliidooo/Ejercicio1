package persistencia;

import java.sql.*;
import laboral.*;

public class EmpleadoDAO {
    public void insertar (Empleado emp) throws SQLException {
        String sql = "INSERT INTO empleados (dni, nombre, sexo, categoria, anyos)" +
                " VALUES (?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionDB.conexion();
        PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, emp.dni);
            ps.setString(2, emp.nombre);
            ps.setString(3, String.valueOf(emp.sexo));
            ps.setInt(4, emp.getCategoria());
            ps.setInt(5, emp.anyos);

            ps.executeUpdate();
        }
    }

    public static void actualizar (Empleado emp) throws SQLException {
        String sql = "UPDATE Empleado SET nombre = ?, sexo = ?, categoria = ?, anyos = ?" +
                "WHERE dni = ?";

        try (Connection conexion = ConexionDB.conexion();
        PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, emp.nombre);
            ps.setString(2, String.valueOf(emp.sexo));
            ps.setInt(3, emp.getCategoria());
            ps.setInt(4, emp.anyos);
            ps.setString(5, emp.dni);

            ps.executeUpdate();
        }
    }

    public static void mostrar () throws SQLException {
        String sql = "SELECT * FROM empleados";

        try (Connection conn = ConexionDB.conexion();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String dni = rs.getString("dni");
                String sexo = rs.getString("sexo");
                int categoria = rs.getInt("categoria");
                int anyos = rs.getInt("anyos");

                System.out.println("Nombre: " + nombre);
                System.out.println("DNI: " + dni);
                System.out.println("Sexo: " + sexo);
                System.out.println("Categoria: " + categoria);
                System.out.println("Años trabajados: " + anyos);
            }
        }
    }

}
