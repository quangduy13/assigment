package com.duytq.assignment.part2.service;

import com.duytq.assignment.part2.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public User getUser(String userName) {
        List<User> users = readInfo();
        return findUser(users, userName);
    }
    @Override
    public List<User> readInfo() {
        List<User> users = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            BufferedReader reader = new BufferedReader(new FileReader("score.json"));
            String line = reader.readLine();
            StringBuilder sb = new StringBuilder();

            while (line != null) {
                sb.append(line).append("\n");
                line = reader.readLine();
            }
            reader.close();
            String a = sb.toString();
            users =  objectMapper.readValue(a, new TypeReference<List<User>>(){});
            int s = 0;
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return users;
    }
    @Override
    public User findUser(List<User> users, String userName){
        for (User user : users){
            if (user.getUserName().equals(userName))
                return user;
        }
        return new User(userName);
    }
}
