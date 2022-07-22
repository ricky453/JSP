<%-- 
    Document   : crear
    Created on : 07-21-2022, 10:17:26 AM
    Author     : ricardo.barrientos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Agregar Visita Web</h1>
            <form action="VisitaswebController" method="POST">
                <table>
                    <tr>
                        <td> ID</td>
                        <td><input type="number" name="id"></td>
                    </tr>
                    <tr>
                        <td> Usuario</td>
                        <td><input text="text" name="usuario"></td>
                    </tr>
                    <tr>
                        <td> Idpantalla</td>
                        <td><input type="number" name="idpantalla"></td>
                    </tr>
                    <tr>
                        <td> Fecha</td>
                        <td><input type="date" name="fecha"></td>
                    </tr>
                    <tr>
                        <TD>
                            <input type="submit" name="accion" value="Agregar">

                        </TD>
                    </tr>
                </table>
            </form>
        </div>
        <form action="VisitaswebController" method="POST">
            <input type="submit" name="accion" value="Listar"><br>


        </form>
    </div>
</body>
</html>
