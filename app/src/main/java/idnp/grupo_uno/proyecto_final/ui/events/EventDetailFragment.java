package idnp.grupo_uno.proyecto_final.ui.events;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import idnp.grupo_uno.proyecto_final.R;

public class EventDetailFragment extends Fragment implements OnMapReadyCallback {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        Log.d("Main", "Compila por amor de dios");
        if (mapFragment != null) {
            Log.d("Main", "Compila por amor de dios");
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        Log.d("Main", "Por la chucha tumar");
        LatLng eventLocation = new LatLng(16.4090, 71.5375);
        LatLngBounds bounds = new LatLngBounds(eventLocation, eventLocation);
        googleMap.setLatLngBoundsForCameraTarget(bounds);
        googleMap.addMarker(new MarkerOptions().position(eventLocation).title("Lugar del Evento"));
    }
}