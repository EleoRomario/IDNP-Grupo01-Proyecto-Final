package idnp.grupo_uno.proyecto_final.Adaptadores;

import static androidx.navigation.Navigation.findNavController;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import idnp.grupo_uno.proyecto_final.MainActivity;
import idnp.grupo_uno.proyecto_final.R;
import idnp.grupo_uno.proyecto_final.VerActivity;
import idnp.grupo_uno.proyecto_final.entidades.Eventos;
import idnp.grupo_uno.proyecto_final.ui.dashboard.EditEventFragment;
import idnp.grupo_uno.proyecto_final.ui.dashboard.EventsDBFragment;

public class ListaEventosAdapter extends RecyclerView.Adapter<ListaEventosAdapter.ContactoViewHolder> {

    ArrayList<Eventos> listaEventos;
    ArrayList<Eventos> listaOriginal;

    public ListaEventosAdapter(ArrayList<Eventos> listaEventos ){
        this.listaEventos = listaEventos;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaEventos);
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item,null,false);
        ContactoViewHolder holder = new ContactoViewHolder(view);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {

        holder.viewId.setText(listaEventos.get(position).getId().toString());

        holder.viewNombre.setText(listaEventos.get(position).getNombre());
        holder.viewTitulo.setText(listaEventos.get(position).getTitulo());
        holder.viewFecha.setText(listaEventos.get(position).getFecha().toString());
        holder.viewDescripcion.setText(listaEventos.get(position).getDescripcion());
        holder.viewLongitud.setText(listaEventos.get(position).getLongitud().toString());
        holder.viewLatitud.setText(listaEventos.get(position).getLatitud().toString());


    }

    public void filtrado(String txtBuscar){

        int longitud = txtBuscar.length();
        if(longitud==0){
            listaEventos.clear();
            listaEventos.addAll(listaOriginal);
        }else{
            List<Eventos> collec = listaEventos.stream().filter(i->i.getNombre().toLowerCase().contains(txtBuscar.toLowerCase())).collect(Collectors.toList());
            listaEventos.clear();
            listaEventos.addAll(collec);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        return listaEventos.size();
    }
    public class ContactoViewHolder extends RecyclerView.ViewHolder {

        TextView viewId, viewNombre, viewTitulo, viewFecha, viewDescripcion, viewLongitud, viewLatitud;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            viewId = itemView.findViewById(R.id.viewID);
            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewTitulo = itemView.findViewById(R.id.viewTitulo);
            viewFecha = itemView.findViewById(R.id.viewFecha);
            viewDescripcion = itemView.findViewById(R.id.viewDescripcion);
            viewLongitud = itemView.findViewById(R.id.viewLongitud);
            viewLatitud = itemView.findViewById(R.id.viewLatitud);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Context context = view.getContext();
                    Intent intent = new Intent(context, VerActivity.class);
                    intent.putExtra("ID",listaEventos.get(getAdapterPosition()).getId());
                    context.startActivity(intent);//
                }
            });
        }
    }
}
