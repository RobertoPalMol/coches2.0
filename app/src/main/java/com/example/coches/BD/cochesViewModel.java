package com.example.coches.BD;

//ESTA CLASE NO VA
/*
import android.app.Application;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.coches.Api.Coche;
import com.example.coches.Api.cochesApi;

import java.util.ArrayList;
import java.util.List;

public class cochesViewModel extends AndroidViewModel {
        private final Application app;
        private final AppDatabase appDatabase;
        private final cocheDao movieDao;
        private LiveData<List<Coche>> coches;

        public cochesViewModel(Application application) {
            super(application);

            this.app = application;
            this.appDatabase = AppDatabase.getDatabase(
                    this.getApplication());                    (1)
            this.movieDao = appDatabase.getCocheDao();     (2)
        }

        public LiveData<List<Coche>> getCoches() {
            return movieDao.getCoches();                   (3)
        }


        public void reload() {                             (4)
            // do async operation to fetch users
            RefreshDataTask task = new RefreshDataTask();
            task.execute();
        }

        private class RefreshDataTask extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... voids) {

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(
                        app.getApplicationContext()
                );
                String pais = preferences.getString("pais", "es");
                String tipusConsulta = preferences.getString(
                        "tipus_consulta", "vistes"
                );

                cochesApi api = new cochesApi();
                ArrayList<Coche> result;
                    result = api.getCoches();


                movieDao.deleteCoches();                    (5)
                movieDao.addCoches(result);                 (6)

                return null;
            }

        }

    }

 */



