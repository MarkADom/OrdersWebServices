package com.marcoDomingues.WebServices.resources;

import com.marcoDomingues.WebServices.entities.User;
import com.marcoDomingues.WebServices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController //responding in /users path.
@RequestMapping(value = "/users")
public class UserResource {

    //service dependency call.
    @Autowired
    private UserService service;

    //requisition type get.
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    //the requisition accepts an id.
    @GetMapping(value = "/{id}")
    //method receiving the above url parameter, to spring recognise
    //the variable we need to call de notation @PathVariable
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.finbById(id);
        return ResponseEntity.ok().body(obj);
    }

}
