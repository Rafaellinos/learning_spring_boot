package com.rafaellinos.demo.resources;

import com.rafaellinos.demo.domain.User;
import com.rafaellinos.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    // or @GetMapping
    public ResponseEntity<List<User>> findAll() {
//        User maria = new User("1", "Maria Silva", "maria@gmail.com");
//        User alex = new User("1", "Alex Green", "alex@gmail.com");
//        List<User> list = new ArrayList<>();
        List<User> list = service.findAll();
        //list.addAll(Arrays.asList(maria, alex));
        //return list;
        return ResponseEntity.ok().body(list);
    }
}
