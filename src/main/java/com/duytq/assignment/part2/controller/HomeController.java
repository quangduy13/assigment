package com.duytq.assignment.part2.controller;

import com.duytq.assignment.part2.model.User;
import com.duytq.assignment.part2.service.GameService;
import com.duytq.assignment.part2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    UserService userService;

    @Autowired
    GameService gameService;

    @GetMapping
    public String getHome() {
        return "home";
    }

    @GetMapping("/play")
    public String getUser(@RequestParam("userName") String userName,
                          Model model) {
        User user = userService.getUser(userName);
        model.addAttribute("messages", gameService.showLeaderBoard());
        model.addAttribute("userName", userName);
        model.addAttribute("score",user.getScore());
        return "player";
    }
}
