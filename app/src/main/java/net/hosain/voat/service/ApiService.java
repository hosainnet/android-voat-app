package net.hosain.voat.service;

import net.hosain.voat.data.Discussion;
import net.hosain.voat.data.Subverse;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface ApiService {

    @GET("/api/v1/v/{subverse}")
    void listSubmissions(@Path("subverse") String subverse, Callback<Subverse> callback);

    @GET("/api/v1/v/{subverse}/{submissionID}/comments")
    void listComments(@Path("subverse") String subverse, @Path("submissionID") int submissionID, Callback<Discussion> callback);

    @GET("/api/defaultsubverses")
    void listDefaultSubverses(Callback<List<String>> callback);
}
