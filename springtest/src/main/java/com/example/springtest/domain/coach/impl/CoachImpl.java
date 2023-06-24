package com.example.springtest.domain.coach.impl;

import com.example.springtest.domain.coach.Coach;
import com.example.utils.PrintSomething;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service("BaseCoach")
class CoachImpl implements Coach {

    public CoachImpl () {
        System.out.println("initializing Coach impl");
    }

    private PrintSomething printSomething;

    @Autowired
    @Lazy
    CoachImpl (PrintSomething p) {
        this.printSomething = p;
    }

    @Override
    public String getDailyWorkout() {
        printSomething.pprintSomething("ahhhhh");
        return "run 5k today";
    }
}