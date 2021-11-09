package idnp.grupo_uno.proyecto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import idnp.grupo_uno.proyecto_final.ui.register.RegisterFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button fragRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragRegister = findViewById(R.id.btn_register);
        fragRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId()==R.id.btn_register){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_register, new RegisterFragment()).commit();
            fragRegister.setVisibility(View.GONE);
        }
    }
}