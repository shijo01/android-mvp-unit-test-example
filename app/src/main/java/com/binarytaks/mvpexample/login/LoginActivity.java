package com.binarytaks.mvpexample.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.binarytaks.mvpexample.main.MainActivity;
import com.binarytaks.mvpexample.R;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText mUserName;
    private EditText mPassword;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUserName = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);

        mLoginPresenter = new LoginPresenter(this, new LoginService());
    }

    public void onLoginClicked(View view) {
        mLoginPresenter.onLoginClicked();
    }

    @Override
    public String getUserName() {
        return mUserName.getText().toString();
    }

    @Override
    public void showUserNameError(int resId) {
        mUserName.setError(getString(resId));
    }

    @Override
    public String getPassword() {
        return mPassword.getText().toString();
    }

    @Override
    public void showPasswordError(int resId) {
        mPassword.setError(getString(resId));
    }

    @Override
    public void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    @Override
    public void showLoginError(int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }
}
