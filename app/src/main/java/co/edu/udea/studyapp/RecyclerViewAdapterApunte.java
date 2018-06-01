package co.edu.udea.studyapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import co.edu.udea.studyapp.data.Apunte;
import co.edu.udea.studyapp.data.Materia;

public class RecyclerViewAdapterApunte extends RecyclerView.Adapter<RecyclerViewAdapterApunte.ViewHolder> implements View.OnClickListener{

private View.OnClickListener listener;

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }

    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView materia, titulo, descripcion, fecha;
        private final Context context;
        private String mItem;



        public ViewHolder(View itemView) {
            super(itemView);

            this.context = itemView.getContext();
            this.materia = (TextView) itemView.findViewById(R.id.item_apunte_materia);
            this.titulo = (TextView) itemView.findViewById(R.id.item_apunte_titulo);
            this.descripcion = (TextView) itemView.findViewById(R.id.item_apunte_descripcion);
            this.fecha = (TextView) itemView.findViewById(R.id.item_apunte_fecha);


           /*
            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    final Intent intent;
                    switch(getAdapterPosition()){
                        default:
                            intent = new Intent(context, MateriaEspecificaActivity.class);
                            getItemId()
                            break;
                    }
                    context.startActivity(intent);
                }

            });
            */



        }

        @Override
        public void onClick(View view) {
            Log.d("MYTAG", "onClick " + getItemId());
        }
    }



    public List<Materia> apuntesLista;

    public RecyclerViewAdapterApunte(List<Materia> apuntesLista){
        this.apuntesLista = apuntesLista;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_apunte, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(this);
        return viewHolder;




    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {



        holder.materia.setText(apuntesLista.get(position).getNombre());
        holder.titulo.setText(apuntesLista.get(position).getFechaDeCreacion());
        holder.descripcion.setText(apuntesLista.get(position).getDescripcion());
       // holder.fecha.setText(apuntesLista.get(position).getNombreCreador());

    }

    @Override
    public int getItemCount() {
        return apuntesLista.size();
    }

public void setOnClickListener(View.OnClickListener listenerM ){
this.listener=listenerM ;
}

}