package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Estudiante;
import com.mongodb.*;

import javax.swing.text.Document;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO implements CRUD {
    Conexion cn = new Conexion();
    DB conn;
    DBCursor cursor;
    DBCollection col;
    BasicDBObject docu = new BasicDBObject();
    Estudiante e = new Estudiante();


    @Override
    public List listar() {
        ArrayList<Estudiante> list = new ArrayList<>();
        try{
            conn = cn.getconnection();
            col = conn.getCollection("estudiante");
            cursor = col.find();
            while (cursor.hasNext()){
                Estudiante est = new Estudiante();
                est.setDocumento(est.getDocumento());
                est.setNombre(est.getNombre());
                est.setApellido(est.getApellido());
                est.setGrado(est.getGrado());
                est.setSexo(est.getSexo());
                list.add(est);
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }

    @Override
    public Estudiante list(String Documento) {
        conn = cn.getconnection();
        col = conn.getCollection("estudiante");
        col.find().comment("Documento");
        try{
            conn = cn.getconnection();
            col = conn.getCollection("estudiante");
            cursor = col.find();
            while (cursor.hasNext()){
                e.setDocumento(e.getDocumento());
                e.setNombre(e.getNombre());
                e.setApellido(e.getApellido());
                e.setGrado(e.getGrado());
                e.setSexo(e.getSexo());
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return e;
    }

    @Override
    public boolean agregar(Estudiante est) {
        conn = cn.getconnection();
        col = conn.getCollection("estudiante");
        docu.put("Documento",est.getDocumento());
        col.insert(docu);
        docu.put("Nombre",est.getNombre());
        col.insert(docu);
        docu.put("Apellido",est.getApellido());
        col.insert(docu);
        docu.put("Sexo",est.getSexo());
        col.insert(docu);
        docu.put("Grado",est.getGrado());
        col.insert(docu);
        return true;
    }

    @Override
    public boolean actualizar(Estudiante est) {
        conn = cn.getconnection();
        col = conn.getCollection("estudiante");
        docu.put("Documento",est.getDocumento());
        BasicDBObject es = new BasicDBObject();
        es.put("Documento",est.getDocumento());
        col.insert(docu);
        docu.put("Nombre",est.getNombre());
        es.put("Nombre",est.getNombre());
        col.insert(docu);
        docu.put("Apellido",est.getApellido());
        col.insert(docu);
        es.put("Apellido",est.getApellido());
        docu.put("Sexo",est.getSexo());
        col.insert(docu);
        es.put("Sexo",est.getSexo());
        docu.put("Grado",est.getGrado());
        col.insert(docu);
        es.put("Grado",est.getGrado());
        return true;
    }

    @Override
    public boolean eliminar(String Documento) {
        try{
            conn = cn.getconnection();
            col = conn.getCollection("estudiante");
            docu.put("Documento",Documento);
            col.remove(docu);
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
}
