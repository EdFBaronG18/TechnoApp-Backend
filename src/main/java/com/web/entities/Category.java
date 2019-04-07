package com.web.entities;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_category")
	private Long idCategory;
	
	@Column(name = "name_category")
	private String name;
	
	@ManyToMany(mappedBy = "categories")
	private Set<Artist> artists = new TreeSet<Artist>();

	//-------------------------------------------------------
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getIdCategory() {
		return idCategory;
	}

	public Set<Artist> getArtists() {
		return artists;
	}
}

