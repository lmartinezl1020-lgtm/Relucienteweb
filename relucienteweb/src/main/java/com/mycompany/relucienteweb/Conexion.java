package com.mycompany.relucienteweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/reluciente?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "1020";

    public static Connection getConnection() {
        Connection conexion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion exitosa");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexion: " + e.getMessage());
        }

        return conexion;
    }

    public static void main(String[] args) {
        Conexion.getConnection();
    }
}