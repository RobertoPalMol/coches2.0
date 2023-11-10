package com.example.coches.Api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.coches.R;
import com.example.coches.databinding.CochesRowBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CocheAdapter extends ArrayAdapter<Coche> {


    public CocheAdapter(@NonNull Context context, int resource, List<Coche> coches) {
        super(context, resource, coches);
    }

    @SuppressLint("SetTextI18n")
    public View getView(int position, View convertView, ViewGroup parent) {


        //CODIGO BASURA (NO BORRADO PORSIACASO HASTA FINALIZAR PROYECTO)
        /*
        Coche coche=getItem(position);
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.lista_coches, parent, false);
        }

        TextView idCoche=convertView.findViewById(R.id.cochesId);
        TextView tiendaCoche=convertView.findViewById(R.id.tiendaId);
        TextView precioCoche=convertView.findViewById(R.id.precioId);
        TextView velocidadCoche=convertView.findViewById(R.id.velocidadId);
        ImageView imagenCoche=convertView.findViewById(R.id.imagenCoche);

        //ImageView (En honor a Ramon)

        Log.d("tallarines", Coche.toString());
        /*idCoche.setText(Coche.getId());
        tiendaCoche.setText("Tienda de venta: "+coche.getTienda());
        precioCoche.setText("Precio: "+coche.getPrecio());
        velocidadCoche.setText("Velocidad maxima (km/h): "+coche.getVelocidad());

        Picasso.get().load(coche.getImagen()).into(imagenCoche);
        Log.i("El id es"+coche.getId(),"El id es"+coche.getId());

        return convertView;
        }
         */





        Coche coches = getItem(position);
        CochesRowBinding binding = null;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            binding = CochesRowBinding.inflate(inflater, parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (CochesRowBinding) convertView.getTag();
        }


        binding.idCoche.setText(coches.getCoche());
        binding.precioCoche.setText("Precio: "+coches.getPrecio());
        //binding.tiendaCoche.setText("Tienda de compra: "+coches.getTienda());
        //binding.velocidadCoche.setInt("Velocidad maxima: "+coches.getVelocidad()+"(km/h)");
        //binding.imagenCoche.setImage(coches.getImagen());




        return convertView;

    }




}