package com.example.springtest.domain.coach.impl;

import com.example.springtest.domain.coach.Coach;
import org.springframework.stereotype.Service;

@Service("SoccerCoach")
public class SoccerCoachImpl implements Coach {
    @Override
    public String getDailyWorkout() {
        return "kick some ball idiot";
    }
}
