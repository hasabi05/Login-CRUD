package com.example.logincrud.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.logincrud.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LoginActivity extends AppCompatActivity {

    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        unbinder = ButterKnife.bind(this);

    }

    @OnClick(R.id.btnAkunBaru)
    void onSubmit(){
        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(intent);

    }
}
