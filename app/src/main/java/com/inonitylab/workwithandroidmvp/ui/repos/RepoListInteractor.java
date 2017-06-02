package com.inonitylab.workwithandroidmvp.ui.repos;

import com.inonitylab.workwithandroidmvp.ui.GithubService;
import com.inonitylab.workwithandroidmvp.ui.models.Repo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by ruhul on 6/3/17.
 */

public class RepoListInteractor implements Callback<List<Repo>> {
    private IOnRepoInteractorFinishedListener listener;

    public RepoListInteractor(IOnRepoInteractorFinishedListener listener) {
        this.listener = listener;
    }

    private RestAdapter initRestAdapter(){
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint("https://api.github.com")
                .build();
        return restAdapter;
    }

    public void loadRecentCommits(String username) {
        RestAdapter adapter = initRestAdapter();
        adapter.create(GithubService.class).listRepos(username, this);
    }

    @Override
    public void success(List<Repo> list, Response response) {
        Collections.sort(list, new Comparator<Repo>() {
            @Override
            public int compare(Repo left, Repo right) {
                return (left.stars > right.stars) ? -1 : 1;
            }
        });

        listener.onNetworkSuccess(list, response);
    }
    @Override
    public void failure(RetrofitError error) {
        listener.onNetworkFailure(error);
    }
}
