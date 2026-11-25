<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.relucienteweb.modelo.Cliente"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Clientes - Reluciente</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f8f8f8;
        }

        h1 {
            color: #333;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 15px;
            background-color: white;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 10px;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>

<body>

    <h1>Clientes Registrados</h1>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Correo</th>
                <th>Documento</th>
                <th>Teléfono</th>
                <th>Dirección</th>
                <th>Ciudad</th>
            </tr>
        </thead>

        <tbody>
            <%
                List<Cliente> lista =
                    (List<Cliente>) request.getAttribute("listaClientes");

                if (lista != null && !lista.isEmpty()) {
                    for (Cliente c : lista) {
            %>
            <tr>
                <td><%= c.getId() %></td>
                <td><%= c.getNombre() %></td>
                <td><%= c.getApellido() %></td>
                <td><%= c.getCorreo() %></td>
                <td><%= c.getDocumento() %></td>
                <td><%= c.getTelefono() %></td>
                <td><%= c.getDireccion() %></td>
                <td><%= c.getCiudad() %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="8">No hay clientes para mostrar.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>

</body>
</html>