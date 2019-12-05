package com.example.logincrud.ui;

import com.example.logincrud.data.model.login.ResponseLogin;
import com.example.logincrud.data.model.register.ResponseRegister;

public interface LoginInterface {
    interface View{

        //Digunakan untuk menunjukan proses dari thread yang berhubungan dengan restAPI
        void onLoadingLogin(boolean loading);
        void onResultLogin(ResponseLogin responseLogin);
        void onErrorLogin();

        //pesan error
        void showMessage(String msg);
        //get attribut dari view
        String getEmail();
        String getPassword();
    }

    interface Presenter {
        void postLogin(String email, String password);

    }
}
