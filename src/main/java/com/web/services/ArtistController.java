package com.web.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.entities.Artist;
import com.web.entities.Commentary;
import com.web.repositories.ArtistRepository;

@RestController
public class ArtistController {
	
	@Autowired
	private ArtistRepository artistRepository;
	
	
	//Get All Artist
	@RequestMapping("/getAllArtist")
	public Iterable<Artist> getAllArtist () {
		return artistRepository.findAll();
	}
	
	//Add Artist
	@RequestMapping(path="/addArtist", method=RequestMethod.POST) 
	public @ResponseBody String addNewArtist 
	(
			@RequestParam String 	name			, 
			@RequestParam String 	description		,
			@RequestParam String 	image			) {
		
		Artist artist = new Artist(name, description, image);
		artistRepository.save(artist);
		return "Artist Saved";
	}
	// Get Artist By Id
	@RequestMapping(path="/getArtistById", method=RequestMethod.POST) 
	public @ResponseBody Artist getArtistById 
	(
			@RequestParam Long idArtist){
		return artistRepository.findById(idArtist).get();
	}
	
	// Get All Comments By Artist Id
	@RequestMapping(path="/getAllCommentByArtistId", method=RequestMethod.POST) 
	public @ResponseBody Set<Commentary>getAllCommentByArtistId
	(
			@RequestParam Long idArtist){
		Optional<Artist> optional = artistRepository.findById(idArtist);
		if(!optional.isPresent())
			return null;
		Artist artist = optional.get();
		return artist.getComments();
	}

	
	
}
