package com.example.coches.Api;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class cochesApi {
    private final String BASE_URL = "https://ltxbhwabgxtxbbvqlkte.supabase.co/rest/v1";
    private final String API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Imx0eGJod2FiZ3h0eGJidnFsa3RlIiwicm9sZSI6ImFub24iLCJpYXQiOjE2OTg5MjE0NjAsImV4cCI6MjAxNDQ5NzQ2MH0.p2asA2EMy8KovBVq3C0GTQPMqP7LlEPtWtJYlCTOKEY";

    public ArrayList<Coche> getCoches() {
        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .appendPath("Deportivos")
                .appendQueryParameter("apikey", API_KEY)//me ha vuelto a petar por tocar esto, cuidado
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
            Log.d("sujetador", "error");
        }
        return null;
    }

    private ArrayList<Coche> processJson(String Jresponse) {
        ArrayList<Coche> listaCoche = new ArrayList<>();
        Log.d("sujetador", "array");
        try {

            JSONArray jsonArray=new JSONArray(Jresponse);
            for(int i=0;i<jsonArray.length();i++){

                JSONObject cocheJson=jsonArray.getJSONObject(i);

                Coche coche=new Coche();
                coche.setId(cocheJson.getInt("id"));
                coche.setCoche(cocheJson.getString("Coche"));
                coche.setTienda(cocheJson.getString("Tienda"));
                coche.setPrecio(cocheJson.getString("Precio"));
                coche.setVelocidad(cocheJson.getInt("Velocidad (km/h)"));
                coche.setImagen(cocheJson.getString("Imagen"));

                listaCoche.add(coche);

            }

        }catch (Exception e){
            Log.d("sujetador", e.getMessage());
            e.printStackTrace();
        }
        return listaCoche;
    }
}
