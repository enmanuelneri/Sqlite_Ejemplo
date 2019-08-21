package com.enul.sqlite_ejemplo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

// 5) Importa el java.util.list para poder usar la lista y acceder a un elemento


public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {

    /*Creamos la siguiente clase interna*/
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView codigo,descripcion;
        ImageView fotoCasa;

        public ViewHolder(View itemView){
            super(itemView);
            codigo=(TextView)itemView.findViewById(R.id.txtCodigo);
            descripcion=(TextView)itemView.findViewById(R.id.txtDescripcion);
            fotoCasa=(ImageView)itemView.findViewById(R.id.imgCasa);
        }
    }
    /*Cremaos una lista para poner las casas, osea mostrar las imagenes*/
    public List<CasaModelo> casaLista;

    /*Creamos un constructor el cual recibira como parametro la lista creada*/

    public RecyclerViewAdaptador(List<CasaModelo> casaLista) {

        this.casaLista = casaLista;
    }

    /*Con el sgt metodo inflamos; es decir hacemos uso de un Layout dentro de otro Layout*/
    /*Por ejemplo nuestro Layout item_Casa tiene como destino ser parte del layout activity_Main*/


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_casa,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    /*El metodo onBindViewHolder es el que realiza las modificaciones del contenido para cada item*/
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.codigo.setText(casaLista.get(position).getCodigo());
        holder.descripcion.setText(casaLista.get(position).getDescripcion());
        holder.fotoCasa.setImageResource(casaLista.get(position).getImgCasa());
    }

    /*El metodo getItemCount permite saber la cantidad de elementos que se procesaran*/

    @Override
    public int getItemCount() {
        return casaLista.size();
    }
}
