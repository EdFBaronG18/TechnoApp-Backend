package com.web.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.entities.Artist;
import com.web.entities.Category;
import com.web.repositories.CategoryRepository;

@RestController
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepository;
	
	//Get All Categories
	@RequestMapping("/getAllCategories")
	@CrossOrigin
	public Iterable<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
	
	// Get All Artist by Category
	@RequestMapping(path="/getArtistByCategoryId", method=RequestMethod.POST) 
	@CrossOrigin
	public @ResponseBody Set<Artist>getArtistByCategoryId
	(
			@RequestParam Long idCategory){
		Optional<Category> optional = categoryRepository.findById(idCategory);
		
		if(!optional.isPresent()) return null;
		
		Category category = optional.get();
		return category.getArtists();
	}
	
	// Add Category
	@RequestMapping(path="/addCategory", method=RequestMethod.POST) 
	@CrossOrigin
	public @ResponseBody String addCategory
	(
			@RequestParam String name){
		
		Category category = new Category();
		category.setName(name);
		categoryRepository.save(category);
		
		return "Category Saved Succesfull";
	}
	
}
