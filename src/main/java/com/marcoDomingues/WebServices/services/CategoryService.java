package com.marcoDomingues.WebServices.services;

import com.marcoDomingues.WebServices.entities.Category;
import com.marcoDomingues.WebServices.entities.User;
import com.marcoDomingues.WebServices.repositories.CategoryRepository;
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
public class CategoryService {

    //dependency automatic injected with @Autowired
    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category finbById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }

}
