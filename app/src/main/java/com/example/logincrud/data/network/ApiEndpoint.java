package com.example.logincrud.data.network;


import com.example.logincrud.data.model.login.ResponseLogin;
import com.example.logincrud.data.model.register.ResponseRegister;
import com.example.logincrud.data.model.student.ResponseStudent;
import com.example.logincrud.data.model.student.delete.ResponseDelete;

import io.reactivex.Single;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ApiEndpoint {
    @FormUrlEncoded
    @POST("register")
    Single<ResponseRegister> postRegister(
            @Field("email") String email,
            @Field("name") String name,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("login")
    Single<ResponseLogin> postLogin(
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("students")
    Single<ResponseStudent> getStudent(


    );

    @DELETE("students/{nim}")
    Single<ResponseDelete> deleteStudent(
            @Path("nim") String nim
    );
}
