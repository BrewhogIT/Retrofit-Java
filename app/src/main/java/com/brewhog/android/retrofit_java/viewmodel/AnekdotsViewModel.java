package com.brewhog.android.retrofit_java.viewmodel;

import android.util.Log;

import com.brewhog.android.retrofit_java.api.Controller;
import com.brewhog.android.retrofit_java.adapters.AnekdotAdapter;
import com.brewhog.android.retrofit_java.pojo.Anekdot;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnekdotsViewModel extends ViewModel {
    private static final String TAG = "AnekdotsViewModel";
    private AnekdotAdapter mAdapter;
    private ArrayList<Anekdot> mAnekdots;

    public AnekdotsViewModel(AnekdotAdapter adapter) {
        mAdapter = adapter;
        mAnekdots = new ArrayList<>();
        loadAnekdotsFromServer();
    }

    public AnekdotAdapter getAdapter() {
        return mAdapter;
    }

    public void showAnekdots(){
        mAdapter.setAnekdots(mAnekdots);
    }

    private void loadAnekdotsFromServer(){
        new Controller().getApiArguments().getAnekdots("new anekdot",10)
                .enqueue(new Callback<List<Anekdot>>() {
                    @Override
                    public void onResponse(Call<List<Anekdot>> call, Response<List<Anekdot>> response) {
                        mAnekdots.addAll(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Anekdot>> call, Throwable t) {
                        Log.e(TAG,"anekdots loading was failed");
                    }
                });

    }
}
