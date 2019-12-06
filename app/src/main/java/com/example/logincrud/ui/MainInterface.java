package com.example.logincrud.ui;

import com.example.logincrud.data.model.student.ResponseStudent;

public interface MainInterface {
    interface View {
        void onLoadingStudent(Boolean loading);

        void onResultStudent(ResponseStudent responseStudent);

        void onErrorStudent();

        void showMessage(String msg);
    }

    interface Presenter {

        void getStudent();

    }
}
