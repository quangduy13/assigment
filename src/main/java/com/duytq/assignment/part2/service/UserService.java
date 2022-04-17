package com.duytq.assignment.part2.service;

import com.duytq.assignment.part2.model.User;

import java.util.List;

public interface UserService {
    User getUser(String userName);
    List<User> readInfo();
    User findUser(List<User> users, String userName);
}
