package com.enul.sqlite_ejemplo;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class enulBD extends SQLiteOpenHelper {

    private static final String NOMBRE_BD="enul.bd";
    private static final int VERSION_BD=1;
    /*Creamos una variable que nos permita crear nuestro script, para poder guardar una tabla*/
    private static final String TABLA_CURSOS="CREATE TABLE CURSOS(CODIGO TEXT PRIMARY KEY, CURSO TEXT, CARRERA TEXT)";

    /*Creamos el constructor, pero luego lo modificamos agregandole el nombre y la version de nuestra BD*/

    public enulBD(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    /*Creamos el metodo Oncreate, el cual se creará automaticamente y generará las tablas. Y mediante el metodo
    * execSQL podemos ejecutar las sentencias sql que se requieran, en este caso el query "TABLA_CURSOS"*/
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(TABLA_CURSOS);
    }

    /*El metodo onUpgrade se lanzará automaticamente cuando es necesario una actualizacion en la estructura de la BD
    * o una conversion de datos. En este caso como estamos trabajando con 1 tabla, simplemente la eliminamos y volvemos
    * a crear otra nueva (nueva version)*/
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS"+ TABLA_CURSOS);
    }

    /*Creamos el metodo que será el encargado de agregar un registro en la tabla*/
    public void agregarCursos(String codigo,String curso,String carrera){
        SQLiteDatabase bd=getWritableDatabase();//Nos permite trabajar en modo lectura y escritura
        /*Verificamos si se abrio correctamente la Base de Datos*/
        if(bd!=null){
            bd.execSQL("INSERT INTO CURSOS VALUES('"+codigo+"' ,'"+curso+"' ,'"+carrera+"' ) ");
            /*Cerramos la conexion con la BD*/
            bd.close();
        }

    }
    /*Luego vamos al MainActivity y declaramos 3 objetos de tipo editText y otro tipo "Button" para agregar los cursos
     que se deseen */




}
