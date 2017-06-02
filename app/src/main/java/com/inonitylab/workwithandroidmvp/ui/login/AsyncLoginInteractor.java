package com.inonitylab.workwithandroidmvp.ui.login;

import android.os.Handler;

/**
 * Created by ruhul on 6/2/17.
 */
/*
* It helps model to cross application boundaries such as networks and serialization
* */
public class AsyncLoginInteractor implements IAsyncLoginInteractor {
    @Override
    public void validateCredentialAsync(final IOnloginFinishedListener listener, final String userName, final String password) {
        // Moch login.
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
              if ((userName.length()> 3) && (password.length() >  3)){
                    listener.onSuccess();
               }else {
                  listener.onError();
              }
           }
       },2000);
    }
}
