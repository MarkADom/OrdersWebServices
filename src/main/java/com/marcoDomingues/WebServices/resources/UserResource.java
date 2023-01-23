package com.marcoDomingues.WebServices.resources;

import com.marcoDomingues.WebServices.entities.User;
import com.marcoDomingues.WebServices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    //the variable we need to call notation @PathVariable
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.finbById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<User> insert (@RequestBody User obj){
        obj = service.insert(obj);
        //creating URI to the path of new resource insert
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    //using "Void" because the method don´t returns anything
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok(obj);
    }
}
