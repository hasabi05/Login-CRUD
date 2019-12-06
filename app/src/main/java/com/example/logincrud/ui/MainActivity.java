package com.example.logincrud.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.logincrud.R;
import com.example.logincrud.Session;
import com.example.logincrud.data.model.student.DataStudent;
import com.example.logincrud.data.model.student.ResponseStudent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements MainInterface.View {

    Unbinder unbinder;

    @BindView(R.id.tvNama)
    TextView tvNama;
    @BindView(R.id.tvEmail)
    TextView tvEmail;


    public TextView getTvNama() {
        return tvNama;
    }

    public TextView getTvEmail() {
        return tvEmail;
    }

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

    @Override
    public void onLoadingStudent(Boolean loading) {
        if(loading){
            Toast.makeText(this, "Mengirim Permintaan", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResultStudent(ResponseStudent responseStudent) {


    }

    @Override
    public void onErrorStudent() {
        Toast.makeText(this, "Gagal melakukan login", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }
}
