package com.inonitylab.workwithandroidmvp.ui.repos;

import com.inonitylab.workwithandroidmvp.ui.models.Repo;

import java.util.List;

import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by ruhul on 6/3/17.
 */

public class RepoListPresenter implements IRepolistPresenter, IOnRepoInteractorFinishedListener {
    private IRepoListView view;
    private RepoListInteractor interactor;

    public RepoListPresenter(IRepoListView view) {
        this.view = view;
        this.interactor = new RepoListInteractor(this); // pass in the InteractorListener
    }

    @Override
    public void loadCommits(String username) {
        interactor.loadRecentCommits(username);
    }

    @Override
    public void onNetworkSuccess(List<Repo> list, Response response) {
        view.onReposLoadedSuccess(list, response);
    }

    @Override
    public void onNetworkFailure(RetrofitError error) {
        view.onReposLoadedFailure(error);
    }
}
