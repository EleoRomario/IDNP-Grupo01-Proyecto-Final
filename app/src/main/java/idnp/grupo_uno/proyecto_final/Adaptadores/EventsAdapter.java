package idnp.grupo_uno.proyecto_final.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import idnp.grupo_uno.proyecto_final.R;
import idnp.grupo_uno.proyecto_final.entidades.Eventos;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventosViewHolder> implements View.OnClickListener {
    ArrayList<Eventos> listaEventos;
    private View.OnClickListener listener;

    public EventsAdapter(ArrayList<Eventos> listaEventos){
      this.listaEventos = listaEventos;
    }

    @Override
    public EventosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item,null,false);
        RecyclerView.LayoutParams layParams = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layParams);

        view.setOnClickListener(this);

        return new EventosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventosViewHolder holder, int position) {
        holder.txtLugar.setText(listaEventos.get(position).getNombre());
        holder.txtFecha.setText(String.valueOf(listaEventos.get(position).getFecha()));
        holder.txtTitulo.setText(listaEventos.get(position).getTitulo());
    }

    @Override
    public int getItemCount() {
        return listaEventos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class EventosViewHolder extends RecyclerView.ViewHolder {
        TextView txtFecha, txtTitulo,txtLugar;

        public EventosViewHolder(View itemView) {
            super(itemView);
            txtFecha= (TextView) itemView.findViewById(R.id.e_fecha);
            txtLugar= (TextView) itemView.findViewById(R.id.e_lugar);
            txtTitulo= (TextView) itemView.findViewById(R.id.e_titulo);
        }
    }
}
