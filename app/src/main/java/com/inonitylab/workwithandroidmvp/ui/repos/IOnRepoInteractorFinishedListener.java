package com.inonitylab.workwithandroidmvp.ui.repos;

import com.inonitylab.workwithandroidmvp.ui.models.Repo;
import java.util.List;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by ruhul on 6/2/17.
 */

public interface IOnRepoInteractorFinishedListener {
    void onNetworkSuccess(List<Repo> list, Response response);
    void onNetworkFailure(RetrofitError error);
}
