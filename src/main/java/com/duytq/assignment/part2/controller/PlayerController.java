package com.duytq.assignment.part2.controller;

import com.duytq.assignment.part2.model.Player;
import com.duytq.assignment.part2.model.User;
import com.duytq.assignment.part2.model.res.UserRes;
import com.duytq.assignment.part2.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private GameService gameService;

    @PostMapping(value = {"/add"})
    public ResponseEntity<?> addPlayer(@RequestBody Player player){
        UserRes userRes = gameService.insertPlayer(player.getPlayerName());
        return ResponseEntity.ok(userRes);
    }

    @PostMapping(value = {"/random"})
    public ResponseEntity<?> random(@RequestBody Player player){
        UserRes userRes = gameService.randomPoint(player.getPlayerName());
        return ResponseEntity.ok(userRes);
    }
}
