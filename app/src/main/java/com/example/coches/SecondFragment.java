package com.example.coches;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.coches.Api.Coche;
import com.example.coches.Api.CocheAdapter;
import com.example.coches.Api.cochesApi;
import com.example.coches.databinding.FragmentSecondBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SecondFragment extends Fragment {
    private FragmentSecondBinding binding;
    private CocheAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Crear instancia de la clase API
        cochesApi api = new cochesApi();
        ArrayList<Coche> cochesList = api.getCoches();

        // Inicializar el adaptador con la lista de coches
        adapter = new CocheAdapter(requireContext(), R.layout.lista_coches, cochesList);

        // Configurar el RecyclerView
        //binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        //binding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
