package com.hfad.assignment.api;

import com.hfad.assignment.jsonData.Entries;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("entries")
    Call<Entries> getEntries();
}
