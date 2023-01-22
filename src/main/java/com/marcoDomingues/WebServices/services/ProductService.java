package com.marcoDomingues.WebServices.services;

import com.marcoDomingues.WebServices.entities.Product;
import com.marcoDomingues.WebServices.entities.User;
import com.marcoDomingues.WebServices.repositories.ProductRepository;
import com.marcoDomingues.WebServices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

/*
//registering class as spring component
@Component
*/

//specific notation to register service on layer services
@Service
public class ProductService {

    //dependency automatic injected with @Autowired
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product finbById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }



}
