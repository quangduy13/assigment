package com.duytq.assignment.part2.model.res;

import com.duytq.assignment.part2.model.User;

public class UserRes {
    private String message;

    private User user;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
