package idnp.grupo_uno.proyecto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import idnp.grupo_uno.proyecto_final.db.DbEventos;
import idnp.grupo_uno.proyecto_final.entidades.Eventos;

public class VerActivity extends AppCompatActivity {

    EditText txtNombre, txtTitulo, txtFecha, txtDescripcion, txtImagen, txtLatitud, txtLongitud;
    Button btnGuarda;
    Eventos evento;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        txtNombre = findViewById(R.id.editnombre);
        txtTitulo = findViewById(R.id.edittitulo);
        txtFecha = findViewById(R.id.editfecha);
        txtDescripcion = findViewById(R.id.editdescripcion);
        txtLatitud = findViewById(R.id.editlatitud);
        txtLongitud = findViewById(R.id.editlongitud);

        btnGuarda = findViewById(R.id.guardarregistro);

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();

            if(extras == null){
                id = Integer.parseInt(null);
            }else{
                id = extras.getInt("ID");
            }
        } else {
            id = (int) savedInstanceState.getSerializable("ID");
        }

        DbEventos dbEventos = new DbEventos(VerActivity.this);
        evento = dbEventos.verEventos(id);

        if(evento != null){
            txtNombre.setText(evento.getNombre());
            txtTitulo.setText(evento.getTitulo());
            txtFecha.setText(evento.getFecha().toString());
            txtDescripcion.setText(evento.getDescripcion());
            txtLatitud.setText(evento.getLatitud().toString());
            txtLongitud.setText(evento.getLongitud().toString());
            btnGuarda.setVisibility(View.INVISIBLE);
            txtNombre.setInputType(InputType.TYPE_NULL);
            txtTitulo.setInputType(InputType.TYPE_NULL);
            txtFecha.setInputType(InputType.TYPE_NULL);
            txtDescripcion.setInputType(InputType.TYPE_NULL);
            txtLatitud.setInputType(InputType.TYPE_NULL);
            txtLongitud.setInputType(InputType.TYPE_NULL);


        }

    }
}