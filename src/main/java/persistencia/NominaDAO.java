package persistencia;

import java.sql.*;
import laboral.*;

public class NominaDAO {

    public static void mostrarSalarioEspecifico(String dni) throws SQLException {
         String sql = "SELECT sueldo FROM nominas WHERE dni = ?";

         try (Connection conn = ConexionDB.conexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {
             ps.setString(1, dni);

             ResultSet rs = ps.executeQuery();

             while (rs.next()) {
                 int sueldo = rs.getInt("sueldo");

                 System.out.println("DNI: " + dni);
                 System.out.println("Sueldo: " + sueldo);
             }
         }
    }

}

