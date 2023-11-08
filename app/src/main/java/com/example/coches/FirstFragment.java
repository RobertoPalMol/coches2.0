package com.example.coches;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.coches.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

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

        botonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchTerm = textoBuscar.getText().toString();
                // Aquí puedes realizar la acción de búsqueda con el término ingresado
                // Por ejemplo, puedes iniciar una nueva actividad o cargar otro fragmento con los resultados de búsqueda.
                // También puedes implementar la lógica de búsqueda directamente aquí.
                // Ejemplo básico:
                Toast.makeText(getActivity(), "Buscando: " + searchTerm, Toast.LENGTH_SHORT).show();

            }
        });

        cochesList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Maneja el clic del botón "Coches disponibles"
                showCochesDisponiblesFragment();
            }
        });
    }

    private void showCochesDisponiblesFragment() {
        // Crea un nuevo fragmento para los coches disponibles
        cochesApi cochesDisponiblesFragment = new cochesApi();

        // Reemplaza el fragmento actual con el nuevo fragmento
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.lista_coches, cochesDisponiblesFragment);
        transaction.addToBackStack(null); // Opcional: Agrega la transacción a la pila de retroceso
        transaction.commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
