package com.ms.user.controllers;

import com.ms.user.dtos.UserRecordDto;
import com.ms.user.models.User;
import com.ms.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRecordDto userRecordDto){
        var userModel = new User();
        //BeanUtils está pegando o record DTO e transcrevendo para a classe model user
        BeanUtils.copyProperties(userRecordDto, userModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }
}
