package idnp.grupo_uno.proyecto_final.ui.dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import idnp.grupo_uno.proyecto_final.R;
import idnp.grupo_uno.proyecto_final.db.DbEventos;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewEventFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewEventFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewEventFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewEventFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewEventFragment newInstance(String param1, String param2) {
        NewEventFragment fragment = new NewEventFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    TextInputLayout txtNombre, txtTitulo, txtFecha, txtDescripcion, txtImagen, txtLatitud, txtLongitud;
    Button btnGuardar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_new_event, container, false);
        txtNombre = vista.findViewById(R.id.editnombre);
        txtTitulo = vista.findViewById(R.id.edittitulo);
        txtFecha = vista.findViewById(R.id.editfecha);
        txtDescripcion = vista.findViewById(R.id.editdescripcion);
        txtLatitud = vista.findViewById(R.id.editlatitud);
        txtLongitud = vista.findViewById(R.id.editlongitud);

        btnGuardar = vista.findViewById(R.id.guardarregistro);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbEventos dbEventos = new DbEventos(getContext());

                double lat = 0;
                double lon = 0;
                Editable fec = txtFecha.getEditText().getText();
                Editable latt = txtLatitud.getEditText().getText();
                Editable lont = txtLongitud.getEditText().getText();
                Editable fect= txtFecha.getEditText().getText();

                String fecs = (fec == null ? null : fec.toString());
                String latts = (latt == null ? null : latt.toString());
                String lonts = (lont == null ? null : lont.toString());
                String fects = (fect == null ? null : fect.toString());
                if(!TextUtils.isEmpty(latts) ){
                    lat = Double.parseDouble(latt.toString());
                }

                if(!TextUtils.isEmpty(lonts)){
                    lon = Double.parseDouble(lont.toString());
                }


                long id=dbEventos.insertaEventos(txtNombre.getEditText().getText().toString(), txtTitulo.getEditText().getText().toString(), txtFecha.getEditText().getText().toString(), txtDescripcion.getEditText().getText().toString(), lat,lon);

                if(id>0){
                    Toast.makeText(getContext(),"REGISTRO GUARDADO",Toast.LENGTH_LONG).show();
                    redirectEventsList();

                }else{
                    Toast.makeText(getContext(),"ERROR AL GUARDAR REGISTRO",Toast.LENGTH_LONG).show();
                }
            }
        });



        return vista;
    }
    public void redirectEventsList(){
        EventsDBFragment eventsDBFragment = new EventsDBFragment();
        FragmentManager manager=getFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.nav_host_fragment,eventsDBFragment).commit();
    }
}