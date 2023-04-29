package ru.netology.javacore;

import com.google.gson.annotations.SerializedName;

public class Request {
    enum Operation {
        @SerializedName("ADD") ADD,
        @SerializedName("REMOVE") REMOVE,
        @SerializedName("RESTORE") RESTORE;
    }
    protected Operation type;
    protected String task = "";

    public Request(Operation type, String task) {
        this.type = type;
        this.task = task;
    }
    public Request(Operation type){
        this.type = type;
    }
}
