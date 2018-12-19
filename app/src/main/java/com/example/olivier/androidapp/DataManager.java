package com.example.olivier.androidapp;

import android.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataManager {
    private static DataManager INSTANCE;

    private String textDisplay;
    private List<Pair<String, String>> tasks;

    public DataManager() {
        textDisplay = new String();
        tasks = new ArrayList<>();
    }

    public static DataManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }

    public String getTextDisplay() {
        return textDisplay;
    }

    public void setTextDisplay(String textDisplay) {
        this.textDisplay = textDisplay;
    }

    public List<Pair<String, String>> getTasks() {
        return tasks;
    }

    public void setTasks(List<Pair<String, String>> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Pair<String, String> task){
        this.tasks.add(task);
    }
}

