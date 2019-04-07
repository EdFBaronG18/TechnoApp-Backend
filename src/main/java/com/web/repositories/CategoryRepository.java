package com.web.repositories;

import org.springframework.data.repository.CrudRepository;

import com.web.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

}
