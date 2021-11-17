package idnp.grupo_uno.proyecto_final.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Blob;
import java.util.ArrayList;

import idnp.grupo_uno.proyecto_final.entidades.Eventos;

public class DbEventos extends DbHelper{

    Context context;
    public DbEventos(Context context){
        super(context);
        this.context = context;
    }
    public long insertaEventos(String nombre, String titulo, Integer fecha, String descripcion, Double latitud, Double longitud){

        long id = 0;

        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("Nombre",nombre);
            values.put("Titulo",titulo);
            values.put("Fecha",fecha);
            values.put("Descripcion",descripcion);
            values.put("Latitud",latitud);
            values.put("Longitud",longitud);


            id = db.insert(TABLA_EVENTOS,null,values);

        }catch(Exception ex){
            ex.toString();
        }
        return id;

    }
    public ArrayList<Eventos> mostrarEventos(){
        DbHelper dphelper = new DbHelper(context);
        SQLiteDatabase db = dphelper.getWritableDatabase();

        ArrayList<Eventos> listaEventos = new ArrayList<>();
        Eventos eventos = null;
        Cursor cursorContactos = null;

        cursorContactos = db.rawQuery("SELECT ID, Nombre, Titulo, Fecha, Descripcion, Latitud, Longitud FROM "+TABLA_EVENTOS,null);
        if(cursorContactos.moveToFirst()){
            do{

                eventos = new Eventos();
                eventos.setId(cursorContactos.getInt(0));
                eventos.setNombre(cursorContactos.getString(1));
                eventos.setTitulo(cursorContactos.getString(2));
                eventos.setFecha(cursorContactos.getInt(3));
                eventos.setDescripcion(cursorContactos.getString(4));
                eventos.setLatitud(cursorContactos.getDouble(5));
                eventos.setLongitud(cursorContactos.getDouble(6));
                listaEventos.add(eventos);

            }while (cursorContactos.moveToNext());
        }
        cursorContactos.close();
        return listaEventos;
    }
}
