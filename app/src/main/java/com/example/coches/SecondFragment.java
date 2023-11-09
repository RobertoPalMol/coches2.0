package com.example.coches;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.coches.Api.Coche;
import com.example.coches.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Coche coche = obtenerCocheDesdeArgumentos();

        //binding.cocheId.setText(coche.getCoche());
        //binding.precioId.setText("Precio: " + coche.getPrecio());
    }
    private Coche obtenerCocheDesdeArgumentos() {
        // Implementa la lógica para obtener el objeto Coche de los argumentos
        if (getArguments() != null) {
            return (Coche) getArguments().getSerializable("coche");
        }
        return null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}