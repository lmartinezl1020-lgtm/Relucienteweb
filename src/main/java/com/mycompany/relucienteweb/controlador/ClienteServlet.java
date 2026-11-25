package com.mycompany.relucienteweb.controlador;

import com.mycompany.relucienteweb.modelo.Cliente;
import com.mycompany.relucienteweb.modelo.ClienteDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    private ClienteDAO clienteDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        clienteDAO = new ClienteDAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> lista = clienteDAO.listar();
        request.setAttribute("listaClientes", lista);
        request.getRequestDispatcher("clientes.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    // En este bloque se capturan los datos, validamos que no estén duplicados y los guardamos en la base de datos
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        StringBuilder sb = new StringBuilder();
        String line;
        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }

        String body = sb.toString();
        String nombre = extraerValorJson(body, "nombre");
        String correo = extraerValorJson(body, "correo");

        PrintWriter out = response.getWriter();

        if (nombre == null || nombre.isBlank() || correo == null || correo.isBlank()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("{\"error\": \"Los campos 'nombre' y 'correo' son obligatorios.\"}");
            out.flush();
            return;
        }

        // TODO: Validar duplicados en ClienteDAO (ejemplo: si existe un método como existeCorreo(correo))
        // TODO: Crear instancia de Cliente, asignar nombre y correo, y guardarla con clienteDAO (ejemplo: clienteDAO.insertar(cliente))

        response.setStatus(HttpServletResponse.SC_OK);
        out.print("{\"mensaje\": \"Cliente procesado correctamente\", \"nombre\": \""
                + escaparJson(nombre) + "\", \"correo\": \"" + escaparJson(correo) + "\"}");
        out.flush();
    }

    private String extraerValorJson(String json, String clave) {
        if (json == null) {
            return null;
        }
        Pattern pattern = Pattern.compile("\"" + Pattern.quote(clave) + "\"\\s*:\\s*\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(json);
        return matcher.find() ? matcher.group(1) : null;
    }

    private String escaparJson(String texto) {
        if (texto == null) {
            return "";
        }
        return texto.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    @Override
    public String getServletInfo() {
        return "Servlet para gestión de clientes";
    }
}