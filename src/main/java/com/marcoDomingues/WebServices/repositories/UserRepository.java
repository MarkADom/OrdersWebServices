package com.marcoDomingues.WebServices.repositories;

import com.marcoDomingues.WebServices.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
