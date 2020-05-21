package Controlador;

import Modelo.Estudiante;
import ModeloDAO.EstudianteDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Controlador")
public class Controlador extends HttpServlet {
    String listar = "Vistas/listar.jsp";
    String agregar = "Vistas/agregar.jsp";
    String actualizar = "Vistas/actualizar.jsp";
    Estudiante e = new Estudiante();
    EstudianteDAO edat = new EstudianteDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acceso="";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")){
            acceso = listar;
        }else if (action.equalsIgnoreCase("agregar")){
            acceso =agregar;
        }
        else if (action.equalsIgnoreCase("Add")){
            String Documento = request.getParameter("documento");
            String Nombre = request.getParameter("nombre");
            String Apellido = request.getParameter("apellido");
            String Sexo = request.getParameter("sexo");
            String Grado = request.getParameter("grado");
            e.setDocumento(Documento);
            e.setNombre(Nombre);
            e.setApellido(Apellido);
            e.setSexo(Sexo);
            e.setGrado(Grado);
            edat.agregar(e);
            acceso = "Listar";
        }else if (action.equalsIgnoreCase("editar")){
            request.setAttribute("idvin",request.getAttribute("id"));
            acceso = actualizar;
        }

        else if(action.equalsIgnoreCase("Actualizar")){
            String Nombre = request.getParameter("nombre");
            String Apellido = request.getParameter("apellido");
            String Sexo = request.getParameter("sexo");
            String Grado = request.getParameter("grado");
            e.setNombre(Nombre);
            e.setApellido(Apellido);
            e.setSexo(Sexo);
            e.setGrado(Grado);
            edat.actualizar(e);
            acceso = "Listar";
        }else if (action.equalsIgnoreCase("eliminar")){
            String id = request.getParameter("id");
            e.setDocumento(id);
            edat.eliminar(id);
            acceso = "Listar";
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request,response);
    }
}
