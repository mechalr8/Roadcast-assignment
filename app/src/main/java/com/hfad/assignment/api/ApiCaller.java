package com.hfad.assignment.api;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hfad.assignment.jsonData.Entries;
import com.hfad.assignment.jsonData.Entry;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCaller implements Callback<Entries> {

    String endPointUrl = "https://api.publicapis.org/";
    public List<Entry> entries;

    public void start(){
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(endPointUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<Entries> call = apiInterface.getEntries();
        call.enqueue(this);
    }

    @Override
    public void onResponse(@NonNull Call<Entries> call, Response<Entries> response) {
        if(response.isSuccessful()){
            assert response.body() != null;
            entries = response.body().getEntry();
            for(Entry e: entries){
                Log.d("On Response Success: ", e.getAPI() + ", " +
                        e.getDescription() + ", " + e.getAuth() + ", " +
                        e.getHTTPS().toString() + ", " + e.getCors() + ", " +
                        e.getLink() + ", " + e.getCategory());
            }
        }
        else
            Log.d("On Response: ", "Response not received");
    }

    @Override
    public void onFailure(Call<Entries> call, Throwable t) {
        Log.d("On Failure: ", "No Response");
    }
}
