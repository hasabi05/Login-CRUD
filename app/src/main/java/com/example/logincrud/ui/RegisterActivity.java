package com.example.logincrud.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.logincrud.R;
import com.example.logincrud.Session;
import com.example.logincrud.data.model.register.ResponseRegister;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class RegisterActivity extends AppCompatActivity implements RegisterInterface.View {

    Unbinder unbinder;
    @BindView(R.id.etNama)
    EditText etNama;
    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.etPassword)
    EditText etPassword;

    RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setTitle("Buat Akun baru");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        unbinder = ButterKnife.bind(this);


    }


    @OnClick(R.id.btnRegister)
    void onSubmit() {
        if (getName().isEmpty() || getEmail().isEmpty() || getPassword().isEmpty()) {
            Toast.makeText(this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }else {
            presenter.postRegister(getName(), getEmail(), getPassword());
        }
    }

    @Override
    public void onResultRegister(ResponseRegister responseRegister) {
        Toast.makeText(this, responseRegister.getMessage(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        //set session
        Session.getInstance(getApplicationContext()).putString((Session.email), getEmail());
        Session.getInstance(getApplicationContext()).putString((Session.name), getName());


        startActivity(intent);
        finish();

    }

    @Override
    public void onErrorRegister() {
        Toast.makeText(this, "Gagal melakukan registrasi", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLoadingRegister(boolean loading) {
        if(loading){
            Toast.makeText(this, "Mengirim Permintaan", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getName() {
        return etNama.getText().toString();
    }

    @Override
    public String getEmail() {
        return etEmail.getText().toString();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }
}
