package com.web.repositories;

import org.springframework.data.repository.CrudRepository;

import com.web.entities.Commentary;

public interface ArtistRepository extends CrudRepository<Commentary, Long>{

}
