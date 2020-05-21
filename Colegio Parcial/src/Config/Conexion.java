package Config;


import com.mongodb.DB;
import com.mongodb.Mongo;

import java.sql.Connection;

public class Conexion {
    DB DataBase;


    public Conexion(){
        try{

            Class.forName("com.mongodb.DB");
            Mongo mongo = new Mongo("localhost",27017);
            DataBase = mongo.getDB("escuela");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public DB getconnection(){
        return DataBase;
    }
}
