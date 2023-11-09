package com.example.coches;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.coches.databinding.ListaCochesBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class ListaCochesFragment extends Fragment {

    private ListaCochesBinding binding;

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

        String[] data = {//Introducir datos de coches

        };

        ArrayList<String> items = new ArrayList<>(Arrays.asList(data));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getContext(), // Context de l'Activity
                R.layout.coches_row, // Layout per a cadascun dels ítems del ListView
                R.id.cochesId, // ID del TextView que contindrà el títol de la pel·lícula
                items
        );
        binding.listaID.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}