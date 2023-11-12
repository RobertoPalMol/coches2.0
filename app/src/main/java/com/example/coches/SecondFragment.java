package com.example.coches;


import android.annotation.SuppressLint;
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

    private ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageView = view.findViewById(R.id.imagenCoche);

        Bundle args = getArguments();
        if(args != null) {

            Coche item = (Coche) args.getSerializable("Coche");

            if (item != null) {
                refrescarInterfaz(item);
            }
        }
    }
    @SuppressLint("SetTextI18n")
    private void refrescarInterfaz(Coche item) {

        binding.idCoche.setText("MODELO DE COCHE: \n" + item.getCoche());
        binding.precioCoche.setText("PRECIO DE VENTA: " + item.getPrecio());
        binding.tiendaId.setText("TIENDA DE VENTA:  \n" + item.getTienda());
        binding.velocidadId.setText("VELOCIDAD MAXIMA: " + item.getVelocidad()+" (km/h)");
        Picasso.get().load(item.getImagen()).into(imageView);//no va la foto :,(


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
