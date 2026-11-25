package com.mycompany.relucienteweb.controlador;

import com.mycompany.relucienteweb.modelo.Cliente;
import com.mycompany.relucienteweb.modelo.ClienteDAO;
import java.io.IOException;
import java.util.List;
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet para gestión de clientes";
    }
}