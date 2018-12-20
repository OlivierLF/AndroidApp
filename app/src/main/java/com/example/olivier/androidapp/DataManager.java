package com.example.olivier.androidapp;

import android.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataManager {

    //this instance will be used through the entire application to store data
    private static DataManager INSTANCE;

    private List<Pair<String, String>> tasks;

    public DataManager() {
        //initialize an empty arrayList in constructor
        tasks = new ArrayList<>();
    }

    public static DataManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }

    public List<Pair<String, String>> getTasks() {
        return tasks;
    }

    public void addTask(Pair<String, String> task){
        this.tasks.add(task);
    }
}

