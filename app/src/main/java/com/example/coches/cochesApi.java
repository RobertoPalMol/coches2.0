package com.example.coches;

import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class cochesApi {
    private String BASE_URL = "https://ltxbhwabgxtxbbvqlkte.supabase.co/rest/v1";

    ArrayList<Coche> getCoches() {
        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .appendPath("Deportivos")
                .appendQueryParameter("apikey", BASE_URL)
                .appendQueryParameter("limit", "20")
                .build();
        String url = builtUri.toString();
        return doCall(url);
    }

    private ArrayList<Coche> doCall(String url) {
        try {
            String Jresponse = HttpUtils.get(url);
            return processJson(Jresponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<Coche> processJson(String Jresponse) {
        ArrayList<Coche> listaCoche = new ArrayList<>();

        try {

            JSONArray jsonArray=new JSONArray(Jresponse);
            for(int i=0;i<jsonArray.length();i++){
                Coche coche=new Coche();
                JSONObject cocheJson=jsonArray.getJSONObject(i);
                coche.setId(cocheJson.getInt("id"));
                coche.setCoche(cocheJson.getString("Coche"));
                coche.setTienda(cocheJson.getString("Tienda"));
                coche.setPrecio(cocheJson.getString("Precio"));
                coche.setVelocidad(cocheJson.getInt("Velocidad (km/h)"));
                coche.setImagen(cocheJson.getString("Imagen"));
                listaCoche.add(coche);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return listaCoche;
    }
}
