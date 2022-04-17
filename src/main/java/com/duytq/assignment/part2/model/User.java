package com.duytq.assignment.part2.model;

import java.io.Serializable;

public class User implements Serializable {
    private String userName;

    private Integer score;

    public User() {

    }
    public User(String name, Integer core) {
        this.userName = name;
        this.score = core;
    }

    public User(String name) {
        this.userName = name;
        this.score = 0;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

}
