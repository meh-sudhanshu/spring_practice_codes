//package com.example.demo.service;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Random;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserDao userDao;
//
//    @Scheduled(fixedRate = 5000)
//    private  void add2Db(){
//        User user = new User();
//        user.setName("user"+new Random().nextInt(374483));
//        userDao.save(user);
//        System.out.println("add service called in"+ new Date().toString());
//    }
//
//    @Scheduled(cron = "0/15 * * * * *")
//    public void fetchDbJob(){
//        List<User> users = userDao.findAll();
//        System.out.println("fetch service called"+new Date().toString());
//        System.out.println("number os records fetched"+users.size());
//    }
//
//
//}
