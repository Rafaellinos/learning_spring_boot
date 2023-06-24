package com.example.springtest.controller;

import com.example.springtest.domain.coach.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {

    private final Coach coach;

    // if one parameter, no need for @Autowired
    @Autowired
    // use for setters -> @Qualifier("SoccerCoach")
    public ControllerTest(@Qualifier("BaseCoach") Coach SoccerCoach) {
        // possible to use SAME VARIABLE NAME to find correct bean
        // or
        // use @Qualifier
        this.coach = SoccerCoach;
    }

    @Value("${message.hello}")
    private String message;

    @GetMapping("/test")
    public String helloWorld() {
        System.out.println("hello");
        return message;
    }

    @GetMapping("/coach")
    public String getCoachDailyWorkout() {
        return this.coach.getDailyWorkout();
    }
}
