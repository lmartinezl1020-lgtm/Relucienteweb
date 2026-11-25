package com.reluciente.main;

import com.reluciente.dao.ServicioDAO;
import com.reluciente.model.Servicio;

public class Main {
    public static void main(String[] args) {
        ServicioDAO servicioDAO = new ServicioDAO();

        // 1. Prueba de Inserción
        Servicio nuevo = new Servicio("Limpieza de vidrios", "Limpieza exterior e interior de ventanales", 95000.00, "ACTIVO");
        if (servicioDAO.insertarServicio(nuevo)) {
            System.out.println("Servicio insertado correctamente.");
        }

        // 2. Prueba de Consulta
        System.out.println("\n--- LISTA DE SERVICIOS ---");
        for (Servicio s : servicioDAO.listarServicios()) {
            System.out.println(s.getIdServicio() + " | " + s.getNombre() + " | $" + s.getPrecioBase() + " | " + s.getEstado());
        }

        // 3. Prueba de Actualización (Ejemplo actualizando el ID 4)
        Servicio actualizado = new Servicio(4, "Limpieza de vidrios y fachadas", "Incluye altura baja", 110000.00, "ACTIVO");
        if (servicioDAO.actualizarServicio(actualizado)) {
            System.out.println("\nServicio actualizado correctamente.");
        }

        // 4. Prueba de Eliminación (Ejemplo eliminando el ID 4)
        if (servicioDAO.eliminarServicio(4)) {
            System.out.println("Servicio eliminado correctamente.");
        }
    }
}