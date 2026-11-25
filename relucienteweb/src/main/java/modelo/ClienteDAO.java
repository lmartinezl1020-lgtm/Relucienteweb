package com.mycompany.relucienteweb.modelo;

import com.mycompany.relucienteweb.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public List<Cliente> listar() {

        List<Cliente> lista = new ArrayList<>();

        String sql = "SELECT "
                + "c.id_cliente, "
                + "c.nombre, "
                + "c.apellido, "
                + "u.correo, "
                + "c.documento, "
                + "c.telefono, "
                + "c.direccion, "
                + "c.ciudad "
                + "FROM clientes c "
                + "INNER JOIN usuarios u ON c.id_usuario = u.id_usuario "
                + "WHERE u.rol = 'CLIENTE'";

        try (Connection con = Conexion.getConnection()) {

            if (con == null) {
                System.out.println("No se pudo conectar a la base de datos.");
                return lista;
            }

            try (PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Cliente c = new Cliente();

                    c.setId(rs.getInt("id_cliente"));
                    c.setNombre(rs.getString("nombre"));
                    c.setApellido(rs.getString("apellido"));
                    c.setCorreo(rs.getString("correo"));
                    c.setDocumento(rs.getString("documento"));
                    c.setTelefono(rs.getString("telefono"));
                    c.setDireccion(rs.getString("direccion"));
                    c.setCiudad(rs.getString("ciudad"));

                    lista.add(c);
                }

                System.out.println("Clientes recuperados: " + lista.size());

            }

        } catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }

        return lista;
    }
}