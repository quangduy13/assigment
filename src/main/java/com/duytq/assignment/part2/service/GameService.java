package com.duytq.assignment.part2.service;

import com.duytq.assignment.part2.model.User;
import com.duytq.assignment.part2.model.res.UserRes;

public interface GameService {
    UserRes insertPlayer(String userName);

    User showLeaderBoard();

    UserRes randomPoint(String userName);
}
