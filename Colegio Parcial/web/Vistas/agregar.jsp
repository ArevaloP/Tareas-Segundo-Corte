<%--
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
    <section id="container">
        <div class="form_register">
            <h1>Registrar Estudiante</h1>
            <hr>
            <div class="alert"><?php echo isset($alert) ? $alert : ''; ?></div>
            <form action="" method="post">
                <label for="documento">Docuemento: </label>
                <input type="text" name="documento" id="documento" placeholder="Documento">
                <label for="nombre">Nombre: </label>
                <input type="text" name="nombre" id="nombre" placeholder="Nombre">
                <label for="apellido">Apellido: </label>
                <input type="text" name="apellido" id="apellido" placeholder="Apellido">
                <label for="sexo">Sexo: </label>
                <input type="text" name="sexo" id="sexo" placeholder="Sexo">
                <label for="grado">Grado: </label>
                <input type="text" name="grado" id="grado" placeholder="Grado">
                <input type="submit" name="accion" value="Add" class="btn_save">
            </form>
        </div>
    </section>
</body>
</html>
