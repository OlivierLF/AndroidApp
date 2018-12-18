package com.example.olivier.androidapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataManager {
    private static DataManager INSTANCE;

    private String textDisplay;
    private List<String> tasks;

    public DataManager(){
        textDisplay = new String();
        tasks = new ArrayList<>();
    }

    public static DataManager getInstance(){
        if (INSTANCE == null){
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

    public List<String> getTasks() {
        return tasks;
    }

    public void setTasks(List<String> tasks) {
        this.tasks = tasks;
    }

    public void addTask(String task){
        this.tasks.add(task);
    }
}
