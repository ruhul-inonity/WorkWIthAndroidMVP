package com.inonitylab.workwithandroidmvp.ui.login;

/**
 * Created by ruhul on 6/2/17.
 */

public class LoginPresenter implements ILoginPresenter,IOnloginFinishedListener{

    private ILoginView view;
    private AsyncLoginInteractor interactor;

    public LoginPresenter(ILoginView loginView){
        this.view = loginView;
        this.interactor = new AsyncLoginInteractor();
    }

    @Override
    public void attemptLogin(String userName, String password) {
        interactor.validateCredentialAsync(this, userName,password);
    }

    @Override
    public void onError() {
        view.loginFailed();
    }

    @Override
    public void onSuccess() {
        view.navigateToListActivity();
    }
}
