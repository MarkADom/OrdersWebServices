package com.marcoDomingues.WebServices.services;

import com.marcoDomingues.WebServices.entities.Order;
import com.marcoDomingues.WebServices.entities.User;
import com.marcoDomingues.WebServices.repositories.OrderRepository;
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
public class OrderService {

    //dependency automatic injected with @Autowired
    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order finbById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }



}
