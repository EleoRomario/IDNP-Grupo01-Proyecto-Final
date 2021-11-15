package idnp.grupo_uno.proyecto_final.ui.register;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import idnp.grupo_uno.proyecto_final.R;
import idnp.grupo_uno.proyecto_final.databinding.FragmentRegisterBinding;

public class RegisterFragment extends Fragment {
    private FragmentRegisterBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setFragment(this);
    }

    public void loginByFacebook() {
        NavHostFragment.findNavController(this).navigate(R.id.action_registerFragment_to_eventsListFragment);
    }

    public void loginByGoogle() {
        NavHostFragment.findNavController(this).navigate(R.id.action_registerFragment_to_eventsListFragment);
    }
}