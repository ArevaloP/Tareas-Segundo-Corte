<%@ page import="Modelo.Estudiante" %>
<%@ page import="ModeloDAO.EstudianteDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="Config.Conexion" %>
<%@ page import="com.mongodb.DB" %>
<%@ page import="com.mongodb.DBCollection" %>
<%@ page import="com.mongodb.DBCursor" %><%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 19/05/2020
  Time: 10:43 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Conexion cn = new Conexion();
    DB conn = cn.getconnection();
    DBCollection col;
     %>
<html>
<head>
    <title>Estudiantes</title>
</head>
<body>
    <h1>Lista de Estudiantes</h1>
    <table>
        <tr>
            <th>Documento</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Sexo</th>
            <th>Grado</th>
            <th>Acciones</th>
        </tr>
        <%
            EstudianteDAO est = new EstudianteDAO();
            List<Estudiante>list=est.listar();
            Iterator<Estudiante>iter=list.iterator();
            Estudiante es = null;
            col = conn.getCollection("estudiante");
            long totalreg = col.count();
            int porpag = 5;
            int pag = (Integer)request.getIntHeader("pag");
            if(pag<=-1){
                pag = 1;
            }
            col.find().limit(porpag);
            int totalPag = (int) (totalreg/porpag);
            while (iter.hasNext()){
                es = iter.next();
        %>
        <tr>
            <td><% es.getDocumento(); %></td>
            <td><% es.getNombre(); %></td>
            <td><% es.getApellido(); %></td>
            <td><% es.getSexo(); %></td>
            <td><% es.getGrado(); %></td>
            <td>
                <a class="link_edit" href="Controlador?accion=editar&id=<%es.getDocumento();%>">Editar</a>
                |
                <a class="link_delete" href="Controlador?accion=eliminar&id=<%es.getDocumento();%>">Eliminar</a>
            </td>
        </tr>
        <% } %>
    </table>

    <% if(totalreg != 0){ %>

    <div class="pagin">
        <ul>
            <%
				if (pag != 1) {
				 %>
            <li><a href="?pag=<% System.out.println(1);%>">|<</a></li>
            <li><a href="?pag=<%System.out.println(pag-1);%>"><<</a></li>

            <%
				}
				for (int i=1; i <= totalPag; i++) {
					if (i == pag){
            %>
                        <li class="pageSelect">i</li>
            <%
                    }else{
            %>
                        <li><a href="?pag=i<%System.out.println(i);%>">.$i.</a></li>
            <%
                    }
            }
            if(pag != totalPag){

            %>

            <li><a href="?pag=<%System.out.println(pag+1);%>">>></a></li>
            <li><a href="?pag=<% System.out.println(totalPag);%>">>|</a></li>
            <% } %>
        </ul>
    </div>
    <% } %>
</body>
</html>
