package com.reluciente.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/reluciente?allowPublicKeyRetrieval=true&useSSL=false";


    private static final String USER = "root";
    private static final String PASSWORD = "1020"; //clave real

    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se encontró el driver JDBC de MySQL. " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de conexión a la base de datos: " + e.getMessage());
        }
        return conexion;
    }
}
