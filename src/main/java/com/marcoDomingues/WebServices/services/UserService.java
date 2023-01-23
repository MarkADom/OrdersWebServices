package com.marcoDomingues.WebServices.services;

import com.marcoDomingues.WebServices.entities.User;
import com.marcoDomingues.WebServices.repositories.UserRepository;
import com.marcoDomingues.WebServices.services.exceptions.ResourceNotFoundException;
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
        //tries to launch get if not possible throws exceptrion
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    //saving user in database
    public User insert(User obj){
       return repository.save(obj);
    }

    //deleting user in database
    public void delete(Long id){
        repository.deleteById(id);
    }

    //prepares the monitored object to be altered and after updated.
    public User update(Long id, User obj){
        User entity = repository.getOne(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
