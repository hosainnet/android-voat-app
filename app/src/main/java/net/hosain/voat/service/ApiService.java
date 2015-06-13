package net.hosain.voat.service;

import net.hosain.voat.data.Subverse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface ApiService {

    @GET("/api/v1/v/{subverse}")
    void listThreads(@Path("subverse") String subverse, Callback<Subverse> callback);

}
