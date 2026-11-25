package com.reluciente.dao;

import com.reluciente.config.ConexionDB;
import com.reluciente.model.Servicio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicioDAO {

    // 1. INSERCIÓN (Create)
    public boolean insertarServicio(Servicio servicio) {
        String sql = "INSERT INTO servicios (nombre, descripcion, precio_base, estado) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, servicio.getNombre());
            ps.setString(2, servicio.getDescripcion());
            ps.setDouble(3, servicio.getPrecioBase());
            ps.setString(4, servicio.getEstado());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar servicio: " + e.getMessage());
            return false;
        }
    }

    // 2. CONSULTA (Read)
    public List<Servicio> listarServicios() {
        List<Servicio> lista = new ArrayList<>();
        String sql = "SELECT id_servicio, nombre, descripcion, precio_base, estado FROM servicios";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Servicio s = new Servicio(
                    rs.getInt("id_servicio"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio_base"),
                    rs.getString("estado")
                );
                lista.add(s);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar servicios: " + e.getMessage());
        }
        return lista;
    }

    // 3. ACTUALIZACIÓN (Update)
    public boolean actualizarServicio(Servicio servicio) {
        String sql = "UPDATE servicios SET nombre = ?, descripcion = ?, precio_base = ?, estado = ? WHERE id_servicio = ?";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, servicio.getNombre());
            ps.setString(2, servicio.getDescripcion());
            ps.setDouble(3, servicio.getPrecioBase());
            ps.setString(4, servicio.getEstado());
            ps.setInt(5, servicio.getIdServicio());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar servicio: " + e.getMessage());
            return false;
        }
    }

    // 4. ELIMINACIÓN (Delete)
    public boolean eliminarServicio(int idServicio) {
        String sql = "DELETE FROM servicios WHERE id_servicio = ?";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idServicio);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar servicio: " + e.getMessage());
            return false;
        }
    }
}