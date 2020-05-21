package Modelo;

public class Estudiante {
    String Documento;
    String Nombre;
    String Apellido;
    String Sexo;
    String Grado;

    public Estudiante(){

    }

    public Estudiante(String documento, String nombre, String apellido, String sexo, String grado) {
        Documento = documento;
        Nombre = nombre;
        Apellido = apellido;
        Sexo = sexo;
        Grado = grado;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String documento) {
        Documento = documento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getGrado() {
        return Grado;
    }

    public void setGrado(String grado) {
        Grado = grado;
    }
}
