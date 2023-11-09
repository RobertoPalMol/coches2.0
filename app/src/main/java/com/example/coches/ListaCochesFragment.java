package com.example.coches;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.coches.Api.Coche;
import com.example.coches.Api.CocheAdapter;
import com.example.coches.Api.cochesApi;
import com.example.coches.databinding.ListaCochesBinding;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//esta clase explota la aplicacion, arreglar si o si
public class ListaCochesFragment extends Fragment {

    private ListaCochesBinding binding;
    private CocheAdapter adapter;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = ListaCochesBinding.inflate(inflater, container, false); // Carga la definición de la interficie
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new CocheAdapter(
                getContext(), // Contexto de l'Activity
                R.layout.coches_row, // Layout per a cadauno de los ítems del ListView
                new ArrayList<Coche>()
                //carles guapo
        );
        binding.listaID.setAdapter(adapter);
        actualizar();

       //Pulsar para ir al coche
        binding.listaID.setOnItemClickListener((adapterView, view1, i, l) -> {

            Coche coche = (Coche) adapterView.getItemAtPosition(i);


            Bundle datos = new Bundle();
            datos.putSerializable("Coche", coche);


            NavHostFragment.findNavController(this).navigate(R.id.action_lista_coches_to_cochesMostrar, datos);
        });

    }


   //Alex me ha ayudado hoy a las 18:26
    public void actualizar() {
        Log.d("tanga", "Ha entrado");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.myLooper());

        executor.execute(() -> {
            cochesApi api = new cochesApi();
            Log.d("tanga", "marikita de playa");
            ArrayList<Coche> list = api.getCoches();

            Log.d("tanga", list.toString());
            handler.post(() -> {
                adapter.clear();
                if (list != null) {
                    for(Coche c : list) {
                        adapter.add(c);
                    }
                }
            });
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}