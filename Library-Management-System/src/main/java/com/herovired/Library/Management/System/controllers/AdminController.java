package com.herovired.Library.Management.System.controllers;


import com.herovired.Library.Management.System.models.UserData;
import com.herovired.Library.Management.System.repositories.UserDataRepository;
import com.herovired.Library.Management.System.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDataRepository userDataRepository;


    @GetMapping("/test-admin")
    public String testAdmin(){
        return "Testing admin";
    }

    @PostMapping("/block-user/{username}")
    public UserData blockUser(@PathVariable String username){
        var userDataObject = userDataRepository.findByUsername(username);
        userDataObject.setBlocked(true);
        return userDataRepository.save(userDataObject);
    }

    @PostMapping("/unblock-user/{username}")
    public UserData unblockUser(@PathVariable String username){
        var userDataObject = userDataRepository.findByUsername(username);
        userDataObject.setBlocked(false);
        return userDataRepository.save(userDataObject);
    }


    // update the cost of a book , block/unblock a book
}
