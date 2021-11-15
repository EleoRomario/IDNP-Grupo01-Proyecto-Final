package idnp.grupo_uno.proyecto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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

import idnp.grupo_uno.proyecto_final.ui.events.EventsListFragment;
import idnp.grupo_uno.proyecto_final.ui.register.RegisterFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "main";


    Button fragRegister, crearR;

    ImageButton fragRegister;
    ImageButton btnBack;
    Button fragEventsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragRegister = findViewById(R.id.btn_login_register);
        fragRegister.setOnClickListener(this);


        crearR = findViewById(R.id.btnCrear2);
        crearR.setOnClickListener(this);

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);
        fragEventsList = findViewById(R.id.btn_events_list);
        fragEventsList.setOnClickListener(this);

    }


    @Override

    public void onClick(View v){
        if(v.getId()==R.id.btn_back){
            onBackPressed();
        }
        if(v.getId()==R.id.btn_login_register){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_register, new RegisterFragment()).commit();
            fragRegister.setVisibility(View.GONE);
        }

        if(v.getId()==R.id.btnCrear2){
            Intent switchActivityIntent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(switchActivityIntent);
        }


        if(v.getId()==R.id.btn_events_list){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_events, new EventsListFragment()).commit();
            fragEventsList.setVisibility(View.GONE);
        }


    public void onClick(View v) {

    }
}