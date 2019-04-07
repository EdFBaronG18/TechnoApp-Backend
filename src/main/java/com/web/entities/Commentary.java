package com.web.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "commentary")
public class Commentary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_commentary")
	private Long idCommentary;
	
	@Column(name = "content_commentary")
	private String content;
	
	@Column(name = "create_commentary")
	private Timestamp create;
	
	@ManyToOne
	@JoinColumn(name = "artist_commentary", nullable = false)
	@JsonIgnore
	private Artist artist;
	
	@ManyToOne
	@JoinColumn(name = "user_commentary", nullable = false)
	@JsonIgnoreProperties({"password"})
	private User user;


	//---------------------------------------------------------
	// Methods
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getIdCommentary() {
		return idCommentary;
	}

	public Timestamp getCreate() {
		return create;
	}

	public Artist getArtist() {
		return artist;
	}

	public User getUser() {
		return user;
	}

	public void setCreate(Timestamp create) {
		this.create = create;
	}
	
	//************************************************
	// Contructors
	
	public Commentary() {
	}
	
	public Commentary(User user, Artist artist, String content) {
		this.create = new Timestamp(System.currentTimeMillis());
		this.user = user;
		this.artist = artist;
		setContent(content);
	}
}
