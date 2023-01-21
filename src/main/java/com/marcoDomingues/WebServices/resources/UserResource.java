package com.marcoDomingues.WebServices.resources;

import com.marcoDomingues.WebServices.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController //responding in /users path
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L,"Maria", "maria@gmail.com","968538383","y5g67f");
        return ResponseEntity.ok().body(u);
    }

}
