package com.marcoDomingues.WebServices.repositories;

import com.marcoDomingues.WebServices.entities.Category;
import com.marcoDomingues.WebServices.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

//no need to call notation @Repository because it extends from JPARepository who is a Spring component.
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
