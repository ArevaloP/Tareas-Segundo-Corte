package Interfaces;

import Modelo.Estudiante;

import java.util.List;

public interface CRUD {
    public List listar();
    public Estudiante list (String Documento);
    public boolean agregar(Estudiante est);
    public boolean actualizar(Estudiante est);
    public boolean eliminar(String Documento);
}
