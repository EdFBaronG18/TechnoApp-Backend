package com.web.repositories;

import org.springframework.data.repository.CrudRepository;

import com.web.entities.Commentary;

public interface CommentaryRepository extends CrudRepository<Commentary, Long>{
}
