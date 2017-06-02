package com.inonitylab.workwithandroidmvp.ui;

import com.inonitylab.workwithandroidmvp.ui.models.Repo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by ruhul on 6/3/17.
 */

public interface GithubService {
    @GET("/users/{user}/repos")
    void listRepos(@Path("user") String user, Callback<List<Repo>> callback);
}
