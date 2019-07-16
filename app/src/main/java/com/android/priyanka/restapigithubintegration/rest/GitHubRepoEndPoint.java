package com.android.priyanka.restapigithubintegration.rest;

import com.android.priyanka.restapigithubintegration.model.GitHubRepo;
import com.android.priyanka.restapigithubintegration.model.GitHubUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubRepoEndPoint {

    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> getRepo(@Path("user") String name);
}
