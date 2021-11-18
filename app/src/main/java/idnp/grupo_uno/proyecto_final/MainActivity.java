package idnp.grupo_uno.proyecto_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import idnp.grupo_uno.proyecto_final.Adaptadores.FragmentComunication;
import idnp.grupo_uno.proyecto_final.entidades.Eventos;
import idnp.grupo_uno.proyecto_final.ui.dashboard.EditEventFragment;
import idnp.grupo_uno.proyecto_final.ui.events.EventsListFragment;
import idnp.grupo_uno.proyecto_final.ui.register.RegisterFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
    }


}