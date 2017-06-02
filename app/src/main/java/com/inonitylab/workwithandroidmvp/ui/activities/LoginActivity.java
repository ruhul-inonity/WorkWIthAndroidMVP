package com.inonitylab.workwithandroidmvp.ui.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.inonitylab.workwithandroidmvp.BuildConfig;
import com.inonitylab.workwithandroidmvp.R;
import com.inonitylab.workwithandroidmvp.ui.login.ILoginView;
import com.inonitylab.workwithandroidmvp.ui.login.LoginPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
* Login activity only knows how to display views and send events and data to presenter.
* It doesn't know about the model
* */
public class LoginActivity extends AppCompatActivity implements ILoginView {

    @Bind(R.id.login_github_username)
    EditText editTextGithubuserName;

    @Bind(R.id.login_fake_password)
    EditText editTextFakePassword;

    LoginPresenter presenter;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        if (BuildConfig.DEBUG){
            editTextGithubuserName.setText("ruhul-inonity");
            editTextFakePassword.setText("bla bla");
        }
        presenter = new LoginPresenter(this);
    }
    @OnClick(R.id.login_submit_button)
    public void loginTapped(View view){
        String email =  editTextGithubuserName.getText().toString();
        String password = editTextFakePassword.getText().toString();
        // Pass user event straight to presenter
        presenter.attemptLogin(email, password);
    }

    @Override
    public void navigateToListActivity() {
       // progressDialog.dismiss();
        Toast.makeText(this, "Login Success!",Toast.LENGTH_SHORT).show();
        // TODO: This seems to have to do with persisting data. Where should we move this?
        Intent i = new Intent(this, RepoListActivity.class);
        i.putExtra("username", editTextGithubuserName.getText().toString());
        startActivity(i);
    }

    @Override
    public void loginFailed() {
      //  progressDialog.dismiss();
        Toast.makeText(this, "Login Invalid: Must be 3 letters or longer", Toast.LENGTH_SHORT).show();
    }
}
