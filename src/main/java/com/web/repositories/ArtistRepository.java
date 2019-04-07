package com.web.repositories;

import org.springframework.data.repository.CrudRepository;

import com.web.entities.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long>{
}
