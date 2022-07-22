
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
            <h3>Actualizar VISITA</h3>
        </div>
        <div>
            <form action="VisitaswebController" method="POST">
                <label>ID</label>
                <input type="number" name="id" value="${visita.getId()}" readonly="true"> <br>
                <label>USUARIO</label>
                <input type="text" name="usuario" value="${visita.getUsuario()}"> <br>
                <label>IDPANTALLA</label>
                <input type="number" name="idpantalla" value="${visita.getIdpantalla()}"><br>
                <label>FECHA ACTUAL</label>
                <input type="text" value="${visita.getFecha()}"><br>
                <label>FECHA NUEVA</label>
                <input type="date" name="fecha" value="${visita.getFecha()}">
                <br>
                <input type="submit" name="accion"  value="Actualizar">
            </form>
        </div>
    </center>
</body>
</html>