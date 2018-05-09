package co.edu.udea.studyapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import co.edu.udea.studyapp.data.Apunte;

public class RecyclerViewAdapterApunte extends RecyclerView.Adapter<RecyclerViewAdapterApunte.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView materia, titulo, descripcion, fecha;

        public ViewHolder(View itemView) {
            super(itemView);
            this.materia = (TextView) itemView.findViewById(R.id.item_apunte_materia);
            this.titulo = (TextView) itemView.findViewById(R.id.item_apunte_titulo);
            this.descripcion = (TextView) itemView.findViewById(R.id.item_apunte_descripcion);
            this.fecha = (TextView) itemView.findViewById(R.id.item_apunte_fecha);
        }
    }

    public List<Apunte> apuntesLista;

    public RecyclerViewAdapterApunte(List<Apunte> apuntesLista){
        this.apuntesLista = apuntesLista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_apunte, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.materia.setText(apuntesLista.get(position).getMateria());
        holder.titulo.setText(apuntesLista.get(position).getTitulo());
        holder.descripcion.setText(apuntesLista.get(position).getDescripcion());
        holder.fecha.setText(apuntesLista.get(position).getFecha());
    }

    @Override
    public int getItemCount() {
        return apuntesLista.size();
    }

}