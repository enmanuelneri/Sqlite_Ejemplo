package com.enul.sqlite_ejemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editCodigo,editCurso, editCarrera;
    Button btnAgregar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Asociamos los objetos creados arriba, con los elementos de nuestro formulario*/
        editCodigo=(EditText)findViewById(R.id.editCodigo);
        editCurso=(EditText)findViewById(R.id.editCurso);
        editCarrera=(EditText)findViewById(R.id.editCarrera);

        btnAgregar=(Button)findViewById(R.id.btnAgregar);

        /*Creamos una instancia de la clase , para hacer uso de los metodos que conforman esta clase*/
        final EnulBD enulBD = new EnulBD(getApplicationContext());

        /*Generamos el evento clic del boton agregar*/
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Llamamos al metodo "agregarCursos" y a los objetos que se encargaran de traer los datos*/
                enulBD.agregarCursos(editCodigo.getText().toString()
                    ,editCurso.getText().toString()
                    ,editCarrera.getText().toString()
                );
                /*Agregamos una notificacion Toast para verificar que los datos fueron agregados*/
                Toast.makeText(getApplicationContext(),"Se agregó correctamente",Toast.LENGTH_LONG).show();
            }
        });


    }
}
