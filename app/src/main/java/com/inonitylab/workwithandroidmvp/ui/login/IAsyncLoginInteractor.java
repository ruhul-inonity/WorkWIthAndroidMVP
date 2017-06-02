package com.inonitylab.workwithandroidmvp.ui.login;

/**
 * Created by ruhul on 6/2/17.
 */

public interface IAsyncLoginInteractor {
    void validateCredentialAsync(IOnloginFinishedListener listener, String userName, String password);
}
