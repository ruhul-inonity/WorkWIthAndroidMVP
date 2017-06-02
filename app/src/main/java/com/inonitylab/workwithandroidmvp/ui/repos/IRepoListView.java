package com.inonitylab.workwithandroidmvp.ui.repos;

import com.inonitylab.workwithandroidmvp.ui.models.Repo;

import java.util.List;

import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by ruhul on 6/2/17.
 */

public interface IRepoListView {
    void onReposLoadedSuccess(List<Repo> list, Response response);
    void onReposLoadedFailure(RetrofitError error);
}
