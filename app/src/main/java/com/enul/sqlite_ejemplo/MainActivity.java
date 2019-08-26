package com.enul.sqlite_ejemplo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// 2)
public class MainActivity extends AppCompatActivity {

    /*Declaramos 3 editText para cada campo de nuestro formulario; y tambien los botones*/
    EditText editCodigo,editDescripcion;
    Button btnAgregar,btnMostrar,btnBuscar,btnEditar,btnEliminar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Asociamos los objetos creados arriba (los EditText y Button), con los elementos de nuestro formulario*/
        editCodigo=(EditText)findViewById(R.id.editCodigo);
        editDescripcion=(EditText)findViewById(R.id.editDescripcion);

        /*Vinculamos los Button creados arriba con los del activity_main Layout*/
        btnAgregar=(Button)findViewById(R.id.btnAgregar);
        btnMostrar=(Button)findViewById(R.id.btnMostrar);
        btnBuscar=(Button)findViewById(R.id.btnBuscar);
        btnEditar=(Button)findViewById(R.id.btnEditar);
        btnEliminar=(Button)findViewById(R.id.btnEliminar);

        /*Creamos una(unica, con final) instancia de la clase EnulBD, para hacer uso de los metodos CRUD que conforman esta clase*/
        final EnulBD enulBD = new EnulBD(getApplicationContext());

        /*Generamos el evento clic del boton agregar*/
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Llamamos al metodo "agregarCursos" y a los objetos que se encargaran de traer los datos*/
                enulBD.agregarCasa(editCodigo.getText().toString()
                    ,editDescripcion.getText().toString()
                );
                /*Agregamos una notificacion Toast para verificar que los datos fueron agregados*/
                Toast.makeText(getApplicationContext(),"Se agregó correctamente",Toast.LENGTH_LONG).show();
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Con la clase intent llamamos al activity_casa*/
                Intent  mostrarCasa=new Intent(getApplicationContext(),CasaActivity.class);
                startActivity(mostrarCasa);
            }
        });

        /*Cuando se haga clic en el boton buscar, llene los datos en la caja de texto*/
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CasaModelo casa=new CasaModelo();
                enulBD.buscarCursos(casa,editCodigo.getText().toString());
                editDescripcion.setText(casa.getDescripcion());
            }
        });

        /*Creamos el evento clic para nuestro boton Editar*/
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enulBD.editarCasa(editCodigo.getText().toString(),editDescripcion.getText().toString());
                //Obtiene el contexto actual y hac que muestre ahi el siguiente mensaje
                Toast.makeText(getApplicationContext(),"Se modificó correctamente",Toast.LENGTH_SHORT).show();
            }
        });

        /*Creamos el evento clic para nuestro boton Eliminar*/
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enulBD.eliminarCasa(editCodigo.getText().toString());
                // Mostramos una notificacion Toast para que nos diga que los datos fueron eliminados correctamente
                Toast.makeText(getApplicationContext(),"Se eliminó correctamente",Toast.LENGTH_LONG).show();
            }
        });


    }



}
