package idnp.grupo_uno.proyecto_final.ui.events;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import idnp.grupo_uno.proyecto_final.R;
import idnp.grupo_uno.proyecto_final.databinding.FragmentEventsListBinding;

public class EventsListFragment extends Fragment {
    private FragmentEventsListBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_events_list, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setFragment(this);
    }

    public void goToEventOverview() {
        NavHostFragment.findNavController(this).navigate(R.id.action_eventsListFragment_to_eventOverview);
    }
}