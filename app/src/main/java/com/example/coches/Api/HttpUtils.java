package com.example.coches.Api;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class HttpUtils {
    public static String get(String direccionURL) throws IOException {
        URL url = new URL(direccionURL);
        String response = null;
        Log.d("calzones", "get");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            Log.d("calzones", "pre try");
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Log.d("calzones", "try");
            response = readStream(in);
        } catch (Exception e){
            Log.d("calzones", e.getMessage());
        }finally {
            urlConnection.disconnect();
        }
        return response;
    }

    private static String readStream(InputStream in) throws IOException {
        InputStreamReader is = new InputStreamReader(in);
        BufferedReader rd = new BufferedReader(is);
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();
        return response.toString();
    }
}

