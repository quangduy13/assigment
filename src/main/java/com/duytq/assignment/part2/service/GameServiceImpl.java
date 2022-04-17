package com.duytq.assignment.part2.service;

import com.duytq.assignment.part2.model.User;
import com.duytq.assignment.part2.model.res.UserRes;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    private static final Integer MAX_POINT = 100;
    private static final Integer MIN_POINT = 1;
    @Autowired
    private UserService userService;

    @Override
    public UserRes insertPlayer(String userName) {
        User user = new User(userName);
        List<User> users = userService.readInfo();
        UserRes us = new UserRes();
        if (checkDuplicate(users, userName))
            us.setMessage("User is existed! Please enter other name");
        else {
            try {
                users.add(user);
                writeFile(users);
                us.setMessage("Success");
                us.setUser(user);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return us;
    }

    @Override
    public User showLeaderBoard()  {
        List<User> users = userService.readInfo();
        if(users.size() > 0){
            Comparator<User> compareById =
                    (User o1, User o2) -> o1.getScore().compareTo( o2.getScore() );
            Collections.sort(users, compareById.reversed());
            return users.get(0);
        }

        return new User();
    }

    @Override
    public UserRes randomPoint(String userName) {
        UserRes userRes = new UserRes();
        int randomNumber = (int)(Math.random() * (MAX_POINT - MIN_POINT) + MIN_POINT);
        List<User> users = userService.readInfo();
        User user = userService.findUser(users, userName);
        int index = users.indexOf(user);
        int score =user.getScore();
        user.setScore(score + randomNumber);
        if (index != -1){
            userRes.setMessage("User is not existed! Please enter name before play");
        } else
            users.add(user);
        try{
            writeFile(users);
        } catch (Exception e){
            e.printStackTrace();
        }
        userRes.setUser(user);
        return userRes;
    }

    private boolean checkDuplicate(List<User> users, String userName){
        for (User user : users){
            if (user.getUserName().equals(userName))
                return true;
        }
        return false;
    }

    public void writeFile(List<User> users) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        FileWriter writer  = new FileWriter("score.json");
        mapper.writeValue(writer, users );
        writer.close();
    }
}
