package com.marcoDomingues.WebServices.services;

import com.marcoDomingues.WebServices.entities.User;
import com.marcoDomingues.WebServices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/*
//registering class as spring component
@Component
*/

//specific notation to register service on layer services
@Service
public class UserService {

    //dependency automatic injected with @Autowired
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User finbById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }



}
