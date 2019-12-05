package com.example.logincrud.data.model.register;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResponseRegister implements Serializable {
    @SerializedName("status")
    @Expose
    public Boolean status;
    @SerializedName("message")
    @Expose
    public String message;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataStudent getData() {
        return data;
    }

    public void setData(DataStudent data) {
        this.data = data;
    }

    @SerializedName("data")
    @Expose
    public DataStudent data;
}
