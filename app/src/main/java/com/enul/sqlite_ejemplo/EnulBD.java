package com.enul.sqlite_ejemplo;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class EnulBD extends SQLiteOpenHelper {

    /*Con las constantes(por el final) de abajo, le damos un nombre a nuestra BD y una Version*/
    private static final String NOMBRE_BD="enul.bd";
    private static final int VERSION_BD=1;
    /*Creamos una variable que nos permita crear nuestro script, para poder guardar una tabla*/
    private static final String TABLA_CASA="CREATE TABLE CASA(CODIGO TEXT PRIMARY KEY, DESCRIPCION TEXT)";

    /*Creamos el constructor, pero luego lo modificamos agregandole el nombre y la version de nuestra BD*/

    public EnulBD(Context context) {

        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    /*Creamos el metodo Oncreate, el cual se creará automaticamente y generará las tablas. Y mediante el metodo
    * execSQL podemos ejecutar las sentencias sql que se requieran, en este caso el query "TABLA_CURSOS"*/
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(TABLA_CASA);
    }

    /*El metodo onUpgrade se lanzará automaticamente cuando es necesario una actualizacion en la estructura de la BD
    * o una conversion de datos. En este caso como estamos trabajando con 1 tabla, simplemente la eliminamos y volvemos
    * a crear otra nueva (nueva version)*/
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLA_CASA);
        sqLiteDatabase.execSQL(TABLA_CASA);
    }

    /*Creamos el metodo que será el encargado de agregar un registro en la tabla*/
    public void agregarCasa(String codigo,String descripcion){
        SQLiteDatabase bd=getWritableDatabase();//Nos permite trabajar en modo lectura y escritura
        /*Verificamos si se abrio correctamente la Base de Datos*/
        if(bd!=null){
            bd.execSQL("INSERT INTO CASA VALUES('"+codigo+"' ,'"+descripcion+"') ");
            /*Cerramos la conexion con la BD*/
            bd.close();
        }

    }
    /*Luego vamos al MainActivity y declaramos 3 objetos de tipo editText y otro tipo "Button" para agregar los cursos
     que se deseen */


    /*Creamos una funcion tipo lista basada en la clase CasaModelo, la cual usaremos para mostrar los datos en nuestra tabla CASA*/
    public List<CasaModelo> mostrarCasas(){
        SQLiteDatabase bd=getReadableDatabase();//El metodo getReadableDatabase nos permite trabajar en modo de lectura
        //Con la clase Cursor recuperamos los datos de un Query
        Cursor cursor=bd.rawQuery("SELECT * FROM CASA",null);
        //La lista de abajo se encargará de almacenar todos nuestro datos de la consulta sql
        List<CasaModelo> casas=new ArrayList<>();
        //Verificamos si existe por lo menos 1 registro
        if(cursor.moveToFirst()){
            do{
                casas.add(new CasaModelo(cursor.getString(0),cursor.getString(1)));
            }while (cursor.moveToNext());

        }
        return casas;
    }


}
