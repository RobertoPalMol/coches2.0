package com.example.coches.BD;

//ESTA CLASE NO VA

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
        private final cocheDao cocheDao;

        public cochesViewModel(Application application) {
            super(application);

            this.app = application;
            this.appDatabase = AppDatabase.getDatabase(
                    this.getApplication());
            this.cocheDao = appDatabase.getCocheDao();
        }

        public LiveData<List<Coche>> getCoches() {
            return cocheDao.getCoches();
        }


        public void reload() {
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

                cochesApi api = new cochesApi();
                ArrayList<Coche> result;
                    result = api.getCoches();


                cocheDao.deleteCoches();
                cocheDao.addCoches(result);

                return null;
            }

        }

    }





