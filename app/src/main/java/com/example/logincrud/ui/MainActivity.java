package com.example.logincrud.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.logincrud.R;
import com.example.logincrud.Session;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    Unbinder unbinder;

    @BindView(R.id.tvNama)
    TextView tvNama;
    @BindView(R.id.tvEmail)
    TextView tvEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unbinder = ButterKnife.bind(this);

        tvNama.setText(Session.getInstance(getApplicationContext()).getString(Session.name));
        tvEmail.setText(Session.getInstance(getApplicationContext()).getString(Session.email));
    }

    @OnClick(R.id.btnLogout)
    void OnLogout(){
        Session.getInstance(getApplicationContext()).logout();
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        finish();

    }
}
