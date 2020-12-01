package com.cookandroid.specialscheduler;

import java.text.SimpleDateFormat;

public class TodoList {

    private String contents;
    public Double progress;
    private SimpleDateFormat deadline = new SimpleDateFormat("yyyyMMdd");

    public TodoList(String contents, SimpleDateFormat deadline) {
        this.contents = contents;
        this.deadline = deadline;
    }

}
