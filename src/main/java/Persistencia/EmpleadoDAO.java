package Persistencia;

import java.sql.*;
import laboral.*;

public class EmpleadoDAO {
    public void insertar (Empleado emp) throws SQLException {
        String sql = "INSERT INTO Empleado (dni, nombre, sexo, categoria, anyos)" +
                " VALUES (?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionDB.conexion();
        PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, Empleado.dni);
            ps.setString(2, Empleado.nombre);
            ps.setString(3, String.valueOf(Empleado.sexo));
            ps.setInt(4, Empleado.getCategoria());
            ps.setInt(5, Empleado.anyos);

            ps.executeUpdate();
        }
    }

    public void actualizar (Empleado emp) throws SQLException {
        String sql = "UPDATE Empleado SET nombre = ?, sexo = ?, categoria = ?, anyos = ?" +
                "WHERE dni = ?";

        try (Connection conexion = ConexionDB.conexion();
        PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, Empleado.nombre);
            ps.setString(2, String.valueOf(Empleado.sexo));
            ps.setInt(3, Empleado.getCategoria());
            ps.setInt(4, Empleado.anyos);
            ps.setString(5, Empleado.dni);

            ps.executeUpdate();
        }
    }
}
