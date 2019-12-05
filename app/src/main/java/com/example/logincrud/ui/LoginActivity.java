package com.example.logincrud.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.logincrud.R;
import com.example.logincrud.Session;
import com.example.logincrud.data.model.login.DataStudent;
import com.example.logincrud.data.model.login.ResponseLogin;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LoginActivity extends AppCompatActivity implements LoginInterface.View{

    Unbinder unbinder;
    @BindView(R.id.etEmailLogin)
    EditText etEmail;
    @BindView(R.id.etPasswordLogin)
    EditText etPassword;
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        unbinder = ButterKnife.bind(this);
        presenter = new LoginPresenter(this);

    }
    @OnClick(R.id.btnLogin) void onLogin(){
        if (getEmail().isEmpty() || getPassword().isEmpty()) {
            Toast.makeText(this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }else {
            presenter.postLogin(getEmail(), getPassword());
        }

    }


    @OnClick(R.id.btnAkunBaru)
    void onSubmit(){
        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(intent);

    }

    @Override
    public void onLoadingLogin(boolean loading) {
        if(loading){
            Toast.makeText(this, "Mengirim Permintaan", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onResultLogin(ResponseLogin responseLogin) {
        DataStudent data = responseLogin.getData();
        Toast.makeText(this, responseLogin.getMessage(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        //set session
        Session.getInstance(getApplicationContext()).putString((Session.email), getEmail());
        Session.getInstance(getApplicationContext()).putString((Session.name), data.getName());


        startActivity(intent);
        finish();

    }

    @Override
    public void onErrorLogin() {
        Toast.makeText(this, "Gagal melakukan login", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public String getEmail() {
        return etEmail.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }
}
