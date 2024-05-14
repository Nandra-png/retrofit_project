package com.example.retrofit;

import com.example.retrofit.TeamResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("search_all_teams.php")
    Call<TeamResponse> getTeams(@Query("l") String league);
}
