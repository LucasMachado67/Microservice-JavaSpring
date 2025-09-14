package com.ms.user.services;

import com.ms.user.models.User;
import com.ms.user.producers.UserProducer;
import com.ms.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProducer userProducer;

    @Transactional
    public User save(User user){
        user = userRepository.save(user);
        userProducer.publishMessageEmail(user);
        return user;
    }
}
