<%@ page import="ModeloDAO.EstudianteDAO" %>
<%@ page import="Modelo.Estudiante" %><%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 19/05/2020
  Time: 10:43 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Estudiantes</title>
</head>
<body>
    <%
        EstudianteDAO edat = new EstudianteDAO();
        String id = (String)request.getAttribute("idvin");
        Estudiante e = edat.list(id);
    %>
    <section id="container">
        <div class="form_register">
            <h1>Actualizar Estudiante</h1>
            <hr>
            <div class="alert"><?php echo isset($alert) ? $alert : ''; ?></div>
            <form action="" method="post">
                <label for="nombre">Nombre: </label>
                <input type="text" name="nombre" id="nombre" placeholder="Nombre" value="<%e.getNombre();%>">
                <label for="apellido">Apellido: </label>
                <input type="text" name="apellido" id="apellido" placeholder="Apellido" value="<%e.getApellido();%>">
                <label for="sexo">Sexo: </label>
                <input type="text" name="sexo" id="sexo" placeholder="Sexo" value="<%e.getSexo();%>">
                <label for="grado">Grado: </label>
                <input type="text" name="grado" id="grado" placeholder="Grado" value="<%e.getGrado();%>">
                <input type="submit" name="accion" value="Actualizar" class="btn_save">
            </form>
        </div>
    </section>
</body>
</html>
