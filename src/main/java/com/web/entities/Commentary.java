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
	private Artist artist;
	
	@ManyToOne
	@JoinColumn(name = "user_commentary", nullable = false)
	private User user;


	//---------------------------------------------------------
	
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
}
