package com.hfad.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hfad.assignment.api.ApiInterface;
import com.hfad.assignment.jsonData.Entries;
import com.hfad.assignment.jsonData.Entry;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EntryAdapter entryAdapter;
    private Entry entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        ApiCaller apiCaller = new ApiCaller();
//        apiCaller.start();
//        apiCaller.onResponse();
//        EntryAdapter entryAdapter = new EntryAdapter(MainActivity.this, apiCaller.entries);
//        for(Entry e: apiCaller.entries){
//                        Log.d("Main Activity Log: ", e.getAPI() + ", " +
//                                e.getDescription() + ", " + e.getAuth() + ", " +
//                                e.getHTTPS().toString() + ", " + e.getCors() + ", " +
//                                e.getLink() + ", " + e.getCategory());
//                    }
//        recyclerView.setAdapter(entryAdapter);

        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.publicapis.org/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<Entries> call = apiInterface.getEntries();
        call.enqueue(new Callback<Entries>() {
            @Override
            public void onResponse(Call<Entries> call, Response<Entries> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                    List<Entry> entries = response.body().getEntry();
                    for(Entry e: entries){
                        Log.d("On Response Success: ", e.getAPI() + ", " +
                                e.getDescription() + ", " + e.getAuth() + ", " +
                                e.getHTTPS().toString() + ", " + e.getCors() + ", " +
                                e.getLink() + ", " + e.getCategory());
                    }
                    EntryAdapter entryAdapter = new EntryAdapter(MainActivity.this, entries);
                    recyclerView.setAdapter(entryAdapter);
                }
                else
                    Log.d("On Response: ", "Response not received");
            }

            @Override
            public void onFailure(Call<Entries> call, Throwable t) {
                Log.d("On Failure: ", "No Response");
            }
        });
    }

}