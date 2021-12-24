package idnp.grupo_uno.proyecto_final.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import idnp.grupo_uno.proyecto_final.R;
import idnp.grupo_uno.proyecto_final.entidades.Service;

// Adapter that inherits from recycler view adapter
public class ServicesAdapter extends RecyclerView.Adapter<ViewHolder> {
    List<Service> services;

    public ServicesAdapter(List<Service> services) {
        this.services = services;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_list_item, null, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(services.get(position));
    }

    @Override
    public int getItemCount() {
        return services.size();
    }
}

// view holder that has three methods: onbind, oncreate, getLength

class ViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    TextView price;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.service_title);
        price = itemView.findViewById(R.id.service_price);
    }

    public void bind(Service service) {
        title.setText(service.getName());
        price.setText(String.valueOf(service.getPrice()));
    }
}
