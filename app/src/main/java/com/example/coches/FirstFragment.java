package com.example.coches;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import com.example.coches.Api.Coche;
import com.example.coches.Api.cochesApi;
import com.example.coches.databinding.FragmentFirstBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class
FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText textoBuscar = view.findViewById(R.id.textoBuscar);
        Button botonBuscar = view.findViewById(R.id.botonBuscar);
        Button cochesList = view.findViewById(R.id.cochesList);

        //Image random novetat
        int num = new Random().nextInt((4-1)+1)+1;
        Log.d("fotitos sexys", ""+num);

        switch (num){
            case 1:
                Picasso.get().load(R.drawable.novedad1).into(binding.novedad);
                break;
            case 2:
                Picasso.get().load(R.drawable.novedad2).into(binding.novedad);
                break;
            case 3:
                Picasso.get().load(R.drawable.novedad3).into(binding.novedad);
                break;
            case 4:
                Picasso.get().load(R.drawable.novedad4).into(binding.novedad);
                break;
            default:
                Log.d("fotitos sexys", ""+num);
        }

        String searchTerm = textoBuscar.getText().toString();
        botonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*

                // No funciona, dejado para futuros proyectos
                if (!searchTerm.isEmpty()) {
                    buscarCoches(searchTerm);
                } else {
                    // Mostrar un mensaje indicando que el campo de búsqueda está vacío
                    Toast.makeText(getContext(), "Por favor, ingrese un término de búsqueda valido", Toast.LENGTH_SHORT).show();


                    Coche coche = Coche(getActivity());


                    Bundle datos = new Bundle();
                    datos.putSerializable("Coche", coche);
                    NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_fragmentsecond);


                }
 */


                String searchTerm = textoBuscar.getText().toString();
                //Toast.makeText(getActivity(), "Buscando: " + searchTerm, Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), "Esta función no esta disponible", Toast.LENGTH_SHORT).show();

            }
        });
        cochesList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Maneja el clic del botón "Coches disponibles"
                //Te lleva a la lista de coches
                NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_lista_coches);
            }
        });

    }

    //intento de barra de busqueda, no funciona
    private void buscarCoches(String searchTerm) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.myLooper());

        executor.execute(() -> {
            cochesApi api = new cochesApi();
            ArrayList<Coche> listaCompleta = api.getCoches();
            ArrayList<Coche> listaFiltrada = new ArrayList<>();

            if (listaCompleta != null) {
                for (Coche coche : listaCompleta) {
                    if (coche.getCoche().toLowerCase().contains(searchTerm.toLowerCase())
                            || coche.getCoche().toLowerCase().contains(searchTerm.toLowerCase())) {
                        listaFiltrada.add(coche);
                    }
                }
            }


        });



    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
