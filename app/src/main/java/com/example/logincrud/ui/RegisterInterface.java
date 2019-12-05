package com.example.logincrud.ui;

import com.example.logincrud.data.model.register.ResponseRegister;

public interface RegisterInterface {
    interface View{
        void onResultRegister(ResponseRegister responseRegister);
        void onErrorRegister();
        void onLoadingRegister(boolean loading);
        void showMessage(String msg);
        String getName();
        String getEmail();
        String getPassword();
    }
    interface Presenter{
        void postRegister(String name, String email, String password);
    }
}
