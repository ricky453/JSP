<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogo</title>
    </head>
    <body>
    <center>
        <div>
            <h3>Formulario</h3>
            <form action="VisitaswebController" method="POST">
                <input type="submit" name ="accion" value="Listar">
                <input type="submit" name ="accion" value="Nuevo">
            </form>
            <hr>
        </div>
        <div>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>USUARIO</th>
                        <th>IDPANTALLA</th>
                        <th>FECHA</th>
                        <th>OPCIONES</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="dato" items="${visitasList}">
                    <tr>
                        <td>${dato.getId()}</td>
                        <td>${dato.getUsuario()}</td>
                        <td>${dato.getIdpantalla()}</td>
                        <td>${dato.getFecha()}</td>
                        <td>
                            <form action="VisitaswebController" method="POST">
                                <input type="hidden" name="id" value="${dato.getId()}">
                                <input type="submit" name="accion" value="Editar" >
                                <input type="submit" name="accion" value="Eliminar">
                            </form>
                        </td>
                    </tr>
                 </c:forEach>
                </tbody>
            </table>

        </div>
    </center>
    </body>
</html>
