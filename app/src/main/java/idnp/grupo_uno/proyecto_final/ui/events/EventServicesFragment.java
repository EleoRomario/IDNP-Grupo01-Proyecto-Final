package idnp.grupo_uno.proyecto_final.ui.events;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import idnp.grupo_uno.proyecto_final.Adaptadores.ServicesAdapter;
import idnp.grupo_uno.proyecto_final.R;
import idnp.grupo_uno.proyecto_final.entidades.Service;

public class EventServicesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_services, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.services_list);
        List<Service> services = new ArrayList<>();
        services.add(new Service("Tour de Servicio", 12.0));
        services.add(new Service("Tour de Servicio", 12.0));
        recyclerView.setAdapter(new ServicesAdapter(services));
    }
}