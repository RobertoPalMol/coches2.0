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

        return convertView;

    }


}