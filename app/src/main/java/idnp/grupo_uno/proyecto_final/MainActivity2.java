package idnp.grupo_uno.proyecto_final;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

import idnp.grupo_uno.proyecto_final.Adaptadores.ListaEventosAdapter;
import idnp.grupo_uno.proyecto_final.db.DbEventos;
import idnp.grupo_uno.proyecto_final.db.DbHelper;
import idnp.grupo_uno.proyecto_final.entidades.Eventos;

public class MainActivity2 extends AppCompatActivity implements SearchView.OnQueryTextListener{

    SearchView txtBuscar;
    RecyclerView listaEventos;
    ArrayList<Eventos> listaArrayEventos;
    Button btnCrear;
    ListaEventosAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtBuscar = findViewById(R.id.buscar);
        listaEventos = findViewById(R.id.lista);
        listaEventos.setLayoutManager(new LinearLayoutManager(this));
        DbEventos dbEventos = new DbEventos(MainActivity2.this);

        listaArrayEventos = new ArrayList<>();
        adapter = new ListaEventosAdapter(dbEventos.mostrarEventos());
        listaEventos.setAdapter(adapter);

        DbHelper dbHelper = new DbHelper(MainActivity2.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        /*btnCrear = findViewById(R.id.btnCrear);
        btnCrear.setOnClickListener(view -> {
            DbHelper dbHelper = new DbHelper(MainActivity2.this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            if (db != null) {
                Toast.makeText(MainActivity2.this, "BASE DE DATOS CREADA",Toast.LENGTH_LONG).show();

            }else {
                Toast.makeText(MainActivity2.this, "ERROR AL CREAR BASE DE DATOS",Toast.LENGTH_LONG).show();
            }
        });*/

        txtBuscar.setOnQueryTextListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuNuevo:
                nuevoRegistro();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
    private void nuevoRegistro(){
        Intent intent = new Intent(this,NuevoActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adapter.filtrado(s);
        return false;
    }
}