package com.mycompany.relucienteweb.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaConexion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/relucienteweb?useSSL=false&serverTimezone=UTC";
        String usuario = "root";
        String password = "1020";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, usuario, password);
            if (con != null) {
                System.out.println("¡Conexión exitosa!");
                con.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
}
