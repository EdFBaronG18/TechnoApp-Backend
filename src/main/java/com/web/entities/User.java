package com.web.entities;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_user")
	private Long idUser;
	
	@Column(name = "username_user", unique = true, nullable = false)
	private String username;

	@Column(name = "name_user", nullable = false)
	private String name;
	
	@Column(name = "password_user", nullable = false)
	private String password;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "user")
	private Set<Commentary> comments = new TreeSet<Commentary>();

	//-------------------------------------------------------------
	//Methods
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getIdUser() {
		return idUser;
	}

	public String getUsername() {
		return username;
	}

	public Set<Commentary> getComments() {
		return comments;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	//**************************************************************
	//Constructors
	
	public User(){
	}
	
	public User(String username, String name, String password) {
		this.username = username;
		setName(name);
		setPassword(password);
	}

}
