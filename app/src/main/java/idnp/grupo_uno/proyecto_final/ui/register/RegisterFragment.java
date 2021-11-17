package idnp.grupo_uno.proyecto_final.ui.register;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import idnp.grupo_uno.proyecto_final.R;
import idnp.grupo_uno.proyecto_final.databinding.FragmentRegisterBinding;

public class RegisterFragment extends Fragment {
    private FragmentRegisterBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false);
        View vista = inflater.inflate(R.layout.fragment_register, container, false);
        Button btn = vista.findViewById(R.id.btn_google);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(v).navigate(R.id.action_registerFragment_to_eventOverview);
            }
        });
        Button btnAdmin = vista.findViewById(R.id.btn_admin);
        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.action_registerFragment_to_eventsDBFragment);
            }
        });
        return vista;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setFragment(this);
    }

    public void loginByFacebook() {
        NavHostFragment.findNavController(this).navigate(R.id.action_registerFragment_to_eventOverview);
    }

    public void loginByGoogle() {
        NavHostFragment.findNavController(this).navigate(R.id.action_registerFragment_to_eventOverview);
    }
}