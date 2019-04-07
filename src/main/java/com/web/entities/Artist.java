package com.web.entities;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "artist")
public class Artist {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_artist")
	private Long idArtist;
	
	@Column(name = "name_artist")
	private String name;
	
	@Column(name = "description_artist")
	private String description;
	
	@Column(name = "image_artist")
	private String image;

	@ManyToMany(targetEntity=Category.class, fetch=FetchType.LAZY)
	@JoinTable(
	        name = "artist_category", 
	        joinColumns = { @JoinColumn(name = "id_artist") }, 
	        inverseJoinColumns = { @JoinColumn(name = "id_category") }
	    )
	private Set<Category> categories = new TreeSet<Category>();
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="artist")
	private Set<Commentary> comments = new TreeSet<Commentary>();

	
	//--------------------------------------------------------------
	//Methods
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Long getIdArtist() {
		return idArtist;
	}

	public Set<Commentary> getComments() {
		return comments;
	}
	
	public boolean addComment(Commentary commentary) {
		return this.comments.add(commentary);
	}
	
	//********************************************************
	//Constructors
	
	public Artist() {
	}
	
	public Artist(String name, String description, String image) {
		setName(name);
		setDescription(description);
		setImage(image);
	}

}
