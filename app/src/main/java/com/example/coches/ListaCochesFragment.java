package com.example.coches;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.coches.Api.Coche;
import com.example.coches.Api.cocheAdapter;
import com.example.coches.Api.cochesApi;
import com.example.coches.databinding.ListaCochesBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ListaCochesFragment extends Fragment {

    private ListaCochesBinding binding;
    private cocheAdapter adapter;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = ListaCochesBinding.inflate(inflater, container, false); // Carrega la definició de la interficie
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new cocheAdapter(
                getContext(), // Context de l'Activity
                R.layout.coches_row, // Layout per a cadascun dels ítems del ListView
                new ArrayList<Coche>()
                //carles guapo
        );
        binding.listaID.setAdapter(adapter);
        actualizar();
    }

   //Alex me ha ayudado hoy a las 18:26
    public void actualizar() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.myLooper());

        executor.execute(() -> {
            cochesApi api = new cochesApi();
            ArrayList<Coche> list = api.getCoches();

            handler.post(() -> {
                adapter.clear();
                for(Coche c : list) {
                    adapter.add(c);
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