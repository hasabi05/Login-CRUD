package com.example.logincrud.ui;

import com.example.logincrud.data.model.login.ResponseLogin;
import com.example.logincrud.data.network.Api;
import com.example.logincrud.data.network.ApiEndpoint;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter implements LoginInterface.Presenter {

    LoginInterface.View view;
    ApiEndpoint endpoint;

    public LoginPresenter(LoginInterface.View view) {
        this.view = view;
        endpoint = Api.getUrl().create(ApiEndpoint.class);
    }

    @Override
    public void postLogin(String email, String password) {
        view.onLoadingLogin(true);
        endpoint.postLogin(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<ResponseLogin>(){

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(ResponseLogin responseLogin) {
                        view.onLoadingLogin(false);
                        view.onResultLogin(responseLogin);

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onErrorLogin();
                        view.showMessage(e.getMessage());
                    }
                });


    }
}
