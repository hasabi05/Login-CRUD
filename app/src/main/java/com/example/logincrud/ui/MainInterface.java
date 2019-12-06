package com.example.logincrud.ui;

import com.example.logincrud.data.model.student.ResponseStudent;
import com.example.logincrud.data.model.student.delete.ResponseDelete;

public interface MainInterface {
    interface View {
        void onLoadingStudent(Boolean loading);
        void onResultStudent(ResponseStudent responseStudent);
        void onErrorStudent();

        void onDelete(String nim);
        void onLoadingDelete(boolean loading);
        void onResultDelete(ResponseDelete responseDelete);
        void onErrorDelete();

        void showMessage(String msg);
    }

    interface Presenter {

        void getStudent();

        void deleteStudent(String nim);

    }
}
