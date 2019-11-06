package com.agan.controller;

import com.agan.entity.User;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/index")
    public Object hello(){
        return "hello springboot-redis";
    }

    @PostMapping("/user")
    public Object addUser(@RequestBody User user){
        stringRedisTemplate.opsForValue().set("user", JSON.toJSONString(user));
        return "success";
    }

    @GetMapping("/user")
    public User getUser(){
        return JSON.parseObject(stringRedisTemplate.opsForValue().get("user"), User.class);
    }

    @PostMapping("/users")
    public Object addUsers(@RequestBody List<User> users){
        stringRedisTemplate.opsForList().rightPushAll("users", users.stream().map(JSON::toJSONString).collect(Collectors.toList()));
        return "success";
    }

    @GetMapping("/users")
    public Object getUsers(){
        List<User> users = new ArrayList<>();
        while (true){
            User user = JSON.parseObject(stringRedisTemplate.opsForList().leftPop("users"), User.class);
            if (Objects.isNull(user)) {
                break;
            }
            users.add(user);
        }
        return users;
    }

}
