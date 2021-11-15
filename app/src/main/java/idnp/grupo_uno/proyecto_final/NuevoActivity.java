package idnp.grupo_uno.proyecto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import idnp.grupo_uno.proyecto_final.db.DbEventos;

public class NuevoActivity extends AppCompatActivity {

    EditText txtNombre, txtTitulo, txtFecha, txtDescripcion, txtImagen, txtLatitud, txtLongitud;
    Button btnGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtNombre = findViewById(R.id.editnombre);
        txtTitulo = findViewById(R.id.edittitulo);
        txtFecha = findViewById(R.id.editfecha);
        txtDescripcion = findViewById(R.id.editdescripcion);
        txtLatitud = findViewById(R.id.editlatitud);
        txtLongitud = findViewById(R.id.editlongitud);

        btnGuardar = findViewById(R.id.guardarregistro);

        btnGuardar.setOnClickListener(view -> {
            DbEventos dbEventos = new DbEventos(NuevoActivity.this);

            double lat = 0;
            double lon = 0;
            Integer fec = 0;
            Editable latt = txtLatitud.getText();
            Editable lont = txtLongitud.getText();
            Editable fect= txtFecha.getText();

            String latts = (latt == null ? null : latt.toString());
            String lonts = (lont == null ? null : lont.toString());
            String fects = (fect == null ? null : fect.toString());
            if(!TextUtils.isEmpty(latts) ){
                lat = Double.parseDouble(latt.toString());
            }

            if(!TextUtils.isEmpty(lonts)){
                lon = Double.parseDouble(lont.toString());
            }

            if(!TextUtils.isEmpty(fects)){
                fec = Integer.parseInt(fect.toString());
            }

            long id=dbEventos.insertaEventos(txtNombre.getText().toString(), txtTitulo.getText().toString(), fec, txtDescripcion.getText().toString(), lat,lon);

            if(id>0){
                Toast.makeText(NuevoActivity.this,"REGISTRO GUARDADO",Toast.LENGTH_LONG).show();
                limpiar();

            }else{
                Toast.makeText(NuevoActivity.this,"ERROR AL GUARDAR REGISTRO",Toast.LENGTH_LONG).show();
            }
        });

    }
    private void limpiar(){
        txtNombre.setText("");
        txtTitulo.setText("");
        txtFecha.setText("");
        txtDescripcion.setText("");
        txtLatitud.setText("");
        txtLongitud.setText("");
    }
}