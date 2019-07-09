package com.enul.sqlite_ejemplo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CasaActivity extends AppCompatActivity {


    /*Creamos una instancia de la clase RecyclerView y de nuestro adaptador(creados anteriormente, RecyclerViewAdaptador)  */
    private RecyclerView recyclerViewCasa;
    private RecyclerViewAdaptador adaptadorCasa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*No te olvides de cambiar el "activity", en este caso daba error porque iniciabas 2 veces el activity_main y NO! el
        * activity_casa, por eso te mandaba el error de nullPoint exception */
        setContentView(R.layout.activity_casa);

        /*Vinculamos la instancia recyclerview con la instancia recyclerview de nuestro layout (osea el recyclerview de la vista xml) */
        recyclerViewCasa= (RecyclerView)findViewById(R.id.recyclerCasas);
        /*Definimos la forma de la lista, en este caso vertical, similar a un ListView */
        recyclerViewCasa.setLayoutManager(new LinearLayoutManager(this));

        //Creamos una instancia de EnulBD, para acceder a los metodos que conforman dicha clase
        EnulBD enulBD=new EnulBD(getApplicationContext());

        /*Enviamos la informacion de la lista a nuestro adaptador*/
        adaptadorCasa=new RecyclerViewAdaptador(enulBD.mostrarCasas());
        /*Asignamos toda esta informacion al recyclerView de nuestro Layout*/
        recyclerViewCasa.setAdapter(adaptadorCasa);


    }

}
