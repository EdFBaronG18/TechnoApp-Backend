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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "artist")
public class Artist {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_artist")
	private Long idArtist;
	
	@Column(name = "name_artist")
	private String name;
	
	@Column(name = "description_artist ")
	private String description;
	
	@Column(name = "image_artist")
	private String image;
	
	@ManyToOne
	@JoinColumn(name = "category_artist")
//	@JsonIgnoreProperties({"artists"})
	private Category category;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="artist")
	private Set<Commentary> comments = new TreeSet<Commentary>((x,y) ->{return x.getCreate().compareTo(y.getCreate());});

	
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

	public Category getCategories() {
		return category;
	}

	public void setCategory(Category category) {
		this.category= category;
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
	
	public Artist(String name, String description, String image, Category category) {
		setName(name);
		setDescription(description);
		setImage(image);
		setCategory(category);
	}

}
