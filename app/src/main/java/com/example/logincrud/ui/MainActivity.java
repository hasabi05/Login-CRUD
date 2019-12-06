package com.example.logincrud.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.logincrud.R;
import com.example.logincrud.Session;
import com.example.logincrud.data.model.student.ResponseStudent;
import com.example.logincrud.data.model.student.delete.ResponseDelete;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements MainInterface.View {

    Unbinder unbinder;
    MainPresenter presenter;

    @BindView(R.id.tvNama)
    TextView tvNama;
    @BindView(R.id.tvEmail)
    TextView tvEmail;
    @BindView(R.id.rvMain)
    RecyclerView rvMain;
    @BindView(R.id.srMain)
    SwipeRefreshLayout srMain;


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

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Data Mahasiswa");
            getSupportActionBar().setElevation(0);
        }

        unbinder = ButterKnife.bind(this);

        tvNama.setText(Session.getInstance(getApplicationContext()).getString(Session.name));
        tvEmail.setText(Session.getInstance(getApplicationContext()).getString(Session.email));

        presenter = new MainPresenter(this);
        presenter.getStudent();
        srMain.setDistanceToTriggerSync(220);

        srMain.setOnRefreshListener(() -> presenter.getStudent());
    }


    @OnClick(R.id.btnLogout)
    void OnLogout() {
        Session.getInstance(getApplicationContext()).logout();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();

    }


    @Override
    public void onLoadingStudent(Boolean loading) {
        if (loading) {
            srMain.setRefreshing(true);
        } else {
            srMain.setRefreshing(false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_search:
                Toast.makeText(this,"Maafa fitur belum ada",Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResultStudent(ResponseStudent responseStudent) {
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setAdapter(new MainAdapter(this, responseStudent.getData(),this));


    }

    @Override
    public void onErrorStudent() {
        Toast.makeText(this, "Gagal mengambil data", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDelete(String nim) {
        presenter.deleteStudent(nim);

    }

    @Override
    public void onLoadingDelete(boolean loading) {
        if (loading) {
            srMain.setRefreshing(true);
        } else {
            srMain.setRefreshing(false);
        }

    }

    @Override
    public void onResultDelete(ResponseDelete responseDelete) {
        presenter.getStudent();

    }

    @Override
    public void onErrorDelete() {
        Toast.makeText(this, "Gagal menghapus data", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

}
