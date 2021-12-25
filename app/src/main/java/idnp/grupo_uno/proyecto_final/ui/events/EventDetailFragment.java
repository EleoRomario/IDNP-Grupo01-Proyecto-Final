package idnp.grupo_uno.proyecto_final.ui.events;

import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.concurrent.Executor;

import idnp.grupo_uno.proyecto_final.R;

public class EventDetailFragment extends Fragment implements OnMapReadyCallback {
    private FusedLocationProviderClient fusedLocationProviderClient;

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
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getContext());
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng eventLocation = new LatLng(-13.52264, -71.96734);
        googleMap.addMarker(new MarkerOptions().position(eventLocation).title("Lugar del Evento"));

        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(@NonNull Location location) {
                if (location != null) {
                    LatLng myPosition = new LatLng(location.getLatitude(), location.getLongitude());

                    LatLngBounds bounds = LatLngBounds.builder()
                            .include(eventLocation)
                            .include(myPosition).build();

                    googleMap.setLatLngBoundsForCameraTarget(bounds);

                    googleMap.addMarker(new MarkerOptions().position(myPosition).title("Posición Actual"));
                }
            }
        });

    }
}