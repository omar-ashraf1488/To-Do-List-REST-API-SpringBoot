package com.oa.taskmangementapp.model;

import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
public class Todo {
    private int id;
    private String description;
    private Date targetDate;

    public Todo(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Todo(int id, String description, Date targetDate) {
        this.id = id;
        this.description = description;
        this.targetDate = targetDate;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }
}
