package com.hfad.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hfad.assignment.api.ApiCaller;
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
        ApiCaller apiCaller = new ApiCaller();
        EntryAdapter entryAdapter = new EntryAdapter(MainActivity.this, apiCaller.entries);
//        for(Entry e: apiCaller.entries){
//            Log.d("Main Activity Log: ", e.getAPI() + ", " +
//                    e.getDescription() + ", " + e.getAuth() + ", " +
//                    e.getHTTPS().toString() + ", " + e.getCors() + ", " +
//                    e.getLink() + ", " + e.getCategory());
//        }
        recyclerView.setAdapter(entryAdapter);
    }

}